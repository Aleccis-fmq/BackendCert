package com.edu.Back.Controller;


import com.edu.Back.Model.Producto;
import com.edu.Back.Service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    //traer el service
    @Autowired
    private IProductoService service;


    //crear servicios
    //listar
    @GetMapping("/1")
    public ResponseEntity<List<Producto>> listar() throws Exception {
        List<Producto> lista =  service.listar();
        return new ResponseEntity<List<Producto>>(lista, HttpStatus.OK);
    }

    //listar por id //busqueda por id
    @GetMapping("/1/{id}")
    public ResponseEntity<Producto> buscarid(@PathVariable("id")Integer id) throws Exception {
        Producto obj = service.listarPorId(id);
        return new ResponseEntity<Producto>(obj,HttpStatus.OK);
    }

    //REGISTRAR
    @PostMapping("/1")
    public ResponseEntity<Producto> registrar(@RequestBody Producto prod) throws Exception {
        Producto obj = service.registrar(prod);
        return new ResponseEntity<Producto>(obj,HttpStatus.CREATED);
    }

    //modificar
    @PutMapping("/1")
    public ResponseEntity<Producto> modificar(@RequestBody Producto prod) throws Exception {
        Producto obj = service.modificar(prod);
        return new ResponseEntity<Producto>(obj,HttpStatus.OK);
    }

    //eliminar
    @DeleteMapping("/1/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id")Integer id) throws Exception {
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


}
