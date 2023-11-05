package com.softrami.apirestaurant.controllers;

import com.softrami.apirestaurant.exceptions.BookingException;
import com.softrami.apirestaurant.jsons.RestaurantRest;
import com.softrami.apirestaurant.responses.BookingResponse;
import com.softrami.apirestaurant.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "restaurant" + "/{" + "restaurantId" + "}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<RestaurantRest> getRestaurantById(@PathVariable Long restaurantId) throws BookingException {
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK),"OK",restaurantService.getRestaurantById(restaurantId));
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "restaurants",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<List<RestaurantRest>> getRestaurants() throws BookingException{
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK),"OK",restaurantService.getRestaurants());
    }
}
