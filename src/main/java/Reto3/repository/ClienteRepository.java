package Reto3.repository;

import Reto3.model.Cliente;
import Reto3.repository.crud.ClienteCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class ClienteRepository {
    @Autowired

    private ClienteCrudRepository clienteCrudRepository;
    //Creacion del repositorio de Cliente
    public List<Cliente> getAll(){
        return (List<Cliente>) clienteCrudRepository.findAll();
    }
    public Optional<Cliente> getCliente(int id){
        return clienteCrudRepository.findById(id);
    }
    public Cliente save(Cliente c){
        return clienteCrudRepository.save(c);
    }
}
