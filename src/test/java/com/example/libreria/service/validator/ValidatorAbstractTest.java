package com.example.libreria.service.validator;

import com.example.libreria.entitie.Autor;
import org.junit.jupiter.api.Test;

import static com.example.libreria.service.validator.ValidatorAbstract.sizeEditorialValidator;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorAbstractTest {

    @Test
    void sizeEditorialValidator_ValidData() throws Exception {
        String name = "Editorial";
        String description = "Descripción de la editorial";
        assertDoesNotThrow(() -> {
            sizeEditorialValidator(name, description);
        });
    }

    @Test
    void sizeEditorialValidator_InvalidName() throws Exception {
        String name = "A";
        String description = "DMAM";
        assertThrows(Exception.class, () -> {
            sizeEditorialValidator(name, description);
        });
    }

    @Test
    void sizeEditorialValidator_InvalidDescription() throws Exception {
        String name = "AAA";
        String description = "";
        assertThrows(Exception.class, () -> {
            sizeEditorialValidator(name, description);
        });
    }

    @Test
    void sizeEditorialValidator_InvalidDescription2() throws Exception {
        String name = "AAAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String description = "";
        assertThrows(Exception.class, () -> {
            sizeEditorialValidator(name, description);
        });
    }


    @Test
    void emailStructureValidatorGpt_ValidData() {
        String email = "correo-1_1.a@gmail.com";
        assertDoesNotThrow(() -> {
            ValidatorAbstract.emailStructureValidatorGpt(email);
        });
    }

    @Test
    void emailStructureValidatorGpt_InvalidData() {
        String email = "correo *@gmail.com!";
        assertThrows(Exception.class, () -> {
            ValidatorAbstract.emailStructureValidatorGpt(email);
        });
    }


    @Test
    void autorPseudoValidator_AllData() {
        Autor data = new Autor("Manuel","Lopera","Low");
        assertDoesNotThrow( () -> {
            ValidatorAbstract.autorPseudoValidator(data);
        });
    }

    @Test
    void autorPseudoValidator_DataOnlyPseudo() {
        Autor data = new Autor("low");
        assertDoesNotThrow( () -> {
            ValidatorAbstract.autorPseudoValidator(data);
        });
    }

    /*
    @Test
     void autorPseudoValidator_DataOnlyName() {
         Autor data = new Autor("nombre","apellido");
         assertDoesNotThrow( () -> {
             ValidatorAbstract.autorPseudoValidator(data);
         });
     }
    */

}