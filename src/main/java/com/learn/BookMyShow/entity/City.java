package com.learn.BookMyShow.entity;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//@Builder
@AllArgsConstructor
@ToString
@Table(name = "city")
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name =  "city_id")
    private int id;

    @Column(name = "city_code",unique = true,nullable = false)
    private String cityCode;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "address")
    private String address;

    @Column(name = "state")
    private String state;

    @Column(name = "pincode",unique = true)
    private Integer pincode;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Theatre> theatres;
}
