package com.second.Oauthserver.config;

import com.second.Oauthserver.service.JpaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private  AuthenticationManager authenticationManager;

    @Autowired
    private JpaUserDetailsService jpaUserDetailsService;


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                ;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients
                .inMemory()
                .withClient("ClientId")
                .secret("secret")
                .authorizedGrantTypes("password","refresh_token", "authorization_code", "implicit")
                .scopes("user_info","read","write")
                .accessTokenValiditySeconds(900)
                .refreshTokenValiditySeconds(1800)
                .autoApprove(true);
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("QWERTY");
        return converter;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        endpoints.authenticationManager(authenticationManager).userDetailsService(jpaUserDetailsService)

                .tokenStore(tokenStore())
                .accessTokenConverter(accessTokenConverter());

    }

}
