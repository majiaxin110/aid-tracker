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


    private Logger logger = LoggerFactory.getLogger(AuthenticationProviderImpl.class);
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String openId = authentication.getName();
        String[] split = authentication.getCredentials().toString().split("_");
        SysConstant.LoginType loginType = SysConstant.LoginType.valueOf(split[0]);
        String roleFlg =split.length>1? split[1]:"";
        if(SysConstant.LoginType.firstLogin.equals(loginType)){
            throw new UsernameNotFoundException(openId);
        }else{
            if("withRole".equals(roleFlg)){
                return new UsernamePasswordAuthenticationToken(openId, loginType.name(), null);
            }else if("withoutRole".equals(roleFlg)){
                throw new UsernameNotFoundException(openId);
            }
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authenticationClz) {
        return authenticationClz.equals(UsernamePasswordAuthenticationToken.class);
    }
}
