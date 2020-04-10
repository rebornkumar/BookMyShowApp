package com.learn.BookMyShow.service;

import com.learn.BookMyShow.dto.CityDto;
import com.learn.BookMyShow.dto.ResponseDto;

import java.util.List;
import java.util.Map;

public interface CityService {
//    void createUpdateCity();
//    Map<String,String> getCityName();

    ResponseDto createCity(CityDto cityDto);
}
