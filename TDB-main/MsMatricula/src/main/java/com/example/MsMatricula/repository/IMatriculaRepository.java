package com.example.MsMatricula.repository;

import com.example.MsMatricula.model.MatriculaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMatriculaRepository extends CrudRepository<MatriculaModel, Integer> {
}
