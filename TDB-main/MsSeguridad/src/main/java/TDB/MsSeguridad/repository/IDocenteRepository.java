package TDB.MsSeguridad.repository;

import TDB.MsSeguridad.model.DocenteModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocenteRepository extends CrudRepository<DocenteModel, String> {

}
