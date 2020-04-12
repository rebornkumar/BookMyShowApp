package com.learn.BookMyShow.repository;

import com.learn.BookMyShow.entity.EndUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EndUserRepo extends JpaRepository<EndUser,Integer> {

    Optional<EndUser>findById(Integer endUserId);
}
