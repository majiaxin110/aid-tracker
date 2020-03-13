package org.hackathon.aidtracker.auth.dto;

import org.springframework.util.StringUtils;

public class PasswordAuthUser {
    private String username;
    private String password;
    private boolean rememberMe;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username= StringUtils.isEmpty(username)?"":username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = StringUtils.isEmpty(password)?"":password;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
