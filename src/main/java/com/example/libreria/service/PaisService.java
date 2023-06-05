package com.example.libreria.service;

import com.example.libreria.entitie.Pais;
import com.example.libreria.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisService implements GeneralService<Pais>{
   @Autowired
    private PaisRepository paisRepository;

    @Override
    public List<Pais> searchAll() throws Exception {
        try {
            return paisRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Pais searchById(Long id) throws Exception {
        try {
            return paisRepository.findById(id).get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Pais create(Pais data) throws Exception {
        try {
            return paisRepository.save(data);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public Pais update(Long id, Pais data) throws Exception {
        try {
            Optional<Pais> paisOptional = paisRepository.findById(id);
            if (paisOptional.isPresent()) {
                Pais paisExist = paisOptional.get();
                paisExist.setNombre(data.getNombre());
                return paisRepository.save(paisExist);
            } else {
                throw new Exception("fallo ");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        try {
            Optional<Pais> paisOptional = paisRepository.findById(id);
            if (paisOptional.isPresent()) {
                paisRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("fallo ");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
