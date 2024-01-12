package TDB.MsControlAcademico.dtos;

public class CursoDTO {
    private String codCurso;
    private String nombre;
    private int creditos;
    private int ciclo;
    private int totalSesiones;
    private String descripcion;
    private Integer idPlanEstudio;

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public int getTotalSesiones() {
        return totalSesiones;
    }

    public void setTotalSesiones(int totalSesiones) {
        this.totalSesiones = totalSesiones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdPlanEstudio() {
        return idPlanEstudio;
    }

    public void setIdPlanEstudio(Integer idPlanEstudio) {
        this.idPlanEstudio = idPlanEstudio;
    }
}
