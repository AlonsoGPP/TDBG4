package com.Msdocencia.MsDocencia.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Msdocencia.MsDocencia.dtos.DocenteDictaCursoResponse;
import com.Msdocencia.MsDocencia.services.DocenteDistaCursoService;

public class RegistroDocenteCursoEspecifico {
@GetMapping("/docente/{docenteId}/curso/{cursoId}")
public ResponseEntity<?> getDocenteDictaCurso(@PathVariable int docenteId, @PathVariable int cursoId) {
    try {
        DocenteDictaCursoResponse docenteDictaCurso = DocenteDistaCursoService.getByDocenteAndCurso(docenteId, cursoId);
        if (docenteDictaCurso != null) {
            return ResponseEntity.status(HttpStatus.OK).body(docenteDictaCurso);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el registro de docente que dicta el curso especificado");
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
    }
}
    
}
