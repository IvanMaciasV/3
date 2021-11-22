package Reto3.repository.crud;

import Reto3.model.Cinema;
import org.springframework.data.repository.CrudRepository;
//creacion de la interface Cinema
public interface CinemaCrudRepository extends CrudRepository<Cinema, Integer> {
}
