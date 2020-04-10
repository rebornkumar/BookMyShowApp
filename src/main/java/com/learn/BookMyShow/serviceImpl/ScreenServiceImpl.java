package com.learn.BookMyShow.serviceImpl;

import com.learn.BookMyShow.dto.ItemResponseDto;
import com.learn.BookMyShow.dto.ResponseDto;
import com.learn.BookMyShow.dto.ScreenDto;
import com.learn.BookMyShow.dto.ShowDto;
import com.learn.BookMyShow.entity.*;
import com.learn.BookMyShow.enums.Item;
import com.learn.BookMyShow.repository.MovieRepo;
import com.learn.BookMyShow.repository.ScreenRepo;
import com.learn.BookMyShow.repository.ShowRepo;
import com.learn.BookMyShow.repository.TheatreRepo;
import com.learn.BookMyShow.service.ScreenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ScreenServiceImpl implements ScreenService {

    @Autowired
    private TheatreRepo theatreRepo;

    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private ShowRepo showRepo;

    @Autowired
    private ScreenRepo screenRepo;

    @Override
    public ItemResponseDto addScreenToTheatre(ScreenDto screenDto) {

        ItemResponseDto itemResponseDto = new ItemResponseDto();
        ResponseDto responseDto = new ResponseDto();

        itemResponseDto.setItemType(Item.SCREEN.toString());
        String errorMessage = "";
        Optional<Theatre>optionalTheatre  = theatreRepo.findById(screenDto.getTheatreId());
        if(optionalTheatre.isPresent()) {
            Screen screen = new Screen();
            List<Show> shows = new ArrayList<>();
            for(ShowDto showDto : screenDto.getShowDtoList()) {
                Show show = new Show();
                Optional<Movie> optionalMovie = movieRepo.findByMovieCode(showDto.getMovieCode());
                if(optionalMovie.isPresent()) {
                    show.setMovie(optionalMovie.get());
//                    show.setShowDate(showDto.getShowDate());
//                    show.setShowTime(showDto.getShowTime());
                    show.setSeats(createSeatsInShow(showDto.getNumberOfSeats()));
                    showRepo.save(show);
                    shows.add(show);
                }
                else {
                    errorMessage = errorMessage + " \n Movie with does not exist in database,create movie first, MovieCode : " + showDto.getMovieCode();
                    log.error(errorMessage);
                }
            }
            screen.getShows().addAll(shows);
            screen.setTheatre(optionalTheatre.get());
            screenRepo.save(screen);
            optionalTheatre.get().getScreens().add(screen);
            theatreRepo.save(optionalTheatre.get());
            itemResponseDto.setItemId(screen.getId());
            errorMessage = errorMessage + " screen added successful above mentioned movies missing screenId " + screen.getId();
            responseDto.setStatus("partial success");
            log.info(errorMessage);
        }
        else {
            errorMessage = errorMessage + " \n Theatre does not exist TheatreId : " + screenDto.getTheatreId();
            responseDto.setStatus("failed");
            log.error(errorMessage);
        }
        responseDto.setMessage(errorMessage);
        itemResponseDto.setResponseDto(responseDto);
        return itemResponseDto;
    }
    private List<Seat> createSeatsInShow(Integer totalSeats) {
        List<Seat> seats = new ArrayList<Seat>();
        for(int row = 0; row < totalSeats;row++) {
            Seat seat = new Seat();
            seat.setSeatNumber(generateSeatNumber(row));
        }
        return seats;
    }
    private String generateSeatNumber(Integer num) {
        int rem = num % 20;
        num /= 20;
        char row = (char)(rem + 'A');
        String column  = Integer.toString(num);
        String seatNumber = Character.toString(row) + " "+ column;
        return seatNumber;
    }

//    public Optional<Screen> getScreenFromTheatreIdAndSreenId(Integer theatreId, Integer screenId) {
//        return new Optional<Screen>();
//    }
}
