package com.edu.Back.ServiceImpl;

import com.edu.Back.Model.Categoria;
import com.edu.Back.Repository.ICategoriaRepo;
import com.edu.Back.Service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl extends  IGenericServiceImpl <Categoria,Integer> implements ICategoriaService {


    //Instanciar Repository
    @Autowired
    private ICategoriaRepo categoriaRepo;

    //Metodo implementado
    @Override
    protected JpaRepository<Categoria, Integer> getRepo() {
        return categoriaRepo;
    }
}
