package com.learn.BookMyShow.controller;

import com.learn.BookMyShow.dto.*;
import com.learn.BookMyShow.service.CityService;
import com.learn.BookMyShow.service.MovieService;
import com.learn.BookMyShow.service.TheatreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Slf4j
@RestController
@RequestMapping(value = "/create")
public class MyController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private CityService cityService;

    @Autowired
    private TheatreService theatreService;

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
}
