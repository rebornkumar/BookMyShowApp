package com.learn.BookMyShow.serviceImpl;

import com.learn.BookMyShow.dto.MovieDto;
import com.learn.BookMyShow.dto.ShowDto;
import com.learn.BookMyShow.dto.TheatreMovieDto;
import com.learn.BookMyShow.entity.*;
import com.learn.BookMyShow.repository.CityRepo;
import com.learn.BookMyShow.repository.MovieRepo;
import com.learn.BookMyShow.repository.TheatreRepo;
import com.learn.BookMyShow.service.SearchMoviesTheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SearchMoviesTheatreServiceImpl implements SearchMoviesTheatreService {
//    @Autowired
//    private TheatreRepo theatreRepo;
//    @Autowired
//    private CityRepo cityRepo;
//    @Autowired
//    private MovieRepo movieRepo;
//
//    @Override
//    public List<MovieDto> getMovieDtoListForCity(String cityName, String cityCode) {
//        List<MovieDto>movieDtoList = new ArrayList<MovieDto>();
//        List<Movie> movieList= new ArrayList<Movie>();
//        List<Theatre> theatreList = getTheatreListForCity(cityName,cityCode);
//        for(Theatre theatre: theatreList) {
//            movieList.addAll(theatre.getMovies());
//        }
//        for(Movie movie : movieList) {
//            movieDtoList.add(getMovieDto(movie));
//        }
//        return movieDtoList;
//    }
//
//    @Override
//    public List<TheatreMovieDto> getMovieShowDetails(String cityCode, String movieTitle) {
//        List<Theatre> theatreList = getTheatreListForCity(cityCode,cityCode);
//        Optional<Movie>movie = movieRepo.findByMovieTitle(movieTitle);
//        List<TheatreMovieDto> theatreMovieDtoList = new ArrayList<TheatreMovieDto>();
//        if(movie.isPresent()) {
//            for (Theatre theatre : theatreList) {
//                TheatreMovieDto theatreMovieDto = new TheatreMovieDto();
//                theatreMovieDto.setTheatreName(theatre.getTheatreName());
//                theatreMovieDto.setTheatreLocation(theatre.getCity().getAddress() + " " + theatre.getCity().getCityName());
//                for (Screen screen : theatre.getScreens()) {
//                    for (Show show : screen.getShows()) {
//                        if (show.getMovie().equals(movie.get())) {
//                            theatreMovieDto.setShowDetail(getShowDto(show));
//                            theatreMovieDtoList.add(theatreMovieDto);
//                        }
//                    }
//                }
//            }
//        }
//
//        return theatreMovieDtoList;
//    }
//    private List<Theatre> getTheatreListForCity(String cityName,String cityCode) {
//        List<Theatre> theatreList = new ArrayList<Theatre>();
//        Optional<City> userCity = cityRepo.findByCityNameOrCityCode(cityName,cityCode);
//        if(userCity.isPresent()) {
//            theatreRepo.findTheatreByCity(userCity.get());
//        }
//        return theatreList;
//    }
//
//    private MovieDto getMovieDto(Movie movie) {
//        MovieDto movieDto = new MovieDto();
//        movieDto.setTitle(movie.getTitle());
//        movieDto.setLanguage(movie.getLanguage());
//        movieDto.setReleaseDate(movie.getReleaseDate());
//        return movieDto;
//    }
//    private ShowDto getShowDto(Show show) {
//        ShowDto showDto = new ShowDto();
//        showDto.setLanguage(show.getMovie().getLanguage());
//        showDto.setMovieTitle(show.getMovie().getTitle());
//        showDto.setScreenNumber(show.getScreen().getId());
//        showDto.setShowDate(show.getShowDate().format(DateTimeFormatter.ofPattern("dd-MMM-yy")));
//        showDto.setShowTime(show.getShowTime().format(DateTimeFormatter.ISO_LOCAL_DATE));
//        return showDto;
//    }
}
