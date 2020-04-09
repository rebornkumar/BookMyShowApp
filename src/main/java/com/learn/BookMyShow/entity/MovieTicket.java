package com.learn.BookMyShow.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
@Entity
public class MovieTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getScreenNumber() {
        return screenNumber;
    }

    public void setScreenNumber(int screenNumber) {
        this.screenNumber = screenNumber;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getTheatreAddress() {
        return theatreAddress;
    }

    public void setTheatreAddress(String theatreAddress) {
        this.theatreAddress = theatreAddress;
    }

    public String getShowTiming() {
        return showTiming;
    }

    public void setShowTiming(String showTiming) {
        this.showTiming = showTiming;
    }

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

//    @Column(name = "booked_seats")
//    private List<String> bookedSeats;
}
