package Reto3.service;

import Reto3.model.Reservacion;
import Reto3.repository.ReservacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//creacion del servicio Reservacion
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
            if(reservationAux.isEmpty()) {
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }

        }
    }

    public Reservacion update (Reservacion r){
        if(r.getIdReservation()!=null){
            Optional<Reservacion>g=reservationRepository.getReservation(r.getIdReservation());
            if(!g.isEmpty()){
                if(r.getStartDate()!=null){
                    g.get().setStartDate(r.getStartDate());
                }
                if(r.getDevolutionDate()!=null){
                    g.get().setDevolutionDate(r.getDevolutionDate());
                }
                return reservationRepository.save(g.get());
            }else{
                return r;
            }
        }else{
            return r;
        }
    }

    public boolean deleteReservation(int id){
        Boolean d=getReservation(id).map(reservacion ->{
            reservationRepository.delete(reservacion);
            return true;
        }).orElse(false);
        return d;
    }

}
