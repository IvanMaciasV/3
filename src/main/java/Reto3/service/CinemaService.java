package Reto3.service;

import Reto3.model.Cinema;
import Reto3.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//creacion del servicio Cinema
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
    /**
    public Cinema update (Cinema cinema){
        if(cinema.getId()!=null){
            Optional<Cinema>categorias=cinemaRepository.getCinema(cinema.getId());
            if(!categorias.isPresent()){
                if(cinema.getDescription()!=null){
                    cinema.get().setDescription(cinema.getDescription());
                }
                if(cinema.getName()!=null){
                    cinema.get().setName(cinema.getName());
                }
                return cinemaRepository.save(categorias.get());
            }else{
                return cinema;
            }
        }else{
            return cinema;
        }
    }

    public boolean deleteCinema(int id){
        Boolean cinemaBoolean=getCinema(id).map(cinema ->{
            cinemaRepository.delete(cinema);
            return true;
        }).orElse(false);
        return cinemaBoolean;
    }**/


}
