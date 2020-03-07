package org.hackathon.aidtracker.auth.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public interface BaseUser{
    String getPassword();
    Collection<? extends GrantedAuthority> getAuthorities();

    default Collection<? extends GrantedAuthority> formatAuth(String auth){
        List<SimpleGrantedAuthority> authList = new ArrayList<>();
        Arrays.stream(auth.split(",")).forEach(a -> authList.add(new SimpleGrantedAuthority(a)));
        return authList;
    }

}
