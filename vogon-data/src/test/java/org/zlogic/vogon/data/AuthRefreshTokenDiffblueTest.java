package org.zlogic.vogon.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class AuthRefreshTokenDiffblueTest {
    @Test
    public void testConstructor() {
        AuthRefreshToken actualAuthRefreshToken = new AuthRefreshToken();
        assertNull(actualAuthRefreshToken.getAuthentication());
        assertNull(actualAuthRefreshToken.getToken());
    }

    @Test
    public void testConstructor2() throws UnsupportedEncodingException {
        byte[] bytes = "AAAAAAAAAAAAAAAAAAAAAAAA".getBytes("UTF-8");
        byte[] bytes1 = "AAAAAAAAAAAAAAAAAAAAAAAA".getBytes("UTF-8");
        AuthRefreshToken actualAuthRefreshToken = new AuthRefreshToken("42", bytes, bytes1);

        byte[] authentication = actualAuthRefreshToken.getAuthentication();
        assertEquals(24, authentication.length);
        byte[] token = actualAuthRefreshToken.getToken();
        assertEquals(24, token.length);
        assertSame(token, bytes);
        assertSame(authentication, bytes1);
    }
}

