package com.lynas.service;

import com.lynas.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by LynAs on 26-Feb-16
 */
@Service(value = "UserDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    AppUserService appUserService;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = appUserService.readAppUserByUserName(userName);
        System.out.println(appUser.getUserName());

        if (appUser !=null){
            Collection<GrantedAuthority> authorities = appUser.getRoles().stream()
                    .map(userRole -> new SimpleGrantedAuthority(userRole.getName()))
                    .collect(Collectors.toCollection(ArrayList::new));

            return new org.springframework.security.core.userdetails.
                    User(userName, appUser.getPassword(), true, true, true, true, authorities);

        }else {
            throw new UsernameNotFoundException("user name not found");
        }
    }
}
