package Reto3.service;

import Reto3.model.Categoria;
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
            if(cinemaAux.isEmpty()){
                return cinemaRepository.save(c);
            }else{
                return c;
            }
        }
    }

    public Cinema update (Cinema c){
        if(c.getId()!=null) {
            Optional<Cinema> g = cinemaRepository.getCinema(c.getId());
            if (!g.isEmpty()) {
                if (c.getName() != null) {
                    g.get().setName(c.getName());
                }
                if (c.getDescription()!=null){
                    g.get().setDescription(c.getDescription());
                }
                if (c.getCapacity() != null) {
                    g.get().setCapacity(c.getCapacity());
                }
                if (c.getOwner()!=null){
                    g.get().setOwner(c.getOwner());
                }
                return cinemaRepository.save(g.get());
            }else {

        return c;}
        } else {
            return c;
        }
    }

    public boolean deleteCinema(int id){
        Boolean d=getCinema(id).map(cinema ->{
            cinemaRepository.delete(cinema);
            return true;
        }).orElse(false);
        return d;
    }
}
