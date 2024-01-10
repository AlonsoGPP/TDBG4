package TDB.MsSeguridad.controller;

import TDB.MsSeguridad.dtos.DocenteRequest;
import TDB.MsSeguridad.dtos.EstudianteRequest;
import TDB.MsSeguridad.services.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/docente")
public class DocenteController {
    @Autowired
    DocenteService docenteService;

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(docenteService.getAll());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erorr inesperado" + e);
        }
    }
    @PostMapping("/")
    public ResponseEntity<?> saveDocente(@RequestBody DocenteRequest docente) {

        try {

            return ResponseEntity.status(HttpStatus.CREATED).body(docenteService.createDocente(docente));

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e);
        }
    }
}
