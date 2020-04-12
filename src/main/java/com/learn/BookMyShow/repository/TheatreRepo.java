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
    List<Theatre> findTheatreByCity(City city);

    @Query(value = "SELECT th from Theatre th JOIN FETCH TheatreOwner owner where owner.id = ?1 AND th.theatreName = ?2")
    Optional<Theatre> findByOwnerIdAndTheatreName(Integer ownerId,String theatreName);
    Optional<Theatre> findById(Integer theatreId);
}
