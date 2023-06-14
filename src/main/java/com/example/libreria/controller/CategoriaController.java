package com.example.libreria.controller;

import com.example.libreria.dto.CategoriaD;
import com.example.libreria.entitie.Categoria;
import com.example.libreria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoriaD>> getAll() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(categoriaService.searchAll());
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaD> getById(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(categoriaService.searchById(id));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @PostMapping("/")
    public ResponseEntity<CategoriaD> create(@RequestBody Categoria data)  {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(categoriaService.create(data));
        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaD> update(@PathVariable Long id, @RequestBody Categoria data)  {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(categoriaService.update(id,data));

        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id)  {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(categoriaService.delete(id));
        }catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(false);
        }
    }
}

