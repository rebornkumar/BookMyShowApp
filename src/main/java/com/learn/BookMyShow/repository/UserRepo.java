package com.learn.BookMyShow.repository;

import com.learn.BookMyShow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
