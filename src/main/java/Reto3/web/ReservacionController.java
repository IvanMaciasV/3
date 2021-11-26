package Reto3.web;

import Reto3.model.Reservacion;
import Reto3.service.ReservacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins="*",methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE}) //los cross para los front
//Creacion del controlador Reservacion
public class ReservacionController {
    @Autowired
    private ReservacionService reservacionService;

    @GetMapping("/all")
    public List<Reservacion> getReservation() {
        return reservacionService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservacion> getReservation(@PathVariable("id") int idReservation) {
        return reservacionService.getReservation(idReservation);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservacion save(@RequestBody Reservacion reservation) {
        return reservacionService.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus (HttpStatus.CREATED)
    public Reservacion update (@RequestBody Reservacion reservacion){return reservacionService.update(reservacion);}

    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public boolean deleteReservation(@PathVariable("id") int idReservacion){return reservacionService.deleteReservation(idReservacion);}
}