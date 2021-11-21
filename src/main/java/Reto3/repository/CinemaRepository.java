package Reto3.repository;

import Reto3.model.Cinema;
import Reto3.repository.crud.CinemaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class CinemaRepository {
    @Autowired
    private CinemaCrudRepository crud;
    private CinemaCrudRepository cinemaCrudRepository;

    public List<Cinema> getAll(){
        return (List<Cinema>) cinemaCrudRepository.findAll();
    }
    public Optional<Cinema> getCinema(int id){
        return cinemaCrudRepository.findById(id);
    }
    public Cinema save(Cinema c){
        return cinemaCrudRepository.save(c);
    }
}

