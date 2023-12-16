package TDB.MsControlAcademico.repository;

import TDB.MsControlAcademico.model.PlanEstudioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanEstudioRepository extends CrudRepository<PlanEstudioModel,Integer> {
}
