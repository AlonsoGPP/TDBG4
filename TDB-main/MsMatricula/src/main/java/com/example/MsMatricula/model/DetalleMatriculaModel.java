package com.example.MsMatricula.model;

import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table(name="detalle_matricula")

public class DetalleMatriculaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_matricula")
    private Integer idDetalleMatricula;

    @Column(name="id_matricula")
    private Integer idMatricula;

    @Column(name="cod_curso")
    private String codCurso;

    @Column(name="created_at")
    private Date createdAt;

    @Column(name="updated_at")
    private Date updatedAt;

    public DetalleMatriculaModel(Integer idDetalleMatricula, Integer idMatricula, String codCurso, Date createdAt, Date updatedAt) {
        this.idDetalleMatricula = idDetalleMatricula;
        this.idMatricula = idMatricula;
        this.codCurso = codCurso;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public DetalleMatriculaModel() {
    }

    public Integer getIdDetalleMatricula() {
        return idDetalleMatricula;
    }

    public void setIdDetalleMatricula(Integer idDetalleMatricula) {
        this.idDetalleMatricula = idDetalleMatricula;
    }

    public Integer getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
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
