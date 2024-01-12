package com.example.MsMatricula.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaRequest {
    private int idMatricula;
    private String codEstudiante;
    private String idPeriodo;
}
