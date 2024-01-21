package com.Msdocencia.MsDocencia.dtos;

import com.Msdocencia.MsDocencia.model.DocenteDictaCursoModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DocenteDictaCursoMapper {
    DocenteDictaCursoMapper mapper= Mappers.getMapper(DocenteDictaCursoMapper.class);

    DocenteDictaCursoResponse modelToResponse(DocenteDictaCursoModel docenteDictaCursoModel);

    DocenteDictaCursoModel requestToModel(DocenteDictaCursoRequest docenteDictaCursoRequest);

}
