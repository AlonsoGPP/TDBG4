package com.Msdocencia.MsDocencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Msdocencia.MsDocencia.components.MessageProvider;
import com.Msdocencia.MsDocencia.services.DocenteDistaCursoService;

public class EliminarRegistroDocenteCurso {

    @Autowired
     MessageProvider messageProvider;
    @Autowired
    DocenteDistaCursoService docenteDistaCursoService;
    @DeleteMapping("/{id}")
public ResponseEntity<?> deleteDocenteDictaCurso(@PathVariable int id) {
    try {
        if (docenteDistaCursoService.deleteById(id)) {
            return ResponseEntity.status(HttpStatus.OK).body(messageProvider.getInvalidRequestErrorMessage());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el registro de docente que dicta el curso especificado");
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al intentar eliminar el registro: " + e.getMessage());
    }
}

}
