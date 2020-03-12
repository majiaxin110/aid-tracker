package org.hackathon.aidtracker.auth.security;

import org.hackathon.aidtracker.auth.dto.BaseUser;
import org.hackathon.aidtracker.auth.exception.WeChatAuthenticationException;
import org.hackathon.aidtracker.constant.SysConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Objects;

@Component(value = "authenticationProvider")
public class AuthenticationProviderImpl implements AuthenticationProvider {


    private Logger logger = LoggerFactory.getLogger(AuthenticationProviderImpl.class);
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String openId =  String.valueOf(authentication.getPrincipal());

        BaseUser baseUser=(BaseUser) authentication.getCredentials();

        Boolean firstLogin = (Boolean) authentication.getDetails();

        if(firstLogin){
            throw new WeChatAuthenticationException(baseUser);
        }

        Collection<? extends GrantedAuthority> authorities = baseUser.getAuthorities();

        //not first login but without role
        if(Objects.isNull(authorities)||authorities.size()==0){
            throw new WeChatAuthenticationException(baseUser);
        }

        //not first login and has role
        return new WeChatAuthenticationToken(openId,baseUser,authorities);
    }

    @Override
    public boolean supports(Class<?> authenticationClz) {
        return authenticationClz.equals(WeChatAuthenticationToken.class);
    }
}
