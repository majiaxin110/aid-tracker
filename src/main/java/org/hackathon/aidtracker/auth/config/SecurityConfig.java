package org.hackathon.aidtracker.auth.config;

import org.hackathon.aidtracker.auth.constant.SysConstant;
import org.hackathon.aidtracker.auth.exception.JwtAccessDeniedHandler;
import org.hackathon.aidtracker.auth.exception.JwtAuthenticationEntryPoint;
import org.hackathon.aidtracker.auth.filter.JwtAuthenticationFilter;
import org.hackathon.aidtracker.auth.filter.LoginAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private AuthenticationProvider authenticationProvider;

    @Autowired
    public SecurityConfig(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider=authenticationProvider;
    }

    @Override
    public void configure(AuthenticationManagerBuilder authBuilder) throws Exception {
        authBuilder.authenticationProvider(authenticationProvider);
    }

    @Override
    public void configure(WebSecurity web) {
        ApplicationContext context = AppContextAccessor.getContext();
        AutowireCapableBeanFactory autowireCapableBeanFactory = context.getAutowireCapableBeanFactory();
        web.ignoring().antMatchers(SysConstant.STATIC_RESOURCE);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.cors()
                .and()
                .csrf().disable().httpBasic()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(new LoginAuthenticationFilter(SysConstant.AUTH_PATH, authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                //.sessionManagement().maximumSessions(1).expiredSessionStrategy(expiredSessionStrategy());
                //.sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(true);
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new JwtAuthenticationEntryPoint()) //anonymous
                .accessDeniedHandler(new JwtAccessDeniedHandler()) //with token but without permission
                .and()
                .formLogin(form -> form.loginPage(SysConstant.LOGIN_PATH).permitAll())
                .logout()
                .logoutUrl(SysConstant.LOGOUT_PATH)
                .logoutSuccessUrl(SysConstant.LOGIN_PATH);
    }
}
