package com.example.libreria.service;

import com.example.libreria.entitie.Editorial;
import com.example.libreria.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.libreria.service.ValidatorAbstract.sizeEditorialValidator;

@Service
public class EditorialService implements GeneralService<Editorial> {

    @Autowired
    private EditorialRepository editorialRepository;

    @Override
    public List<Editorial> searchAll() throws Exception {
        try {
            return editorialRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Editorial searchById(Long id) throws Exception {
        try {
            Optional<Editorial> editorialOptional = editorialRepository.findById(id);
            if (editorialOptional.isPresent()) {
                return editorialOptional.get();
            } else {
                throw new Exception("Fallo al encontrar la editorial");
            }
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    @Override
    public Editorial create(Editorial data) throws Exception {
        if (sizeEditorialValidator(data.getNombre(), data.getDescripcion())) {
            return editorialRepository.save(data);
        } else {
            throw new Exception("fallo al crear la editorial");
        }
    }

    @Override
    public Editorial update(Long id, Editorial data) throws Exception {
        try {
            Optional<Editorial> acudienteOptional = editorialRepository.findById(id);
            if (acudienteOptional.isPresent()) {
                Editorial acudienteExist = acudienteOptional.get();
                acudienteExist.setNombre(data.getNombre());
                acudienteExist.setDescripcion(data.getDescripcion());
                return editorialRepository.save(acudienteExist);

            } else {
                throw new Exception("fallo al actualizar la editorial");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        try {
            Optional<Editorial> acudienteOptional = editorialRepository.findById(id);
            if (acudienteOptional.isPresent()) {
                editorialRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("fallo al eliminar la editorial");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
