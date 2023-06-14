package com.example.libreria.service;

import com.example.libreria.dto.CategoriaD;
import com.example.libreria.entitie.Categoria;
import com.example.libreria.mapper.CategoriaMapper;
import com.example.libreria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements GeneralService<CategoriaD,Categoria>{
    private final CategoriaRepository categoriaRepository;

    private CategoriaMapper categoriaMapper;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    public List<CategoriaD> searchAll() throws Exception {
        try {
            return categoriaMapper.toDtoList(categoriaRepository.findAll());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public CategoriaD searchById(Long id) throws Exception {
        try {
            return categoriaMapper.toDto(categoriaRepository.findById(id).get());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public CategoriaD create(Categoria data) throws Exception {
        try {
            return categoriaMapper.toDto(categoriaRepository.save(data)) ;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public CategoriaD update(Long id, Categoria data) throws Exception {
        try {
            Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
            if (categoriaOptional.isPresent()) {
                Categoria categoriaExist = categoriaOptional.get();
                categoriaExist.setNombre(data.getNombre());
                categoriaExist.setDescripcion(data.getDescripcion());
                return categoriaMapper.toDto(categoriaRepository.save(categoriaExist));
            } else {
                throw new Exception("fallo al actualizar la categoria");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

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
