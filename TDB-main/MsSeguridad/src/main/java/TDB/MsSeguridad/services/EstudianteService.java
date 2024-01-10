package TDB.MsSeguridad.services;

import TDB.MsSeguridad.dtos.*;
import TDB.MsSeguridad.model.EstudianteModel;
import TDB.MsSeguridad.model.UsuarioModel;
import TDB.MsSeguridad.repository.IEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteService {
    @Autowired
    IEstudianteRepository estudianteRepository;

    public List<EstudianteResponse> getAll(){
        List<EstudianteModel> estudiantes= (List<EstudianteModel>) estudianteRepository.findAll();
        List<EstudianteResponse> estudianteResponse=estudiantes.stream().map(estudante-> EstudianteMapper.mapper1.estudianteToEstudianteResponse(estudante)).collect(Collectors.toList());
        return estudianteResponse;
    }

    public EstudianteResponse createEstudiante(EstudianteRequest estudianteRequest){
        EstudianteModel estudianteModel=EstudianteMapper.mapper1.estudianteRequestToEstudianteModel(estudianteRequest);
        estudianteModel.setCreatedAt(getCurrentDate());
        return EstudianteMapper.mapper1.estudianteToEstudianteResponse(estudianteRepository.save(estudianteModel));

    }
    public EstudianteResponse getById(String id){

        EstudianteModel mo=estudianteRepository.findById(id).orElse(null);//
        return EstudianteMapper.mapper1.estudianteToEstudianteResponse(mo);
    }
    public boolean deleteById(String id){
        try {
            EstudianteModel mo=estudianteRepository.findById(id).orElseThrow();//
            estudianteRepository.delete(mo);
            return true;
        }catch (Exception e ){
            return false;
        }

    }
    public EstudianteResponse actualizarEstudiante(EstudianteRequest est)  {
        EstudianteModel estudianteMoUp=EstudianteMapper.mapper1.estudianteRequestToEstudianteModel(est);

        EstudianteModel tmpObj=estudianteRepository.findById(estudianteMoUp.getCodEstudiante()).orElse(null);
        if(tmpObj!=null){
            if(estudianteMoUp.getNombre()!=null){
                tmpObj.setNombre(estudianteMoUp.getNombre());
            }
            if(estudianteMoUp.getApellido()!=null){
                tmpObj.setApellido(estudianteMoUp.getApellido());
            }
            if(estudianteMoUp.getEmail()!=null){
                tmpObj.setEmail(estudianteMoUp.getEmail());
            }
            if(estudianteMoUp.getFechaNacimiento()!=null){
                tmpObj.setEmail(estudianteMoUp.getEmail());
            }
            if(estudianteMoUp.getUser()!=null){
                tmpObj.setUser(estudianteMoUp.getUser());
            }
          tmpObj.setUpdatedAt(getCurrentDate());

            return EstudianteMapper.mapper1.estudianteToEstudianteResponse(estudianteRepository.save(tmpObj));
        }


        return null;

    }
    public Date getCurrentDate(){
        return  java.util.Date
                .from(LocalDateTime.now().atZone(java.time.ZoneId.systemDefault())
                        .toInstant());
    }
}
