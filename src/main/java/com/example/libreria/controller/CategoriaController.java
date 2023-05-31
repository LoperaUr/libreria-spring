package com.example.libreria.controller;

import com.example.libreria.entitie.Categoria;
import com.example.libreria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public List<Categoria> getAll() throws Exception {
        return categoriaService.searchAll();
    }

    @GetMapping("/{id}")
    public Categoria getById(@PathVariable Long id) throws Exception {
        return categoriaService.searchById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria) throws Exception {
        categoriaService.create(categoria);
        return ResponseEntity.ok(categoria);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoria) throws Exception {
        categoriaService.update(id, categoria);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) throws Exception {
        categoriaService.delete(id);
        return ResponseEntity.ok(true);
    }
}

