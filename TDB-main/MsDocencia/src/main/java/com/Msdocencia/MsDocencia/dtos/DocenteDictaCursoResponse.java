package com.Msdocencia.MsDocencia.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocenteDictaCursoResponse {
    private Integer idDocenteDictaCurso;
    private Integer idDocente;
    private Integer codCurso;
    private Integer idPeriodo;
    private Date createdAt;
    private Date updatedAt;
}
