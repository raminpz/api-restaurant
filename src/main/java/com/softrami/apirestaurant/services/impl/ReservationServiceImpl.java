package com.softrami.apirestaurant.services.impl;

import com.softrami.apirestaurant.entities.Reservation;
import com.softrami.apirestaurant.entities.Restaurant;
import com.softrami.apirestaurant.entities.Turn;
import com.softrami.apirestaurant.exceptions.BookingException;
import com.softrami.apirestaurant.exceptions.InternalServerErrorException;
import com.softrami.apirestaurant.exceptions.NotFoundException;
import com.softrami.apirestaurant.jsons.CreateReservationRest;
import com.softrami.apirestaurant.jsons.ReservationRest;
import com.softrami.apirestaurant.repositories.ReservationRepository;
import com.softrami.apirestaurant.repositories.RestaurantRepository;
import com.softrami.apirestaurant.repositories.TurnRepository;
import com.softrami.apirestaurant.services.ReservationService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

    @Autowired
    private TurnRepository turnRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private ReservationRepository reservationRespository;

    public static final ModelMapper modelMapper = new ModelMapper();


    // Metodo buscar reserva por Id
    public ReservationRest getReservation(Long reservationId) throws BookingException {
        return modelMapper.map(getReservationtEntity(reservationId), ReservationRest.class);
    }

    // Metodo crear reservacion
    public String createReservation(CreateReservationRest createReservationRest) throws BookingException {
        // Primero Validamos que exista el Restauarnt
        final Restaurant restaurantId = restaurantRepository.findById(createReservationRest.getRestaurantId())
                .orElseThrow(()->new NotFoundException("RESTAURANT_NOT_FOUND","RESTAURANT_NOT_FOUND"));
        // Validamos que exista el turno
        final Turn turnId = turnRepository.findById(createReservationRest.getTurnId())
                .orElseThrow(()->new NotFoundException("TURN_NOT_FOUND","TURN_NOT_FOUND"));

        String locator = generateLocator(restaurantId,createReservationRest);
        final Reservation reservation = new Reservation();
        reservation.setLocator(locator);
        reservation.setPerson(createReservationRest.getPerson());
        reservation.setDate(createReservationRest.getDate());
        reservation.setRestaurant(restaurantId);
        reservation.setTurn(turnId.getName());

        try {
            reservationRespository.save(reservation);
        } catch (final Exception e){
            LOGGER.error("INTERNAL_SERVER_ERROR",e);
            throw  new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }
        return locator;
    }

    // Metodo generador de Localizacion
    private String generateLocator(Restaurant restaurantId, CreateReservationRest createReservationRest) throws BookingException{
        return restaurantId.getName() + createReservationRest.getTurnId();
    }


    // Metodo privado que va a buscar reserva si existe o no
    private Object getReservationtEntity(Long reservationId) throws BookingException{
        return reservationRespository.findById(reservationId).orElseThrow(()->new NotFoundException("SNOT-404-1","RESTAURANT_NOT_FOUND"));
    }
}
