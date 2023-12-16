package TDB.MsControlAcademico.dtos;

import TDB.MsControlAcademico.model.PlanEstudioModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlanEstudioMapper {
    PlanEstudioMapper mapper= Mappers.getMapper(PlanEstudioMapper.class);

    PlanEstudioDTO PlanEstudioToPlanEstudiDTO(PlanEstudioModel planEstudioModel);

    PlanEstudioModel PlanEstudioDTOTOPlanEstudio(PlanEstudioDTO planEstudioDTO);
}
