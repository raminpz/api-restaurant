package com.softrami.apirestaurant.services.impl;

import com.softrami.apirestaurant.entities.Restaurant;
import com.softrami.apirestaurant.exceptions.BookingException;
import com.softrami.apirestaurant.exceptions.NotFoundException;
import com.softrami.apirestaurant.jsons.RestaurantRest;
import com.softrami.apirestaurant.repositories.RestaurantRepository;
import com.softrami.apirestaurant.services.RestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService{
    @Autowired
    RestaurantRepository restaurantRepository;

    public static final ModelMapper modelMapper = new ModelMapper();

    public RestaurantRest getRestaurantById(Long restaurantId) throws BookingException {
        return modelMapper.map(getRestaurantEntity(restaurantId), RestaurantRest.class);
    }

    public List<RestaurantRest> getRestaurants() throws BookingException {
        final List<Restaurant> restaurantEntity = restaurantRepository.findAll();
        return restaurantEntity.stream().map(service ->modelMapper.map(service, RestaurantRest.class))
                .collect(Collectors.toList());
    }

    private Restaurant getRestaurantEntity(Long restaurantId) throws BookingException{
        return restaurantRepository.findById(restaurantId).orElseThrow(()->new NotFoundException("SNOT-404-1","RESTAURANT_NOT_FOUND"));
    }
}
