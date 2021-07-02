package org.zlogic.vogon.web.data.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class TransactionComponentJsonDiffblueTest {
    @Test
    public void testSetAccountId() {
        TransactionComponentJson transactionComponentJson = new TransactionComponentJson();
        transactionComponentJson.setAccountId(1234567890L);
        assertEquals(1234567890L, transactionComponentJson.getAccountId().longValue());
    }

    @Test
    public void testConstructor() {
        TransactionComponentJson actualTransactionComponentJson = new TransactionComponentJson();
        actualTransactionComponentJson.setId(123L);
        assertEquals(123L, actualTransactionComponentJson.getId().longValue());
    }

    @Test
    public void testGetAccountId() {
        assertNull((new TransactionComponentJson()).getAccountId());
    }

    @Test
    public void testSetAmount() {
        TransactionComponentJson transactionComponentJson = new TransactionComponentJson();
        transactionComponentJson.setAmount(10.0);
        assertEquals(1000L, transactionComponentJson.getRawAmount().longValue());
    }
}

