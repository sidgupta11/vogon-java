package org.zlogic.vogon.web.controller;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.zlogic.vogon.data.VogonUser;
import org.zlogic.vogon.data.report.ReportFactory;
import org.zlogic.vogon.web.security.VogonSecurityUser;

public class AnalyticsControllerDiffblueTest {

    /*
    @Test
    public void testGetReport() {
        AnalyticsController analyticsController = new AnalyticsController();
        ReportFactory reportFactory = new ReportFactory(new VogonUser("janedoe", "iloveyou"));

        VogonUser vogonUser = new VogonUser();
        vogonUser.setPassword("iloveyou");
        vogonUser.setUsername("janedoe");
        vogonUser.setVersion(1L);
        VogonSecurityUser vogonSecurityUser = mock(VogonSecurityUser.class);
        when(vogonSecurityUser.getUser()).thenReturn(vogonUser);
        assertTrue(analyticsController.getReport(reportFactory, vogonSecurityUser).isEmpty());
        verify(vogonSecurityUser).getUser();
        assertTrue(reportFactory.getSelectedAccounts().isEmpty());
        assertSame(vogonUser, reportFactory.getOwner());
    }
     */
}

