package TDB.MsSeguridad.dtos;


import java.util.Date;

public class UserResponse  {

    private int idUsuario;
    private  String username;
    private boolean activo;
    private Date createdAt;
    private Date updatedAt;

    public UserResponse() {
    }

    public UserResponse(int idUsuario,String username, boolean activo, Date createdAt, Date updatedAt) {
        this.idUsuario=idUsuario;
        this.username = username;
        this.activo = activo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
