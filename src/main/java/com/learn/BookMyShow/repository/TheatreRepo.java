package com.learn.BookMyShow.repository;

import com.learn.BookMyShow.entity.City;
import com.learn.BookMyShow.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TheatreRepo extends JpaRepository<Theatre,Integer> {
    List<Theatre> findTheatreByCity(City city);

    Optional<Theatre> findByTheatreName(String theatreName);
}
