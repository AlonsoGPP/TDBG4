package TDB.MsControlAcademico.controller;
import TDB.MsControlAcademico.components.MessageProvider;
import TDB.MsControlAcademico.dtos.FacultadDTO;
import TDB.MsControlAcademico.model.FacultadModel;
import TDB.MsControlAcademico.services.FacultadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path="api/facultades")
public class FacultadController {
    @Autowired
    FacultadService facultadService;

    @Autowired
    MessageProvider messageProvider;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(facultadService.obtenerTodasLasFacultades());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageProvider.getGenericErrorMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable int id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(facultadService.obtenerFacultadPorId(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageProvider.getGenericErrorMessage());
        }
    }

    @PostMapping("")
    public ResponseEntity<?> createOne(@RequestBody FacultadDTO facultadDTO){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(facultadService.guardarFacultad(facultadDTO));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageProvider.getGenericErrorMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOne(@PathVariable int id, @RequestBody FacultadDTO facultadDTO){
        try{
        FacultadDTO response=facultadService.updateFacultad(id, facultadDTO);
        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }catch(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageProvider.getGenericErrorMessage());
    }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        try {
            facultadService.eliminarFacultad(id);
            return  ResponseEntity.status(HttpStatus.OK).body(messageProvider.getSuccesfullyDeletedMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageProvider.getGenericErrorMessage());
        }
    }



}
