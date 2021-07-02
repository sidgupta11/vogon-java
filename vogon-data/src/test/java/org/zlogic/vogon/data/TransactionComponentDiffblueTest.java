package org.zlogic.vogon.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.util.Date;

import org.junit.Test;

public class TransactionComponentDiffblueTest {
    @Test
    public void testConstructor() {
        TransactionComponent actualTransactionComponent = new TransactionComponent();
        actualTransactionComponent.setVersion(1L);
        assertNull(actualTransactionComponent.getAccount());
        assertNull(actualTransactionComponent.getId());
        assertNull(actualTransactionComponent.getRawAmount());
        assertNull(actualTransactionComponent.getTransaction());
        assertEquals(1L, actualTransactionComponent.getVersion());
    }

    @Test
    public void testConstructor2() {
        TransactionComponent actualTransactionComponent = new TransactionComponent(null, null, 10L);

        assertEquals(0L, actualTransactionComponent.getVersion());
        assertEquals(10L, actualTransactionComponent.getRawAmount().longValue());
    }

    @Test
    public void testConstructor3() {
        VogonUser owner = new VogonUser("janedoe", "iloveyou");

        TransactionComponent actualTransactionComponent = new TransactionComponent(null,
                new FinanceTransaction(owner, "The characteristics of someone or something", new String[]{"foo", "foo", "foo"},
                        new Date(1L), FinanceTransaction.Type.EXPENSEINCOME),
                10L);

        assertEquals(0L, actualTransactionComponent.getVersion());
        assertEquals(10L, actualTransactionComponent.getRawAmount().longValue());
        FinanceTransaction transaction = actualTransactionComponent.getTransaction();
        assertEquals(1, transaction.tags.size());
        assertEquals(1, transaction.components.size());
    }

    @Test
    public void testSetAccount() {
        TransactionComponent transactionComponent = new TransactionComponent();
        transactionComponent.setAccount(null);
        assertEquals(0L, transactionComponent.getVersion());
    }

    @Test
    public void testSetAccount2() {
        TransactionComponent transactionComponent = new TransactionComponent();
        transactionComponent.setRawAmount(10L);
        VogonUser owner = new VogonUser("janedoe", "iloveyou");

        FinanceAccount financeAccount = new FinanceAccount(owner, new FinanceAccount());

        transactionComponent.setAccount(financeAccount);
        assertEquals(0.1, financeAccount.getBalance(), 0.0);
        assertEquals(1, financeAccount.transactionComponents.size());
        assertSame(financeAccount, transactionComponent.getAccount());
    }

    @Test
    public void testSetTransaction() {
        TransactionComponent transactionComponent = new TransactionComponent();
        transactionComponent.setTransaction(null);
        assertEquals(0L, transactionComponent.getVersion());
    }

    @Test
    public void testSetTransaction2() {
        TransactionComponent transactionComponent = new TransactionComponent();
        VogonUser owner = new VogonUser("janedoe", "iloveyou");

        FinanceTransaction financeTransaction = new FinanceTransaction(owner, "The characteristics of someone or something",
                new String[]{"foo", "foo", "foo"}, new Date(1L), FinanceTransaction.Type.EXPENSEINCOME);

        transactionComponent.setTransaction(financeTransaction);
        assertEquals(1, financeTransaction.components.size());
        assertSame(financeTransaction, transactionComponent.getTransaction());
    }

    @Test
    public void testSetRawAmount() {
        TransactionComponent transactionComponent = new TransactionComponent();
        transactionComponent.setRawAmount(10L);
        assertEquals(10L, transactionComponent.getRawAmount().longValue());
    }

    @Test
    public void testGetAmount() {
        TransactionComponent transactionComponent = new TransactionComponent();
        transactionComponent.setRawAmount(10L);
        assertEquals(0.1, transactionComponent.getAmount(), 0.0);
    }
}

