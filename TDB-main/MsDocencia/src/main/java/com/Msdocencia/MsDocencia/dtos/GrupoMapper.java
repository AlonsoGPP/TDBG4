package com.Msdocencia.MsDocencia.dtos;


import org.mapstruct.factory.Mappers;

import com.Msdocencia.MsDocencia.model.GruposModel;



public interface GrupoMapper {

    GrupoMapper  mapper= Mappers.getMapper(GrupoMapper.class);

    GrupoResponse modelToResponse(GruposModel gruposModel);

    GruposModel requestToModel(GrupoRequest gruposRequest);

}

