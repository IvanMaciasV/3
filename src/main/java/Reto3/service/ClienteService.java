package Reto3.service;

import Reto3.model.Cliente;
import Reto3.repository.ClienteRepository;
import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//creacion del servicio Cliente
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAll(){
        return clienteRepository.getAll();
    }

    public Optional<Cliente> getCliente(int idClient){return clienteRepository.getCliente(idClient);    }

    public Cliente save(Cliente c){
        if(c.getIdClient()==null){
            return clienteRepository.save(c);
        }else {
            Optional<Cliente> clienteAux=clienteRepository.getCliente(c.getIdClient());
            if(clienteAux.isPresent()){
                return clienteRepository.save(c);
            }else{
                return c;
            }
        }
    }
/**
    public Cliente update (Cliente cliente){
        if(cliente.getIdCliente()!=null){
            Optional<Cliente>categorias=clienteRepository.getCliente(cliente.getIdCliente());
            if(!categorias.isPresent()){
                if(cliente.getDescription()!=null){
                    categorias.get().setDescription(cliente.getDescription());
                }
                if(cliente.getName()!=null){
                    categorias.get().setName(cliente.getName());
                }
                return clienteRepository.save(categorias.get());
            }else{
                return cliente;
            }
        }else{
            return cliente;
        }
    }

    public boolean deleteCliente(int id){
        Boolean clienteBoolean=getCliente(id).map(category ->{
            clienteRepository.delete(category);
            return true;
        }).orElse(false);
        return clienteBoolean;
    }**/

}
