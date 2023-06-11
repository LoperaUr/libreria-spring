package com.example.libreria.mapper;

import com.example.libreria.dto.UbicacionD;
import com.example.libreria.entitie.Ubicacion;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UbicacionMapper {

    @Mappings({
            @Mapping(source = "piso", target = "ubicacionPiso"),
            @Mapping(source = "salon", target = "ubicacionSalon"),
            @Mapping(source = "estante", target = "ubicacionEstante")
    })
    UbicacionD toDto(Ubicacion ubicacion);
    List<UbicacionD> toDtoList(List<Ubicacion> ubicaciones);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    Ubicacion toEntity(UbicacionD ubicacionD);
    List<Ubicacion> toEntityList(List<UbicacionD> ubicacionDList);


}
