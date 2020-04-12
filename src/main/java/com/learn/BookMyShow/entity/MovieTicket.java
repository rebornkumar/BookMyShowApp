package com.learn.BookMyShow.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
//@Builder
@AllArgsConstructor
@ToString
@Entity
public class MovieTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "screenNumber")
    private int screenNumber;

    @Column(name = "theatre_name")
    private String theatreName;

    @Column(name = "theatre_address")
    private String theatreAddress;

    @Column(name = "show_timing")
    private String showTiming;

    @Column(name = "seat_number")
    private String bookedSeats;
}
