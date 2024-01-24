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

import com.Msdocencia.MsDocencia.dtos.GrupoRequest;
import com.Msdocencia.MsDocencia.dtos.GrupoResponse;
import com.Msdocencia.MsDocencia.services.GrupoService;
@RestController
@RequestMapping("api/grupo")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @GetMapping("/")
    public ResponseEntity<?> getAllGrupos() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(grupoService.getAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error inesperado: " + e.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createGrupo(@RequestBody GrupoRequest request) {
        try {
            GrupoResponse createdResponse = grupoService.create(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGrupo(@PathVariable int id, @RequestBody GrupoRequest request) {
        try {
            GrupoResponse updatedResponse = grupoService.update(id, request);

            if (updatedResponse != null) {
                return ResponseEntity.status(HttpStatus.OK).body(updatedResponse);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: No se encontró el grupo");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGrupo(@PathVariable int id) {
        try {
            grupoService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Borrado correcto");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: No se encontró el grupo");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        try {
            GrupoResponse grupoResponse = grupoService.getById(id);
            return ResponseEntity.status(HttpStatus.OK).body(grupoResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: No se encontró el grupo");
        }
    }
}
