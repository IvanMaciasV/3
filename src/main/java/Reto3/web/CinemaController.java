package Reto3.web;


import Reto3.model.Cinema;
import Reto3.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Cinema")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/all")
    public List<Cinema> getCinema(){
        return cinemaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Cinema> getCinema (@PathVariable("id")int id){
        return cinemaService.getCinema(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cinema save(@RequestBody Cinema c){
        return cinemaService.save(c);
    }
}
