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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public TheatreOwner getTheatreOwner() {
        return theatreOwner;
    }

    public void setTheatreOwner(TheatreOwner theatreOwner) {
        this.theatreOwner = theatreOwner;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private TheatreOwner theatreOwner;
//
//    @OneToMany(mappedBy = "theatre", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    private List<Screen> screens;
}

