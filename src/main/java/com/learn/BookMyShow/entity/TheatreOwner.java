package com.learn.BookMyShow.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
@Entity
public class TheatreOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "theatreOwner", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Theatre> theatres;
}
