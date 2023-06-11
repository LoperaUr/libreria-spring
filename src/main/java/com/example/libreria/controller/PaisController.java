package com.example.libreria.controller;

import com.example.libreria.dto.PaisD;
import com.example.libreria.entitie.Pais;
import com.example.libreria.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pais")
public class PaisController {
    @Autowired
    private PaisService paisService;

    @GetMapping("/")
    public ResponseEntity<List<PaisD>> getAll(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(paisService.searchAll());
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<PaisD> getById(@PathVariable Long id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(paisService.searchById(id));
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
    @PostMapping("/")
    public ResponseEntity<PaisD> create (@RequestBody Pais data) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(paisService.create(data));
        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaisD> update(@PathVariable Long id, @RequestBody Pais data){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(paisService.update(id,data));

        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);

        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete (@PathVariable Long id ){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(paisService.delete(id));
        }catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(false);
        }
    }

}

