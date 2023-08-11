package com.second.Oauthserver.config;

import com.second.Oauthserver.service.JpaUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

   // private final PasswordEncoder passwordEncoder;
    private final JpaUserDetailsService jpaUserDetailsService;
//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//        var uds = new InMemoryUserDetailsManager();
//        var u = User.withUsername("john")
//                .password("12345")
//                .authorities("read")
//                .build();
//        uds.createUser(u);
//        return uds;
//    }



    //@Override
   /* protected void configure(HttpSecurity http) throws Exception {
        http
                .anonymous().and()
                .csrf()
                .disable()
                .headers().frameOptions()
                .disable()
                .and()
                .requestMatchers().antMatchers("/check")
                .and().authorizeRequests()
                //.authorizeRequests()
//                .antMatchers("/test1").permitAll()
               //.antMatchers("/name")
                //.permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic().disable();
    }
*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jpaUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        log.info("<<<<configure method");
//        http.requestMatcher(new RequestHeaderRequestMatcher("Authorization"))
//                .authorizeRequests()
//                .antMatchers("/**").authenticated()
//                .antMatchers(HttpMethod.POST, "/users").permitAll();
       // http.csrf().disable().authorizeRequests().anyRequest().authenticated();

        http
                .exceptionHandling()
                .authenticationEntryPoint((request, response, e) ->
                {
                    System.out.println("Test123123123123");
                    Authentication g = SecurityContextHolder.getContext().getAuthentication();
                    System.out.println("g.getAuthorities() :::" + g);
                    response.setContentType("application/json;charset=UTF-8");
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                });
    }

  /*  @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("<<<<<<<<<<<configure");
        List<RequestMatcher> requestMatchers = new ArrayList<RequestMatcher>();
        requestMatchers.add(new AntPathRequestMatcher("/check/**"));

        http.anonymous().and()
                .requestMatcher(new OrRequestMatcher(requestMatchers)).
                authorizeRequests().antMatchers("/check/**")
                .permitAll();
    }
*/
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//       web.ignoring().antMatchers(HttpMethod.GET,"/test1")
//               .antMatchers(HttpMethod.POST,"/users")
//               .antMatchers(HttpMethod.GET,"/test1") ;
//    }



//    @Autowired
//    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring().antMatchers(HttpMethod.POST,"/users")
                .antMatchers(HttpMethod.POST,"/userone");
    }

}
