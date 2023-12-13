package TDB.MsControlAcademico.controller;

import TDB.MsControlAcademico.dtos.CarreraDTO;
import TDB.MsControlAcademico.services.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path="api/carreras")
public class CarreraController {
    @Autowired
    CarreraService carreraService;

    @PostMapping("")
    public ResponseEntity<?> createOne(@RequestBody CarreraDTO carreraDTO){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(carreraService.crearCarrera(carreraDTO));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }
    }

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(carreraService.obtenerTodasLasCarreras());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable int id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(carreraService.obtenerCarreraPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }

    }

    @PutMapping("")
    public ResponseEntity<?> updateOne( @RequestBody CarreraDTO carreraDTO){
        try {
            CarreraDTO response=carreraService.updateCarrera(carreraDTO);
            return  ResponseEntity.status(HttpStatus.OK).body(response);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        try {
            carreraService.eliminarCarrera(id);
            return  ResponseEntity.status(HttpStatus.OK).body("{\"Msg\":\"Eliminado con exito.\"}");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }
    }
}
