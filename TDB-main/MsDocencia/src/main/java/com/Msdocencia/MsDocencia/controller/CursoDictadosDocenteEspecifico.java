package com.Msdocencia.MsDocencia.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Msdocencia.MsDocencia.dtos.DocenteDictaCursoResponse;
import com.Msdocencia.MsDocencia.services.DocenteDistaCursoService;

public class CursoDictadosDocenteEspecifico {
 @GetMapping("/docente/{docenteId}")
public ResponseEntity<?> getCursosByDocente(@PathVariable int docenteId) {
    try {
        List<DocenteDictaCursoResponse> cursos = DocenteDistaCursoService.getByDocenteId(docenteId);
        if (cursos != null && !cursos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(cursos);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron cursos dictados por el docente con ID: " + docenteId);
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
    }
}
   
}
