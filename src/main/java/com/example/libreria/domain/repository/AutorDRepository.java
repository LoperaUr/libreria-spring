package com.example.libreria.domain.repository;

import com.example.libreria.domain.AutorD;

import java.util.List;
import java.util.Optional;

public interface AutorDRepository {
    List<AutorD> getAll();
    Optional<AutorD> getAutor(int autorId);
    AutorD save(AutorD autor);
    void delete(int autorId);
}
