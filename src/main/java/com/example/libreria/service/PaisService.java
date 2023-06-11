package com.example.libreria.service;

import com.example.libreria.dto.PaisD;
import com.example.libreria.entitie.Pais;
import com.example.libreria.mapper.PaisMapper;
import com.example.libreria.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisService implements GeneralService<PaisD, Pais> {
    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private PaisMapper paisMapper;

    public List<PaisD> searchAll() throws Exception {
        try {
            return paisMapper.toDtoList(paisRepository.findAll()) ;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public PaisD searchById(Long id) throws Exception {
        try {
            return paisMapper.toDto(paisRepository.findById(id).get()) ;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public PaisD create(Pais data) throws Exception {
        try {
            return paisMapper.toDto(paisRepository.save(data)) ;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public PaisD update(Long id, Pais data) throws Exception {
        try {
            Optional<Pais> paisOptional = paisRepository.findById(id);
            if (paisOptional.isPresent()) {
                Pais paisExist = paisOptional.get();
                paisExist.setNombre(data.getNombre());
                return paisMapper.toDto(paisRepository.save(paisExist));
            } else {
                throw new Exception("fallo ");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

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
