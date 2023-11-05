package com.softrami.apirestaurant.services;

import com.softrami.apirestaurant.exceptions.BookingException;
import com.softrami.apirestaurant.jsons.CreateReservationRest;
import com.softrami.apirestaurant.jsons.ReservationRest;

public interface ReservationService {

    ReservationRest getReservation(Long reservationId) throws BookingException;

    String createReservation(CreateReservationRest reservationRespository) throws BookingException;
}
