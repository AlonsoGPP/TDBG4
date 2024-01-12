package TDB.MsControlAcademico.dtos;

import TDB.MsControlAcademico.model.FacultadModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FacultadMapper {
    FacultadMapper mapper1 = Mappers.getMapper(FacultadMapper.class);
    FacultadDTO facultadToFacultadDTO(FacultadModel facultadModel);

    FacultadModel facultadDTOtoFacultad(FacultadDTO facultadDTO);
}
