package com.example.libreria.mapper;

import com.example.libreria.dto.EditorialD;
import com.example.libreria.entitie.Editorial;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EditorialMapper {

    @Mappings({
            @Mapping(source = "nombre", target = "editorialNombre"),
            @Mapping(source = "descripcion", target = "editorialDescripcion")
    })
    EditorialD toDto(Editorial editorial);
    List<EditorialD> toDtoList(List<Editorial> editoriales);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    Editorial toEntity(EditorialD editorialD);
    List<Editorial> toEntityList(List<EditorialD> editorialDList);
}