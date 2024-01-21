package com.Msdocencia.MsDocencia.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GrupoResponse {
    private Integer idGrupo;
    private Integer nombre;
    private Integer numeroEstudiantes;
    private Integer idDocenteDictaCurso;
}
