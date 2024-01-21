package com.example.MsMatricula.repository;

import com.example.MsMatricula.model.PeriodoAcademicoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeriodoAcademicoRepository extends CrudRepository<PeriodoAcademicoModel, Integer> {
}
