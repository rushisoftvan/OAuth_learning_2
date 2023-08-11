package com.second.Oauthserver.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;


public class AuthServerConfig   {
//
//    private  final AuthenticationManager authenticationManager;
//
//    private final PasswordEncoder passwordEncoder;
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        security.passwordEncoder(passwordEncoder)
//                 .checkTokenAccess("permitAll()"); // permitAll() //isAuthenticated()
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//                .withClient("client1")
//                .secret("secret1")
//                .scopes("read")
//                //.accessTokenValiditySeconds(1000)
//                .authorizedGrantTypes("password","refresh_token")
//                .and()
//                .withClient("resourceserver")
//                .secret("12345");
//
//    }
//
//    @Bean
//    public TokenStore tokenStore() {
//        return new JwtTokenStore(converter());
//    }
//
//    @Bean
//    public JwtAccessTokenConverter converter() {
//        var conv = new JwtAccessTokenConverter();
//        conv.setSigningKey("secret");
//        return conv;
//    }
//
//
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.authenticationManager(authenticationManager)
//                .tokenStore(tokenStore())
//                .accessTokenConverter(converter());
//    }

}
