package TDB.MsControlAcademico.controller;

import TDB.MsControlAcademico.components.MessageProvider;
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
    @Autowired
    MessageProvider messageProvider;

    @PostMapping("")
    public ResponseEntity<?> createOne(@RequestBody CarreraDTO carreraDTO){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(carreraService.crearCarrera(carreraDTO));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageProvider.getGenericErrorMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(carreraService.obtenerTodasLasCarreras());
        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageProvider.getGenericErrorMessage());

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable int id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(carreraService.obtenerCarreraPorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageProvider.getGenericErrorMessage());
        }

    }

    @PutMapping("")
    public ResponseEntity<?> updateOne( @RequestBody CarreraDTO carreraDTO){
        try {
            CarreraDTO response=carreraService.updateCarrera(carreraDTO);
            return  ResponseEntity.status(HttpStatus.OK).body(response);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageProvider.getGenericErrorMessage());
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        try {
            carreraService.eliminarCarrera(id);
            return  ResponseEntity.status(HttpStatus.OK).body(messageProvider.getSuccesfullyDeletedMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageProvider.getGenericErrorMessage());
        }
    }
}
