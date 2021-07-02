package org.zlogic.vogon.web.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.zlogic.vogon.web.security.VogonSecurityUser;

public class DataControllerDiffblueTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testExportDataJSON() throws RuntimeException {
        DataController dataController = new DataController();
        VogonSecurityUser vogonSecurityUser = mock(VogonSecurityUser.class);
        when(vogonSecurityUser.getUsername()).thenThrow(new RuntimeException("An error occurred"));
        thrown.expect(RuntimeException.class);
        dataController.exportDataJSON(vogonSecurityUser);
        verify(vogonSecurityUser).getUsername();
    }
}

