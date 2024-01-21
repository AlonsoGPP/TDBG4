package com.example.MsMatricula.dtos;

import com.example.MsMatricula.model.MatriculaModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MatriculaMapper {
    MatriculaMapper mapper1 = Mappers.getMapper(MatriculaMapper.class);

    MatriculaResponse matriculaModelToResponse(MatriculaModel matriculaModel);

    MatriculaModel matriculaRequestToModel(MatriculaRequest matriculaRequest);
}
