package TDB.MsControlAcademico.dtos;

import TDB.MsControlAcademico.model.CursoModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CursoMapper {
    CursoMapper mapper= Mappers.getMapper(CursoMapper.class);

    CursoDTO cursoToCursoDTO(CursoModel cursoModel);
    CursoModel cursoDTOToCurso(CursoDTO cursoDTO);
}
