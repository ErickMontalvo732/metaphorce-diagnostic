package com.metaphorce.databaseLib.dto;

public class RegistroUsuarioDto {

    private Long idRol;
    private String nombreUsuario;
    private String contrasenia;


    public RegistroUsuarioDto() {

    }

    public Long getIdRol() {
        return idRol;
    }
    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

}
