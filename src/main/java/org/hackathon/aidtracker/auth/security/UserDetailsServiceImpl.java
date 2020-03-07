package org.hackathon.aidtracker.auth.security;

import org.hackathon.aidtracker.auth.dto.JwtUser;
import org.hackathon.aidtracker.system.dao.SysUserRepo;
import org.hackathon.aidtracker.system.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component(value = "userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private SysUserRepo sysUserRepo;

    @Autowired
    public UserDetailsServiceImpl(SysUserRepo sysUserRepo){
        this.sysUserRepo=sysUserRepo;
    }
    @Override
    public UserDetails loadUserByUsername(String openId) throws UsernameNotFoundException {
        Optional<SysUser> op = sysUserRepo.findById(openId);
        return op.map(JwtUser::new).orElse(null);
    }
}
