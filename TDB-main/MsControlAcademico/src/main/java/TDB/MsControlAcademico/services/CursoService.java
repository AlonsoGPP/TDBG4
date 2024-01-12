package TDB.MsControlAcademico.services;

import java.time.LocalDateTime;
import TDB.MsControlAcademico.dtos.CursoDTO;
import TDB.MsControlAcademico.dtos.CursosMapper;
import TDB.MsControlAcademico.interfaces.CursoServiceInterface;
import TDB.MsControlAcademico.model.CursoModel;
import TDB.MsControlAcademico.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService implements CursoServiceInterface {
    @Autowired
    CursoRepository cursoRepository;

    @Override
    public CursoDTO crearCurso(CursoDTO cursoDTO) {
        CursoModel cursoModel= CursosMapper.mapper1.cursoDTOToCurso(cursoDTO);
        cursoModel.setCREATED_AT(getCurrentDate());
        return CursosMapper.mapper1.cursoToCursoDTO(cursoRepository.save(cursoModel));
    }

    @Override
    public CursoDTO obtenerCursoPorId(String cod) {
      CursoModel cursoModel=cursoRepository.findById(cod).orElse(null);
      return CursosMapper.mapper1.cursoToCursoDTO(cursoModel);
    }

    @Override
    public List<CursoDTO> obtenerTodosLosCursos() {
        List<CursoModel> cursos= (List<CursoModel>) cursoRepository.findAll();
        List<CursoDTO> cursosDTOS=cursos.stream().map(
                curso -> CursosMapper.mapper1.cursoToCursoDTO(curso)).collect(Collectors.toList());
        return cursosDTOS;
    }

    @Override
    public void eliminarCurso(String codCurso) {
        CursoModel mo= cursoRepository.findById(codCurso).orElse(null);
        if(mo!=null){
            cursoRepository.delete(mo);
        }
    }

    @Override
    public CursoDTO updateCurso(CursoDTO cursoDTO) {
        CursoModel cursoModel = CursosMapper.mapper1.cursoDTOToCurso(cursoDTO);
        cursoModel.setUPDATED_AT(getCurrentDate());
        if(cursoRepository.existsById(cursoDTO.getCodCurso())){
            return CursosMapper.mapper1.cursoToCursoDTO(cursoRepository.save(cursoModel));
        }
        return null;
    }
    public Date getCurrentDate(){
       return  java.util.Date
                .from(LocalDateTime.now().atZone(java.time.ZoneId.systemDefault())
                        .toInstant());
    }

}
