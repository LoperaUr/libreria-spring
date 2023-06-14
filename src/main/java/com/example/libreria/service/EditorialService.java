package com.example.libreria.service;

import com.example.libreria.dto.EditorialD;
import com.example.libreria.entitie.Editorial;
import com.example.libreria.mapper.EditorialMapper;
import com.example.libreria.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.libreria.service.validator.ValidatorAbstract.sizeEditorialValidator;

@Service
public class EditorialService implements GeneralService<EditorialD, Editorial> {

    private final EditorialRepository editorialRepository;

    private final EditorialMapper editorialMapper;

    public EditorialService(EditorialRepository editorialRepository, EditorialMapper editorialMapper) {
        this.editorialRepository = editorialRepository;
        this.editorialMapper = editorialMapper;
    }

    public List<EditorialD> searchAll() throws Exception {
        try {
            return editorialMapper.toDtoList(editorialRepository.findAll());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public EditorialD searchById(Long id) throws Exception {
        try {
            return editorialMapper.toDto(editorialRepository.findById(id).get());
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public EditorialD create(Editorial data) throws Exception {
        if (sizeEditorialValidator(data.getNombre(), data.getDescripcion())) {
            return editorialMapper.toDto(editorialRepository.save(data));
        } else {
            throw new Exception("fallo al crear la editorial");
        }
    }

    public EditorialD update(Long id, Editorial data) throws Exception {
        try {
            Optional<Editorial> acudienteOptional = editorialRepository.findById(id);
            if (acudienteOptional.isPresent()) {
                Editorial acudienteExist = acudienteOptional.get();
                acudienteExist.setNombre(data.getNombre());
                acudienteExist.setDescripcion(data.getDescripcion());
                return editorialMapper.toDto(editorialRepository.save(acudienteExist));

            } else {
                throw new Exception("fallo al actualizar la editorial");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

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
