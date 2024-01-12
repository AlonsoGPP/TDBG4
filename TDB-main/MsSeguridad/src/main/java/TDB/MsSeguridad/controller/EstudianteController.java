package TDB.MsSeguridad.controller;

import TDB.MsSeguridad.dtos.EstudianteRequest;
import TDB.MsSeguridad.dtos.EstudianteResponse;
import TDB.MsSeguridad.dtos.UserRequest;
import TDB.MsSeguridad.dtos.UserResponse;
import TDB.MsSeguridad.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estudiante")
public class EstudianteController {
    @Autowired
    EstudianteService estudianteService;

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estudianteService.getAll());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erorr inesperado" + e);
        }
    }
    @PostMapping("/")
    public ResponseEntity<?> saveEstudent(@RequestBody EstudianteRequest est) {

        try {

            return ResponseEntity.status(HttpStatus.CREATED).body(estudianteService.createEstudiante(est));

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e);
        }
    }
    @PutMapping("/")
    public ResponseEntity<?> updateEstudiantes(@RequestBody EstudianteRequest est){
        try {
           EstudianteResponse estR= estudianteService.actualizarEstudiante(est);

            if(estR!=null){
                return  ResponseEntity.status(HttpStatus.OK).body(estR);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error No se encontro el usuario");
            }



        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");}
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String cod){
        if(estudianteService.deleteById(cod)){
            return ResponseEntity.status(HttpStatus.OK).body("Borrado correcto");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erorr no se encontro el estudiante");
        }

    }
    @GetMapping("/{cod}")
    public ResponseEntity<?> getById(@PathVariable String cod){
        return ResponseEntity.status(HttpStatus.OK).body(estudianteService.getById(cod));
    }
}
