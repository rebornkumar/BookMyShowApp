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

    @Column(name = "theatre_name",unique = true)
    private String theatreName;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private TheatreOwner theatreOwner;

    @OneToMany(mappedBy = "theatre", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Screen> screens = new ArrayList<Screen>();
}

