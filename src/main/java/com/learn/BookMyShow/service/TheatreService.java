package com.learn.BookMyShow.service;

import com.learn.BookMyShow.dto.ItemResponseDto;
import com.learn.BookMyShow.dto.TheatreDto;

public interface TheatreService {

    ItemResponseDto createTheatre(TheatreDto theatreDto);
}
