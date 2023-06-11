package com.example.libreria.mapper;

import com.example.libreria.dto.AutorD;
import com.example.libreria.entitie.Autor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AutorMapper {

    @Mappings({
            @Mapping(source = "nombre", target = "autorNombre"),
            @Mapping(source = "apellido", target = "autorApellido"),
            @Mapping(source = "nacionalidad", target = "pais"),
            @Mapping(source = "pseudonimo", target = "autorPseudonimo")

    })
    AutorD toDto(Autor autor);
    List<AutorD> toDtoList(List<Autor> autores);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    Autor toEntity(AutorD autorD);

    List<Autor> toEntityList(List<AutorD> autorDList);
}
