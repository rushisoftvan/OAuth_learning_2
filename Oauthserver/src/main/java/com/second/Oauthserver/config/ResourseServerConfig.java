package com.second.Oauthserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourseServerConfig extends ResourceServerConfigurerAdapter {

    // product-service(Resource server) - Public URLS needs to configure here with
    //                                    anonymous user enables
    // Another service (Authorization server)

    public static final String[] PUBLIC_URLS = {
            "/test1",
            "/name",
            "/test",
            "/m1"
    };

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .anonymous().and()
                .authorizeRequests()
                .antMatchers(PUBLIC_URLS).permitAll()
                //.antMatchers("/check").hasAuthority("ADMIN")
                .anyRequest().authenticated();
        ;
    }




}
