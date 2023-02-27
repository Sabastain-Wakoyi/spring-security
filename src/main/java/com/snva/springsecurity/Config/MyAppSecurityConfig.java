package com.snva.springsecurity.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


public class MyAppSecurityConfig   {



   // @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
//                .httpBasic() for apis
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/user").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/student").hasRole("STUDENT")
                .antMatchers(HttpMethod.GET,"/admin").hasRole("ADMIN")
                .and()
                .csrf().disable();

    }

   // @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("{noop}userpassword").roles("USER")
                .and()
                .withUser("student").password("{noop}studentpassword").roles("STUDENT")
                .and()
                .withUser("admin").password("{noop}adminpassword").roles("ADMIN","USER","STUDENT");

    }


}
