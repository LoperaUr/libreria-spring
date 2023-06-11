package com.example.libreria.service;

import com.example.libreria.dto.AutorD;
import com.example.libreria.entitie.Autor;
import com.example.libreria.mapper.AutorMapper;
import com.example.libreria.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.libreria.service.validator.ValidatorAbstract.autorValidator;
import static com.example.libreria.service.validator.ValidatorAbstract.emailStructureValidatorGpt;

@Service
public class AutorService implements GeneralService<AutorD, Autor> {
    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private AutorMapper autorMapper;

    @Override
    public List<AutorD> searchAll() throws Exception {
        try {
            return autorMapper.toDtoList(autorRepository.findAll());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public AutorD searchById(Long id) throws Exception {
        try {
            return autorMapper.toDto(autorRepository.findById(id).get());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public AutorD create(Autor data) throws Exception {
        if (emailStructureValidatorGpt(data.getEmail()) && autorValidator(data) && !autorRepository.findByPseudonimo(data.getPseudonimo()).isPresent()) {
            return autorMapper.toDto(autorRepository.save(data));
        }
        throw new Exception("fallo al crear el autor");
    }

    @Override
    public AutorD update(Long id, Autor data) throws Exception {
        try {
            Optional<Autor> autorOptional = autorRepository.findById(id);
            if (autorOptional.isPresent()) {
                Optional<Autor> autorPseudonimo = autorRepository.findByPseudonimo(data.getPseudonimo());
                Autor autorExist = autorOptional.get();
                if(!emailStructureValidatorGpt(data.getEmail())) {
                    throw new Exception("Email invalido");
                } else if (autorValidator(data)) {
                    throw new Exception("Debe tener nombre y apellido o pseudonimo");
                } else if (autorPseudonimo.isPresent() && !data.getPseudonimo().equals(autorPseudonimo.get().getPseudonimo())) {
                    throw new Exception("El pseudonimo debe ser unico");
                }
                autorExist.setNombre(data.getNombre());
                autorExist.setApellido(data.getApellido());
                autorExist.setPseudonimo(data.getPseudonimo());
                autorExist.setEmail(data.getEmail());
                return autorMapper.toDto(autorRepository.save(autorExist));
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
