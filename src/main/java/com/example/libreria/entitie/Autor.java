package com.example.libreria.entitie;

import jakarta.persistence.*;

@Entity
@Table (name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    @Column(unique = true)
    private String pseudonimo;

    @Column(unique = true)
    private String email;


    public Autor() {
    }

    public Autor(Long id, String nombre, String apellido, String pseudonimo, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pseudonimo = pseudonimo;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPseudonimo() {
        return pseudonimo;
    }

    public void setPseudonimo(String pseudonimo) {
        this.pseudonimo = pseudonimo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
