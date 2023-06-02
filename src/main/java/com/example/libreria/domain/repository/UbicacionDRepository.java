package com.example.libreria.domain.repository;

import com.example.libreria.domain.UbicacionD;

import java.util.List;
import java.util.Optional;

public interface UbicacionDRepository {
    List<UbicacionD> getAll();
    Optional<UbicacionD> getUbicacion(int editorialId);
    UbicacionD save(UbicacionD ubicacionD);
    void delete(int ubicacionId);
}
