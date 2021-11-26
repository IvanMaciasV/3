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
            if(clienteAux.isEmpty()){
                return clienteRepository.save(c);
            }else{
                return c;
            }
        }
    }

    public Cliente update (Cliente c){
        if(c.getIdClient()!=null){
            Optional<Cliente>g=clienteRepository.getCliente(c.getIdClient());
            if(!g.isEmpty()){
                if(c.getEmail()!=null){
                    g.get().setEmail(c.getEmail());
                }
                if(c.getName()!=null){
                    g.get().setName(c.getName());
                }
                if(c.getPassword()!=null){
                    g.get().setPassword(c.getPassword());
                }
                if(c.getAge()!=null){
                    g.get().setAge(c.getAge());
                }
                return clienteRepository.save(g.get());
            }else{
                return c;
            }
        }else{
            return c;
        }
    }

    public boolean deleteClient(int id){
        Boolean d=getCliente(id).map(cliente ->{
            clienteRepository.delete(cliente);
            return true;
        }).orElse(false);
        return d;
    }

}
