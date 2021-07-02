package org.zlogic.vogon.web;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

public class SecurityConfigDiffblueTest {
    @Test
    public void testAuthenticationMananagerProviderAuthenticationManagerBean() throws Exception {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        ((new SecurityConfig()).new AuthenticationMananagerProvider()).authenticationManagerBean();
    }

    @Test
    public void testOAuth2SecurityConfigConfigure() throws Exception {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        SecurityConfig.OAuth2SecurityConfig oAuth2SecurityConfig = new SecurityConfig.OAuth2SecurityConfig();
        oAuth2SecurityConfig.configure(new ClientDetailsServiceConfigurer(null));
    }

    @Test
    public void testOAuth2SecurityConfigConfigure2() throws Exception {
        SecurityConfig.OAuth2SecurityConfig oAuth2SecurityConfig = new SecurityConfig.OAuth2SecurityConfig();
        AuthorizationServerEndpointsConfigurer authorizationServerEndpointsConfigurer = new AuthorizationServerEndpointsConfigurer();
        oAuth2SecurityConfig.configure(authorizationServerEndpointsConfigurer);
        assertTrue(authorizationServerEndpointsConfigurer
                .getTokenStore() instanceof org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore);
    }

    @Test
    public void testOAuth2SecurityConfigConfigure3() throws Exception {
        SecurityConfig.OAuth2SecurityConfig oAuth2SecurityConfig = new SecurityConfig.OAuth2SecurityConfig();

        AuthorizationServerEndpointsConfigurer authorizationServerEndpointsConfigurer = new AuthorizationServerEndpointsConfigurer();
        authorizationServerEndpointsConfigurer.addInterceptor(new UserRoleAuthorizationInterceptor());
        oAuth2SecurityConfig.configure(authorizationServerEndpointsConfigurer);
        assertTrue(authorizationServerEndpointsConfigurer
                .getTokenStore() instanceof org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore);
    }

    @Test
    public void testOAuth2SecurityConfigConfigure4() throws Exception {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        SecurityConfig.OAuth2SecurityConfig oAuth2SecurityConfig = new SecurityConfig.OAuth2SecurityConfig();
        oAuth2SecurityConfig.configure(new AuthorizationServerSecurityConfigurer());
    }

    @Test
    public void testOAuth2SecurityConfigConfigure5() throws Exception {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        SecurityConfig.OAuth2SecurityConfig oAuth2SecurityConfig = new SecurityConfig.OAuth2SecurityConfig();

        AuthorizationServerSecurityConfigurer authorizationServerSecurityConfigurer = new AuthorizationServerSecurityConfigurer();
        authorizationServerSecurityConfigurer.addObjectPostProcessor(null);
        oAuth2SecurityConfig.configure(authorizationServerSecurityConfigurer);
    }

    @Test
    public void testResourceServerConfigure() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        SecurityConfig.ResourceServer resourceServer = new SecurityConfig.ResourceServer();
        resourceServer.configure(new ResourceServerSecurityConfigurer());
    }

    @Test
    public void testResourceServerConfigure2() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        SecurityConfig.ResourceServer resourceServer = new SecurityConfig.ResourceServer();

        ResourceServerSecurityConfigurer resourceServerSecurityConfigurer = new ResourceServerSecurityConfigurer();
        resourceServerSecurityConfigurer.addObjectPostProcessor(null);
        resourceServer.configure(resourceServerSecurityConfigurer);
    }

    @Test
    public void testTokenStore() {
        // TODO: This test is incomplete.
        //   Reason: Nothing to assert: neither the return value type of the method under test nor the types of its parameters have observers (e.g. getters or public fields).
        //   Add observers (e.g. getters or public fields) to the declaring class
        //   of the method under test, its return type or any of its parameter
        //   types.
        //   See https://diff.blue/R003

        (new SecurityConfig()).tokenStore();
    }
}

