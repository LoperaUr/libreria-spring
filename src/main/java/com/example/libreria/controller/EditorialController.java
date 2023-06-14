package com.example.libreria.controller;

import com.example.libreria.dto.EditorialD;
import com.example.libreria.entitie.Editorial;
import com.example.libreria.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/editorial")

public class EditorialController {
    private final EditorialService editorialService;

    public EditorialController(EditorialService editorialService) {
        this.editorialService = editorialService;
    }

    @GetMapping("/")
    public ResponseEntity<List<EditorialD>> getAll() throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(editorialService.searchAll());
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EditorialD> getById(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(editorialService.searchById(id));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @PostMapping("/")
    public ResponseEntity<EditorialD> create(@RequestBody Editorial data) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(editorialService.create(data));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EditorialD> update(@PathVariable Long id, @RequestBody Editorial data) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(editorialService.update(id, data));

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(editorialService.delete(id));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(false);
        }
    }

}
