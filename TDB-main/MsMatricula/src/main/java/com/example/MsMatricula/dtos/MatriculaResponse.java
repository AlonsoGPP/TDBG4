package com.example.MsMatricula.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaResponse {
    private int idMatricula;
    private String codEstudiante;
    private String idPeriodo;
    private Date fechaMatricula;
    private Date updatedAt;
}
