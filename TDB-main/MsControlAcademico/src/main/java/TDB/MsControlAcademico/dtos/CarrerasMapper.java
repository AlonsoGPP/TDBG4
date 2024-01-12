package TDB.MsControlAcademico.dtos;

import TDB.MsControlAcademico.model.CarreraModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarrerasMapper {
    CarrerasMapper mapper1 = Mappers.getMapper(CarrerasMapper.class);

    CarreraDTO carreraToCarreraDTO(CarreraModel carreraModel);

    CarreraModel carreraDTOToCarreraModel(CarreraDTO carreraDTO);
}
