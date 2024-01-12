package com.example.MsMatricula.services;

import com.example.MsMatricula.dtos.MatriculaMapper;
import com.example.MsMatricula.dtos.MatriculaRequest;
import com.example.MsMatricula.dtos.MatriculaResponse;
import com.example.MsMatricula.model.MatriculaModel;
import com.example.MsMatricula.repository.IMatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatriculaService {
    @Autowired
    IMatriculaRepository iMatriculaRepository;

    public List<MatriculaResponse> getAll(){
        List<MatriculaModel> docentes= (List<MatriculaModel>) iMatriculaRepository.findAll();
        List<MatriculaResponse> docenteResponse=docentes.stream().map(docente-> MatriculaMapper.mapper.matriculaModelToResponse(docente)).collect(Collectors.toList());
        return docenteResponse;
    }

    public MatriculaResponse createDocente(MatriculaRequest matriculaRequest){
        MatriculaModel matriculaModel=MatriculaMapper.mapper.matriculaRequestToModel(matriculaRequest);
        matriculaModel.setUpdateAt(getCurrentDate());
        return MatriculaMapper.mapper.docenteModelToDocenteResponse(iMatriculaRepository.save(docenteModel));

    }
    public Date getCurrentDate(){
        return  java.util.Date
                .from(LocalDateTime.now().atZone(java.time.ZoneId.systemDefault())
                        .toInstant());
    }
}
