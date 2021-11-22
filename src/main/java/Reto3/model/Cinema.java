package Reto3.model;
/**
 * Author: Ivan Macias
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
// Creacion de la tabla Cinema
@Entity
@Table(name="Cinema")
public class Cinema implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String owner;
    private Integer capacity;
    private String description;
//relacion con la tabla categoria
    @ManyToOne
    @JoinColumn(name = "categoriaId")
    @JsonIgnoreProperties("cinemas")
    private Categoria category;
//relacion con la tabla mensaje
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cinema")
    @JsonIgnoreProperties({"cinemas"})
    private List<Mensage> messages;
//relacion con la tabla reservacion
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy = "cinema")
    @JsonIgnoreProperties({"cinemas","message"})
    private List<Reservacion> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }

    public List<Mensage> getMessages() {
        return messages;
    }

    public void setMessages(List<Mensage> messages) {
        this.messages = messages;
    }

    public List<Reservacion> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservacion> reservations) {
        this.reservations = reservations;
    }
}
