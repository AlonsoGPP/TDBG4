package com.example.MsMatricula.controllers;

import com.example.MsMatricula.dtos.MatriculaRequest;
import com.example.MsMatricula.dtos.MatriculaResponse;
import com.example.MsMatricula.services.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/matricula")
public class MatriculaController {
    @Autowired
    MatriculaService matriculaService;
    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(matriculaService.getAll());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erorr inesperado" + e);
        }
    }
    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody MatriculaRequest maRq) {

        try {

            return ResponseEntity.status(HttpStatus.CREATED).body(matriculaService.create(maRq));

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e);
        }
    }
    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody MatriculaRequest maRq){
        try {
            MatriculaResponse maRs= matriculaService.update(maRq);

            if(maRs!=null){
                return  ResponseEntity.status(HttpStatus.OK).body(maRs);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error No se encontro el usuario");
            }



        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");}
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        if(matriculaService.deleteById(id)){
            return ResponseEntity.status(HttpStatus.OK).body("Borrado correcto");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erorr no se encontro el estudiante");
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(matriculaService.getById(id));
    }
}
