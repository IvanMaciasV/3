package Reto3.service;

import Reto3.model.Reservacion;
import Reto3.repository.ReservacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ReservacionService {
    @Autowired
    private ReservacionRepository reservationRepository;

    public List<Reservacion> getAll(){
        return reservationRepository.getAll();

    }

    public Optional<Reservacion> getReservation(int idReservation){
        return reservationRepository.getReservation(idReservation);
    }

    public Reservacion save(Reservacion reservation) {
        if(reservation.getIdReservation()== null){
            return reservationRepository.save(reservation);

        }else{
            Optional<Reservacion>reservationAux=reservationRepository.getReservation(reservation.getIdReservation());
            if(reservationAux.isPresent()) {
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }

        }
    }

}
