package com.example.MsMatricula.controllers;

import com.example.MsMatricula.dtos.DetalleMatriculaRequest;
import com.example.MsMatricula.dtos.DetalleMatriculaResponse;
import com.example.MsMatricula.dtos.PeriodoAcademicoRequest;
import com.example.MsMatricula.dtos.PeriodoAcademicoResponse;
import com.example.MsMatricula.services.PeriodoAcademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/periodo-academico")
public class PeriodoAcademicoController {
    @Autowired
    PeriodoAcademicoService periodoAcademicoService;

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(periodoAcademicoService.getAll());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erorr inesperado" + e);
        }
    }
    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody PeriodoAcademicoRequest periodoAcademicoRequest) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(periodoAcademicoService.create(periodoAcademicoRequest));

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e);
        }
    }
    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody PeriodoAcademicoRequest periodoAcademicoRequest){
        try {
            PeriodoAcademicoResponse response= periodoAcademicoService.update(periodoAcademicoRequest);

            if(response!=null){
                return  ResponseEntity.status(HttpStatus.OK).body(response);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error No se encontro la consulta");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");}
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        if(periodoAcademicoService.deleteById(id)){
            return ResponseEntity.status(HttpStatus.OK).body("Borrado correcto");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erorr no se encontro el objeto solicitado");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(periodoAcademicoService.getById(id));
    }
}
