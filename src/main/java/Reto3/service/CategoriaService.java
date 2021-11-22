package Reto3.service;

import Reto3.model.Categoria;
import Reto3.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//creacion del servicio Categoria
@Service
public class CategoriaService {
    @Autowired
    private  CategoriaRepository categoriaRepository;

    public List<Categoria> getAll(){
        return categoriaRepository.getAll();

    }

    public Optional <Categoria> getCategoria(int id){
        return categoriaRepository.getCategoria(id);
    }
    public Categoria save(Categoria c) {
        if(c.getId()== null){
            return categoriaRepository.save(c);
        }else{
            Optional<Categoria>categoryAux=categoriaRepository.getCategoria(c.getId());
            if(categoryAux.isPresent()) {
                return categoriaRepository.save(c);
            }else{
                return c;
            }
        }
    }


}
