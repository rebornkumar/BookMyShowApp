package com.learn.BookMyShow.serviceImpl;

import com.learn.BookMyShow.entity.City;
import com.learn.BookMyShow.repository.CityRepo;
import com.learn.BookMyShow.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CityServiceImpl implements CityService {

//    @Autowired
//    private CityRepo cityRepo;
//
//    @Override
//    public Map<String,String> getCityName() {
//        List<City>cities = cityRepo.findAll();
//        Map<String,String>cityCodesMap = new HashMap<String,String>();
//        for(City city:cities) {
//            cityCodesMap.put(city.getCityCode(),city.getCityName());
//        }
//        return cityCodesMap;
//    }
}
