package com.example.libreria.service;

import com.example.libreria.entitie.Categoria;
import com.example.libreria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements GeneralService<Categoria>{
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> searchAll() throws Exception {
        try {
            return categoriaRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Categoria searchById(Long id) throws Exception {
        try {
            return categoriaRepository.findById(id).get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Categoria create(Categoria data) throws Exception {
        try {
            return categoriaRepository.save(data);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public Categoria update(Long id, Categoria data) throws Exception {
        try {
            Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
            if (categoriaOptional.isPresent()) {
                Categoria categoriaExist = categoriaOptional.get();
                categoriaExist.setNombre(data.getNombre());
                categoriaExist.setDescripcion(data.getDescripcion());
                return categoriaRepository.save(categoriaExist);
            } else {
                throw new Exception("fallo al actualizar la categoria");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        try {
            Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
            if (categoriaOptional.isPresent()) {
                categoriaRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("fallo al eliminar la categoria");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
