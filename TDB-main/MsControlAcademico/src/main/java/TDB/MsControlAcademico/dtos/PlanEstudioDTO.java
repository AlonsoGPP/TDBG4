package TDB.MsControlAcademico.dtos;

public class PlanEstudioDTO {
    private int id_plan_estudio;
    private String año;
    private int cant_creditos;

    private int cod_carrera;

    public int getId_plan_estudio() {
        return id_plan_estudio;
    }

    public void setId_plan_estudio(int id_plan_estudio) {
        this.id_plan_estudio = id_plan_estudio;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public int getCant_creditos() {
        return cant_creditos;
    }

    public void setCant_creditos(int cant_creditos) {
        this.cant_creditos = cant_creditos;
    }

    public int getCod_carrera() {
        return cod_carrera;
    }

    public void setCod_carrera(int cod_carrera) {
        this.cod_carrera = cod_carrera;
    }
}
