package Reto3.repository.crud;

import Reto3.model.Reservacion;
import org.springframework.data.repository.CrudRepository;
//creacion de la interface Reservacion
public interface ReservacionCrudRepository extends CrudRepository<Reservacion,Integer>{
}
