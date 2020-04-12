package com.learn.BookMyShow.repository;

import com.learn.BookMyShow.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface CityRepo extends JpaRepository<City,Integer> {

    Optional<City> findByCityCode(String cityCode);
}
