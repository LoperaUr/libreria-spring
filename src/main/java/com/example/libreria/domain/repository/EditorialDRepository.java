package com.example.libreria.domain.repository;

import com.example.libreria.domain.EditorialD;

import java.util.List;
import java.util.Optional;

public interface EditorialDRepository {
    List<EditorialD> getAll();
    Optional<EditorialD> getEditorial(int editorialId);
    EditorialD save(EditorialD editorialD);
    void delete(int editorialId);
}
