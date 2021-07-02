package org.zlogic.vogon.web.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class UsernameExistsExceptionDiffblueTest {
    @Test
    public void testConstructor() {
        UsernameExistsException actualUsernameExistsException = new UsernameExistsException();
        assertNull(actualUsernameExistsException.getCause());
        assertEquals("org.zlogic.vogon.web.security.UsernameExistsException: User already exists",
                actualUsernameExistsException.toString());
        assertEquals(0, actualUsernameExistsException.getSuppressed().length);
        assertEquals("User already exists", actualUsernameExistsException.getMessage());
        assertEquals("User already exists", actualUsernameExistsException.getLocalizedMessage());
    }
}

