package com.learn.BookMyShow.serviceImpl;

import com.learn.BookMyShow.dto.ItemResponseDto;
import com.learn.BookMyShow.dto.ResponseDto;
import com.learn.BookMyShow.dto.TheatreDto;
import com.learn.BookMyShow.entity.City;
import com.learn.BookMyShow.entity.Theatre;
import com.learn.BookMyShow.entity.TheatreOwner;
import com.learn.BookMyShow.enums.Item;
import com.learn.BookMyShow.repository.CityRepo;
import com.learn.BookMyShow.repository.TheatreOwnerRepo;
import com.learn.BookMyShow.repository.TheatreRepo;
import com.learn.BookMyShow.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    private TheatreRepo theatreRepo;
    @Autowired
    private CityRepo cityRepo;
    @Autowired
    private TheatreOwnerRepo theatreOwnerRepo;

    @Override
    public ItemResponseDto createTheatre(TheatreDto theatreDto) {
        Optional<Theatre> oldTheatre = theatreRepo.findByTheatreName(theatreDto.getTheatreName());
        if(oldTheatre.isPresent()) {
            return updateTheatreFromDto(oldTheatre.get(),theatreDto);
        }
        else {
            Theatre theatre = new Theatre();
            return createTheatreFromDto(theatre,theatreDto);
        }
    }
    private ItemResponseDto createTheatreFromDto(Theatre theatre,TheatreDto theatreDto) {
        ItemResponseDto itemResponseDto = new ItemResponseDto();
        itemResponseDto.setItemType(Item.THEATRE.toString());
        String errorMessage = "";

        Optional<City> city = cityRepo.findByCityNameOrCityCode(theatreDto.getCityCode(),theatreDto.getCityCode());
        if(city.isPresent()) {
            theatre.setCity(city.get());
            theatre.setDescription(theatreDto.getDescription());
            theatre.setTheatreName(theatreDto.getTheatreName());
            Optional<TheatreOwner> theatreOwner = theatreOwnerRepo.findById(theatreDto.getOwnerId());
            if(theatreOwner.isPresent()) {
                theatre.setTheatreOwner(theatreOwner.get());
                theatreRepo.save(theatre);
                itemResponseDto.setItemId(theatre.getId());
                errorMessage = errorMessage + "Theatre created successfully in database";
            }
            else {
                errorMessage = errorMessage + " OwnerId : " + theatreDto.getOwnerId() + " does not exist, enter valid OwnerId or create new TheatreOwnere";
            }
        }
        else {
            errorMessage = errorMessage + " CityCode : " + theatreDto.getCityCode() + " does not exist, enter valid cityCode or create new city";
        }
        ResponseDto responseDto = new ResponseDto("success",errorMessage);
        itemResponseDto.setResponseDto(responseDto);
        return itemResponseDto;
    }
    private ItemResponseDto updateTheatreFromDto(Theatre theatre,TheatreDto theatreDto) {
        ItemResponseDto itemResponseDto = new ItemResponseDto();
        itemResponseDto.setItemType(Item.THEATRE.toString());
        String errorMessage = "";
        Optional<City> city = cityRepo.findByCityNameOrCityCode(theatreDto.getCityCode(),theatreDto.getCityCode());
        if(city.isPresent()) {
            theatre.setCity(city.get());
            theatre.setDescription(theatreDto.getDescription());
            theatre.setTheatreName(theatreDto.getTheatreName());
            Optional<TheatreOwner> theatreOwner = theatreOwnerRepo.findById(theatreDto.getOwnerId());
            if(theatreOwner.isPresent()) {
                theatre.setTheatreOwner(theatreOwner.get());
                theatreRepo.save(theatre);
                itemResponseDto.setItemId(theatre.getId());
                errorMessage = errorMessage + "Theatre updated successfully in database";
            }
            else {
                errorMessage = errorMessage + " OwnerId : " + theatreDto.getOwnerId() + " does not exist, enter valid OwnerId or create new TheatreOwnere";
            }
        }
        else {
            errorMessage = errorMessage + " CityCode : " + theatreDto.getCityCode() + " does not exist, enter valid cityCode or create new city";
        }
        ResponseDto responseDto = new ResponseDto("success",errorMessage);
        itemResponseDto.setResponseDto(responseDto);
        return itemResponseDto;
    }
}
