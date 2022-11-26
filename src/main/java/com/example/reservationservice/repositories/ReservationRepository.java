package com.example.reservationservice.repositories;

import com.example.reservationservice.models.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    List<Reservation> findByWorkingact(String workingact);
    List<Reservation> findReservationByWorkingact(String workingact);

}
