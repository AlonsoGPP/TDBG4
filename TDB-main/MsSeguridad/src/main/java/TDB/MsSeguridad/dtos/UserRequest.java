package TDB.MsSeguridad.dtos;


import java.io.Serializable;
import java.util.Date;

public class UserRequest  {

private int idUsuario;
    private String username;
    private String password;
    private boolean activo;
   // private Date createdAt;
   // private Date updatedAt;

 
    public UserRequest() {
 
    }


    public UserRequest(int idUsuario, String username, String password, boolean activo, Date createdAt, Date updatedAt) {
       this.idUsuario=idUsuario;
        this.username = username;
        this.password = password;
        this.activo = activo;
       // this.createdAt = createdAt;
        //this.updatedAt = updatedAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActivo() {
        return activo;
    }



    public void setActivo(boolean activo) {
        this.activo = activo;
    }
/*
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
*/
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}

