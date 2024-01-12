package TDB.MsControlAcademico.services;

import TDB.MsControlAcademico.dtos.PlanEstudioDTO;
import TDB.MsControlAcademico.dtos.PlanEstudioMapper;
import TDB.MsControlAcademico.interfaces.PlanEstudioServiceInterface;
import TDB.MsControlAcademico.model.PlanEstudioModel;
import TDB.MsControlAcademico.repository.PlanEstudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PlanEstudioService implements PlanEstudioServiceInterface {
    @Autowired
    PlanEstudioRepository planEstudioRepository;
    @Override
    public PlanEstudioDTO crearPlanEstudio(PlanEstudioDTO planEstudioDTO) {
        PlanEstudioModel planEstudioModel= PlanEstudioMapper.mapper.PlanEstudioDTOTOPlanEstudio(planEstudioDTO);
        return PlanEstudioMapper.mapper.PlanEstudioToPlanEstudiDTO(planEstudioRepository.save(planEstudioModel));
    }

    @Override
    public PlanEstudioDTO obtenerPlanEstudioPorId(int id) {

           PlanEstudioModel planEstudioModel=planEstudioRepository.findById(id).orElse(null);
           return PlanEstudioMapper.mapper.PlanEstudioToPlanEstudiDTO(planEstudioModel);

    }

    @Override
    public List<PlanEstudioDTO> obtenerPlanesEstudio() {
        List<PlanEstudioModel> planesestudio= (List<PlanEstudioModel>) planEstudioRepository.findAll();
        List<PlanEstudioDTO>  planesEstudioDTOS=planesestudio.stream().map(
                planEstudio-> PlanEstudioMapper.mapper.PlanEstudioToPlanEstudiDTO(planEstudio)).collect(Collectors.toList());
        return planesEstudioDTOS;
    }

    @Override
    public void eliminarPlanEstudio(int id) {
        PlanEstudioModel mo= planEstudioRepository.findById(id).orElse(null);
        if(mo!=null){
            planEstudioRepository.delete(mo);
        }
    }

    @Override
    public PlanEstudioDTO updatePlanEstudio(PlanEstudioDTO planEstudioDTO) {
        PlanEstudioModel planEstudioModel = PlanEstudioMapper.mapper.mapper.PlanEstudioDTOTOPlanEstudio(planEstudioDTO);
        if(planEstudioRepository.existsById(planEstudioDTO.getIdPlanEstudio())){
            return PlanEstudioMapper.mapper.PlanEstudioToPlanEstudiDTO(planEstudioRepository.save(planEstudioModel));
        }
        return null;
    }
}
