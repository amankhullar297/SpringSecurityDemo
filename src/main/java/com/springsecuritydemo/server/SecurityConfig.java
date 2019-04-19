package com.springsecuritydemo.server;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
    @EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        PasswordEncoder passEncoder;


        @Autowired
        AuthenticationSuccessHandler authSuccess;

        @Autowired
        UserDetailsService userDetailsService;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService).passwordEncoder(passEncoder);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable().formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/login_process")
                    .successHandler(authSuccess)
                    .failureUrl("/login")
                    .and().authorizeRequests().antMatchers("/Admin/**").hasAuthority("admin").
                    and().authorizeRequests().antMatchers("/User/**").hasAuthority("user").and()
                    .logout().logoutSuccessUrl("/login").invalidateHttpSession(true);
        }

    }

