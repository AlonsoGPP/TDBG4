package com.example.MsMatricula.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class DetalleMatriculaRequest {

    private String idDetalleMatricula;

    private int idMatricula;


    private String codCurso;

    public DetalleMatriculaRequest() {
    }

    public DetalleMatriculaRequest(String idDetalleMatricula, int idMatricula, String codCurso) {
        this.idDetalleMatricula = idDetalleMatricula;
        this.idMatricula = idMatricula;
        this.codCurso = codCurso;
    }

    public String getIdDetalleMatricula() {
        return idDetalleMatricula;
    }

    public void setIdDetalleMatricula(String idDetalleMatricula) {
        this.idDetalleMatricula = idDetalleMatricula;
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }
}
