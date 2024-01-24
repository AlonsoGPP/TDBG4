package com.Msdocencia.MsDocencia.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Msdocencia.MsDocencia.dtos.DocenteDictaCursoResponse;

public class RegistroDocentesCursoEspecifico {
    @GetMapping("/curso/{cursoId}")
public ResponseEntity<?> getDocentesByCurso(@PathVariable int cursoId) {
    try {
        List<DocenteDictaCursoResponse> docentes = DocenteDistaCursoService.getByCursoId(cursoId);
        if (docentes != null && !docentes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(docentes);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron docentes para el curso con ID: " + cursoId);
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
    }
}

}
