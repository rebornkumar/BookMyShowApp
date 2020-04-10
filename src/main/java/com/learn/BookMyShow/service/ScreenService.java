package com.learn.BookMyShow.service;

import com.learn.BookMyShow.dto.ItemResponseDto;
import com.learn.BookMyShow.dto.ScreenDto;
import com.learn.BookMyShow.entity.Screen;

import java.util.Optional;

public interface ScreenService {
//    Optional<Screen> getScreenFromTheatreIdAndSreenId(Integer theatreId, Integer screenId);
    ItemResponseDto addScreenToTheatre(ScreenDto screenDto);
}
