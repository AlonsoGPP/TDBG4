package com.example.MsMatricula.dtos;

import com.example.MsMatricula.model.PeriodoAcademicoModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PeriodoAcademicoMapper {
    PeriodoAcademicoMapper mapper= Mappers.getMapper(PeriodoAcademicoMapper.class);
    PeriodoAcademicoResponse modelToResponse(PeriodoAcademicoModel periodoAcademicoModel);

    PeriodoAcademicoModel requestToModel(PeriodoAcademicoRequest periodoAcademicoRequest);
}
