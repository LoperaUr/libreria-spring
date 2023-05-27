package com.example.libreria.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GeneralService<E> {
    public List<E> searchAll() throws Exception;
    public E searchById(Long id) throws Exception;
    public E create(E data) throws Exception;
    public E update(Long id, E data) throws Exception;
    public boolean delete(Long id) throws Exception;

}
