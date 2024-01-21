package com.example.MsMatricula.dtos;

import com.example.MsMatricula.model.DetalleMatriculaModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DetalleMatriculaMapper {
    DetalleMatriculaMapper mapper = Mappers.getMapper(DetalleMatriculaMapper.class);

    DetalleMatriculaResponse detalleMatriculaModelToResponse(DetalleMatriculaModel detalleMatriculaModel);

    DetalleMatriculaModel detalleMatriculaRequestToModel(DetalleMatriculaRequest detalleMatriculaRequest);
}
