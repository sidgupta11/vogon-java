package org.zlogic.vogon.web.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.util.Date;
import java.util.HashSet;

import org.junit.Test;
import org.zlogic.vogon.data.VogonUser;

public class TransactionFilterSpecificationDiffblueTest {
    @Test
    public void testConstructor() {
        VogonUser vogonUser = new VogonUser("janedoe", "iloveyou");

        TransactionFilterSpecification actualTransactionFilterSpecification = new TransactionFilterSpecification(vogonUser);
        actualTransactionFilterSpecification.setFilterDescription("Filter Description");
        HashSet<String> stringSet = new HashSet<String>();
        actualTransactionFilterSpecification.setFilterTags(stringSet);
        assertNull(actualTransactionFilterSpecification.getFilterDate());
        assertEquals("Filter Description", actualTransactionFilterSpecification.getFilterDescription());
        assertSame(stringSet, actualTransactionFilterSpecification.getFilterTags());
        assertSame(vogonUser, actualTransactionFilterSpecification.getOwner());
    }

    @Test
    public void testSetFilterDate() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        TransactionFilterSpecification transactionFilterSpecification = new TransactionFilterSpecification(
                new VogonUser("janedoe", "iloveyou"));
        transactionFilterSpecification.setFilterDate(new Date(1L));
    }

    @Test
    public void testSetFilterDate2() {
        TransactionFilterSpecification transactionFilterSpecification = new TransactionFilterSpecification(
                new VogonUser("janedoe", "iloveyou"));
        transactionFilterSpecification.setFilterDate(null);
        assertNull(transactionFilterSpecification.getFilterDate());
    }
}

