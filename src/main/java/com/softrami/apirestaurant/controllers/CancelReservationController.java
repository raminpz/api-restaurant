package com.softrami.apirestaurant.controllers;

import com.softrami.apirestaurant.exceptions.BookingException;
import com.softrami.apirestaurant.responses.BookingResponse;
import com.softrami.apirestaurant.services.CancelReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class CancelReservationController {

    @Autowired
    CancelReservationService cancelReservationService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "delete/Reservation", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingResponse<String> deleteReservation(@RequestParam String locator) throws BookingException{
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK),"OK", cancelReservationService.deleteReservation(locator));
    }


}
