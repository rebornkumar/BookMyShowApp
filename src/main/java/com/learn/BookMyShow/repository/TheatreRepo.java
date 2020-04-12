package com.learn.BookMyShow.repository;

import com.learn.BookMyShow.entity.City;
import com.learn.BookMyShow.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TheatreRepo extends JpaRepository<Theatre,Integer> {

    @Query(value = "select * from theatre join city ON (theatre.city_id = city.city_id) where city.city_id = ?1",nativeQuery = true)
    List<Theatre> findTheatreByCityId(Integer cityId);
    @Query(value = "select * from theatre join theatre_owner ON (theatre_owner.owner_id = theatre.owner_id) where theatre_owner.owner_id = ?1 AND theatre.theatre_name = ?2",nativeQuery = true)
    Optional<Theatre> findByOwnerIdAndTheatreName(Integer ownerId,String theatreName);
    Optional<Theatre> findById(Integer theatreId);
}
