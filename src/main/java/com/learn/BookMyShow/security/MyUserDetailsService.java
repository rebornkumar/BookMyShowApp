package com.learn.BookMyShow.security;

import com.learn.BookMyShow.entity.Role;
import com.learn.BookMyShow.entity.User;
import com.learn.BookMyShow.repository.RoleRepo;
import com.learn.BookMyShow.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findUserByUsername(username);
        UserDetails userDetails = new MyUserDetails(user);
        return userDetails;
        //find user by user name from database
        // create instance of UserDetails from user name;
    }
}
