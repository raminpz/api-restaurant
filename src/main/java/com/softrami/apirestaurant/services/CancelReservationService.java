package com.softrami.apirestaurant.services;

import com.softrami.apirestaurant.exceptions.BookingException;
import org.springframework.stereotype.Service;

@Service
public interface CancelReservationService {
    public String deleteReservation(String locator) throws BookingException;
}
