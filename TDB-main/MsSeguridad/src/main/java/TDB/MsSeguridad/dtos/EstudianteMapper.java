package TDB.MsSeguridad.dtos;

import TDB.MsSeguridad.model.EstudianteModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EstudianteMapper {

    EstudianteMapper mapper1 = Mappers.getMapper(EstudianteMapper.class);
    EstudianteResponse estudianteToEstudianteResponse(EstudianteModel estudianteModel);

    EstudianteModel estudianteRequestToEstudianteModel(EstudianteRequest estudianteRequest);
}
