package org.zlogic.vogon.web.data.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.zlogic.vogon.data.FinanceTransaction;
import org.zlogic.vogon.data.VogonUser;

public class FinanceTransactionJsonDiffblueTest {
    @Test
    public void testConstructor() {
        FinanceTransactionJson actualFinanceTransactionJson = new FinanceTransactionJson();
        ArrayList<TransactionComponentJson> transactionComponentJsonList = new ArrayList<TransactionComponentJson>();
        actualFinanceTransactionJson.setComponentsJson(transactionComponentJsonList);
        actualFinanceTransactionJson.setId(123L);
        assertEquals(123L, actualFinanceTransactionJson.getId().longValue());
        assertSame(transactionComponentJsonList, actualFinanceTransactionJson.getComponentsJson());
    }

    @Test
    public void testConstructor2() {
        FinanceTransactionJson actualFinanceTransactionJson = new FinanceTransactionJson();
        assertTrue(actualFinanceTransactionJson.getComponentsJson().isEmpty());
        assertEquals(0L, actualFinanceTransactionJson.getVersion());
        assertEquals(FinanceTransaction.Type.UNDEFINED, actualFinanceTransactionJson.getType());
    }

    @Test
    public void testConstructor3() {
        VogonUser vogonUser = new VogonUser("janedoe", "iloveyou");

        Date date = new Date(1L);
        FinanceTransactionJson actualFinanceTransactionJson = new FinanceTransactionJson(
                new FinanceTransaction(vogonUser, "The characteristics of someone or something",
                        new String[]{"foo", "foo", "foo"}, date, FinanceTransaction.Type.EXPENSEINCOME));
        assertTrue(actualFinanceTransactionJson.getComponentsJson().isEmpty());
        assertEquals(0L, actualFinanceTransactionJson.getVersion());
        assertEquals(FinanceTransaction.Type.EXPENSEINCOME, actualFinanceTransactionJson.getType());
        assertEquals(1, actualFinanceTransactionJson.getTags().length);
        assertSame(vogonUser, actualFinanceTransactionJson.getOwner());
        assertNull(actualFinanceTransactionJson.getId());
        assertSame(date, actualFinanceTransactionJson.getDate());
        assertEquals("The characteristics of someone or something", actualFinanceTransactionJson.getDescription());
    }
}

