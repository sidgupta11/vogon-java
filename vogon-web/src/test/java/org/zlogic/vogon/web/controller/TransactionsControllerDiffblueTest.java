package org.zlogic.vogon.web.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.EntityNotFoundException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.data.domain.Sort;
import org.zlogic.vogon.data.FinanceTransaction;
import org.zlogic.vogon.data.VogonUser;
import org.zlogic.vogon.web.data.model.FinanceTransactionJson;
import org.zlogic.vogon.web.security.VogonSecurityUser;

public class TransactionsControllerDiffblueTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /*
    @Test
    public void testGetTransactions() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        TransactionsController transactionsController = new TransactionsController();
        Date filterDate = new Date(1L);
        transactionsController.getTransactions(1, TransactionsController.SortColumn.DATE, Sort.Direction.ASC,
                "Filter Description", filterDate, new ArrayList<String>(), mock(VogonSecurityUser.class));
    }
     */

    @Test
    public void testGetTransactions2() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        TransactionsController transactionsController = new TransactionsController();
        Date filterDate = new Date(1L);
        transactionsController.getTransactions(1, null, Sort.Direction.ASC, "Filter Description", filterDate,
                new ArrayList<String>(), mock(VogonSecurityUser.class));
    }

    /*
    @Test
    public void testGetTransactions3() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        TransactionsController transactionsController = new TransactionsController();
        Date filterDate = new Date(1L);
        transactionsController.getTransactions(1, TransactionsController.SortColumn.DESCRIPTION, Sort.Direction.ASC,
                "Filter Description", filterDate, new ArrayList<String>(), mock(VogonSecurityUser.class));
    }
     */

    /*
    @Test
    public void testGetTransactions4() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        TransactionsController transactionsController = new TransactionsController();
        Date filterDate = new Date(1L);
        transactionsController.getTransactions(1, TransactionsController.SortColumn.DATE, null, "Filter Description",
                filterDate, new ArrayList<String>(), mock(VogonSecurityUser.class));
    }
     */

    @Test
    public void testGetTransaction() {
        TransactionsController transactionsController = new TransactionsController();
        VogonSecurityUser vogonSecurityUser = mock(VogonSecurityUser.class);
        when(vogonSecurityUser.getUser()).thenThrow(new EntityNotFoundException("An error occurred"));
        thrown.expect(EntityNotFoundException.class);
        transactionsController.getTransaction(123L, vogonSecurityUser);
        verify(vogonSecurityUser).getUser();
    }

    @Test
    public void testSubmitTransaction() {
        TransactionsController transactionsController = new TransactionsController();
        VogonUser owner = new VogonUser("janedoe", "iloveyou");

        FinanceTransactionJson transaction = new FinanceTransactionJson(
                new FinanceTransaction(owner, "The characteristics of someone or something", new String[]{"foo", "foo", "foo"},
                        new Date(1L), FinanceTransaction.Type.EXPENSEINCOME));
        VogonSecurityUser vogonSecurityUser = mock(VogonSecurityUser.class);
        when(vogonSecurityUser.getUser()).thenThrow(new EntityNotFoundException("An error occurred"));
        thrown.expect(EntityNotFoundException.class);
        transactionsController.submitTransaction(transaction, vogonSecurityUser);
        verify(vogonSecurityUser).getUser();
    }

    /*
    @Test
    public void testSubmitTransaction2() {
        TransactionsController transactionsController = new TransactionsController();
        FinanceTransactionJson financeTransactionJson = mock(FinanceTransactionJson.class);
        when(financeTransactionJson.getId()).thenThrow(new EntityNotFoundException("An error occurred"));

        VogonUser vogonUser = new VogonUser();
        vogonUser.setPassword("iloveyou");
        vogonUser.setUsername("janedoe");
        vogonUser.setVersion(1L);
        VogonSecurityUser vogonSecurityUser = mock(VogonSecurityUser.class);
        when(vogonSecurityUser.getUser()).thenReturn(vogonUser);
        thrown.expect(EntityNotFoundException.class);
        transactionsController.submitTransaction(financeTransactionJson, vogonSecurityUser);
        verify(financeTransactionJson).getId();
        verify(vogonSecurityUser).getUser();
    }
     */

    @Test
    public void testDeleteTransaction() {
        TransactionsController transactionsController = new TransactionsController();
        VogonSecurityUser vogonSecurityUser = mock(VogonSecurityUser.class);
        when(vogonSecurityUser.getUser()).thenThrow(new EntityNotFoundException("An error occurred"));
        thrown.expect(EntityNotFoundException.class);
        transactionsController.deleteTransaction(123L, vogonSecurityUser);
        verify(vogonSecurityUser).getUser();
    }
}

