package com.learn.BookMyShow.repository;

import com.learn.BookMyShow.entity.Movie;

import java.util.Optional;

public interface MovieRepo {
    Optional<Movie> findByMovieTitle(String movieTitle);
}
