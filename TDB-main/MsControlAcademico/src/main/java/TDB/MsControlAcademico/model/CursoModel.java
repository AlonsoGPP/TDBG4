package TDB.MsControlAcademico.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "curso")

public class CursoModel {
    @Id
    @Column(name = "cod_curso", length = 30, nullable = false)
    private String cod_curso;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "creditos", nullable = false)
    private int creditos;

    @Column(name = "ciclo", nullable = false)
    private int ciclo;

    @Column(name = "total_sesiones", nullable = false)
    private int total_sesiones;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "id_plan_estudio")
    private Integer id_plan_estudio=0;

    @Column(name = "CREATED_AT")
    private Date CREATED_AT;

    @Column(name = "UPDATED_AT")
    private Date UPDATED_AT;

    public CursoModel() {
    }

    // Constructor con campos
    public CursoModel(String codCurso, String nombre, int creditos, int ciclo, int totalSesiones, String descripcion, int idPlanEstudio, Date createdAt, Date updatedAt) {
        this.cod_curso = codCurso;
        this.nombre = nombre;
        this.creditos = creditos;
        this.ciclo = ciclo;
        this.total_sesiones = totalSesiones;
        this.descripcion = descripcion;
        this.id_plan_estudio = idPlanEstudio;
        this.CREATED_AT = createdAt;
        this.UPDATED_AT = updatedAt;


    }

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

    public Date getCREATED_AT() {
        return CREATED_AT;
    }

    public void setCREATED_AT(Date CREATED_AT) {
        this.CREATED_AT = CREATED_AT;
    }

    public Date getUPDATED_AT() {
        return UPDATED_AT;
    }

    public void setUPDATED_AT(Date UPDATED_AT) {
        this.UPDATED_AT = UPDATED_AT;
    }
}