package com.softrami.apirestaurant.repositories;

import com.softrami.apirestaurant.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Optional<Reservation> findByLocator(String locator);
    @Modifying
    @Transactional
    Optional<Reservation> deleteByLocator(String locator);
    Optional<Reservation> findByTurnAndRestaurantId(String turn, Long restaurantId);
}
