package com.learn.BookMyShow.repository;

import com.learn.BookMyShow.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShowRepo extends JpaRepository<Show,Integer> {
    Optional<Show>findById(Integer showId);
}
