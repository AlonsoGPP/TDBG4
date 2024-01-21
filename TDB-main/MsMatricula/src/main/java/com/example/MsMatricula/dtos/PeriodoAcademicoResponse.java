package com.example.MsMatricula.dtos;

import jakarta.persistence.Column;

import java.util.Date;

public class PeriodoAcademicoResponse {
    private int idPeriodoAcademico;

    private String nombrePeriodo;

    private Date fechaInicio;

    private Date fechaFin;
    private Date createdAt;
    private Date updatedAt;

    public PeriodoAcademicoResponse() {
    }

    public PeriodoAcademicoResponse(int idPeriodoAcademico, String nombrePeriodo, Date fechaInicio, Date fechaFin, Date createdAt, Date updatedAt) {
        this.idPeriodoAcademico = idPeriodoAcademico;
        this.nombrePeriodo = nombrePeriodo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
