package com.example.libreria.service;

import com.example.libreria.entitie.Autor;
import com.example.libreria.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.libreria.service.ValidatorAbstract.emailStructureValidator;
import static com.example.libreria.service.ValidatorAbstract.emailStructureValidatorGpt;

@Service
public class AutorService implements GeneralService<Autor> {
    @Autowired
    private AutorRepository autorRepository;

    @Override
    public List<Autor> searchAll() throws Exception {
        try {
            return autorRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Autor searchById(Long id) throws Exception {
        try {
            return autorRepository.findById(id).get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Autor create(Autor data) throws Exception {
        if (emailStructureValidatorGpt(data.getEmail())) {
            return autorRepository.save(data);
        } else {
            throw new Exception("fallo al crear el autor");
        }
    }

    @Override
    public Autor update(Long id, Autor data) throws Exception {
        try {
            Optional<Autor> autorOptional = autorRepository.findById(id);
            if (autorOptional.isPresent()) {
                Autor autorExist = autorOptional.get();
                autorExist.setNombre(data.getNombre());
                autorExist.setApellido(data.getApellido());
                autorExist.setPseudonimo(data.getPseudonimo());
                if (emailStructureValidatorGpt(data.getEmail())) {
                    autorExist.setEmail(data.getEmail());
                    return autorRepository.save(autorExist);
                } else {
                    throw new Exception("Email invalido");
                }
            } else {
                throw new Exception("fallo al actualizar el autor");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        try {
            if (autorRepository.existsById(id)) {
                autorRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("fallo al eliminar el autor");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
