package com.softrami.apirestaurant.services.impl;

import com.softrami.apirestaurant.exceptions.BookingException;
import com.softrami.apirestaurant.exceptions.InternalServerErrorException;
import com.softrami.apirestaurant.exceptions.NotFoundException;
import com.softrami.apirestaurant.repositories.ReservationRepository;
import com.softrami.apirestaurant.services.CancelReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancelReservationServiceImpl implements CancelReservationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CancelReservationServiceImpl.class);

    @Autowired
    private ReservationRepository reservationRespository;

    public String deleteReservation(String locator) throws BookingException {

        // Para poder eliminar una reserva, primero debe existir una reserva, hacemos la validacion
        reservationRespository.findByLocator(locator)
                .orElseThrow(()->new NotFoundException("LOCATOR_NOT_FOUND","RESTAURANT_NOT_FOUND"));

        try {
            reservationRespository.deleteByLocator(locator);
        } catch (Exception e){
            LOGGER.error("INTERNAL_SERVER_ERROR",e);
            throw  new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }

        return "LOCATOR_DELETED";
    }
}
