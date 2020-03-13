package org.hackathon.aidtracker.auth.exception;

import org.hackathon.aidtracker.system.entity.SysUser;
import org.springframework.security.core.AuthenticationException;

public class OpenIdAuthenticationException extends AuthenticationException {

    private SysUser sysUser;

    public OpenIdAuthenticationException(String msg) {
        super(msg);
    }

    public OpenIdAuthenticationException(SysUser sysUser) {
        super("this user hasn't been assigned a role");
        this.sysUser=sysUser;
    }

    public SysUser getSysUser() {
        return sysUser;
    }
}
