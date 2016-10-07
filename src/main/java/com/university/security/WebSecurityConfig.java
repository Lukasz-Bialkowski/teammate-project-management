package com.university.security;

import com.university.entity.enumeration.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginFailureHandler loginFailureHandler;

    @Autowired
    private LoginSuccesHandler loginSuccesHandler;

    @Autowired
    private AppEntryPoint appEntryPoint;

    @Autowired
    private CurrentUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(appEntryPoint)
                .and()
                .formLogin()
                .successHandler(loginSuccesHandler)
                .failureHandler(loginFailureHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/", "/home", "/src/**", "/vendor/**", "/assets/**", "/templates-app.js", "/templates-common.js", "/user/create",
                        "/user/save", "/user/employmentFormsList", "/user/positionsList").permitAll()
                .anyRequest().authenticated();
    }

    @Autowired
    public void setGlobalUser(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
                .and()
                .inMemoryAuthentication().withUser("admin").password("admin").roles(String.valueOf(Role.ADMIN));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
