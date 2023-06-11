package com.example.libreria.mapper;

import com.example.libreria.dto.PaisD;
import com.example.libreria.entitie.Pais;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaisMapper {
    @Mappings({
            @Mapping(source = "nombre", target = "paisNombre"),
            @Mapping(source = "autors", target = "autores")
    })
    PaisD toDto(Pais pais);
    List<PaisD> toDtoList(List<Pais> paises);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    Pais toEntity(PaisD paisD);
    List<Pais> toEntityList(List<PaisD> paisDList);
}
