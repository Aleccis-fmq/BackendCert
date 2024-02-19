package com.edu.Back.ServiceImpl;

import com.edu.Back.Service.IGenericService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class IGenericServiceImpl <T,ID> implements IGenericService<T,ID> {

    //Traer Datos Iniciales de JPA , Repository Generico.
    protected abstract JpaRepository <T,ID>getRepo();

    //traer los componentes creados en IGenericService

    //Metodo de Registrar
    @Override
    public T registrar (T t) throws  Exception{
        return getRepo().save(t);
    }

    //Metodo de Modificar
    @Override
    public T modificar (T t) throws  Exception{
        return getRepo().save(t);
    }

    //Metodo de Listar
    @Override
    public List<T> listar() throws Exception{
        return getRepo().findAll();
    }

    //Metodo de Listar por Id
    @Override
    public T listarPorId(ID id) throws  Exception{
        return getRepo().findById(id).orElse(null);
    }

    //Eliminar
    @Override
    public void eliminar(ID id) throws Exception{
        getRepo().deleteById(id);
    }
}
