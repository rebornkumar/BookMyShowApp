package com.learn.BookMyShow.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "theatre_owner")
@Entity
public class TheatreOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "theatreOwner", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Theatre> theatres;
}
