package TDB.MsControlAcademico.controller;

import TDB.MsControlAcademico.dtos.CursoDTO;
import TDB.MsControlAcademico.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import TDB.MsControlAcademico.components.MessageProvider;
@RestController
@CrossOrigin(origins="*")
@RequestMapping(path="api/cursos")
public class CursoController {
    @Autowired
    CursoService cursoService;

    @Autowired
    MessageProvider messageProvider;

    @PostMapping("")
    public ResponseEntity<?> createOne(@RequestBody CursoDTO cursoDTO){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(cursoService.crearCurso(cursoDTO));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageProvider.getGenericErrorMessage());
        }
    }
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(cursoService.obtenerTodosLosCursos());
        }catch (Exception e){
            System.out.println("err: "+e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageProvider.getGenericErrorMessage());
        }
    }

    @GetMapping("/{cod}")
    public ResponseEntity<?> getOne(@PathVariable String cod){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(cursoService.obtenerCursoPorId(cod));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageProvider.getGenericErrorMessage());
        }

    }
    @PutMapping("")
    public ResponseEntity<?> updateOne( @RequestBody CursoDTO cursoDTO){
        try {
            CursoDTO response=cursoService.updateCurso(cursoDTO);
            return  ResponseEntity.status(HttpStatus.OK).body(response);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageProvider.getGenericErrorMessage());
        }

    }
    @DeleteMapping("/{cod}")
    public ResponseEntity<?> delete(@PathVariable String cod){
        try {
            cursoService.eliminarCurso(cod);
            return  ResponseEntity.status(HttpStatus.OK).body(messageProvider.getSuccesfullyDeletedMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageProvider.getGenericErrorMessage());
        }
    }


}
