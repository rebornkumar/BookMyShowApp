package com.learn.BookMyShow.service;

import com.learn.BookMyShow.entity.MovieTicket;

import java.util.List;

public interface MovieTicketBookingService {

    MovieTicket createMovieTicketForUser(Integer endUserId,Integer showdId,List<String>seats);
}
