package com.metaphorce.databaseLib.dto;

public class LoginUsuarioDto {

    private String nombreUsuario;
    private String contrasenia;
    private Long idRol;


    public LoginUsuarioDto() {
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
    public Long getIdRol() {
        return idRol;
    }
    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }
}

