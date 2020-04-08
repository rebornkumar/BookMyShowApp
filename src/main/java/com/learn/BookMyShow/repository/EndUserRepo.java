package com.learn.BookMyShow.repository;

import com.learn.BookMyShow.entity.EndUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EndUserRepo extends JpaRepository<EndUser,Integer> {
}
