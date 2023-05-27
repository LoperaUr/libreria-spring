package com.example.libreria.controller;

import com.example.libreria.entitie.Autor;
import com.example.libreria.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @GetMapping("/")
    public List<Autor> getAll() throws Exception {
        return autorService.searchAll();
    }

    @GetMapping("/{id}")
    public Autor getById(@PathVariable Long id) throws Exception {
        return autorService.searchById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Autor> create(@RequestBody Autor autor) throws Exception {
        autorService.create(autor);
        return ResponseEntity.ok(autor);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Autor> update(@PathVariable Long id, @RequestBody Autor autor) throws Exception {
        autorService.update(id, autor);
        return ResponseEntity.ok(autor);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) throws Exception {
        autorService.delete(id);
        return ResponseEntity.ok(true);
    }

}
