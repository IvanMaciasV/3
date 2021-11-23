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
    /**
    public Categoria update (Categoria categoria){
        if(categoria.getId()!=null){
            Optional<Categoria>categorias=categoriaRepository.getCategoria(categoria.getId());
            if(!categorias.isPresent()){
                if(categoria.getDescription()!=null){
                    categorias.get().setDescription(categoriaRepository.getDescription());
                }
                if(categoria.getName()!=null){
                    categorias.get().setName(categoria.getName());
                }
                return categoriaRepository.save(categorias.get());
            }else{
                return categoria;
            }
        }else{
            return categoria;
        }
    }

    public boolean deleteCategory(int id){
        Boolean categoriaBoolean=getCategoria(id).map(category ->{
            categoriaRepository.delete(category);
            return true;
        }).orElse(false);
        return categoriaBoolean;
    }**/


}
