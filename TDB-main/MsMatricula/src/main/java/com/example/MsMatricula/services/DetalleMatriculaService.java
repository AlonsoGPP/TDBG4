package com.example.MsMatricula.services;

import com.example.MsMatricula.dtos.DetalleMatriculaMapper;
import com.example.MsMatricula.dtos.DetalleMatriculaRequest;
import com.example.MsMatricula.dtos.DetalleMatriculaResponse;

import com.example.MsMatricula.model.DetalleMatriculaModel;
import com.example.MsMatricula.repository.IDetalleMatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;




@Service
public class DetalleMatriculaService {
    @Autowired
    IDetalleMatriculaRepository iDetalleMatriculaRepository;
    public List<DetalleMatriculaResponse> getAll(){
        List<DetalleMatriculaModel> detalles= (List<DetalleMatriculaModel>) iDetalleMatriculaRepository.findAll();
        List<DetalleMatriculaResponse> docenteResponse=detalles.stream().map(detalleM-> DetalleMatriculaMapper.mapper.detalleMatriculaModelToResponse(detalleM)).collect(Collectors.toList());
        return docenteResponse;
    }
    public DetalleMatriculaResponse create(DetalleMatriculaRequest docenteRequest){
        DetalleMatriculaModel detalleModel=DetalleMatriculaMapper.mapper.detalleMatriculaRequestToModel(docenteRequest);
        detalleModel.setCreatedAt(getCurrentDate());
        return DetalleMatriculaMapper.mapper.detalleMatriculaModelToResponse(iDetalleMatriculaRepository.save(detalleModel));

    }
    public DetalleMatriculaResponse getById(int id){

        DetalleMatriculaModel mo=iDetalleMatriculaRepository.findById(id).orElse(null);//
        return DetalleMatriculaMapper.mapper.detalleMatriculaModelToResponse(mo);
    }
    public boolean deleteById(int id){
        try {
            DetalleMatriculaModel mo=iDetalleMatriculaRepository.findById(id).orElseThrow();//
            iDetalleMatriculaRepository.delete(mo);
            return true;
        }catch (Exception e ){
            return false;
        }

    }
    public Date getCurrentDate(){
        return  java.util.Date
                .from(LocalDateTime.now().atZone(java.time.ZoneId.systemDefault())
                        .toInstant());
    }
    public DetalleMatriculaResponse actualizar(DetalleMatriculaRequest detalleRq)  {
        DetalleMatriculaModel detalleUpt=DetalleMatriculaMapper.mapper.detalleMatriculaRequestToModel(detalleRq);

        DetalleMatriculaModel origin=iDetalleMatriculaRepository.findById(detalleUpt.getIdDetalleMatricula()).orElse(null);
        if(origin!=null){
            if(detalleUpt.getIdMatricula()!=null){
                origin.setIdMatricula(detalleUpt.getIdMatricula());
            }
            if(detalleUpt.getCodCurso()!=null){
                origin.setCodCurso(detalleUpt.getCodCurso());
            }

            origin.setUpdatedAt(getCurrentDate());

            return DetalleMatriculaMapper.mapper.detalleMatriculaModelToResponse(iDetalleMatriculaRepository.save(origin));
        }


        return null;
    }
}
