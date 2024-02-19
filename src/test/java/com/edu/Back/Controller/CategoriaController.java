package com.edu.Back.Controller;

import com.edu.Back.Model.Categoria;
import com.edu.Back.Service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    //Service
    @Autowired
    private ICategoriaService service;

    //ModeloMapper

    // RICH NIVEL 1 / MODELO

    // LISTAR
    @GetMapping("/1")
    public ResponseEntity<List<Categoria>> listar1() throws Exception {
        List<Categoria> lista = service.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    // LISTARPORID
    @GetMapping("/1/{id}")
    public ResponseEntity<Categoria> listarporIdD(@PathVariable("id") Integer id) throws Exception {
        Categoria obj = service.listarPorId(id);
        return new ResponseEntity<Categoria>(obj, HttpStatus.OK);
    }

    // REGISTRAR
    @PostMapping("/1")
    public ResponseEntity<Categoria> registrarr(@RequestBody Categoria cat) throws Exception {
        Categoria obj = service.registrar(cat);
        return new ResponseEntity<Categoria>(obj, HttpStatus.CREATED);
    }

    // MODIFICAR
    @PutMapping("/1")
    public ResponseEntity<Categoria> modificarr(@RequestBody Categoria cat) throws Exception {
        Categoria obj = service.modificar(cat);
        return new ResponseEntity<Categoria>(obj, HttpStatus.OK);
    }

    // ELIMINAR
    @DeleteMapping("/1/{id}")
    public ResponseEntity<Void> eliminarr(@PathVariable("id") Integer id) throws Exception {
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
