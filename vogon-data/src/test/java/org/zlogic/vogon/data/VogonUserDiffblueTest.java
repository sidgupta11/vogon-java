package org.zlogic.vogon.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VogonUserDiffblueTest {
    @Test
    public void testConstructor() {
        VogonUser actualVogonUser = new VogonUser();
        actualVogonUser.setVersion(1L);
        assertEquals(0L, actualVogonUser.getId());
        assertNull(actualVogonUser.getPassword());
        assertNull(actualVogonUser.getUsername());
        assertEquals(1L, actualVogonUser.getVersion());
    }

    @Test
    public void testConstructor2() {
        VogonUser actualVogonUser = new VogonUser("janedoe", "iloveyou");

        assertEquals(0L, actualVogonUser.getVersion());
        assertEquals("janedoe", actualVogonUser.getUsername());
        assertEquals("iloveyou", actualVogonUser.getPassword());
    }

    @Test
    public void testConstructor3() {
        VogonUser actualVogonUser = new VogonUser(null, "iloveyou");

        assertEquals(0L, actualVogonUser.getVersion());
        assertNull(actualVogonUser.getUsername());
        assertEquals("iloveyou", actualVogonUser.getPassword());
    }

    @Test
    public void testConstructor4() {
        VogonUser actualVogonUser = new VogonUser("", "iloveyou");

        assertEquals(0L, actualVogonUser.getVersion());
        assertNull(actualVogonUser.getUsername());
        assertEquals("iloveyou", actualVogonUser.getPassword());
    }

    @Test
    public void testGetAccounts() {
        assertTrue((new VogonUser("janedoe", "iloveyou")).getAccounts().isEmpty());
    }

    @Test
    public void testGetTransactions() {
        assertTrue((new VogonUser("janedoe", "iloveyou")).getTransactions().isEmpty());
    }

    @Test
    public void testSetUsername() {
        VogonUser vogonUser = new VogonUser("janedoe", "iloveyou");
        vogonUser.setUsername("janedoe");
        assertEquals("janedoe", vogonUser.getUsername());
    }

    @Test
    public void testSetUsername2() {
        VogonUser vogonUser = new VogonUser("janedoe", "iloveyou");
        vogonUser.setUsername(null);
        assertNull(vogonUser.getUsername());
    }

    @Test
    public void testSetUsername3() {
        VogonUser vogonUser = new VogonUser("janedoe", "iloveyou");
        vogonUser.setUsername("");
        assertNull(vogonUser.getUsername());
    }

    @Test
    public void testSetPassword() {
        VogonUser vogonUser = new VogonUser("janedoe", "iloveyou");
        vogonUser.setPassword("iloveyou");
        assertEquals("iloveyou", vogonUser.getPassword());
    }

    @Test
    public void testSetPassword2() {
        VogonUser vogonUser = new VogonUser("janedoe", "iloveyou");
        vogonUser.setPassword(null);
        assertNull(vogonUser.getPassword());
    }

    @Test
    public void testSetPassword3() {
        VogonUser vogonUser = new VogonUser("janedoe", "iloveyou");
        vogonUser.setPassword("");
        assertNull(vogonUser.getPassword());
    }

    @Test
    public void testEquals() {
        VogonUser vogonUser = new VogonUser();
        vogonUser.setPassword("iloveyou");
        vogonUser.setUsername("janedoe");
        vogonUser.setVersion(1L);
        assertFalse(vogonUser.equals(null));
    }

    @Test
    public void testEquals2() {
        VogonUser vogonUser = new VogonUser();
        vogonUser.setPassword("iloveyou");
        vogonUser.setUsername("janedoe");
        vogonUser.setVersion(1L);
        assertFalse(vogonUser.equals("Different type to VogonUser"));
    }

    @Test
    public void testEquals3() {
        VogonUser vogonUser = new VogonUser();
        vogonUser.setPassword("iloveyou");
        vogonUser.setUsername("janedoe");
        vogonUser.setVersion(1L);
        assertTrue(vogonUser.equals(vogonUser));
        int expectedHashCodeResult = vogonUser.hashCode();
        assertEquals(expectedHashCodeResult, vogonUser.hashCode());
    }

    @Test
    public void testEquals4() {
        VogonUser vogonUser = new VogonUser();
        vogonUser.setPassword("iloveyou");
        vogonUser.setUsername("janedoe");
        vogonUser.setVersion(1L);

        VogonUser vogonUser1 = new VogonUser();
        vogonUser1.setPassword("iloveyou");
        vogonUser1.setUsername("janedoe");
        vogonUser1.setVersion(1L);
        assertTrue(vogonUser.equals(vogonUser1));
        int expectedHashCodeResult = vogonUser.hashCode();
        assertEquals(expectedHashCodeResult, vogonUser1.hashCode());
    }
}

