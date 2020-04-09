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
@Entity
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theatre_id")
    private int id;

    @Column(name = "theatre_name")
    private String theatreName;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private TheatreOwner theatreOwner;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "theatre_movies",joinColumns = @JoinColumn(name = "theatre_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie>movies;

    @OneToMany(mappedBy = "theatre", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Screen> screens;
}

