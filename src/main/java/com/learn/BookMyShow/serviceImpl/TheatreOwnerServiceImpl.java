package com.learn.BookMyShow.serviceImpl;

import com.learn.BookMyShow.dto.MovieDto;
import com.learn.BookMyShow.dto.ShowDto;
import com.learn.BookMyShow.entity.Movie;
import com.learn.BookMyShow.entity.Screen;
import com.learn.BookMyShow.entity.Show;
import com.learn.BookMyShow.repository.ScreenRepo;
import com.learn.BookMyShow.repository.ShowRepo;
import com.learn.BookMyShow.service.MovieService;
import com.learn.BookMyShow.service.ScreenService;
import com.learn.BookMyShow.service.TheatreOwnerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TheatreOwnerServiceImpl implements TheatreOwnerService {

    @Autowired
    private MovieService movieService;

    @Autowired
    private ShowRepo showRepo;

    @Autowired
    private ScreenService screenService;

    @Override
    public void createUpdateTheatre() {

    }

    @Override
    public void createUpdateScreen() {

    }

    @Override
    public void createUpdateShow() {

    }

//    @Override
//    public void createUpdateShow() {
////      Integer theatreId, ShowDto showDto
////        Optional<Screen> screen = screenService.getScreenFromTheatreIdAndSreenId(theatreId,showDto.getScreenNumber());
////        Optional<Movie> movie = movieService.getByMovieIdOrMovieTitle(-1,showDto.getMovieTitle());
////        Map<String,String> message = new HashMap<String,String>();
////
////        if(movie.isPresent()) {
////            Show show = new Show();
////            show.setMovie(movie.get());
////            show.set
////
////        }
////        else {
////            message.put("status", "Movie deatils dont match with database. Please create or update movie")
////        }
//
//
//    }
}
