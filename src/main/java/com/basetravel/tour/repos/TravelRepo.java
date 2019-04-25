package com.basetravel.tour.repos;

import com.basetravel.tour.domain.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelRepo extends JpaRepository<Travel, Long> {
}
