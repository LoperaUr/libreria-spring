package com.example.libreria.dto;

import com.example.libreria.entitie.Autor;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class PaisD {
    private String paisNombre;
    @JsonIgnore
    private List<Autor> autores;

    public String getPaisNombre() {
        return paisNombre;
    }

    public void setPaisNombre(String paisNombre) {
        this.paisNombre = paisNombre;
    }


    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
}
