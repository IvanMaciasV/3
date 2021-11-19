package Reto3.service;

import Reto3.model.Cinema;
import Reto3.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public List<Cinema> getAll(){
        return cinemaRepository.getAll();
    }

    public Optional<Cinema> getCinema(int id){
        return cinemaRepository.getCinema(id);
    }

    public Cinema save(Cinema c){
        if(c.getId()==null){
            return cinemaRepository.save(c);
        }else {
            Optional<Cinema> cinemaAux=cinemaRepository.getCinema(c.getId());
            if(cinemaAux.isPresent()){
                return cinemaRepository.save(c);
            }else{
                return c;
            }
        }
    }
}
