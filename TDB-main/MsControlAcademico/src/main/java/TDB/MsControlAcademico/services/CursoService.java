package TDB.MsControlAcademico.services;


import TDB.MsControlAcademico.dtos.CursoDTO;
import TDB.MsControlAcademico.dtos.CursoMapper;
import TDB.MsControlAcademico.interfaces.CursoServiceInterface;
import TDB.MsControlAcademico.model.CursoModel;
import TDB.MsControlAcademico.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService implements CursoServiceInterface {
    @Autowired
    CursoRepository cursoRepository;

    @Override
    public CursoDTO crearCurso(CursoDTO cursoDTO) {
        CursoModel cursoModel= CursoMapper.mapper.cursoDTOToCurso(cursoDTO);
        return CursoMapper.mapper.cursoToCursoDTO(cursoRepository.save(cursoModel));
    }

    @Override
    public CursoDTO obtenerCursoPorId(String cod) {
      CursoModel cursoModel=cursoRepository.findById(cod).orElse(null);
      return CursoMapper.mapper.cursoToCursoDTO(cursoModel);
    }

    @Override
    public List<CursoDTO> obtenerTodosLosCursos() {
        List<CursoModel> cursos= (List<CursoModel>) cursoRepository.findAll();
        List<CursoDTO> cursosDTOS=cursos.stream().map(
                curso -> CursoMapper.mapper.cursoToCursoDTO(curso)).collect(Collectors.toList());
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
        CursoModel cursoModel = CursoMapper.mapper.cursoDTOToCurso(cursoDTO);
        if(cursoRepository.existsById(cursoDTO.getCod_curso())){
            return CursoMapper.mapper.cursoToCursoDTO(cursoRepository.save(cursoModel));
        }
        return null;
    }

}
