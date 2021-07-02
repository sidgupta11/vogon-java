package org.zlogic.vogon.web.data.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TransactionComponentJsonDiffblueTest {
    @Test
    public void testConstructor() {
        TransactionComponentJson actualTransactionComponentJson = new TransactionComponentJson();
        actualTransactionComponentJson.setId(123L);
        assertEquals(123L, actualTransactionComponentJson.getId().longValue());
    }
}

