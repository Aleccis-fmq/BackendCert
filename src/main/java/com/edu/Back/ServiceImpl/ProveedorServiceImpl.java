package com.edu.Back.ServiceImpl;

import com.edu.Back.Model.Proveedor;
import com.edu.Back.Repository.IProveedorRepo;
import com.edu.Back.Service.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProveedorServiceImpl extends IGenericServiceImpl <Proveedor,Integer>  implements IProveedorService {


    @Autowired
    private IProveedorRepo proveedorRepo;

    @Override
    protected JpaRepository<Proveedor, Integer> getRepo() {
        return proveedorRepo;
    }
}
