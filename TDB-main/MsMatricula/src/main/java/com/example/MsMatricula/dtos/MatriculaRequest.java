package com.example.MsMatricula.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class MatriculaRequest {
    private int idMatricula;
    private String codEstudiante;
    private String idPeriodo;

    public MatriculaRequest() {
    }

    public MatriculaRequest(int idMatricula, String codEstudiante, String idPeriodo) {
        this.idMatricula = idMatricula;
        this.codEstudiante = codEstudiante;
        this.idPeriodo = idPeriodo;
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public String getCodEstudiante() {
        return codEstudiante;
    }

    public void setCodEstudiante(String codEstudiante) {
        this.codEstudiante = codEstudiante;
    }

    public String getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(String idPeriodo) {
        this.idPeriodo = idPeriodo;
    }
}
