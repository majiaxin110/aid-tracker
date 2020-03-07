package org.hackathon.aidtracker.auth.dto;

import org.hackathon.aidtracker.auth.constant.SysConstant;
import org.hackathon.aidtracker.system.entity.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class JwtUser implements UserDetails {

    private String openId;
    private Collection<? extends GrantedAuthority> authorities;
    private SysUser sysUser;
    //现在只支持一个用户一个角色
    public JwtUser(SysUser sysUser){
        this.openId=sysUser.getOpenId();
        List<SimpleGrantedAuthority> authList = new ArrayList<>();
        authList.add(new SimpleGrantedAuthority(sysUser.getRole().val()));
        authorities=authList;
        this.sysUser=sysUser;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return SysConstant.phantomPass;
    }

    @Override
    public String getUsername() {
        return openId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
