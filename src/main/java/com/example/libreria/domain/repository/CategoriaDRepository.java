package com.example.libreria.domain.repository;

import com.example.libreria.domain.CategoriaD;

import java.util.List;
import java.util.Optional;

public interface CategoriaDRepository {
    List<CategoriaD> getAll();
    Optional<CategoriaD> getCategory(int categoriaId);
    CategoriaD save(CategoriaD categoriaD);
    void delete(int categoriaId);
}
