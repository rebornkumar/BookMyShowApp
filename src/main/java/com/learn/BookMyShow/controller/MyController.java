package com.learn.BookMyShow.controller;

import com.learn.BookMyShow.dto.MovieDto;
import com.learn.BookMyShow.dto.ResponseDto;
import com.learn.BookMyShow.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/check")
public class MyController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ResponseDto createMovie(@RequestBody @Valid @NotNull MovieDto movieDto, Errors errors) throws Exception{

//        if (errors.hasErrors()) {
//            // Extract ConstraintViolation list from body errors
//            List<ConstraintViolation<?>> violationsList = new ArrayList<>();
//            for (ObjectError e : errors.getAllErrors()) {
//                violationsList.add(e.unwrap(ConstraintViolation.class));
//            }
//
//            String exceptionMessage = "";
//
//            // Construct a helpful message for each input violation
//            for (ConstraintViolation<?> violation : violationsList) {
//                exceptionMessage += violation.getPropertyPath() + " " + violation.getMessage() + "\n";
//            }
//            throw new Exception(String.format("Request input is invalid:\n%s", exceptionMessage));
//        }
        ResponseDto responseDto = new ResponseDto("failed","enter valid input");
        if(errors.hasErrors() == false) {
            responseDto = movieService.createMovie(movieDto);
        }
        return responseDto;
    }
}
