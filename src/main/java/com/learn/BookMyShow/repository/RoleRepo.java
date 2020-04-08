package com.learn.BookMyShow.repository;

import com.learn.BookMyShow.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Integer> {
    Role findRoleByRoleId(Integer id);
}
