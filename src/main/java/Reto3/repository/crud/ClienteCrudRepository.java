package Reto3.repository.crud;

import Reto3.model.Cliente;
import org.springframework.data.repository.CrudRepository;

//creacion de la interface Cliente
public interface ClienteCrudRepository extends CrudRepository<Cliente, Integer>{
}


