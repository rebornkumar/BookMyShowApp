package com.learn.BookMyShow.serviceImpl;

import com.learn.BookMyShow.dto.MovieDto;
import com.learn.BookMyShow.dto.MovieSearchDto;
import com.learn.BookMyShow.dto.ShowDto;
import com.learn.BookMyShow.dto.TheatreMovieDto;
import com.learn.BookMyShow.entity.*;
import com.learn.BookMyShow.repository.CityRepo;
import com.learn.BookMyShow.repository.MovieRepo;
import com.learn.BookMyShow.repository.TheatreRepo;
import com.learn.BookMyShow.service.SearchMoviesTheatreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.*;
@Slf4j
@Service
public class SearchMoviesTheatreServiceImpl implements SearchMoviesTheatreService {

    @Autowired
    private TheatreRepo theatreRepo;
    @Autowired
    private CityRepo cityRepo;
    @Autowired
    private MovieRepo movieRepo;

    @Override
    public Map<String,String> getCityCodeList() {
        List<City> cityList = cityRepo.findAll();
        Map<String,String> cityMapping = new HashMap<String,String>();
        for(City city : cityList) {
            cityMapping.put(city.getCityCode(),city.getCityName());
        }
        return cityMapping;
    }
    @Override
    public List<TheatreMovieDto> getMovieDtoListForCity(String cityName, String cityCode) {
        List<MovieDto>movieDtoList = new ArrayList<MovieDto>();
        List<Movie> movieList= new ArrayList<Movie>();
        List<Theatre> theatreList = getTheatreListForCity(cityName,cityCode);

        return getMovieDtosFromTheateList(theatreList,null,true);
    }
    @Override
    public List<TheatreMovieDto> getMovieShowDetails(String cityCode, String movieCode) {
        List<Theatre> theatreList = getTheatreListForCity(cityCode,cityCode);
        Optional<Movie>movie = movieRepo.findByMovieCode(movieCode);
        List<TheatreMovieDto> theatreMovieDtoList = new ArrayList<TheatreMovieDto>();
        if(movie.isPresent()) {
            theatreMovieDtoList = getMovieDtosFromTheateList(theatreList,movie.get(),false);
        }
        return theatreMovieDtoList;
    }
    private List<TheatreMovieDto> getMovieDtosFromTheateList(List<Theatre>theatreList,Movie movie,Boolean isShow) {
        List<TheatreMovieDto> theatreMovieDtoList = new ArrayList<TheatreMovieDto>();
        for (Theatre theatre : theatreList) {
            TheatreMovieDto theatreMovieDto = new TheatreMovieDto();
            theatreMovieDto.setTheatreName(theatre.getTheatreName());
            theatreMovieDto.setTheatreLocation(theatre.getCity().getAddress() + " " + theatre.getCity().getCityName());
            for (Screen screen : theatre.getScreens()) {
                for (Show show : screen.getShows()) {
                    if (isShow || show.getMovie().equals(movie)) {
                        theatreMovieDto.setShowDetail(getShowDto(show));
                        theatreMovieDtoList.add(theatreMovieDto);
                    }
                }
            }
        }
        return theatreMovieDtoList;
    }
    private List<Theatre> getTheatreListForCity(String cityName,String cityCode) {
        List<Theatre> theatreList = new ArrayList<Theatre>();
        Optional<City> userCity = cityRepo.findByCityNameOrCityCode(cityName,cityCode);
        if(userCity.isPresent()) {
            theatreList = theatreRepo.findTheatreByCity(userCity.get());
        }
        else {
            log.error("City with CityCode " + cityCode + " does not exist");
        }
        return theatreList;
    }
    private MovieDto getMovieDto(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setMovieTitle(movie.getTitle());
        movieDto.setLanguage(movie.getLanguage());
        movieDto.setReleaseDate(movie.getReleaseDate());
        return movieDto;
    }
    private ShowDto getShowDto(Show show) {
        ShowDto showDto = new ShowDto();
        showDto.setLanguage(show.getMovie().getLanguage());
        showDto.setMovieTitle(show.getMovie().getTitle());
        showDto.setScreenNumber(show.getScreen().getId());
//        showDto.setShowDate(show.getShowDate().format(DateTimeFormatter.ofPattern("dd-MMM-yy")));
//        showDto.setShowTime(show.getShowTime().format(DateTimeFormatter.ISO_LOCAL_DATE));
        return showDto;
    }
}
