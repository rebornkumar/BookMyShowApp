package com.learn.BookMyShow.serviceImpl;

import com.learn.BookMyShow.dto.CityDto;
import com.learn.BookMyShow.dto.MovieDto;
import com.learn.BookMyShow.dto.ResponseDto;
import com.learn.BookMyShow.entity.City;
import com.learn.BookMyShow.entity.Movie;
import com.learn.BookMyShow.repository.CityRepo;
import com.learn.BookMyShow.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepo cityRepo;

    @Override
    public ResponseDto createCity(CityDto cityDto) {

        ResponseDto responseDto = new ResponseDto();
        Optional<City>oldCity = cityRepo.findByCityCode(cityDto.getCityCode());
        if(oldCity.isPresent()) {
            updateCityFromDto(oldCity.get(),cityDto);
            responseDto.setStatus("city updated!!");
            responseDto.setMessage(("City with cityCode : "+cityDto.getCityCode()+" already exists in database. \n Updated successfully"));
            log.info("City cityCode : {} already exists in database.Updating city with cityId : {}",cityDto.getCityCode(),oldCity.get().getId());
        }
        else {
            City city = new City();
            createCityFromDto(city,cityDto);
            log.info("City cityCode : {} created in database with cityId : {}",city.getCityCode(),city.getId());
            responseDto.setStatus("success");
            responseDto.setMessage("new city created in database with city Code "+ city.getCityCode());
        }
        return responseDto;
    }
    private void  createCityFromDto(City city,CityDto cityDto) {
        city.setCityCode(cityDto.getCityCode());
        city.setCityName(cityDto.getCityName());
        city.setAddress(cityDto.getAddress());
        city.setPincode(cityDto.getPincode());
        city.setState(cityDto.getState());
        cityRepo.save(city);
    }
    private void updateCityFromDto(City oldCity,CityDto cityDto) {
        oldCity.setCityName(cityDto.getCityName());
        oldCity.setAddress(cityDto.getAddress());
        oldCity.setPincode(cityDto.getPincode());
        oldCity.setState(cityDto.getState());
        cityRepo.save(oldCity);
    }
}
