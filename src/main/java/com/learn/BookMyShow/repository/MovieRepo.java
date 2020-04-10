package com.learn.BookMyShow.repository;

import com.learn.BookMyShow.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Integer> {
    Optional<Movie> findByMovieCode(String movieCode);
//    Optional<Movie> findByMovieTitle(String movieTitle);
}
