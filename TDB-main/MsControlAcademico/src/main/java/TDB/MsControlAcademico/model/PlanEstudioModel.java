package TDB.MsControlAcademico.model;


import jakarta.persistence.*;

@Entity
@Table(name="plan_estudios")
public class PlanEstudioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plan_estudio")
    private int idPlanEstudio;

    @Column(name = "año")
    private String anho;

    @Column(name = "cant_creditos")
    private int cantCreditos;

    @Column(name = "cod_carrera", nullable = false)
    private int codCarrera;

    public int getIdPlanEstudio() {
        return idPlanEstudio;
    }

    public void setIdPlanEstudio(int idPlanEstudio) {
        this.idPlanEstudio = idPlanEstudio;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public int getCantCreditos() {
        return cantCreditos;
    }

    public void setCantCreditos(int cantCreditos) {
        this.cantCreditos = cantCreditos;
    }

    public int getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(int codCarrera) {
        this.codCarrera = codCarrera;
    }
}
