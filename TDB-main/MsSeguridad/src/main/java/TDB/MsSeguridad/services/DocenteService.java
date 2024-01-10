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
        List<DocenteResponse> docenteResponse=docentes.stream().map(docente-> DocenteMapper.mapper1.docenteModelToDocenteResponse(docente)).collect(Collectors.toList());
        return docenteResponse;
    }
    public DocenteResponse createDocente(DocenteRequest docenteRequest){
        DocenteModel docenteModel=DocenteMapper.mapper1.docenteRequestToDocenteModel(docenteRequest);
        docenteModel.setCreatedAt(getCurrentDate());
        return DocenteMapper.mapper1.docenteModelToDocenteResponse(iDocenteRepository.save(docenteModel));

    }
    public Date getCurrentDate(){
        return  java.util.Date
                .from(LocalDateTime.now().atZone(java.time.ZoneId.systemDefault())
                        .toInstant());
    }
}
