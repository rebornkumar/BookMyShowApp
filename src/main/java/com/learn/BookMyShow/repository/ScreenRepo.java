package com.learn.BookMyShow.repository;

import com.learn.BookMyShow.entity.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenRepo extends JpaRepository<Screen,Integer> {
}
