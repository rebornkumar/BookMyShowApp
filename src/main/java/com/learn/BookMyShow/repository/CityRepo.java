package com.learn.BookMyShow.repository;

import com.learn.BookMyShow.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepo extends JpaRepository<City,Integer> {
}
