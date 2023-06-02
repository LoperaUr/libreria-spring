package com.example.libreria.domain;

public class EditorialD {
    private int editorialId;
    private String EditorialNombre;
    private String EditorialDescripcion;

    public int getEditorialId() {
        return editorialId;
    }

    public void setEditorialId(int editorialId) {
        this.editorialId = editorialId;
    }

    public String getEditorialNombre() {
        return EditorialNombre;
    }

    public void setEditorialNombre(String editorialNombre) {
        EditorialNombre = editorialNombre;
    }

    public String getEditorialDescripcion() {
        return EditorialDescripcion;
    }

    public void setEditorialDescripcion(String editorialDescripcion) {
        EditorialDescripcion = editorialDescripcion;
    }
}
