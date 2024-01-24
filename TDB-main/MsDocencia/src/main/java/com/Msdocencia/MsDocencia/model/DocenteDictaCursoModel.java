package com.Msdocencia.MsDocencia.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="docente_dicta_curso")
public class DocenteDictaCursoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_docente_dicta_curso")
    private Integer idDocenteDictaCurso;

    @Column(name="id_docente")
    private Integer idDocente;
    @Column(name="cod_curso")
    private Integer codCurso;
    @Column(name="id_periodo")
    private Integer idPeriodo;
    @Column(name="created_at")
    private Date createdAt;

    @Column(name="updated_at")
    private Date updatedAt;

    
}
