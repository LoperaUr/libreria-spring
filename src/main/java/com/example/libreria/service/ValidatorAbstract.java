package com.example.libreria.service;

public abstract class ValidatorAbstract {

    public static boolean sizeEditorialValidator(String name, String description) throws Exception {
        if (name.length() > 1 && name.length() <= 30) {
            if (description.length() > 1 && description.length() <= 300) {
                return true;
            } else {
                throw new Exception("La descripción de la editorial debe tener entre 1 y 300 caracteres");
            }
        } else {
            throw new Exception("El nombre de la editorial debe tener entre 1 y 30 caracteres");
        }
    }
}
