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
        List<MatriculaResponse> docenteResponse=docentes.stream().map(docente-> MatriculaMapper.mapper1.matriculaModelToResponse(docente)).collect(Collectors.toList());
        return docenteResponse;
    }

    public MatriculaResponse create(MatriculaRequest matriculaRequest){
        MatriculaModel matriculaModel=MatriculaMapper.mapper1.matriculaRequestToModel(matriculaRequest);
        matriculaModel.setUpdatedAt(getCurrentDate());
        return MatriculaMapper.mapper1.matriculaModelToResponse(iMatriculaRepository.save(matriculaModel));

    }
    public MatriculaResponse update(MatriculaRequest maRq)  {
        MatriculaModel ma=MatriculaMapper.mapper1.matriculaRequestToModel(maRq);

        MatriculaModel tmpObj=iMatriculaRepository.findById(ma.getIdMatricula()).orElse(null);
        if(tmpObj!=null){
            if(ma.getCodEstudiante()!=null){
                tmpObj.setCodEstudiante(ma.getCodEstudiante());
            }
            if(ma.getIdPeriodo()!=null){
                tmpObj.setIdPeriodo(ma.getIdPeriodo());
            }
            if(ma.getFechaMatricula()!=null){
                tmpObj.setFechaMatricula(ma.getFechaMatricula());
            }

            tmpObj.setUpdatedAt(getCurrentDate());

            return MatriculaMapper.mapper1.matriculaModelToResponse(iMatriculaRepository.save(tmpObj));
        }


        return null;
    }

    public boolean deleteById(int id){
        try {
            MatriculaModel maMo=iMatriculaRepository.findById(id).orElseThrow();//
            iMatriculaRepository.delete(maMo);
            return true;
        }catch (Exception e ){
            return false;
        }

    }
    public MatriculaResponse getById(int id){

        MatriculaModel maMo=iMatriculaRepository.findById(id).orElse(null);//
        return MatriculaMapper.mapper1.matriculaModelToResponse(maMo);
    }

    public Date getCurrentDate(){
        return  java.util.Date
                .from(LocalDateTime.now().atZone(java.time.ZoneId.systemDefault())
                        .toInstant());
    }
}
