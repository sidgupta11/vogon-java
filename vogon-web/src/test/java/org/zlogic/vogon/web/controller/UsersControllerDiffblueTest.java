package org.zlogic.vogon.web.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.zlogic.vogon.web.security.UsernameExistsException;
import org.zlogic.vogon.web.security.VogonSecurityUser;

public class UsersControllerDiffblueTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testGetUserData() {
        UsersController usersController = new UsersController();
        VogonSecurityUser vogonSecurityUser = mock(VogonSecurityUser.class);
        when(vogonSecurityUser.getUsername()).thenThrow(new UsernameExistsException());
        thrown.expect(UsernameExistsException.class);
        usersController.getUserData(vogonSecurityUser);
        verify(vogonSecurityUser).getUsername();
    }
}

