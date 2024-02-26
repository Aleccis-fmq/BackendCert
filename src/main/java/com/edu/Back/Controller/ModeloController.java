package com.edu.Back.Controller;

import com.edu.Back.Model.Modelo;
import com.edu.Back.Service.IModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelo")
public class ModeloController {

    //instanciar service
    @Autowired
    private IModeloService service;

    //listar
    @GetMapping("/1")
    public ResponseEntity<List<Modelo>> listar1() throws Exception {
        List<Modelo> obj = service.listar();
        return new ResponseEntity<List<Modelo>>(obj, HttpStatus.OK);
    }

    //listar x id
    @GetMapping("/1/{id}")
    public ResponseEntity<Modelo> listarxid1(@PathVariable("id")Integer id) throws Exception {
        Modelo obj = service.listarPorId(id);
        return new ResponseEntity<Modelo>(obj,HttpStatus.OK);
    }

    //registrar
    @PostMapping("/1")
    public ResponseEntity<Modelo> registrar1(@RequestBody Modelo mod) throws Exception {
        Modelo obj = service.registrar(mod);
        return new ResponseEntity<Modelo>(obj,HttpStatus.CREATED);
    }


    //modificar
    @PutMapping("/1")
    public ResponseEntity<Modelo> modificar1(@RequestBody Modelo mod ) throws Exception {
        Modelo obj = service.modificar(mod);
        return new ResponseEntity<Modelo>(obj,HttpStatus.OK);
    }

    //eliminar
    @DeleteMapping("/1/{id}")
    public ResponseEntity<Void> eliminarxid1(@PathVariable("id") Integer id) throws Exception {
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }



}
