package com.edu.Back.Controller;


import com.edu.Back.Model.Proveedor;
import com.edu.Back.Service.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
public class ProveedorControler {

    //Service
    @Autowired
    private IProveedorService service;


    // Rich nivel 1 /modelo

    // listar
    @GetMapping("/1")
    public ResponseEntity<List<Proveedor>> listar1() throws Exception {
        List<Proveedor> lista = service.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    // buscar por id //listar
    @GetMapping("1/{id}")
    public ResponseEntity<Proveedor> listarporId(@PathVariable("id") Integer id) throws Exception {
        Proveedor obj = service.listarPorId(id);
        return new ResponseEntity<Proveedor>(obj,HttpStatus.OK);
    }

    //registrar
    @PostMapping("/1")
    public ResponseEntity<Proveedor> registrar(@RequestBody Proveedor prov) throws Exception {
        Proveedor obj = service.registrar(prov);
        return new ResponseEntity<Proveedor>(obj,HttpStatus.CREATED);
    }

    //modificar
    @PutMapping("/1")
    public ResponseEntity<Proveedor> modificar (@RequestBody Proveedor prov) throws Exception {
        Proveedor obj = service.modificar(prov);
        return new ResponseEntity<Proveedor>(obj,HttpStatus.OK);
    }

    //eliminar
    @DeleteMapping("/1/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id")Integer id) throws Exception {
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
