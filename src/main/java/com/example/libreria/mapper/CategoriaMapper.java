package com.example.libreria.mapper;

import com.example.libreria.dto.CategoriaD;
import com.example.libreria.entitie.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    @Mappings({
            @Mapping(source = "nombre", target = "categoriaNombre"),
            @Mapping(source = "descripcion", target = "categoriaDescripcion")
    })
    CategoriaD toDto(Categoria categoria);
    List<CategoriaD> toDtoList(List<Categoria> categorias);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    Categoria toEntity(CategoriaD categoriaD);
    List<Categoria> toEntityList(List<CategoriaD> categoriaDList);
}
