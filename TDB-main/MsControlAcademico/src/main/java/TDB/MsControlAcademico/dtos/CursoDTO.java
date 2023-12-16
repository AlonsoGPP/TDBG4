package TDB.MsControlAcademico.dtos;

public class CursoDTO {
    private String cod_curso;
    private String nombre;
    private int creditos;
    private int ciclo;
    private int total_sesiones;
    private String descripcion;
    private Integer id_plan_estudio;

    public String getCod_curso() {
        return cod_curso;
    }

    public void setCod_curso(String cod_curso) {
        this.cod_curso = cod_curso;
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

    public int getTotal_sesiones() {
        return total_sesiones;
    }

    public void setTotal_sesiones(int total_sesiones) {
        this.total_sesiones = total_sesiones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId_plan_estudio() {
        return id_plan_estudio;
    }

    public void setId_plan_estudio(Integer id_plan_estudio) {
        this.id_plan_estudio = id_plan_estudio;
    }
}
