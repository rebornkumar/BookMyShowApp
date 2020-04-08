package com.learn.BookMyShow.repository;

import com.learn.BookMyShow.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepo extends JpaRepository<Show,Integer> {
}
