package com.example.libreria.dto;

import com.example.libreria.entitie.Pais;

public class AutorD {
    private String autorNombre;
    private String autorApellido;
    private String autorPseudonimo;
    private String email;
    private Pais pais;

    public String getAutorNombre() {
        return autorNombre;
    }

    public void setAutorNombre(String autorNombre) {
        this.autorNombre = autorNombre;
    }

    public String getAutorApellido() {
        return autorApellido;
    }

    public void setAutorApellido(String autorApellido) {
        this.autorApellido = autorApellido;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getAutorPseudonimo() {
        return autorPseudonimo;
    }

    public void setAutorPseudonimo(String autorPseudonimo) {
        this.autorPseudonimo = autorPseudonimo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
