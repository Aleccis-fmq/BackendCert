package com.edu.Back.Controller;

import com.edu.Back.Dto.ModelDto.CategoriaDto;
import com.edu.Back.Model.Categoria;
import com.edu.Back.Service.ICategoriaService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    //Service
    @Autowired
    private ICategoriaService service;

    //ModeloMapper
    @Autowired
    private ModelMapper mapper;

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

    //USO DE DTOS

    //listar
    @GetMapping("/2")
    public ResponseEntity<List<CategoriaDto>> listar2() throws Exception {
        List<CategoriaDto> lista2 = service.listar().stream().map(p -> mapper.map(p, CategoriaDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<List<CategoriaDto>>(lista2,HttpStatus.OK);
    }

    //listar x id
    @GetMapping("/2/{id}")
    public ResponseEntity<CategoriaDto> listarxid2(@PathVariable ("id")Integer id) throws Exception {
        Categoria obj = service.listarPorId(id);
        //
        CategoriaDto dto = mapper.map(obj, CategoriaDto.class);

        return new ResponseEntity<CategoriaDto>(dto,HttpStatus.OK);
    }

    // Registrar
    @PostMapping("/2")
    public ResponseEntity<Void> registrar2(@Valid @RequestBody CategoriaDto catdto) throws Exception {

        Categoria cat =  mapper.map(catdto, Categoria.class);
        Categoria obj = service.registrar(cat);

        // ACCESO AL RECURSO :8080/usuarios/2/1
        URI loc = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getIdCategoria()).toUri();

        // return
        return  ResponseEntity.created(loc).build();
    }

    // MODIFICAR
    @PutMapping("/2")
    public ResponseEntity<Categoria> modificar(@Valid @RequestBody CategoriaDto catdto) throws Exception {
        Categoria cat = mapper.map(catdto, Categoria.class);
        Categoria obj = service.modificar(cat);

        //
        return new ResponseEntity<Categoria>(obj,HttpStatus.OK);
    }

    //
    // ELIMINAR
    @DeleteMapping("/2/{id}")
    public ResponseEntity<Void> eliminar2(@PathVariable("id") Integer id) throws Exception {
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


}
