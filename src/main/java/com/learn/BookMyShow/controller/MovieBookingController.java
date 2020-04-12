package com.learn.BookMyShow.controller;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.learn.BookMyShow.dto.MovieBookingRequest;
import com.learn.BookMyShow.dto.TheatreMovieDto;
import com.learn.BookMyShow.entity.MovieTicket;
import com.learn.BookMyShow.service.MovieTicketBookingService;
import com.learn.BookMyShow.service.SearchMoviesTheatreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@JsonIgnoreProperties
@RequestMapping(value = "/v1")
public class MovieBookingController {

    @Autowired
    private SearchMoviesTheatreService searchMoviesTheatreService;

    @Autowired
    private MovieTicketBookingService movieTicketBookingService;

    @RequestMapping(value = "/city",method = RequestMethod.GET)
    public Map<String,String> getTheatreCityList() {
        log.info("getting theatre city list for user");
        return searchMoviesTheatreService.getCityCodeList();
    }

    @RequestMapping(value = "/movie",method = RequestMethod.GET)
    public List<TheatreMovieDto> getMovieShowListForUser(@RequestParam String cityCode,@RequestParam(required = false) String cityName) {

        List<TheatreMovieDto> theatreMovieDtoList = searchMoviesTheatreService.getMovieDtoListForCity(cityCode,cityName);
        return theatreMovieDtoList;
    }
    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public List<TheatreMovieDto> getShowListOfMovie(@RequestParam String cityCode,@RequestParam String movieCode) {
        List<TheatreMovieDto> theatreMovieDtoList = searchMoviesTheatreService.getMovieShowDetails(cityCode,movieCode);
        return theatreMovieDtoList;
    }
    @RequestMapping(value = "/booking",method = RequestMethod.GET)
    public Map<String,MovieTicket> createMovieBooking(@RequestBody @Valid MovieBookingRequest movieBookingRequest) {
        MovieTicket movieTicket = movieTicketBookingService.createMovieTicketForUser(movieBookingRequest.getEndUserId(),movieBookingRequest.getShowId(),movieBookingRequest.getSeatNumber());
        Map<String,MovieTicket> response = new HashMap<String,MovieTicket>();
        if(movieTicket != null) {
            log.info("Ticket generated successfully with TicketId : {}",movieTicket.getId());
            response.put("status : successful",movieTicket);
        }
        else {
            log.info("failed!!, selected seats are not available");
            response.put("status : failed \n Selected Seats unavailable",movieTicket);
        }
        return response;
    }
}
