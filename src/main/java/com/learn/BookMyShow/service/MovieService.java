package com.learn.BookMyShow.service;

import com.learn.BookMyShow.dto.MovieDto;
import com.learn.BookMyShow.dto.ResponseDto;
import com.learn.BookMyShow.entity.Movie;

import java.util.Map;
import java.util.Optional;

public interface MovieService {
//
//    void createUpdateMovie();
//    Optional<Movie> getByMovieIdOrMovieTitle(Integer movieId,String movieTitle);
        ResponseDto createMovie(MovieDto movieDto);
}
