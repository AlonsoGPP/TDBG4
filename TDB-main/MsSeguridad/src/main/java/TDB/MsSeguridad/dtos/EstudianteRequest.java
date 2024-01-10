package TDB.MsSeguridad.dtos;

import TDB.MsSeguridad.model.UsuarioModel;

import java.util.Date;

public class EstudianteRequest {
    private String codEstudiante;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String email;
    private UsuarioModel user;

    public EstudianteRequest() {
    }

    public EstudianteRequest(String codEstudiante, String nombre, String apellido, Date fechaNacimiento, String email, UsuarioModel id_user) {
        this.codEstudiante = codEstudiante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.user = id_user;
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

    public UsuarioModel getUser() {
        return user;
    }

    public void setUser(UsuarioModel user) {
        this.user = user;
    }
}
