package com.learn.BookMyShow.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.learn.BookMyShow.dto.*;
import com.learn.BookMyShow.entity.Movie;
import com.learn.BookMyShow.entity.Seat;
import com.learn.BookMyShow.entity.Theatre;
import com.learn.BookMyShow.repository.MovieRepo;
import com.learn.BookMyShow.repository.SeatRepo;
import com.learn.BookMyShow.repository.TheatreRepo;
import com.learn.BookMyShow.service.CityService;
import com.learn.BookMyShow.service.MovieService;
import com.learn.BookMyShow.service.ScreenService;
import com.learn.BookMyShow.service.TheatreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.*;

@Slf4j
@RestController
@JsonIgnoreProperties
@RequestMapping(value = "/create")
public class MyController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private CityService cityService;

    @Autowired
    private TheatreService theatreService;

    @Autowired
    private ScreenService screenService;

    @Autowired
    private SeatRepo seatRepo;

    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private TheatreRepo theatreRepo;


    @RequestMapping(value = "/movie",method = RequestMethod.POST)
    public ResponseDto createMovie(@RequestBody @Valid @NotNull MovieDto movieDto, Errors errors) throws Exception{
        ResponseDto responseDto = new ResponseDto("failed","enter valid input");
        if(errors.hasErrors()) {
            log.error("invalid inpur from user");
        }
        else {
            responseDto = movieService.createMovie(movieDto);
        }
        return responseDto;
    }


    @RequestMapping(value = "/city",method = RequestMethod.POST)
    public ResponseDto createCity(@RequestBody @Valid @NotNull CityDto cityDto, Errors errors) throws Exception{
        ResponseDto responseDto = new ResponseDto("failed","enter valid input");
        if(errors.hasErrors()) {
            log.error("invalid input from user");
        }
        else {
            responseDto = cityService.createCity(cityDto);
        }

        return responseDto;
    }
    @RequestMapping(value = "/city",method = RequestMethod.GET)
    public CityDto getCity() {
        return new CityDto();
    }


    @RequestMapping(value = "/theatre",method = RequestMethod.POST)
    public ItemResponseDto createTheatre(@RequestBody @Valid @NotNull TheatreDto theatreDto, Errors errors) throws Exception{
        ResponseDto responseDto = new ResponseDto("failed","enter valid input");
        ItemResponseDto itemResponseDto = new ItemResponseDto();
        itemResponseDto.setResponseDto(responseDto);
        if(errors.hasErrors()) {
            log.error("invalid input from user");
        }
        else {
            itemResponseDto = theatreService.createTheatre(theatreDto);
        }

        return itemResponseDto;
    }
    @RequestMapping(value = "/theatre",method = RequestMethod.GET)
    public TheatreDto getTheatre() {
        return new TheatreDto();
    }



    @RequestMapping(value = "/screen",method = RequestMethod.POST)
    public ItemResponseDto createScreen(@RequestBody @Valid @NotNull ScreenDto screenDto, Errors errors) throws Exception{
        ResponseDto responseDto = new ResponseDto("failed","enter valid input");
        ItemResponseDto itemResponseDto = new ItemResponseDto();
        itemResponseDto.setResponseDto(responseDto);
        if(errors.hasErrors()) {
            log.error("invalid input from user");
        }
        else {
            itemResponseDto = screenService.addScreenToTheatre(screenDto);
        }

        return itemResponseDto;
    }
    @RequestMapping(value = "/screen",method = RequestMethod.GET)
    public ScreenDto getScreen() {
        return new ScreenDto();
    }

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public ShowDto getShow() {
        return new ShowDto();
    }
    @RequestMapping(value = "/exp",method = RequestMethod.GET)
    public List<Seat> getExp(@RequestParam Integer id) {
        return seatRepo.findByShowIdAndSeatNumberList(id, new ArrayList<String>());
    }
    @RequestMapping(value = "/exp1",method = RequestMethod.GET)
    public Optional<Movie> getExp1(@RequestParam String cityCode) {
        return movieRepo.findByMovieCode(cityCode);
    }
//
    @RequestMapping(value = "/exp5",method = RequestMethod.GET)
    public Map<String,Boolean> getExp5(@RequestParam boolean flag) {
        Map<String,Boolean> seatStatusMapping = new HashMap<String,Boolean>();
        for(Seat seat : seatRepo.findByBooked(flag)) {
            seatStatusMapping.put(seat.getSeatNumber(), flag);
        }
        return seatStatusMapping;
    }
}
