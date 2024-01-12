package TDB.MsControlAcademico.model;

import jakarta.persistence.*;

@Entity
@Table(name = "carrera")
public class CarreraModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_carrera")
    private int codCarrera;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "id_facultad", nullable = false)
    private int idFacultad;

    public CarreraModel() {
    }

    // Constructor con campos
    public CarreraModel(String nombre, int idFacultad) {
        this.nombre = nombre;
        this.idFacultad = idFacultad;
    }

    public int getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(int codCarrera) {
        this.codCarrera = codCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(int idFacultad) {
        this.idFacultad = idFacultad;
    }
}
