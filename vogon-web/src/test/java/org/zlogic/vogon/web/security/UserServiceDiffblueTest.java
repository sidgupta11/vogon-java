package org.zlogic.vogon.web.security;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.zlogic.vogon.data.VogonUser;

public class UserServiceDiffblueTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testRefreshUser() {
        UserService userService = new UserService();
        VogonSecurityUser vogonSecurityUser = new VogonSecurityUser(null);
        userService.refreshUser(vogonSecurityUser);
        assertFalse(vogonSecurityUser.isEnabled());
    }

    @Test
    public void testRefreshUser2() {
        UserService userService = new UserService();
        VogonSecurityUser vogonSecurityUser = mock(VogonSecurityUser.class);
        when(vogonSecurityUser.getUser()).thenThrow(new UsernameNotFoundException("Msg"));
        thrown.expect(UsernameNotFoundException.class);
        userService.refreshUser(vogonSecurityUser);
        verify(vogonSecurityUser).getUser();
    }

    @Test
    public void testCreateUser() throws UsernameExistsException {
        UserService userService = new UserService();
        VogonUser vogonUser = mock(VogonUser.class);
        when(vogonUser.getPassword()).thenThrow(new UsernameNotFoundException("Msg"));
        when(vogonUser.getUsername()).thenReturn("foo");
        thrown.expect(UsernameNotFoundException.class);
        userService.createUser(vogonUser);
        verify(vogonUser).getPassword();
        verify(vogonUser).getUsername();
    }

    @Test
    public void testCreateUser2() throws UsernameExistsException {
        UserService userService = new UserService();
        VogonUser vogonUser = mock(VogonUser.class);
        when(vogonUser.getPassword()).thenThrow(new DataIntegrityViolationException("42"));
        when(vogonUser.getUsername()).thenReturn("foo");
        thrown.expect(DataIntegrityViolationException.class);
        userService.createUser(vogonUser);
        verify(vogonUser).getPassword();
        verify(vogonUser).getUsername();
    }

    @Test
    public void testCreateUser3() throws UsernameExistsException {
        UserService userService = new UserService();
        VogonUser vogonUser = mock(VogonUser.class);
        when(vogonUser.getPassword()).thenThrow(new DataIntegrityViolationException(""));
        when(vogonUser.getUsername()).thenReturn("org.zlogic.vogon.data.VogonUser");
        thrown.expect(DataIntegrityViolationException.class);
        userService.createUser(vogonUser);
        verify(vogonUser).getPassword();
        verify(vogonUser).getUsername();
    }

    @Test
    public void testUpdateUser() throws UsernameExistsException {
        UserService userService = new UserService();
        VogonUser vogonUser = mock(VogonUser.class);
        when(vogonUser.getUsername()).thenThrow(new UsernameNotFoundException("Msg"));
        VogonSecurityUser vogonSecurityUser = new VogonSecurityUser(vogonUser);
        userService.updateUser(vogonSecurityUser, new VogonUser("janedoe", "iloveyou"));
        verify(vogonUser).getUsername();
        assertNull(vogonSecurityUser.getPassword());
    }

    @Test
    public void testPasswordEncoder() {
        // TODO: This test is incomplete.
        //   Reason: Nothing to assert: neither the return value type of the method under test nor the types of its parameters have observers (e.g. getters or public fields).
        //   Add observers (e.g. getters or public fields) to the declaring class
        //   of the method under test, its return type or any of its parameter
        //   types.
        //   See https://diff.blue/R003

        (new UserService()).passwordEncoder();
    }
}

