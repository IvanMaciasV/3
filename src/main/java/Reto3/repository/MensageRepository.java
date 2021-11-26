package Reto3.repository;


import Reto3.model.Mensage;
import Reto3.repository.crud.MensageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class MensageRepository {
    @Autowired
    private MensageCrudRepository messageCrudRepository;
    //Creacion del repositorio de Mensaje
    public List<Mensage> getAll(){return (List<Mensage>) messageCrudRepository.findAll();}
    public Optional<Mensage> getMessage(int id){return messageCrudRepository.findById(id);}
    public Mensage save(Mensage message){return messageCrudRepository.save(message);}
    public void delete(Mensage message) {messageCrudRepository.delete(message);}
}