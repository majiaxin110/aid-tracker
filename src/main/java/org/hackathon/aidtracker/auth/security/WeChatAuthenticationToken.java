package org.hackathon.aidtracker.auth.security;

import org.hackathon.aidtracker.auth.dto.BaseUser;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class WeChatAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = 520L;
    private final String openId;
    private BaseUser baseUser;
    private Boolean firstLogin;
    public WeChatAuthenticationToken(String openId,BaseUser baseUser, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.openId = openId;
        this.baseUser = baseUser;
        super.setAuthenticated(true);
    }
    public WeChatAuthenticationToken(String openId,BaseUser baseUser,boolean firstLogin){
        super(null);
        this.openId=openId;
        this.baseUser=baseUser;
        this.firstLogin=firstLogin;
        this.setAuthenticated(false);
    }
    public WeChatAuthenticationToken(String openId,BaseUser baseUser){
        super(null);
        this.openId=openId;
        this.baseUser=baseUser;
        this.firstLogin=true;
        this.setAuthenticated(false);
    }

    @Override
    public Object getCredentials() {
        return this.baseUser;
    }

    @Override
    public Object getDetails() {
        return firstLogin;
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
        this.baseUser = null;
    }
}
