package com.learn.BookMyShow.controller;

import com.learn.BookMyShow.dto.CityDto;
import com.learn.BookMyShow.dto.MovieDto;
import com.learn.BookMyShow.dto.ResponseDto;
import com.learn.BookMyShow.service.CityService;
import com.learn.BookMyShow.service.MovieService;
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
    public CityDto getType() {
        return new CityDto();
    }

}
