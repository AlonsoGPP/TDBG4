package com.Msdocencia.MsDocencia.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocenteDictaCursoRequest {
    private Integer idDocenteDictaCurso;
    private Integer idDocente;
    private Integer codCurso;
    private Integer idPeriodo;
}
