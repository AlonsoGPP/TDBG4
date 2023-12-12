package TDB.MsControlAcademico.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "facultad")
public class FacultadModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_facultad;


    private String nombre;

    private String descripcion;

    // Constructores, getters y setters

    // Constructor vacío (necesario para JPA)
    public FacultadModel() {
    }

    // Constructor con campos
    public FacultadModel(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters y setters
    public int getIdFacultad() {
        return id_facultad;
    }

    public void setIdFacultad(int idFacultad) {
        this.id_facultad = idFacultad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}