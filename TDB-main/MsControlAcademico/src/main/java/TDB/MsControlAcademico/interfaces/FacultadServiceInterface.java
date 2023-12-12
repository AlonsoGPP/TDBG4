package TDB.MsControlAcademico.interfaces;
import TDB.MsControlAcademico.dtos.FacultadDTO;
import TDB.MsControlAcademico.model.FacultadModel;

import java.util.List;

public interface FacultadServiceInterface {
    FacultadModel guardarFacultad(FacultadDTO facultadDTO);
    FacultadDTO obtenerFacultadPorId(int id);
    List<FacultadDTO>  obtenerTodasLasFacultades();
    void eliminarFacultad(int id);
    FacultadDTO updateFacultad(int id, FacultadDTO facultadDTO);
}
