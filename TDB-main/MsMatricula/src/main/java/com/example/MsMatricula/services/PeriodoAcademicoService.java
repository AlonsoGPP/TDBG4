package com.example.MsMatricula.services;

import com.example.MsMatricula.dtos.*;
import com.example.MsMatricula.model.MatriculaModel;
import com.example.MsMatricula.model.PeriodoAcademicoModel;
import com.example.MsMatricula.repository.IPeriodoAcademicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeriodoAcademicoService {
    @Autowired
    IPeriodoAcademicoRepository iPeriodoAcademicoRepository;
    public List<PeriodoAcademicoResponse> getAll(){
        List<PeriodoAcademicoModel> periodos= (List<PeriodoAcademicoModel>) iPeriodoAcademicoRepository.findAll();
        return periodos.stream().map(periodo-> PeriodoAcademicoMapper.mapper.modelToResponse(periodo)).collect(Collectors.toList());

    }
    public PeriodoAcademicoResponse create(PeriodoAcademicoRequest periodoAcademicoRequest){
        PeriodoAcademicoModel model=PeriodoAcademicoMapper.mapper.requestToModel(periodoAcademicoRequest);
        model.setCreatedAt(getCurrentDate());
        return PeriodoAcademicoMapper.mapper.modelToResponse(iPeriodoAcademicoRepository.save(model));

    }
    public Date getCurrentDate(){
        return  java.util.Date
                .from(LocalDateTime.now().atZone(java.time.ZoneId.systemDefault())
                        .toInstant());
    }
    public PeriodoAcademicoResponse update(PeriodoAcademicoRequest periodoAcademicoRequest)  {
        PeriodoAcademicoModel ma=PeriodoAcademicoMapper.mapper.requestToModel(periodoAcademicoRequest);

        PeriodoAcademicoModel origin=iPeriodoAcademicoRepository.findById(ma.getIdPeriodoAcademico()).orElse(null);
        if(origin!=null){
            if(ma.getNombrePeriodo()!=null){
                origin.setNombrePeriodo(ma.getNombrePeriodo());
            }
            if(ma.getFechaInicio()!=null){
                origin.setFechaInicio(ma.getFechaInicio());
            }
            if(ma.getFechaFin()!=null){
                origin.setFechaFin(ma.getFechaFin());
            }

            origin.setUpdatedAt(getCurrentDate());

            return PeriodoAcademicoMapper.mapper.modelToResponse(iPeriodoAcademicoRepository.save(origin));
        }


        return null;
    }
    public boolean deleteById(int id){
        try {
            PeriodoAcademicoModel maMo=iPeriodoAcademicoRepository.findById(id).orElseThrow();//
            iPeriodoAcademicoRepository.delete(maMo);
            return true;
        }catch (Exception e ){
            return false;
        }

    }
    public PeriodoAcademicoResponse getById(int id){

        PeriodoAcademicoModel mo=iPeriodoAcademicoRepository.findById(id).orElse(null);//
        return PeriodoAcademicoMapper.mapper.modelToResponse(mo);
    }
}
