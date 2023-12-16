package TDB.MsControlAcademico.interfaces;

import TDB.MsControlAcademico.dtos.PlanEstudioDTO;

import java.util.List;

public interface PlanEstudioServiceInterface {
    PlanEstudioDTO crearPlanEstudio(PlanEstudioDTO planEstudioDTO);

    PlanEstudioDTO obtenerPlanEstudioPorId(int id);

    List<PlanEstudioDTO> obtenerPlanesEstudio();

    void eliminarPlanEstudio(int id);

    PlanEstudioDTO updatePlanEstudio( PlanEstudioDTO planEstudioDTO);
}
