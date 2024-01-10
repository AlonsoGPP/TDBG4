package TDB.MsSeguridad.repository;

import TDB.MsSeguridad.model.EstudianteModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstudianteRepository extends CrudRepository<EstudianteModel, String> {

}
