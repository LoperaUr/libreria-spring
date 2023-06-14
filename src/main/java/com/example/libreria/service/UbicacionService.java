package com.example.libreria.service;

import com.example.libreria.dto.UbicacionD;
import com.example.libreria.entitie.Ubicacion;
import com.example.libreria.mapper.UbicacionMapper;
import com.example.libreria.repository.UbicacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UbicacionService implements GeneralService<UbicacionD, Ubicacion> {
    private final UbicacionRepository ubicacionRepository;

    private final UbicacionMapper ubicacionMapper;

    public UbicacionService(UbicacionRepository ubicacionRepository, UbicacionMapper ubicacionMapper) {
        this.ubicacionRepository = ubicacionRepository;
        this.ubicacionMapper = ubicacionMapper;
    }

    public List<UbicacionD> searchAll() throws Exception {
        try {
            return ubicacionMapper.toDtoList(ubicacionRepository.findAll()) ;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public UbicacionD searchById(Long id) throws Exception {
        try {
            return ubicacionMapper.toDto(ubicacionRepository.findById(id).get());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public UbicacionD create(Ubicacion data) throws Exception {
        try {
            return ubicacionMapper.toDto(ubicacionRepository.save(data));
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public UbicacionD update(Long id, Ubicacion data) throws Exception {
        try {
            Optional<Ubicacion> ubicacionOptional = ubicacionRepository.findById(id);
            if (ubicacionOptional.isPresent()) {
                Ubicacion ubicacionExist = ubicacionOptional.get();
                ubicacionExist.setPiso(data.getPiso());
                ubicacionExist.setSalon(data.getSalon());
                ubicacionExist.setEstante(data.getEstante());
                return ubicacionMapper.toDto(ubicacionRepository.save(ubicacionExist));
            } else {
                throw new Exception("fallo al actualizar la ubicacion");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public boolean delete(Long id) throws Exception {
        try {
            Optional<Ubicacion> ubicacionOptional = ubicacionRepository.findById(id);
            if (ubicacionOptional.isPresent()) {
                ubicacionRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("fallo al eliminar la ubicacion");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
