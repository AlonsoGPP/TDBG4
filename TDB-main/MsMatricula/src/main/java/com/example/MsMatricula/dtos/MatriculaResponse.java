package com.example.MsMatricula.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


public class MatriculaResponse {
    private int idMatricula;
    private String codEstudiante;
    private String idPeriodo;
    private Date fechaMatricula;
    private Date updatedAt;

    public MatriculaResponse() {
    }

    public MatriculaResponse(int idMatricula, String codEstudiante, String idPeriodo, Date fechaMatricula, Date updatedAt) {
        this.idMatricula = idMatricula;
        this.codEstudiante = codEstudiante;
        this.idPeriodo = idPeriodo;
        this.fechaMatricula = fechaMatricula;
        this.updatedAt = updatedAt;
    }

    public int getIdMatricula() {        return idMatricula;
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

    public Date getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
