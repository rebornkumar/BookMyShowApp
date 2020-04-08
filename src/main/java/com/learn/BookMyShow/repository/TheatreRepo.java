package com.learn.BookMyShow.repository;

import com.learn.BookMyShow.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepo extends JpaRepository<Theatre,Integer> {
}
