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
            if(reservationAux.isPresent()) {
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }

        }
    }
    /**
    public Reservacion update (Reservacion reservacion){
        if(reservacion.getId()!=null){
            Optional<Reservacion>categorias=reservationRepository.getReservation(reservacion.getId());
            if(!categorias.isPresent()){
                if(reservacion.getDescription()!=null){
                    categorias.get().setDescription(reservacion.getDescription());
                }
                if(reservacion.getName()!=null){
                    categorias.get().setName(reservacion.getName());
                }
                return reservationRepository.save(categorias.get());
            }else{
                return reservacion;
            }
        }else{
            return reservacion;
        }
    }

    public boolean deleteReservation(int id){
        Boolean categoriaBoolean=getReservation(id).map(category ->{
            reservationRepository.delete(category);
            return true;
        }).orElse(false);
        return categoriaBoolean;
    }**/

}
