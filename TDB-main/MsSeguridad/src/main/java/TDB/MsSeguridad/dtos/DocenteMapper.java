package TDB.MsSeguridad.dtos;

import TDB.MsSeguridad.model.DocenteModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DocenteMapper {
    DocenteMapper mapper1 = Mappers.getMapper(DocenteMapper.class);

    DocenteResponse docenteModelToDocenteResponse(DocenteModel docenteModel);

    DocenteModel docenteRequestToDocenteModel(DocenteRequest docenteRequest);
}

