package TDB.MsSeguridad.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Docente")
public class DocenteModel {
    @Id
    @Column(name="cod_docente",length = 30, nullable = false)
    private String codDocente;

    @Column(name="nombres", nullable = false)
    private String nombre;

    @Column(name="apellidos", nullable = false)
    private String apellido;

    @Column(name = "dni", nullable = false, length = 8)
    private String dni;

    @Column(name="formacion", nullable = false)
    private String formacion;

    @Column(name="telefono", nullable = true)
    private String telefono;
    @Column(name="email", nullable = true)
    private String email;

    @Column(name="activo", nullable = false)
    private boolean activo;

    @Column(name="createdAt")
    public Date createdAt;

    @Column(name = "updatedAt")
    public Date updatedAt;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_usuario", referencedColumnName = "id_usuario")
    UsuarioModel user;
//falta agregar correo y a estudiante falta agregar dni
    public DocenteModel() {
    }

    public DocenteModel(String codDocente, String nombre, String apellido, String dni, String formacion, String telefono, String email, boolean activo, Date createdAt, Date updatedAt, UsuarioModel user) {
        this.codDocente = codDocente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.formacion = formacion;
        this.telefono = telefono;
        this.email = email;
        this.activo = activo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
    }

    public String getCodDocente() {
        return codDocente;
    }

    public void setCodDocente(String codDocente) {
        this.codDocente = codDocente;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFormacion() {
        return formacion;
    }

    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
