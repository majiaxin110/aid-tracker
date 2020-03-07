package org.hackathon.aidtracker.auth.security;

import org.hackathon.aidtracker.auth.constant.SysConstant;
import org.hackathon.aidtracker.auth.constant.WxUrl;
import org.hackathon.aidtracker.auth.dto.WxAuthRes;
import org.hackathon.aidtracker.auth.filter.WechatAuthenticationFilter;
import org.hackathon.aidtracker.auth.util.WechatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Component(value = "authenticationProvider")
public class AuthenticationProviderImpl implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;

    private Logger logger = LoggerFactory.getLogger(AuthenticationProviderImpl.class);
    @Autowired
    public AuthenticationProviderImpl(UserDetailsService userDetailsService,
                                      BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String authCode = authentication.getName();
        String openId = WechatUtil.getOpenId(authCode);
        if(!StringUtils.isEmpty(openId)){
            UserDetails details = userDetailsService.loadUserByUsername(openId);
            if(Objects.isNull(details)){
                //first login ; go register
                throw new UsernameNotFoundException("first login");
            }else{
                return new UsernamePasswordAuthenticationToken(openId, SysConstant.phantomPass, details.getAuthorities());
            }
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authenticationClz) {
        return authenticationClz.equals(UsernamePasswordAuthenticationToken.class);
    }
}
