package com.learn.BookMyShow.entity;

import lombok.*;
import javax.persistence.*;
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

    @Column(name = "city_code")
    private String cityCode;

    @Column(name = "address")
    private String address;

    @Column(name = "state")
    private String state;

    @Column(name = "pincode")
    private Integer pincode;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Theatre> theatres;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public List<Theatre> getTheatres() {
        return theatres;
    }

    public void setTheatres(List<Theatre> theatres) {
        this.theatres = theatres;
    }
}
