package com.example.MsMatricula.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="detalle_matricula")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleMatriculaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_matricula")
    private String idDetalleMatricula;

    @Column(name="id_matricula")
    private int idMatricula;

    @Column(name="cod_curso")
    private String codCurso;
}
