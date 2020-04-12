package com.learn.BookMyShow.repository;

import com.learn.BookMyShow.entity.Seat;
import com.learn.BookMyShow.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepo extends JpaRepository<Seat,Integer> {
    @Query(value = "select * from seat join shows ON (seat.show_id = shows.show_id) where seat.show_id = ?1 AND seat.seat_number IN ?2 AND seat.is_booked = 'f'",nativeQuery = true)
    List<Seat> findByShowIdAndSeatNumberList(Integer showId, List<String> seatNumbers);
    @Query(value = "select * from seat where is_booked = ?1",nativeQuery = true)
    List<Seat> findByBooked(Boolean booked);
}
