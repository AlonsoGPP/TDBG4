package TDB.MsControlAcademico.dtos;

import TDB.MsControlAcademico.model.CursoModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CursosMapper {
    CursosMapper mapper1 = Mappers.getMapper(CursosMapper.class);

    CursoDTO cursoToCursoDTO(CursoModel cursoModel);
    CursoModel cursoDTOToCurso(CursoDTO cursoDTO);
}
