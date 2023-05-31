package com.example.libreria.service;

import com.example.libreria.entitie.Categoria;
import com.example.libreria.entitie.Ubicacion;
import com.example.libreria.repository.UbicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UbicacionService implements GeneralService<Ubicacion>{
    @Autowired
    private UbicacionRepository ubicacionRepository;

    @Override
    public List<Ubicacion> searchAll() throws Exception {
        try {
            return ubicacionRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Ubicacion searchById(Long id) throws Exception {
        try {
            return ubicacionRepository.findById(id).get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Ubicacion create(Ubicacion data) throws Exception {
        try {
            return ubicacionRepository.save(data);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public Ubicacion update(Long id, Ubicacion data) throws Exception {
        try {
            Optional<Ubicacion> ubicacionOptional = ubicacionRepository.findById(id);
            if (ubicacionOptional.isPresent()) {
                Ubicacion ubicacionExist = ubicacionOptional.get();
                ubicacionExist.setPiso(data.getPiso());
                ubicacionExist.setSalon(data.getSalon());
                ubicacionExist.setEstante(data.getEstante());
                return ubicacionRepository.save(ubicacionExist);
            } else {
                throw new Exception("fallo al actualizar la ubicacion");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
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
