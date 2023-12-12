package TDB.MsControlAcademico.repository;

import TDB.MsControlAcademico.model.FacultadModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultadRepository extends CrudRepository<FacultadModel, Integer> {

}