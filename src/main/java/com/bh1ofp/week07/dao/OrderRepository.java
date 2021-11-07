package com.bh1ofp.week07.dao;

import com.bh1ofp.week07.entity.Order;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT o FROM Order o")
    List<Order> queryOrderBy();


}