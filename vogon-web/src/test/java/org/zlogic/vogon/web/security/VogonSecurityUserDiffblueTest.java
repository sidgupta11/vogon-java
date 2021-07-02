package org.zlogic.vogon.web.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;
import org.zlogic.vogon.data.VogonUser;

public class VogonSecurityUserDiffblueTest {
    /*
    @Test
    public void testConstructor() {
        VogonUser vogonUser = new VogonUser("janedoe", "iloveyou");

        VogonSecurityUser actualVogonSecurityUser = new VogonSecurityUser(vogonUser);
        VogonUser vogonUser1 = new VogonUser();
        vogonUser1.setPassword("iloveyou");
        vogonUser1.setUsername("janedoe");
        vogonUser1.setVersion(1L);
        actualVogonSecurityUser.setUser(vogonUser1);
        VogonUser user = actualVogonSecurityUser.getUser();
        assertEquals(vogonUser, user);
        assertSame(vogonUser1, user);
    }
     */

    @Test
    public void testGetAuthorities() {
        Collection<? extends GrantedAuthority> actualAuthorities = (new VogonSecurityUser(
                new VogonUser("janedoe", "iloveyou"))).getAuthorities();
        assertEquals(1, actualAuthorities.size());
        assertEquals(VogonSecurityUser.AUTHORITY_USER,
                ((List<? extends GrantedAuthority>) actualAuthorities).get(0).getAuthority());
    }

    @Test
    public void testGetUsername() {
        assertEquals("janedoe", (new VogonSecurityUser(new VogonUser("janedoe", "iloveyou"))).getUsername());
        assertNull((new VogonSecurityUser(null)).getUsername());
    }

    @Test
    public void testGetPassword() {
        assertEquals("iloveyou", (new VogonSecurityUser(new VogonUser("janedoe", "iloveyou"))).getPassword());
        assertNull((new VogonSecurityUser(null)).getPassword());
    }

    @Test
    public void testIsAccountNonExpired() {
        assertTrue((new VogonSecurityUser(new VogonUser("janedoe", "iloveyou"))).isAccountNonExpired());
        assertFalse((new VogonSecurityUser(null)).isAccountNonExpired());
    }

    @Test
    public void testIsAccountNonLocked() {
        assertTrue((new VogonSecurityUser(new VogonUser("janedoe", "iloveyou"))).isAccountNonLocked());
        assertFalse((new VogonSecurityUser(null)).isAccountNonLocked());
    }

    @Test
    public void testIsCredentialsNonExpired() {
        assertTrue((new VogonSecurityUser(new VogonUser("janedoe", "iloveyou"))).isCredentialsNonExpired());
        assertFalse((new VogonSecurityUser(null)).isCredentialsNonExpired());
    }

    @Test
    public void testIsEnabled() {
        assertTrue((new VogonSecurityUser(new VogonUser("janedoe", "iloveyou"))).isEnabled());
        assertFalse((new VogonSecurityUser(null)).isEnabled());
    }
}

