package com.example.libreria.controller;

import com.example.libreria.dto.AutorD;
import com.example.libreria.entitie.Autor;
import com.example.libreria.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/autor")
public class AutorController {
    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping("/")
    public ResponseEntity<List<AutorD>> getAll() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(autorService.searchAll());
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorD> getById(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(autorService.searchById(id));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @PostMapping("/")
    public ResponseEntity<AutorD> create(@RequestBody Autor data) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(autorService.create(data));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AutorD> update(@PathVariable Long id, @RequestBody Autor data) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(autorService.update(id, data));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(autorService.delete(id));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(false);
        }
    }
}
