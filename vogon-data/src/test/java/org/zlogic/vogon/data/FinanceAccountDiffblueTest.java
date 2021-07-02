package org.zlogic.vogon.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FinanceAccountDiffblueTest {
    @Test
    public void testConstructor() {
        FinanceAccount actualFinanceAccount = new FinanceAccount();
        VogonUser vogonUser = new VogonUser();
        vogonUser.setPassword("iloveyou");
        vogonUser.setUsername("janedoe");
        vogonUser.setVersion(1L);
        actualFinanceAccount.setOwner(vogonUser);
        actualFinanceAccount.setVersion(1L);
        assertNull(actualFinanceAccount.getId());
        assertNull(actualFinanceAccount.getName());
        assertSame(vogonUser, actualFinanceAccount.getOwner());
        assertEquals(1L, actualFinanceAccount.getVersion());
    }

    @Test
    public void testConstructor2() {
        FinanceAccount actualFinanceAccount = new FinanceAccount();
        assertTrue(actualFinanceAccount.showInList);
        assertTrue(actualFinanceAccount.includeInTotal);
        assertEquals(0L, actualFinanceAccount.getVersion());
    }

    @Test
    public void testConstructor3() {
        FinanceAccount actualFinanceAccount = new FinanceAccount(new VogonUser("janedoe", "iloveyou"), "Name", null);

        assertEquals(0.0, actualFinanceAccount.getBalance(), 0.0);
        assertTrue(actualFinanceAccount.transactionComponents.isEmpty());
        assertTrue(actualFinanceAccount.showInList);
        assertTrue(actualFinanceAccount.includeInTotal);
        assertEquals("INR", actualFinanceAccount.currency);
        assertEquals(0L, actualFinanceAccount.getVersion());
        assertEquals("Name", actualFinanceAccount.getName());
        assertNull(actualFinanceAccount.getOwner().accounts);
    }

    @Test
    public void testConstructor4() {
        VogonUser owner = new VogonUser("janedoe", "iloveyou");

        FinanceAccount actualFinanceAccount = new FinanceAccount(owner, new FinanceAccount());

        assertEquals(0.0, actualFinanceAccount.getBalance(), 0.0);
        assertTrue(actualFinanceAccount.transactionComponents.isEmpty());
        assertTrue(actualFinanceAccount.showInList);
        assertTrue(actualFinanceAccount.includeInTotal);
        assertEquals("INR", actualFinanceAccount.currency);
        assertEquals(0L, actualFinanceAccount.getVersion());
        assertNull(actualFinanceAccount.getName());
        assertNull(actualFinanceAccount.getOwner().accounts);
    }

    @Test
    public void testConstructor5() {
        VogonUser owner = new VogonUser("janedoe", "iloveyou");

        VogonUser owner1 = new VogonUser("janedoe", "iloveyou");

        FinanceAccount actualFinanceAccount = new FinanceAccount(owner, new FinanceAccount(owner1, new FinanceAccount()));

        assertEquals(0.0, actualFinanceAccount.getBalance(), 0.0);
        assertTrue(actualFinanceAccount.transactionComponents.isEmpty());
        assertTrue(actualFinanceAccount.showInList);
        assertTrue(actualFinanceAccount.includeInTotal);
        assertEquals("INR", actualFinanceAccount.currency);
        assertEquals(0L, actualFinanceAccount.getVersion());
        assertNull(actualFinanceAccount.getName());
        assertNull(actualFinanceAccount.getOwner().accounts);
    }

    @Test
    public void testMerge() {
        FinanceAccount financeAccount = new FinanceAccount();
        financeAccount.merge(new FinanceAccount());
        assertTrue(financeAccount.showInList);
        assertTrue(financeAccount.includeInTotal);
        assertEquals("INR", financeAccount.currency);
        assertNull(financeAccount.getName());
    }

    @Test
    public void testMerge2() {
        FinanceAccount financeAccount = new FinanceAccount();
        VogonUser owner = new VogonUser("janedoe", "iloveyou");

        financeAccount.merge(new FinanceAccount(owner, new FinanceAccount()));
        assertTrue(financeAccount.showInList);
        assertTrue(financeAccount.includeInTotal);
        assertEquals("INR", financeAccount.currency);
        assertNull(financeAccount.getName());
    }

    @Test
    public void testMerge3() {
        FinanceAccount financeAccount = new FinanceAccount();
        financeAccount.merge(new FinanceAccount(), true);
        assertTrue(financeAccount.showInList);
        assertTrue(financeAccount.includeInTotal);
        assertEquals("INR", financeAccount.currency);
        assertNull(financeAccount.getName());
    }

    @Test
    public void testMerge4() {
        FinanceAccount financeAccount = new FinanceAccount();
        VogonUser owner = new VogonUser("janedoe", "iloveyou");

        financeAccount.merge(new FinanceAccount(owner, new FinanceAccount()), true);
        assertTrue(financeAccount.showInList);
        assertTrue(financeAccount.includeInTotal);
        assertEquals("INR", financeAccount.currency);
        assertNull(financeAccount.getName());
    }

    @Test
    public void testMerge5() {
        FinanceAccount financeAccount = new FinanceAccount();
        financeAccount.merge(new FinanceAccount(), false);
        assertTrue(financeAccount.showInList);
        assertTrue(financeAccount.includeInTotal);
        assertEquals("INR", financeAccount.currency);
        assertNull(financeAccount.getName());
    }

    @Test
    public void testAddComponent() {
        VogonUser owner = new VogonUser("janedoe", "iloveyou");

        FinanceAccount financeAccount = new FinanceAccount(owner, new FinanceAccount());

        TransactionComponent transactionComponent = new TransactionComponent();
        transactionComponent.setRawAmount(10L);
        financeAccount.addComponent(transactionComponent);
        FinanceAccount account = transactionComponent.getAccount();
        assertEquals(10L, account.getRawBalance());
        assertTrue(account.includeInTotal);
        assertEquals(1, account.getComponents().size());
    }

    @Test
    public void testRemoveComponent() {
        VogonUser owner = new VogonUser("janedoe", "iloveyou");

        FinanceAccount financeAccount = new FinanceAccount(owner, new FinanceAccount());
        financeAccount.removeComponent(new TransactionComponent());
        assertEquals(0.0, financeAccount.getBalance(), 0.0);
        assertTrue(financeAccount.transactionComponents.isEmpty());
    }

    @Test
    public void testGetComponents() {
        assertTrue((new FinanceAccount()).getComponents().isEmpty());
    }

    @Test
    public void testGetComponents2() {
        VogonUser owner = new VogonUser("janedoe", "iloveyou");

        assertTrue((new FinanceAccount(owner, new FinanceAccount())).getComponents().isEmpty());
    }

    @Test
    public void testSetName() {
        FinanceAccount financeAccount = new FinanceAccount();
        financeAccount.setName("Name");
        assertEquals("Name", financeAccount.getName());
    }

    @Test
    public void testSetName2() {
        FinanceAccount financeAccount = new FinanceAccount();
        financeAccount.setName("");
        assertTrue(financeAccount.showInList);
        assertTrue(financeAccount.includeInTotal);
        assertEquals(0L, financeAccount.getVersion());
    }

    @Test
    public void testGetCurrency() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        VogonUser owner = new VogonUser("janedoe", "iloveyou");

        (new FinanceAccount(owner, new FinanceAccount())).getCurrency();
    }

    @Test
    public void testSetCurrency() {
        FinanceAccount financeAccount = new FinanceAccount();
        financeAccount.setCurrency(null);
        assertTrue(financeAccount.showInList);
        assertTrue(financeAccount.includeInTotal);
        assertEquals(0L, financeAccount.getVersion());
    }

    @Test
    public void testGetIncludeInTotal() {
        assertTrue((new FinanceAccount()).getIncludeInTotal());
    }

    @Test
    public void testSetIncludeInTotal() {
        FinanceAccount financeAccount = new FinanceAccount();
        financeAccount.setIncludeInTotal(true);
        assertTrue(financeAccount.includeInTotal);
    }

    @Test
    public void testGetShowInList() {
        assertTrue((new FinanceAccount()).getShowInList());
    }

    @Test
    public void testSetShowInList() {
        FinanceAccount financeAccount = new FinanceAccount();
        financeAccount.setShowInList(true);
        assertTrue(financeAccount.showInList);
    }

    @Test
    public void testGetRawBalance() {
        VogonUser owner = new VogonUser("janedoe", "iloveyou");

        assertEquals(0L, (new FinanceAccount(owner, new FinanceAccount())).getRawBalance());
    }

    @Test
    public void testGetBalance() {
        VogonUser owner = new VogonUser("janedoe", "iloveyou");

        assertEquals(0.0, (new FinanceAccount(owner, new FinanceAccount())).getBalance(), 0.0);
    }
}

