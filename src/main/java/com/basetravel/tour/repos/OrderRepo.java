package com.basetravel.tour.repos;

import com.basetravel.tour.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order,Long> {

    List<Order> findByUser (Long user);
    List<Order> findByTravel (Long travel);
    Order findByOrderId (Long orderId);
}
