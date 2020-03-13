package org.hackathon.aidtracker.auth.security;

import cn.hutool.core.collection.CollUtil;
import org.hackathon.aidtracker.auth.dto.BaseUser;
import org.hackathon.aidtracker.auth.dto.OpenIdAuthUser;
import org.hackathon.aidtracker.auth.exception.OpenIdAuthenticationException;
import org.hackathon.aidtracker.system.entity.SysUser;
import org.hackathon.aidtracker.system.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class OpenIdAuthenticationProvider implements AuthenticationProvider {


    private Logger logger = LoggerFactory.getLogger(OpenIdAuthenticationProvider.class);

    private SysUserService sysUserService;

    @Autowired
    public OpenIdAuthenticationProvider(SysUserService sysUserService){
        this.sysUserService=sysUserService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String openId = String.valueOf(authentication.getPrincipal());

        SysUser sysUser = sysUserService.findByOpenId(openId);

        OpenIdAuthUser openIdUser = (OpenIdAuthUser) authentication.getDetails();

        if (Objects.isNull(sysUser)) {
            //first login create sysUser
            SysUser newUser = new SysUser();
            newUser.setOpenId(openId);
            newUser.setNickname(openIdUser.getNickname());
            newUser.setAvatarUrl(openIdUser.getAvatarUrl());
            sysUserService.save(newUser);
            throw new OpenIdAuthenticationException(newUser);
        } else {
            // not first login update sysUser
            sysUser.setNickname(openIdUser.getNickname());
            sysUser.setAvatarUrl(openIdUser.getAvatarUrl());
            sysUserService.save(sysUser);

            //not first login but without role
            if(Objects.isNull(sysUser.getRole())){
                throw new OpenIdAuthenticationException(sysUser);
            }

            //not first login and has role
            return new OpenIdAuthenticationToken(openId,sysUser,CollUtil.newArrayList(new SimpleGrantedAuthority(sysUser.getRole().val())));
        }
    }

    @Override
    public boolean supports(Class<?> authenticationClz) {
        return  OpenIdAuthenticationToken.class.equals(authenticationClz);
    }
}
