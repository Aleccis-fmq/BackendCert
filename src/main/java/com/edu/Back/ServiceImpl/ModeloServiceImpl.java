package com.edu.Back.ServiceImpl;

import com.edu.Back.Model.Modelo;
import com.edu.Back.Repository.IModeloRepo;
import com.edu.Back.Service.IModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ModeloServiceImpl extends IGenericServiceImpl<Modelo,Integer> implements IModeloService {


    //INSTANCIAR EL REPO DE MODELO
    @Autowired
    private IModeloRepo modeloRepo;

    @Override
    protected JpaRepository<Modelo, Integer> getRepo() {
        return modeloRepo;
    }
}
