package com.learn.BookMyShow.entity;

import com.learn.BookMyShow.enums.SeatType;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

//@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "seat")
@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private int id;

    @Column(name = "seat_number", nullable = true)
    private String seatNumber;

    @Column(name = "is_booked",nullable = false)
    private boolean booked = false;

    @Column(name = "customer_id")
    private Integer customerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id")
    private Show show;
}
