package com.learn.BookMyShow.serviceImpl;

import com.learn.BookMyShow.entity.MovieTicket;
import com.learn.BookMyShow.entity.Seat;
import com.learn.BookMyShow.entity.Show;
import com.learn.BookMyShow.repository.SeatRepo;
import com.learn.BookMyShow.service.MovieTicketBookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MovieTicketBookingServiceImpl implements MovieTicketBookingService {

    @Autowired
    private SeatRepo seatRepo;
    @Transactional
    @Override
    public MovieTicket createMovieTicketForUser(Integer endUserId, Integer showId, List<String> seatNumbers) {
        if(seatValidation(showId,seatNumbers)) {
            //book tickets
            MovieTicket movieTicket = new MovieTicket();
            List<Seat> seatList = seatRepo.findByShowIdAndSeatNumber(showId,seatNumbers);
            for(Seat seat : seatList) {
                seat.setBooked(true);
                seat.setCustomerId(endUserId);
                seatRepo.save(seat);
            }

        }
        return null;
    }
    private void generateMovieTicket(MovieTicket movieTicket,Integer showId,Integer endUserId) {

    }
    private boolean seatValidation(Integer showId,List<String>seatNumbers) {
        Integer availableSeats = seatRepo.findByShowIdAndSeatNumber(showId,seatNumbers).size();
        if(availableSeats == seatNumbers.size()) {
            return true;
        }
        else {
            return false;
        }
    }
}
