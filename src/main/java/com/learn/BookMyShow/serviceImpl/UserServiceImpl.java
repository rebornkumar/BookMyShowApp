package com.learn.BookMyShow.serviceImpl;

import com.learn.BookMyShow.entity.Role;
import com.learn.BookMyShow.entity.User;
import com.learn.BookMyShow.repository.RoleRepo;
import com.learn.BookMyShow.repository.UserRepo;
import com.learn.BookMyShow.service.UserService;
import com.learn.BookMyShow.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;

    public User findUserByEmail(String email) {
        return userRepo.findUserByEmail(email);
    }

    public User findUserByUsername(String userName) {
        return userRepo.findUserByUsername(userName);
    }

    public void saveUser(User user) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setActive(true);
        userRepo.save(user);
//        if(Constant.END_USER.equalsIgnoreCase(user.getUserType())) {
//            Role userRole = roleRepo.findByRole("ADMIN");
//        }
////        Role userRole = roleRepository.findByRole("ADMIN");
////        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));

    }
}
