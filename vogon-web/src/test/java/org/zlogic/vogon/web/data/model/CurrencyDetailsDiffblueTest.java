package org.zlogic.vogon.web.data.model;

import static org.junit.Assert.assertNull;

import org.junit.Test;

public class CurrencyDetailsDiffblueTest {
    @Test
    public void testConstructor() {
        new CurrencyDetails(null);
        assertNull(null);
    }
}

