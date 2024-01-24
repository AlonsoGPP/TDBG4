package com.Msdocencia.MsDocencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Msdocencia.MsDocencia.dtos.DocenteDictaCursoRequest;
import com.Msdocencia.MsDocencia.dtos.DocenteDictaCursoResponse;
import com.Msdocencia.MsDocencia.services.DocenteDistaCursoService;


@RestController
@RequestMapping("api/docenteDictaCurso")
public class DocenteDictaCursoController {

    @Autowired
    DocenteDistaCursoService docenteDistaCursoService;

    @GetMapping("/")
    public ResponseEntity<?> getAllDocenteDictaCurso() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(docenteDistaCursoService.getAll());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error inesperado: " + e.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createDocenteDictaCurso(@RequestBody DocenteDictaCursoRequest request) {
        try {
            DocenteDictaCursoResponse createdResponse = docenteDistaCursoService.create(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/")
    public ResponseEntity<?> updateDocenteDictaCurso(@RequestBody DocenteDictaCursoRequest request) {
        try {
            DocenteDictaCursoResponse updatedResponse = docenteDistaCursoService.update(request);

            if (updatedResponse != null) {
                return ResponseEntity.status(HttpStatus.OK).body(updatedResponse);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Error: No se encontró el detalle de matrícula");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDocenteDictaCurso(@PathVariable int id) {
        try {
            if (docenteDistaCursoService.deleteById(id)) {
                return ResponseEntity.status(HttpStatus.OK).body("Borrado correcto");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: No se encontró el objeto solicitado");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(docenteDistaCursoService.getById(id));
    }

}
