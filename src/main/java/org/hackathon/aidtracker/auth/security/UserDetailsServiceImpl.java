package org.hackathon.aidtracker.auth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component(value = "userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {



    @Autowired
    public UserDetailsServiceImpl(){

    }
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //todo
        //
      return null;
    }
}
