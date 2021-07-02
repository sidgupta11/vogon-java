package org.zlogic.vogon.web.data;

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
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.zlogic.vogon.data.FinanceTransaction;
import org.zlogic.vogon.data.TransactionComponent;
import org.zlogic.vogon.data.VogonUser;
import org.zlogic.vogon.web.data.model.FinanceTransactionJson;

@ContextConfiguration(classes = {InitializationHelper.class})
@RunWith(SpringRunner.class)
public class InitializationHelperDiffblueTest {
    @Autowired
    private InitializationHelper initializationHelper;

    @Test
    public void testInitializeTransaction() {
        VogonUser vogonUser = new VogonUser("janedoe", "iloveyou");

        Date date = new Date(1L);
        FinanceTransactionJson actualInitializeTransactionResult = this.initializationHelper
                .initializeTransaction(new FinanceTransaction(vogonUser, "The characteristics of someone or something",
                        new String[]{"foo", "foo", "foo"}, date, FinanceTransaction.Type.EXPENSEINCOME));
        assertTrue(actualInitializeTransactionResult.getComponentsJson().isEmpty());
        assertEquals(0L, actualInitializeTransactionResult.getVersion());
        assertEquals(FinanceTransaction.Type.EXPENSEINCOME, actualInitializeTransactionResult.getType());
        assertEquals(1, actualInitializeTransactionResult.getTags().length);
        assertSame(vogonUser, actualInitializeTransactionResult.getOwner());
        assertNull(actualInitializeTransactionResult.getId());
        assertSame(date, actualInitializeTransactionResult.getDate());
        assertEquals("The characteristics of someone or something", actualInitializeTransactionResult.getDescription());
    }

    /*
    @Test
    public void testInitializeTransaction2() {
        VogonUser vogonUser = new VogonUser();
        vogonUser.setPassword("iloveyou");
        vogonUser.setUsername("janedoe");
        vogonUser.setVersion(1L);
        FinanceTransaction financeTransaction = mock(FinanceTransaction.class);
        when(financeTransaction.getComponents()).thenReturn(new ArrayList<TransactionComponent>());
        when(financeTransaction.getVersion()).thenReturn(1L);
        when(financeTransaction.getType()).thenReturn(FinanceTransaction.Type.EXPENSEINCOME);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant());
        when(financeTransaction.getDate()).thenReturn(fromResult);
        when(financeTransaction.getTags()).thenReturn(new String[]{"foo"});
        when(financeTransaction.getOwner()).thenReturn(vogonUser);
        when(financeTransaction.getId()).thenReturn(1L);
        when(financeTransaction.getDescription()).thenReturn("foo");
        FinanceTransactionJson actualInitializeTransactionResult = this.initializationHelper
                .initializeTransaction(financeTransaction);
        assertTrue(actualInitializeTransactionResult.getComponentsJson().isEmpty());
        assertEquals(1L, actualInitializeTransactionResult.getVersion());
        assertEquals(FinanceTransaction.Type.EXPENSEINCOME, actualInitializeTransactionResult.getType());
        assertEquals(1, actualInitializeTransactionResult.getTags().length);
        assertSame(vogonUser, actualInitializeTransactionResult.getOwner());
        assertEquals(1L, actualInitializeTransactionResult.getId().longValue());
        assertSame(fromResult, actualInitializeTransactionResult.getDate());
        assertEquals("foo", actualInitializeTransactionResult.getDescription());
        verify(financeTransaction).getComponents();
        verify(financeTransaction).getDate();
        verify(financeTransaction).getDescription();
        verify(financeTransaction).getId();
        verify(financeTransaction).getOwner();
        verify(financeTransaction).getTags();
        verify(financeTransaction).getType();
        verify(financeTransaction).getVersion();
    }
     */

    @Test
    public void testInitializeTransactions() {
        InitializationHelper initializationHelper = new InitializationHelper();
        assertTrue(initializationHelper.initializeTransactions(new ArrayList<FinanceTransaction>()).isEmpty());
    }
}

