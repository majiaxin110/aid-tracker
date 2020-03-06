package org.hackathon.aidtracker.auth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component(value = "authenticationProvider")
public class AuthenticationProviderImpl implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AuthenticationProviderImpl(UserDetailsService userDetailsService,
                                      BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //todo
        // for wechat user and system keeper authentication
//        String username = authentication.getName();
//        String password = authentication.getCredentials().toString();
//        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//        if (!bCryptPasswordEncoder.matches(password, userDetails.getPassword())) {
//            throw new AuthenticationCredentialsNotFoundException("invalid password");
//        }
//        return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
        return null;
    }

    @Override
    public boolean supports(Class<?> authenticationClz) {
        return authenticationClz.equals(UsernamePasswordAuthenticationToken.class);
    }
}
