package com.example.MsMatricula.controllers;

import com.example.MsMatricula.dtos.DetalleMatriculaRequest;
import com.example.MsMatricula.dtos.DetalleMatriculaResponse;
import com.example.MsMatricula.services.DetalleMatriculaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/detalle-matricula")
public class DetalleMatriculaController {
    @Autowired
    DetalleMatriculaService detalleMatriculaService;

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(detalleMatriculaService.getAll());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erorr inesperado" + e);
        }
    }
    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody DetalleMatriculaRequest detalleRq) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(detalleMatriculaService.create(detalleRq));

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e);
        }
    }
    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody DetalleMatriculaRequest detalleRq){
        try {
            DetalleMatriculaResponse detalleRs= detalleMatriculaService.actualizar(detalleRq);

            if(detalleRs!=null){
                return  ResponseEntity.status(HttpStatus.OK).body(detalleRs);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error No se encontro el detalle de matricula");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");}
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        if(detalleMatriculaService.deleteById(id)){
            return ResponseEntity.status(HttpStatus.OK).body("Borrado correcto");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erorr no se encontro el objeto solicitado");
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(detalleMatriculaService.getById(id));
    }
}
