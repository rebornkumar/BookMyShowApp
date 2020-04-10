package com.learn.BookMyShow.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//@Builder
@AllArgsConstructor
@ToString
@Table(name = "movie")
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int id;

    @NotEmpty(message = "code cant be empty")
    @Column(name = "movie_code",unique = true,nullable = false)
    private String movieCode;

    @Column(name = "title")
    private String title;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "language")
    private String language;

    @OneToMany(mappedBy = "movie",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Show> shows;
//
//    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    private List<Theatre> theatres;
}
