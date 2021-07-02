package org.zlogic.vogon.web;

import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class ApplicationDiffblueTest {
    @Test
    public void testConfigure() {
        Application application = new Application();
        Class<?> forNameResult = Object.class;
        Class<?> forNameResult1 = Object.class;
        SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(forNameResult, forNameResult1,
                Object.class);
        assertSame(springApplicationBuilder, application.configure(springApplicationBuilder));
    }
}

