package Reto3.repository;

import Reto3.model.Categoria;
import Reto3.repository.crud.CategoriaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
//Creacion del repositorio de categoria
public class CategoriaRepository {
    @Autowired
    private CategoriaCrudRepository categoriaCrudRepository;

    public List<Categoria> getAll(){return (List<Categoria>) categoriaCrudRepository.findAll();}
    public Optional<Categoria> getCategoria(int id){return categoriaCrudRepository.findById(id);}
    public Categoria save(Categoria category){return categoriaCrudRepository.save(category);}

}