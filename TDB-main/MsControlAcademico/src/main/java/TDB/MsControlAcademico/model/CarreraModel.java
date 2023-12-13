package TDB.MsControlAcademico.model;

import jakarta.persistence.*;

@Entity
@Table(name = "carrera")
public class CarreraModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_carrera")
    private int cod_carrera;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "id_facultad", nullable = false)
    private int id_facultad;

    public CarreraModel() {
    }

    // Constructor con campos
    public CarreraModel(String nombre, int idFacultad) {
        this.nombre = nombre;
        this.id_facultad = idFacultad;
    }

    public int getCod_carrera() {
        return cod_carrera;
    }

    public void setCod_carrera(int cod_carrera) {
        this.cod_carrera = cod_carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_facultad() {
        return id_facultad;
    }

    public void setId_facultad(int id_facultad) {
        this.id_facultad = id_facultad;
    }
}
