package TDB.MsControlAcademico.repository;

import TDB.MsControlAcademico.model.CursoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends CrudRepository<CursoModel, String> {
}
