package com.learn.BookMyShow.serviceImpl;

import com.learn.BookMyShow.entity.EndUser;
import com.learn.BookMyShow.entity.MovieTicket;
import com.learn.BookMyShow.entity.Seat;
import com.learn.BookMyShow.entity.Show;
import com.learn.BookMyShow.repository.EndUserRepo;
import com.learn.BookMyShow.repository.MovieTicketRepo;
import com.learn.BookMyShow.repository.SeatRepo;
import com.learn.BookMyShow.repository.ShowRepo;
import com.learn.BookMyShow.service.MovieTicketBookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.management.OperatingSystemMXBean;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MovieTicketBookingServiceImpl implements MovieTicketBookingService {

    @Autowired
    private SeatRepo seatRepo;
    @Autowired
    private ShowRepo showRepo;

    @Autowired
    private EndUserRepo endUserRepo;

    @Autowired
    private MovieTicketRepo movieTicketRepo;

    @Transactional
    @Override
    public synchronized MovieTicket createMovieTicketForUser(Integer endUserId, Integer showId, List<String> seatNumbers) {
        if(seatValidation(showId,seatNumbers)) {
            //book tickets
            MovieTicket movieTicket = new MovieTicket();
            List<Seat> seatList = seatRepo.findByShowIdAndSeatNumber(showId,seatNumbers);
            for(Seat seat : seatList) {
                seat.setBooked(true);
                seat.setCustomerId(endUserId);
                seatRepo.save(seat);
            }
            String seats = "";
            for(String seatId : seatNumbers) {
                seats = seats + seatId + ", ";
            }
            movieTicket.setBookedSeats(seats);
            generateMovieTicket(movieTicket,showId,endUserId);
        }
        return null;
    }
    private void generateMovieTicket(MovieTicket movieTicket,Integer showId,Integer endUserId) {
        Optional<Show> show = showRepo.findById(showId);
        Optional<EndUser> user = endUserRepo.findById(endUserId);
        if(show.isPresent() && user.isPresent()) {
            log.info("population movie ticket details movieTicketId : {} ",movieTicket.getId());
            movieTicket.setMovieName(show.get().getMovie().getTitle());
            movieTicket.setTheatreName(show.get().getScreen().getTheatre().getTheatreName());
            movieTicket.setScreenNumber(show.get().getScreen().getId());
            movieTicket.setShowTiming(show.get().getShowTime());
            if(show.get().getScreen().getTheatre().getCity().getAddress() != null) {
                movieTicket.setTheatreAddress(show.get().getScreen().getTheatre().getCity().getAddress() + "\n");
            }
            if(show.get().getScreen().getTheatre().getCity().getCityName() != null) {
                movieTicket.setTheatreAddress(movieTicket.getTheatreAddress() + " " +show.get().getScreen().getTheatre().getCity().getCityName());
            }
            movieTicket.setUsername(user.get().getUser().getUsername());
            movieTicket.setCustomerName(user.get().getUser().getName());
            movieTicketRepo.save(movieTicket);
        }
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
