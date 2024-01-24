package com.Msdocencia.MsDocencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Msdocencia.MsDocencia.components.MessageProvider;
import com.Msdocencia.MsDocencia.dtos.DocenteDictaCursoRequest;
import com.Msdocencia.MsDocencia.dtos.DocenteDictaCursoResponse;
import com.Msdocencia.MsDocencia.services.DocenteDistaCursoService;

public class ActualizarRegistroDocenteCurso {

    @Autowired
     MessageProvider messageProvider;
     @Autowired
     DocenteDistaCursoService docenteDistaCursoService;
 @PutMapping("/{id}")
public ResponseEntity<?> updateDocenteDictaCurso(@PathVariable int id, @RequestBody DocenteDictaCursoRequest request) {
    try {
        DocenteDictaCursoResponse updatedResponse = docenteDistaCursoService.update(request);

        if (updatedResponse != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageProvider.getInvalidRequestErrorMessage());
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
    }
}
   
}
