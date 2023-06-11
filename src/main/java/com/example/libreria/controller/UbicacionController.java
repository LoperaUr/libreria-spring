package com.example.libreria.controller;

import com.example.libreria.dto.UbicacionD;
import com.example.libreria.entitie.Ubicacion;
import com.example.libreria.service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ubicacion")
public class UbicacionController {
    @Autowired
    private UbicacionService ubicacionService;

    @GetMapping("/")
    public ResponseEntity<List<UbicacionD>> getAll() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ubicacionService.searchAll());
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UbicacionD> getById(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ubicacionService.searchById(id));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @PostMapping("/")
    public ResponseEntity<UbicacionD> create(@RequestBody Ubicacion data) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(ubicacionService.create(data));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UbicacionD> update(@PathVariable Long id, @RequestBody Ubicacion data) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ubicacionService.update(id, data));

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
                    .body(ubicacionService.delete(id));
        }catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(false);
        }
    }
}
