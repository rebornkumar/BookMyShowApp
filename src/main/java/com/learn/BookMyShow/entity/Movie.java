package com.learn.BookMyShow.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
@Table(name = "movie")
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "language")
    private String language;

    @OneToOne(mappedBy = "movie",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Show show;
    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Theatre> theatres;

}
