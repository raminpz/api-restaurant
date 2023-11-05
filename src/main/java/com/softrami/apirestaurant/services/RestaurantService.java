package com.softrami.apirestaurant.services;

import com.softrami.apirestaurant.exceptions.BookingException;
import com.softrami.apirestaurant.jsons.RestaurantRest;

import java.util.List;

public interface RestaurantService {
    RestaurantRest getRestaurantById(Long restaurantId) throws BookingException;

    public List<RestaurantRest> getRestaurants() throws BookingException;
}
