package org.zlogic.vogon.web.configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@ContextConfiguration(classes = {VogonConfiguration.class})
@RunWith(SpringRunner.class)
public class VogonConfigurationDiffblueTest {
    @Autowired
    private VogonConfiguration vogonConfiguration;

    @Test
    public void testIsAllowRegistration() {
        assertFalse(this.vogonConfiguration.isAllowRegistration());
    }

    @Test
    public void testGetTransactionsPageSize() {
        assertEquals(100, this.vogonConfiguration.getTransactionsPageSize());
    }

    @Test
    public void testGetTokenExpiresSeconds() {
        assertEquals(1209600, this.vogonConfiguration.getTokenExpiresSeconds());
    }
}

