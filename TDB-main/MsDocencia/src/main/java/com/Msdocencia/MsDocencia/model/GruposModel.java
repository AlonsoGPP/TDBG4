package com.Msdocencia.MsDocencia.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GruposModel  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_matricula")
    private Integer idGrupo;
    @Column(name="nombre")
    private Integer nombre;

    @Column(name="numero_estudiantes")
    private Integer numeroEstudiantes;

    @Column(name="numero_estudiantes")
    private Integer idDocenteDictaCurso;

    @Column(name="created_at")
    private Date createdAt;

    @Column(name="updated_at")
    private Date updatedAt;
}
