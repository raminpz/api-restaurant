package com.softrami.apirestaurant.controllers;

import com.softrami.apirestaurant.exceptions.BookingException;
import com.softrami.apirestaurant.jsons.CreateReservationRest;
import com.softrami.apirestaurant.jsons.ReservationRest;
import com.softrami.apirestaurant.responses.BookingResponse;
import com.softrami.apirestaurant.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class ReservationController {

    @Autowired
    ReservationService  reservationService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "restaurant" + "/{" + "restaurantId" + "}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<ReservationRest> getRestaurantById(@PathVariable Long reservationId) throws BookingException {
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK),"OK",reservationService.getReservation(reservationId));
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "reservation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<String> createReservation(@RequestBody CreateReservationRest createReservationRest) throws BookingException{
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK),"OK", reservationService.createReservation(createReservationRest));
    }



}
