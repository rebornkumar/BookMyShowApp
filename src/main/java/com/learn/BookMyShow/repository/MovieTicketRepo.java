package com.learn.BookMyShow.repository;

import com.learn.BookMyShow.entity.MovieTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieTicketRepo extends JpaRepository<MovieTicket,Integer> {
}
