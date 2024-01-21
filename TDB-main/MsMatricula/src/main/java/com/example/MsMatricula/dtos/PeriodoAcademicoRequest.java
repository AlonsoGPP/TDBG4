package com.example.MsMatricula.dtos;



import java.util.Date;

public class PeriodoAcademicoRequest {
    private int idPeriodoAcademico;

    private String nombrePeriodo;

    private Date fechaInicio;

    private Date fechaFin;

    public PeriodoAcademicoRequest() {
    }

    public PeriodoAcademicoRequest(int idPeriodoAcademico, String nombrePeriodo, Date fechaInicio, Date fechaFin) {
        this.idPeriodoAcademico = idPeriodoAcademico;
        this.nombrePeriodo = nombrePeriodo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getIdPeriodoAcademico() {
        return idPeriodoAcademico;
    }

    public void setIdPeriodoAcademico(int idPeriodoAcademico) {
        this.idPeriodoAcademico = idPeriodoAcademico;
    }

    public String getNombrePeriodo() {
        return nombrePeriodo;
    }

    public void setNombrePeriodo(String nombrePeriodo) {
        this.nombrePeriodo = nombrePeriodo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
