package com.example.MsMatricula.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="matricula")

public class MatriculaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matricula")
    private int idMatricula;

    @Column(name="cod_estudiante")
    private String codEstudiante;

    @Column(name="id_periodo")
    private String idPeriodo;

    @Column(name="fecha_matricula")
    private Date fechaMatricula;


    @Column(name="UpdatedAt")
    private Date updatedAt;

    public MatriculaModel() {
    }

    public MatriculaModel(int idMatricula, String codEstudiante, String idPeriodo, Date fechaMatricula, Date updatedAt) {
        this.idMatricula = idMatricula;
        this.codEstudiante = codEstudiante;
        this.idPeriodo = idPeriodo;
        this.fechaMatricula = fechaMatricula;
        this.updatedAt = updatedAt;
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
