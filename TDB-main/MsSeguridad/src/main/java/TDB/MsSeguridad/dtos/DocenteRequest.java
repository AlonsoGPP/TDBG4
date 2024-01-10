package TDB.MsSeguridad.dtos;

import TDB.MsSeguridad.model.UsuarioModel;

public class DocenteRequest {
    private String codDocente;
    private String nombre;
    private String apellido;
    private String dni;
    private String formacion;
    private String telefono;
    private boolean activo;
    private UsuarioModel user;
    public DocenteRequest() {
    }

    public DocenteRequest(String codDocente, String nombre, String apellido, String dni, String formacion, String telefono, boolean activo, UsuarioModel user) {
        this.codDocente = codDocente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.formacion = formacion;
        this.telefono = telefono;
        this.activo = activo;
        this.user=user;
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

    public UsuarioModel getUser() {
        return user;
    }

    public void setUser(UsuarioModel user) {
        this.user = user;
    }
}
