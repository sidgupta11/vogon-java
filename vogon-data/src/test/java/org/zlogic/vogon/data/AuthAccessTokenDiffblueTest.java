package org.zlogic.vogon.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.junit.Test;

public class AuthAccessTokenDiffblueTest {
    @Test
    public void testConstructor() {
        AuthAccessToken actualAuthAccessToken = new AuthAccessToken();
        assertNull(actualAuthAccessToken.getAuthentication());
        assertNull(actualAuthAccessToken.getToken());
    }

    @Test
    public void testConstructor2() throws UnsupportedEncodingException {
        Date date = new Date(1L);
        byte[] bytes = "AAAAAAAAAAAAAAAAAAAAAAAA".getBytes("UTF-8");
        byte[] bytes1 = "AAAAAAAAAAAAAAAAAAAAAAAA".getBytes("UTF-8");
        AuthAccessToken actualAuthAccessToken = new AuthAccessToken("42", "42", "42", "janedoe", "ABC123", date, bytes,
                bytes1);

        byte[] authentication = actualAuthAccessToken.getAuthentication();
        assertEquals(24, authentication.length);
        byte[] token = actualAuthAccessToken.getToken();
        assertEquals(24, token.length);
        assertEquals(1, date.getDate());
        assertEquals("Thu Jan 01 05:30:00 IST 1970", date.toString());
        assertEquals("01-Jan-1970, 5:30:00 AM", date.toLocaleString());
        assertEquals(70, date.getYear());
        assertEquals(-330, date.getTimezoneOffset());
        assertEquals(1L, date.getTime());
        assertEquals(0, date.getSeconds());
        assertEquals(0, date.getMonth());
        assertEquals(30, date.getMinutes());
        assertEquals(5, date.getHours());
        assertEquals(4, date.getDay());
        assertSame(token, bytes);
        assertSame(authentication, bytes1);
    }
}

