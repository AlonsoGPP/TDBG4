package TDB.MsControlAcademico.dtos;

import TDB.MsControlAcademico.model.PlanEstudioModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlanEstudioMapper {
    PlanEstudioMapper mapper = Mappers.getMapper(PlanEstudioMapper.class);

    @Mapping(source = "anho", target = "año")
    PlanEstudioDTO PlanEstudioToPlanEstudiDTO(PlanEstudioModel planEstudioModel);
    @Mapping(source = "año", target = "anho")
    PlanEstudioModel PlanEstudioDTOTOPlanEstudio(PlanEstudioDTO planEstudioDTO);
}
