package TDB.MsControlAcademico.model;

import jakarta.persistence.*;

@Entity
@Table(name = "facultad")
public class FacultadModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_facultad")
    private int idFacultad;

    @Column(name="nombre", nullable=false)
    private String nombre;
    @Column(name="descripcion")
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
        return idFacultad;
    }

    public void setIdFacultad(int idFacultad) {
        this.idFacultad = idFacultad;
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