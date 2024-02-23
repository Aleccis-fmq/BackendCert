package com.edu.Back.ServiceImpl;

import com.edu.Back.Model.Producto;
import com.edu.Back.Repository.IProductoRepo;
import com.edu.Back.Service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends IGenericServiceImpl<Producto,Integer> implements IProductoService {

    //Traemos el repository
    @Autowired //traer la depedencia
    private IProductoRepo productoRepo;

    @Override
    protected JpaRepository<Producto, Integer> getRepo() {
        return productoRepo;
    }
}
