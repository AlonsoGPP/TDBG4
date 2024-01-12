package TDB.MsControlAcademico.services;

import TDB.MsControlAcademico.dtos.FacultadDTO;
import TDB.MsControlAcademico.dtos.FacultadMapper;
import TDB.MsControlAcademico.interfaces.FacultadServiceInterface;
import TDB.MsControlAcademico.model.FacultadModel;
import TDB.MsControlAcademico.repository.FacultadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultadService implements FacultadServiceInterface {
    @Autowired
    FacultadRepository facultadRepository;
    @Override
    public FacultadModel guardarFacultad(FacultadDTO facultadDTO) {
        FacultadModel facultadModel=FacultadMapper.mapper1.facultadDTOtoFacultad(facultadDTO);
        return facultadRepository.save(facultadModel);
    }


    @Override
    public FacultadDTO obtenerFacultadPorId(int id) {
        FacultadModel facultad= facultadRepository.findById(id).orElse(null);
        return FacultadMapper.mapper1.facultadToFacultadDTO(facultad);
    }

    @Override
    public List<FacultadDTO>  obtenerTodasLasFacultades() {
        List<FacultadModel> facultades = (List<FacultadModel>) facultadRepository.findAll();
        List<FacultadDTO> facultadesDTOS=facultades.stream().map(
                facultad -> FacultadMapper.mapper1.facultadToFacultadDTO(facultad)).collect(Collectors.toList());

        return facultadesDTOS;
    }

    @Override
    public void eliminarFacultad(int id) {
      FacultadModel mo=  facultadRepository.findById(id).orElse(null);
      if(mo!=null){
          facultadRepository.delete(mo);
      }
    }
    @Override
    public FacultadDTO updateFacultad(int id, FacultadDTO facultadDTO){
        FacultadModel facultadModel=FacultadMapper.mapper1.facultadDTOtoFacultad(facultadDTO);
        if(facultadRepository.existsById(id)){
            FacultadModel response=facultadRepository.save(facultadModel);
            return FacultadMapper.mapper1.facultadToFacultadDTO(response);
        }else{
            return null;
        }
    }

}
