package TDB.MsControlAcademico.controller;

import TDB.MsControlAcademico.dtos.CarreraDTO;
import TDB.MsControlAcademico.dtos.PlanEstudioDTO;
import TDB.MsControlAcademico.services.PlanEstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path="api/plan_estudio")
public class PlanEstudioController {
    @Autowired
    PlanEstudioService planEstudioService;

    @PostMapping("")
    public ResponseEntity<?> createOne(@RequestBody PlanEstudioDTO planEstudioDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(planEstudioService.crearPlanEstudio(planEstudioDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }
    }
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(planEstudioService.obtenerPlanesEstudio());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable int id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(planEstudioService.obtenerPlanEstudioPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }

    }

    @PutMapping("")
    public ResponseEntity<?> updateOne( @RequestBody PlanEstudioDTO planEstudioDTO){
        try {
            PlanEstudioDTO response=planEstudioService.updatePlanEstudio(planEstudioDTO);
            return  ResponseEntity.status(HttpStatus.OK).body(response);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        try {
            planEstudioService.eliminarPlanEstudio(id);
            return  ResponseEntity.status(HttpStatus.OK).body("{\"Msg\":\"Eliminado con exito.\"}");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }
    }



}
