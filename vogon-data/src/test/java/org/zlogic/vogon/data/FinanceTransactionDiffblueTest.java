package org.zlogic.vogon.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ConcurrentModificationException;
import java.util.Date;

import org.junit.Rule;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FinanceTransactionDiffblueTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testConstructor() {
        FinanceTransaction actualFinanceTransaction = new FinanceTransaction();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant());
        actualFinanceTransaction.setDate(fromResult);
        actualFinanceTransaction.setDescription("The characteristics of someone or something");
        VogonUser vogonUser = new VogonUser();
        vogonUser.setPassword("iloveyou");
        vogonUser.setUsername("janedoe");
        vogonUser.setVersion(1L);
        actualFinanceTransaction.setOwner(vogonUser);
        actualFinanceTransaction.setType(FinanceTransaction.Type.EXPENSEINCOME);
        actualFinanceTransaction.setVersion(1L);
        assertSame(fromResult, actualFinanceTransaction.getDate());
        assertEquals("The characteristics of someone or something", actualFinanceTransaction.getDescription());
        assertNull(actualFinanceTransaction.getId());
        assertSame(vogonUser, actualFinanceTransaction.getOwner());
        assertEquals(FinanceTransaction.Type.EXPENSEINCOME, actualFinanceTransaction.getType());
        assertEquals(1L, actualFinanceTransaction.getVersion());
    }

    @Test
    public void testConstructor2() {
        FinanceTransaction actualFinanceTransaction = new FinanceTransaction();
        assertEquals(0L, actualFinanceTransaction.getVersion());
        assertEquals(FinanceTransaction.Type.UNDEFINED, actualFinanceTransaction.getType());
    }

    @Test
    public void testConstructor3() {
        VogonUser owner = new VogonUser("janedoe", "iloveyou");

        FinanceTransaction actualFinanceTransaction = new FinanceTransaction(owner,
                "The characteristics of someone or something", new String[]{"foo", "foo", "foo"}, new Date(1L),
                FinanceTransaction.Type.EXPENSEINCOME);

        assertTrue(actualFinanceTransaction.getComponents().isEmpty());
        assertEquals(1, actualFinanceTransaction.tags.size());
        assertEquals(0L, actualFinanceTransaction.getVersion());
        assertEquals(FinanceTransaction.Type.EXPENSEINCOME, actualFinanceTransaction.getType());
        Date expectedDate = actualFinanceTransaction.transactionDate;
        assertSame(expectedDate, actualFinanceTransaction.getDate());
        assertEquals("The characteristics of someone or something", actualFinanceTransaction.getDescription());
        assertNull(actualFinanceTransaction.getOwner().accounts);
    }

    @Test
    public void testConstructor4() {
        VogonUser owner = new VogonUser("janedoe", "iloveyou");

        FinanceTransaction actualFinanceTransaction = new FinanceTransaction(owner,
                "The characteristics of someone or something", null, new Date(1L), FinanceTransaction.Type.EXPENSEINCOME);

        assertTrue(actualFinanceTransaction.getComponents().isEmpty());
        assertTrue(actualFinanceTransaction.tags.isEmpty());
        assertEquals(0L, actualFinanceTransaction.getVersion());
        assertEquals(FinanceTransaction.Type.EXPENSEINCOME, actualFinanceTransaction.getType());
        Date expectedDate = actualFinanceTransaction.transactionDate;
        assertSame(expectedDate, actualFinanceTransaction.getDate());
        assertEquals("The characteristics of someone or something", actualFinanceTransaction.getDescription());
        assertNull(actualFinanceTransaction.getOwner().accounts);
    }

    @Test
    public void testConstructor5() {
        VogonUser owner = new VogonUser("janedoe", "iloveyou");

        FinanceTransaction financeTransaction = new FinanceTransaction();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        financeTransaction.setDate(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        financeTransaction.setTags();
        FinanceTransaction actualFinanceTransaction = new FinanceTransaction(owner, financeTransaction);

        assertTrue(actualFinanceTransaction.getComponents().isEmpty());
        assertTrue(actualFinanceTransaction.tags.isEmpty());
        assertEquals(0L, actualFinanceTransaction.getVersion());
        assertEquals(FinanceTransaction.Type.UNDEFINED, actualFinanceTransaction.getType());
        Date expectedDate = actualFinanceTransaction.transactionDate;
        assertSame(expectedDate, actualFinanceTransaction.getDate());
        assertNull(actualFinanceTransaction.getDescription());
        assertNull(actualFinanceTransaction.getOwner().accounts);
    }

    @Test
    public void testMerge() {
        FinanceTransaction financeTransaction = new FinanceTransaction();
        LocalDateTime atStartOfDayResult = LocalDate.ofEpochDay(1L).atStartOfDay();
        financeTransaction.setDate(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        financeTransaction.setTags();

        FinanceTransaction financeTransaction1 = new FinanceTransaction();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        financeTransaction1.setDate(Date.from(atStartOfDayResult1.atZone(ZoneId.systemDefault()).toInstant()));
        financeTransaction1.setTags();
        financeTransaction.merge(financeTransaction1);
        Date expectedDate = financeTransaction.transactionDate;
        assertSame(expectedDate, financeTransaction.getDate());
        assertTrue(financeTransaction.tags.isEmpty());
        assertNull(financeTransaction.getDescription());
        assertEquals(FinanceTransaction.Type.UNDEFINED, financeTransaction.getType());
    }

    @Test
    public void testMerge2() {
        FinanceTransaction financeTransaction = new FinanceTransaction();
        LocalDateTime atStartOfDayResult = LocalDate.ofEpochDay(1L).atStartOfDay();
        financeTransaction.setDate(java.util.Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        financeTransaction.setTags();
        java.sql.Date date = mock(java.sql.Date.class);
        when(date.clone()).thenThrow(new ConcurrentModificationException("An error occurred"));

        FinanceTransaction financeTransaction1 = new FinanceTransaction();
        financeTransaction1.setDate(date);
        financeTransaction1.setTags();
        thrown.expect(ConcurrentModificationException.class);
        financeTransaction.merge(financeTransaction1);
        verify(date).clone();
    }

    @Test
    public void testMerge3() {
        FinanceTransaction financeTransaction = new FinanceTransaction();
        financeTransaction.setVersion(1L);
        financeTransaction.addTag("Tag");
        LocalDateTime atStartOfDayResult = LocalDate.ofEpochDay(1L).atStartOfDay();
        financeTransaction.setDate(java.util.Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        financeTransaction.setTags();
        java.sql.Date date = mock(java.sql.Date.class);
        when(date.clone()).thenReturn("42");

        FinanceTransaction financeTransaction1 = new FinanceTransaction();
        financeTransaction1.setDate(date);
        financeTransaction1.setTags();
        thrown.expect(ConcurrentModificationException.class);
        financeTransaction.merge(financeTransaction1);
    }

    @Test
    public void testMerge4() {
        FinanceTransaction financeTransaction = new FinanceTransaction();
        LocalDateTime atStartOfDayResult = LocalDate.ofEpochDay(1L).atStartOfDay();
        financeTransaction.setDate(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        financeTransaction.setTags();

        FinanceTransaction financeTransaction1 = new FinanceTransaction();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        financeTransaction1.setDate(Date.from(atStartOfDayResult1.atZone(ZoneId.systemDefault()).toInstant()));
        financeTransaction1.setTags();
        financeTransaction.merge(financeTransaction1, true);
        Date expectedDate = financeTransaction.transactionDate;
        assertSame(expectedDate, financeTransaction.getDate());
        assertTrue(financeTransaction.tags.isEmpty());
        assertNull(financeTransaction.getDescription());
        assertEquals(FinanceTransaction.Type.UNDEFINED, financeTransaction.getType());
    }

    @Test
    public void testMerge5() {
        FinanceTransaction financeTransaction = new FinanceTransaction();
        LocalDateTime atStartOfDayResult = LocalDate.ofEpochDay(1L).atStartOfDay();
        financeTransaction.setDate(java.util.Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        financeTransaction.setTags();
        java.sql.Date date = mock(java.sql.Date.class);
        when(date.clone()).thenThrow(new ConcurrentModificationException("An error occurred"));

        FinanceTransaction financeTransaction1 = new FinanceTransaction();
        financeTransaction1.setDate(date);
        financeTransaction1.setTags();
        thrown.expect(ConcurrentModificationException.class);
        financeTransaction.merge(financeTransaction1, true);
        verify(date).clone();
    }

    @Test
    public void testMerge6() {
        FinanceTransaction financeTransaction = new FinanceTransaction();
        LocalDateTime atStartOfDayResult = LocalDate.ofEpochDay(1L).atStartOfDay();
        financeTransaction.setDate(java.util.Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        financeTransaction.setTags();
        java.sql.Date date = mock(java.sql.Date.class);
        when(date.clone()).thenThrow(new ConcurrentModificationException("An error occurred"));

        FinanceTransaction financeTransaction1 = new FinanceTransaction();
        financeTransaction1.setDate(date);
        financeTransaction1.setTags();
        thrown.expect(ConcurrentModificationException.class);
        financeTransaction.merge(financeTransaction1, false);
        verify(date).clone();
    }

    @Test
    public void testMerge7() {
        FinanceTransaction financeTransaction = new FinanceTransaction();
        financeTransaction.setVersion(1L);
        financeTransaction.addTag("Tag");
        LocalDateTime atStartOfDayResult = LocalDate.ofEpochDay(1L).atStartOfDay();
        financeTransaction.setDate(java.util.Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        financeTransaction.setTags();
        java.sql.Date date = mock(java.sql.Date.class);
        when(date.clone()).thenReturn("42");

        FinanceTransaction financeTransaction1 = new FinanceTransaction();
        financeTransaction1.setDate(date);
        financeTransaction1.setTags();
        thrown.expect(ConcurrentModificationException.class);
        financeTransaction.merge(financeTransaction1, true);
    }

    @Test
    public void testGetComponents() {
        VogonUser owner = new VogonUser("janedoe", "iloveyou");

        assertTrue(
                (new FinanceTransaction(owner, "The characteristics of someone or something", new String[]{"foo", "foo", "foo"},
                        new Date(1L), FinanceTransaction.Type.EXPENSEINCOME)).getComponents().isEmpty());
    }

    @Test
    public void testAddComponent() {
        VogonUser owner = new VogonUser("janedoe", "iloveyou");

        FinanceTransaction financeTransaction = new FinanceTransaction(owner, "The characteristics of someone or something",
                new String[]{"foo", "foo", "foo"}, new Date(1L), FinanceTransaction.Type.EXPENSEINCOME);
        TransactionComponent transactionComponent = new TransactionComponent();
        financeTransaction.addComponent(transactionComponent);
        FinanceTransaction transaction = transactionComponent.getTransaction();
        assertEquals(1, transaction.components.size());
        assertEquals(1, transaction.tags.size());
    }

    @Test
    public void testRemoveComponent() {
        VogonUser owner = new VogonUser("janedoe", "iloveyou");

        FinanceTransaction financeTransaction = new FinanceTransaction(owner, "The characteristics of someone or something",
                new String[]{"foo", "foo", "foo"}, new Date(1L), FinanceTransaction.Type.EXPENSEINCOME);
        financeTransaction.removeComponent(new TransactionComponent());
        assertTrue(financeTransaction.components.isEmpty());
    }

    @Test
    public void testAddTag() {
        FinanceTransaction financeTransaction = new FinanceTransaction();
        financeTransaction.addTag("Tag");
        assertEquals(1, financeTransaction.tags.size());
    }

    @Test
    public void testAddTag2() {
        VogonUser owner = new VogonUser("janedoe", "iloveyou");

        FinanceTransaction financeTransaction = new FinanceTransaction(owner, "The characteristics of someone or something",
                new String[]{"foo", "foo", "foo"}, new Date(1L), FinanceTransaction.Type.EXPENSEINCOME);
        financeTransaction.addTag("Tag");
        assertEquals(2, financeTransaction.tags.size());
    }

    @Test
    public void testGetTags() {
        VogonUser owner = new VogonUser("janedoe", "iloveyou");

        String[] actualTags = (new FinanceTransaction(owner, "The characteristics of someone or something",
                new String[]{"foo", "foo", "foo"}, new Date(1L), FinanceTransaction.Type.EXPENSEINCOME)).getTags();
        assertEquals(1, actualTags.length);
        assertEquals("foo", actualTags[0]);
    }

    @Test
    public void testSetTags() {
        FinanceTransaction financeTransaction = new FinanceTransaction();
        financeTransaction.setTags("foo", "foo", "foo");
        assertEquals(1, financeTransaction.tags.size());
    }
}

