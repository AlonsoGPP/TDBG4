package com.Msdocencia.MsDocencia.services;

import com.Msdocencia.MsDocencia.dtos.DocenteDictaCursoMapper;
import com.Msdocencia.MsDocencia.dtos.DocenteDictaCursoRequest;
import com.Msdocencia.MsDocencia.dtos.DocenteDictaCursoResponse;
import com.Msdocencia.MsDocencia.model.DocenteDictaCursoModel;
import com.Msdocencia.MsDocencia.repository.IDocenteDictaCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocenteDistaCursoService {
    @Autowired
    IDocenteDictaCursoRepository iDocenteDictaCursoRepository;

    public List<DocenteDictaCursoResponse> getAll(){
        List<DocenteDictaCursoModel> detalles= (List<DocenteDictaCursoModel>) iDocenteDictaCursoRepository.findAll();
        List<DocenteDictaCursoResponse> list = detalles.stream().map(detalle-> DocenteDictaCursoMapper.mapper.modelToResponse(detalle)).collect(Collectors.toList());
        return list;
    }
    public DocenteDictaCursoResponse create(DocenteDictaCursoRequest docenteDictaCursoRequest){
        DocenteDictaCursoModel model=DocenteDictaCursoMapper.mapper.requestToModel(docenteDictaCursoRequest);
        model.setCreatedAt(getCurrentDate());
        return DocenteDictaCursoMapper.mapper.modelToResponse(iDocenteDictaCursoRepository.save(model));

    }

    public DocenteDictaCursoResponse update(DocenteDictaCursoRequest docenteDictaCursoRequest)  {
        DocenteDictaCursoModel ma=DocenteDictaCursoMapper.mapper.requestToModel(docenteDictaCursoRequest);

        DocenteDictaCursoModel origin=iDocenteDictaCursoRepository.findById(ma.getIdDocenteDictaCurso()).orElse(null);
        if(origin!=null){
            if(ma.getIdDocente()!=null){
                origin.setIdDocente(ma.getIdDocente());
            }
            if(ma.getCodCurso()!=null){
                origin.setCodCurso(ma.getCodCurso());
            }
            if(ma.getIdPeriodo()!=null){
                origin.setIdPeriodo(ma.getIdPeriodo());
            }

            origin.setUpdatedAt(getCurrentDate());

            return DocenteDictaCursoMapper.mapper.modelToResponse(iDocenteDictaCursoRepository.save(origin));
        }


        return null;
    }
    public boolean deleteById(int id){
        try {
            DocenteDictaCursoModel mo=iDocenteDictaCursoRepository.findById(id).orElseThrow();//
            iDocenteDictaCursoRepository.delete(mo);
            return true;
        }catch (Exception e ){
            return false;
        }

    }
    public DocenteDictaCursoResponse getById(int id){

        DocenteDictaCursoModel mo=iDocenteDictaCursoRepository.findById(id).orElse(null);//
        return DocenteDictaCursoMapper.mapper.modelToResponse(mo);
    }
    public Date getCurrentDate(){
        return  java.util.Date
                .from(LocalDateTime.now().atZone(java.time.ZoneId.systemDefault())
                        .toInstant());
    }
}
