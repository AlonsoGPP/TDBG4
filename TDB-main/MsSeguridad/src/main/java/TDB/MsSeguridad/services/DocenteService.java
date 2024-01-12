package TDB.MsSeguridad.services;

import TDB.MsSeguridad.dtos.*;
import TDB.MsSeguridad.model.DocenteModel;
import TDB.MsSeguridad.repository.IDocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocenteService {
    @Autowired
    IDocenteRepository iDocenteRepository;

    public List<DocenteResponse> getAll(){
        List<DocenteModel> docentes= (List<DocenteModel>) iDocenteRepository.findAll();
        List<DocenteResponse> docenteResponse=docentes.stream().map(docente-> DocenteMapper.mapper.docenteModelToDocenteResponse(docente)).collect(Collectors.toList());
        return docenteResponse;
    }
    public DocenteResponse createDocente(DocenteRequest docenteRequest){
        DocenteModel docenteModel=DocenteMapper.mapper.docenteRequestToDocenteModel(docenteRequest);
        docenteModel.setCreatedAt(getCurrentDate());
        return DocenteMapper.mapper.docenteModelToDocenteResponse(iDocenteRepository.save(docenteModel));

    }
    public DocenteResponse getById(String cod){

        DocenteModel mo=iDocenteRepository.findById(cod).orElse(null);//
        return DocenteMapper.mapper.docenteModelToDocenteResponse(mo);
    }

    public boolean deleteById(String id){
        try {
            DocenteModel mo=iDocenteRepository.findById(id).orElseThrow();//
            iDocenteRepository.delete(mo);
            return true;
        }catch (Exception e ){
            return false;
        }

    }

    public DocenteResponse actualizarDocente(DocenteRequest docenteR)  {
        DocenteModel doceModelUpd=DocenteMapper.mapper.docenteRequestToDocenteModel(docenteR);

        DocenteModel tmpObj=iDocenteRepository.findById(doceModelUpd.getCodDocente()).orElse(null);
        if(tmpObj!=null){
            if(doceModelUpd.getNombre()!=null){
                tmpObj.setNombre(doceModelUpd.getNombre());
            }
            if(doceModelUpd.getApellido()!=null){
                tmpObj.setApellido(doceModelUpd.getApellido());
            }
            if(doceModelUpd.getDni()!=null){
                tmpObj.setDni(doceModelUpd.getDni());
            }
            if(doceModelUpd.getFormacion()!=null){
                tmpObj.setFormacion(doceModelUpd.getFormacion());
            }
            if(doceModelUpd.getTelefono()!=null){
                tmpObj.setTelefono(doceModelUpd.getTelefono());
            }
            if(!doceModelUpd.isActivo()){
                tmpObj.setActivo(doceModelUpd.isActivo());
            }
            if(doceModelUpd.getTelefono()!=null){
                tmpObj.setTelefono(doceModelUpd.getTelefono());
            }
            if(doceModelUpd.getEmail()!=null){
                tmpObj.setEmail(doceModelUpd.getEmail());
            }
            if(doceModelUpd.getUser()!=null){
                tmpObj.setUser(doceModelUpd.getUser());
            }
            tmpObj.setUpdatedAt(getCurrentDate());

            return DocenteMapper.mapper.docenteModelToDocenteResponse(iDocenteRepository.save(tmpObj));
        }


        return null;
    }

    public Date getCurrentDate(){
        return  java.util.Date
                .from(LocalDateTime.now().atZone(java.time.ZoneId.systemDefault())
                        .toInstant());
    }
}
