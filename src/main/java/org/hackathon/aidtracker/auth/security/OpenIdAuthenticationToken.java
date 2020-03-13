package org.hackathon.aidtracker.auth.security;

import org.hackathon.aidtracker.auth.dto.OpenIdAuthUser;
import org.hackathon.aidtracker.system.entity.SysUser;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class OpenIdAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = 520L;
    private final String openId;
    private OpenIdAuthUser openIdUser;
    private SysUser sysUser;
    public OpenIdAuthenticationToken(String openId, SysUser sysUser, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.openId = openId;
        this.sysUser=sysUser;
        super.setAuthenticated(true);
    }
    public OpenIdAuthenticationToken(String openId, OpenIdAuthUser openIdUser){
        super(null);
        this.openId=openId;
        this.openIdUser=openIdUser;
        this.setAuthenticated(false);
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return openIdUser;
    }

    @Override
    public Object getPrincipal() {
        return this.openId;
    }

    @Override
    public void setAuthenticated(boolean authenticated) {
        if (authenticated) {
            throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        }
        super.setAuthenticated(false);
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
        this.openIdUser = null;
    }
}
