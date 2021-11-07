package com.bh1ofp.week07.dao;

import com.bh1ofp.week07.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT u FROM User  u")
    List<User> queryUser();
}