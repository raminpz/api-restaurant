package com.softrami.apirestaurant.repositories;

import com.softrami.apirestaurant.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findByName(String name);
    Optional<Restaurant> findById(Long id);

    @Query("SELECT REST FROM Restaurant  REST")
    public List<Restaurant> findRestaurants();
}
