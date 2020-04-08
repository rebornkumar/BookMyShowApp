package com.learn.BookMyShow.security;


import com.learn.BookMyShow.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;


public class MyUserDetails implements UserDetails {

    private String userName;
    private String password;
    private boolean active;
    List<GrantedAuthority> authorities;
    public MyUserDetails(User user) {
        this.userName = user.getUsername();
        this.password = user.getPassword();
        this.active = user.getActive();
        if(user.getUserType().equals("app_user")) {
            authorities.add(new SimpleGrantedAuthority("role_user"));
        }
        else {
            authorities.add(new SimpleGrantedAuthority("role_user"));
            authorities.add(new SimpleGrantedAuthority("role_admin"));
        }
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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
        return active;
    }
}
