package Reto3.repository.crud;

import Reto3.model.Mensage;
import org.springframework.data.repository.CrudRepository;
//creacion de la interface Mensaje
public interface MensageCrudRepository extends CrudRepository<Mensage,Integer> {
}