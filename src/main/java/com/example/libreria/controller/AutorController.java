package com.example.libreria.controller;

import com.example.libreria.entitie.Autor;
import com.example.libreria.entitie.Editorial;
import com.example.libreria.service.AutorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
@Api(tags = "Controller")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @GetMapping("/")
    public ResponseEntity<List<Autor>> getAll() throws Exception {
        return new ResponseEntity<>(autorService.searchAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Autor getById(@PathVariable Long id) throws Exception {
        return autorService.searchById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Autor> create(@RequestBody Autor autor) throws Exception {
        return new ResponseEntity<>(autorService.create(autor), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Autor> update(@PathVariable Long id, @RequestBody Autor autor) throws Exception {
        autorService.update(id, autor);
        return ResponseEntity.ok(autor);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(autorService.delete(id), HttpStatus.OK);
    }
}
