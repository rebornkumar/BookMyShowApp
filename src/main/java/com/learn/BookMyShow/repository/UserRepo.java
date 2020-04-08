package com.learn.BookMyShow.repository;

import com.learn.BookMyShow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    User findUserByUsername(String username);

    User findUserByEmail(String email);
}
