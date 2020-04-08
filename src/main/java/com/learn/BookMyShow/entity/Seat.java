package com.learn.BookMyShow.entity;

import com.learn.BookMyShow.enums.SeatType;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Builder
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

//    @Column(name = "seat_number", nullable = false)
//    private String seatNumber;
//
//    @Column(name = "rate", nullable = false)
//    private int rate;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "seat_type", nullable = false)
//    private SeatType seatType;
//
//    @Column(name = "is_booked", columnDefinition = "bit(1) default 0", nullable = false)
//    private boolean booked;

//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "booked_at")
    private Date bookedAt;

    @Column(name = "customer_id")
    private int customerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id")
    private Show show;
}
