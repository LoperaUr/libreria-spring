package com.example.libreria.controller;

import com.example.libreria.entitie.Editorial;
import com.example.libreria.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editorial")

public class EditorialController {
    @Autowired
    private EditorialService editorialService;

    @GetMapping("/")
    public List<Editorial> getAll() throws Exception {
        return editorialService.searchAll();
    }

    @GetMapping("/{id}")
    public Editorial getById(@PathVariable Long id) throws Exception {
        return editorialService.searchById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Editorial> create(@RequestBody Editorial editorial) throws Exception {
        editorialService.create(editorial);
        return ResponseEntity.ok(editorial);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Editorial> update(@PathVariable Long id, @RequestBody Editorial editorial) throws Exception {
        editorialService.update(id, editorial);
        return ResponseEntity.ok(editorial);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) throws Exception {
        editorialService.delete(id);
        return ResponseEntity.ok(true);
    }

}
