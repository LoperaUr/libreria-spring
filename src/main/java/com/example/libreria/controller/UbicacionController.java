package com.example.libreria.controller;

import com.example.libreria.entitie.Ubicacion;
import com.example.libreria.service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ubicacion")
public class UbicacionController {
    @Autowired
    private UbicacionService ubicacionService;

    @GetMapping("/")
    public List<Ubicacion> getAll() throws Exception {
        return ubicacionService.searchAll();
    }

    @GetMapping("/{id}")
    public Ubicacion getById(@PathVariable Long id) throws Exception {
        return ubicacionService.searchById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Ubicacion> create(@RequestBody Ubicacion ubicacion) throws Exception {
        ubicacionService.create(ubicacion);
        return ResponseEntity.ok(ubicacion);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Ubicacion> update(@PathVariable Long id, @RequestBody Ubicacion ubicacion) throws Exception {
        ubicacionService.update(id, ubicacion);
        return ResponseEntity.ok(ubicacion);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) throws Exception {
        ubicacionService.delete(id);
        return ResponseEntity.ok(true);
    }
}
