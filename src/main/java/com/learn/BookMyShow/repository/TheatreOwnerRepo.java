package com.learn.BookMyShow.repository;

import com.learn.BookMyShow.entity.TheatreOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreOwnerRepo extends JpaRepository<TheatreOwner,Integer> {
}
