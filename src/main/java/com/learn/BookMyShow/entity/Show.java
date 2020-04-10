package com.learn.BookMyShow.entity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

//@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "shows")
@Entity
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_id")
    private int id;

    @Column(name = "show_date",nullable = false)
    private String showDate;

    @Column(name = "show_time",nullable = false)
    private String showTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    private Screen screen;

    @OneToMany(mappedBy = "show",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Seat> seats;
}
