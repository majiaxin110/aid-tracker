package org.hackathon.aidtracker.auth.config;

import org.hackathon.aidtracker.auth.filter.PasswordAuthenticationFilter;
import org.hackathon.aidtracker.auth.security.OpenIdAuthenticationProvider;
import org.hackathon.aidtracker.auth.security.PasswordAuthenticationProvider;
import org.hackathon.aidtracker.constant.SysConst;
import org.hackathon.aidtracker.auth.exception.JwtAccessDeniedHandler;
import org.hackathon.aidtracker.auth.exception.JwtAuthenticationEntryPoint;
import org.hackathon.aidtracker.auth.filter.JwtAuthenticationFilter;
import org.hackathon.aidtracker.auth.filter.OpenIdAuthenticationFilter;
import org.hackathon.aidtracker.system.dao.SysUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private PasswordAuthenticationProvider passwordAuthenticationProvider;
    private OpenIdAuthenticationProvider openIdAuthenticationProvider;
    @Autowired
    public SecurityConfig(PasswordAuthenticationProvider passwordAuthenticationProvider,
                          OpenIdAuthenticationProvider openIdAuthenticationProvider) {
        this.passwordAuthenticationProvider=passwordAuthenticationProvider;
        this.openIdAuthenticationProvider=openIdAuthenticationProvider;

    }

    @Override
    public void configure(AuthenticationManagerBuilder authBuilder) throws Exception {
        authBuilder.authenticationProvider(passwordAuthenticationProvider)
                .authenticationProvider(openIdAuthenticationProvider);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(SysConst.FILL_USER_PATH);
        web.ignoring().antMatchers(SysConst.TEST_RESOURCE);
        web.ignoring().antMatchers(SysConst.SWAGGER_RESOURCE);//
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.cors()
                .and()
                .csrf().disable().httpBasic()
                .and()
                .authorizeRequests().anyRequest().permitAll()
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilterAfter(new OpenIdAuthenticationFilter(SysConst.OPEN_ID_AUTH_PATH,authenticationManager()),JwtAuthenticationFilter.class)
                .addFilterAfter(new PasswordAuthenticationFilter(SysConst.PASSWORD_AUTH_PATH,authenticationManager()),JwtAuthenticationFilter.class)
//                .addFilter(new LoginAuthenticationFilter(SysConstant.AUTH_PATH, authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new JwtAuthenticationEntryPoint()) //anonymous
                .accessDeniedHandler(new JwtAccessDeniedHandler()); //with token but without permission;
    }
}
