package com.example.reservationservice.controllers;

import com.example.reservationservice.models.Reservation;
import com.example.reservationservice.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/reservations/")
public class ReservationController {

    @Autowired
    ReservationRepository repository;

    @PostMapping(value = "create")
    public Reservation postReservation(@RequestBody Reservation res) {
        Reservation _res = repository.save(new Reservation(res.getId(), res.getWorkingact(), res.getCharityact(), res.getIdBox()));
        System.out.println(_res);
        return _res;
    }

    @GetMapping("reservations")
    public List<Reservation> getAllBoxes() {
        System.out.println("Get all Reservations ...");

        List<Reservation> reservations = new ArrayList<>();
        repository.findAll().forEach(reservations::add);
        System.out.println(reservations);
        return reservations;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable("id") long id) {
        System.out.println("Delete reservation with ID = " + id + "...");

        repository.deleteById(id);

        return new ResponseEntity<>("Reservantion has been deleted!", HttpStatus.OK);
    }

    @GetMapping(value = "/wa/{workingact}")
    public List<Reservation> reservationByWorkingact(@PathVariable String workingact) {

        List<Reservation> reservations = new ArrayList<>();
        repository.findAll().forEach(reservations::add);

        for (Reservation r : reservations) {
            if(!r.getWorkingact().equals(workingact))
                reservations.remove(r);
        }

        return reservations;
    }

}

