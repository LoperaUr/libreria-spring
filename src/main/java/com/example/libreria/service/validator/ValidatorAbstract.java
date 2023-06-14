package com.example.libreria.service.validator;

import com.example.libreria.entitie.Autor;

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


    public static boolean emailStructureValidatorGpt(String email) throws Exception {
        String emailRegex = "^[A-Za-z0-9_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (email.matches(emailRegex)) {
            return true;
        } else {
            throw new Exception("El email debe tener el formato correcto y no contener caracteres especiales ni espacios adicionales");
        }
    }

    public static boolean autorPseudoValidator(Autor data) throws Exception {
        if ((data.getApellido() == null || !data.getApellido().isEmpty()) &&
                (data.getNombre() == null || !data.getNombre().isEmpty())) {
            return true;
        } else if (!data.getPseudonimo().isEmpty()) {
            return true;
        } else {
            throw new Exception("Debe tener nombre y apellido o pseudonimo");
        }
    }
}
