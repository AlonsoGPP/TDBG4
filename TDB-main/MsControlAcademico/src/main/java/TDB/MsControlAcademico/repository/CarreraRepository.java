package TDB.MsControlAcademico.repository;

import TDB.MsControlAcademico.model.CarreraModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends CrudRepository<CarreraModel, Integer> {
}
