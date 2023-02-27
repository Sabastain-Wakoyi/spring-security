package com.snva.springsecurity.Config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class OpenIdConnectSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(request->request
                .antMatchers("/","index.html","/user").permitAll()
                .anyRequest().authenticated())
                .csrf(csrf->csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .logout(logout->logout.logoutSuccessUrl("/").permitAll())
                .oauth2Login(oauth-> oauth.successHandler((request,response,auth)->{
                   


                    response.sendRedirect("/");
                }));
    }
}
