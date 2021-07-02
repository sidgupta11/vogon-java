package org.zlogic.vogon.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@ContextConfiguration(classes = {WebConfig.class})
@RunWith(SpringRunner.class)
public class WebConfigDiffblueTest {
    @MockBean
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    private WebConfig webConfig;

    @Test
    public void testAddViewControllers() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        this.webConfig.addViewControllers(new ViewControllerRegistry(new AnnotationConfigReactiveWebApplicationContext()));
    }

    @Test
    public void testAddViewControllers2() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        ViewControllerRegistry viewControllerRegistry = new ViewControllerRegistry(
                new AnnotationConfigReactiveWebApplicationContext());
        viewControllerRegistry.addRedirectViewController("https://example.org/example", "https://example.org/example");
        this.webConfig.addViewControllers(viewControllerRegistry);
    }

    @Test
    public void testAddViewControllers3() {
        ViewControllerRegistry viewControllerRegistry = mock(ViewControllerRegistry.class);
        when(viewControllerRegistry.addViewController(anyString()))
                .thenReturn(new ViewControllerRegistration("https://example.org/example"));
        this.webConfig.addViewControllers(viewControllerRegistry);
        verify(viewControllerRegistry).addViewController(anyString());
    }

    @Test
    public void testAddViewControllers4() {
        ViewControllerRegistration viewControllerRegistration = mock(ViewControllerRegistration.class);
        doNothing().when(viewControllerRegistration).setViewName(anyString());
        ViewControllerRegistry viewControllerRegistry = mock(ViewControllerRegistry.class);
        when(viewControllerRegistry.addViewController(anyString())).thenReturn(viewControllerRegistration);
        this.webConfig.addViewControllers(viewControllerRegistry);
        verify(viewControllerRegistry).addViewController(anyString());
        verify(viewControllerRegistration).setViewName(anyString());
    }

    @Test
    public void testGetViewResolver() {
        assertTrue(
                this.webConfig.getViewResolver() instanceof org.springframework.web.servlet.view.InternalResourceViewResolver);
    }

    @Test
    public void testConfigureMessageConverters() {
        ArrayList<HttpMessageConverter<?>> httpMessageConverterList = new ArrayList<HttpMessageConverter<?>>();
        this.webConfig.configureMessageConverters(httpMessageConverterList);
        assertEquals(2, httpMessageConverterList.size());
        assertEquals(2, httpMessageConverterList.get(1).getSupportedMediaTypes().size());
    }

    @Test
    public void testAddArgumentResolvers() {
        ArrayList<HandlerMethodArgumentResolver> handlerMethodArgumentResolverList = new ArrayList<HandlerMethodArgumentResolver>();
        this.webConfig.addArgumentResolvers(handlerMethodArgumentResolverList);
        assertEquals(1, handlerMethodArgumentResolverList.size());
    }

    @Test
    public void testConfigureDefaultServletHandling() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        this.webConfig.configureDefaultServletHandling(new DefaultServletHandlerConfigurer(new MockServletContext()));
    }

    @Test
    public void testConfigureDefaultServletHandling2() {
        DefaultServletHandlerConfigurer defaultServletHandlerConfigurer = mock(DefaultServletHandlerConfigurer.class);
        doNothing().when(defaultServletHandlerConfigurer).enable();
        this.webConfig.configureDefaultServletHandling(defaultServletHandlerConfigurer);
        verify(defaultServletHandlerConfigurer).enable();
    }
}

