package org.hackathon.aidtracker.auth.exception;

import org.hackathon.aidtracker.auth.dto.BaseUser;
import org.springframework.security.core.AuthenticationException;

public class WeChatAuthenticationException extends AuthenticationException {

    private BaseUser baseUser;

    public WeChatAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }

    public WeChatAuthenticationException(String msg) {
        super(msg);
    }

    public WeChatAuthenticationException(BaseUser baseUser) {
        super("msg");
        this.baseUser=baseUser;
    }

    public BaseUser getBaseUser() {
        return baseUser;
    }
}
