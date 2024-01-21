package com.example.MsMatricula.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="periodo_academico")
public class PeriodoAcademicoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_periodo_academico")
    private int idPeriodoAcademico;
    @Column(name="nombre_periodo", length = 30)
    private String nombrePeriodo;
    @Column(name="fecha_inicio")
    private Date fechaInicio;
    @Column(name="fecha_fin")
    private Date fechaFin;
    @Column(name="created_at")
    private Date createdAt;
    @Column(name="updated_at")
    private Date updatedAt;

    public PeriodoAcademicoModel() {
    }

    public PeriodoAcademicoModel(int idPeriodoAcademico, String nombrePeriodo, Date fechaInicio, Date fechaFin, Date createdAt, Date updatedAt) {
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
