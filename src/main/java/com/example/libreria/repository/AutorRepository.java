package com.example.libreria.repository;

import com.example.libreria.entitie.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByPseudonimo(String pseudonimo);
}
