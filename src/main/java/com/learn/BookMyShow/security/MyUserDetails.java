package com.learn.BookMyShow.security;


import com.learn.BookMyShow.entity.User;
import com.learn.BookMyShow.util.Constant;
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
        if(Constant.THEATRE_OWNER.equals(user.getUserType())) {
            authorities.add(new SimpleGrantedAuthority("role_user"));
            authorities.add(new SimpleGrantedAuthority("role_admin"));
        }
        else {
            authorities.add(new SimpleGrantedAuthority("role_user"));
        }
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
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
        return this.active;
    }
}
