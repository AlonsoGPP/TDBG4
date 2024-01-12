package TDB.MsSeguridad.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Estudiante")
public class EstudianteModel {
    @Id
    @Column(name = "cod_estudiante", length=30, nullable = false)
    private String codEstudiante;

    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name="apellido", nullable = false)
    private String apellido;

    @Column(name="dni", nullable = false)
    private String dni;
    @Column(name="fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name="email")
    private String email;
    @Column(name="createdAt")
    public Date createdAt;

    @Column(name = "updatedAt")
    public Date updatedAt;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_usuario", referencedColumnName = "id_usuario")
    UsuarioModel user;

    public EstudianteModel() {
    }

    public EstudianteModel(String codEstudiante, String nombre, String apellido, String dni, Date fechaNacimiento, String email, Date createdAt, Date updatedAt, UsuarioModel user) {
        this.codEstudiante = codEstudiante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
    }

    public String getCodEstudiante() {
        return codEstudiante;
    }

    public void setCodEstudiante(String codEstudiante) {
        this.codEstudiante = codEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public UsuarioModel getUser() {
        return user;
    }

    public void setUser(UsuarioModel user) {
        this.user = user;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
