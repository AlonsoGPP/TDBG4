package com.example.MsMatricula.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="matricula")
@AllArgsConstructor
@NoArgsConstructor
@Data
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

}
