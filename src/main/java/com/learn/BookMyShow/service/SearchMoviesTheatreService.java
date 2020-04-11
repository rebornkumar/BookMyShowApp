package com.learn.BookMyShow.service;

import com.learn.BookMyShow.dto.MovieDto;
import com.learn.BookMyShow.dto.MovieSearchDto;
import com.learn.BookMyShow.dto.TheatreMovieDto;
import com.learn.BookMyShow.entity.Movie;

import java.util.List;
import java.util.Map;

public interface SearchMoviesTheatreService {

    Map<String,String> getCityCodeList();
    List<TheatreMovieDto> getMovieDtoListForCity(String cityName, String cityCode);
    List<TheatreMovieDto> getMovieShowDetails(String cityCode,String movieCode);
}
