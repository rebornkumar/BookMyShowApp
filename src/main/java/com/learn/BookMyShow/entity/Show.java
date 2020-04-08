package com.learn.BookMyShow.entity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Builder
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

    @Column(name = "show_date", columnDefinition = "DATE", nullable = false)
    private LocalDate showDate;

    @Column(name = "show_time", columnDefinition = "TIME", nullable = false)
    private LocalTime showTime;

    @Column(name = "show_movie_id",nullable = false)
    private int showMovieId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Screen screen;

    @OneToMany(mappedBy = "show",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Seat> seats;
}
