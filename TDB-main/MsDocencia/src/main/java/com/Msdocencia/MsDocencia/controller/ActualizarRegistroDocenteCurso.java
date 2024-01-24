package com.Msdocencia.MsDocencia.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Msdocencia.MsDocencia.dtos.DocenteDictaCursoRequest;
import com.Msdocencia.MsDocencia.dtos.DocenteDictaCursoResponse;

public class ActualizarRegistroDocenteCurso {
 @PutMapping("/{id}")
public ResponseEntity<?> updateDocenteDictaCurso(@PathVariable int id, @RequestBody DocenteDictaCursoRequest request) {
    try {
        DocenteDictaCursoResponse updatedResponse = DocenteDistaCursoService.update(id, request);

        if (updatedResponse != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el registro de docente que dicta el curso especificado");
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
    }
}
   
}
