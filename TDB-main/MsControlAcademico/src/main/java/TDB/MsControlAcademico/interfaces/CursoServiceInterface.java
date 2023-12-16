package TDB.MsControlAcademico.interfaces;

import TDB.MsControlAcademico.dtos.CursoDTO;

import java.util.List;

public interface CursoServiceInterface {
    CursoDTO crearCurso(CursoDTO cursoDTO);
    CursoDTO obtenerCursoPorId(String cod);
    List<CursoDTO> obtenerTodosLosCursos();
    void eliminarCurso(String codCurso);
    CursoDTO updateCurso(CursoDTO cursoDTO);

}
