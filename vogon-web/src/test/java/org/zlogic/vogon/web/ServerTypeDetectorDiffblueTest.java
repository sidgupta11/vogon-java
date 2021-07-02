package org.zlogic.vogon.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = {ServerTypeDetector.class})
@RunWith(SpringRunner.class)
public class ServerTypeDetectorDiffblueTest {
    @Autowired
    private ServerTypeDetector serverTypeDetector;

    @Test
    public void testHasEnvironmentVariable() {
        assertFalse(this.serverTypeDetector.hasEnvironmentVariable(Pattern.compile(".*\\.txt")));
        assertFalse(this.serverTypeDetector.hasEnvironmentVariable(Pattern.compile("42", 1)));
    }

    @Test
    public void testGetCloudType() {
        assertEquals(ServerTypeDetector.CloudType.NONE, this.serverTypeDetector.getCloudType());
    }

    @Test
    public void testGetServerType() {
        assertEquals(ServerTypeDetector.ServerType.STANDALONE, this.serverTypeDetector.getServerType());
    }

    @Test
    public void testGetDatabaseType() {
        assertEquals(ServerTypeDetector.DatabaseType.H2, this.serverTypeDetector.getDatabaseType());
    }

    @Test
    public void testConstructor() {
        ServerTypeDetector actualServerTypeDetector = new ServerTypeDetector();
        assertNull(actualServerTypeDetector.getKeystoreFile());
        assertNull(actualServerTypeDetector.getKeystorePassword());
    }
}

