package com.javaSpring.examen.Modelos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioLogin {

    @Email(message = "Proporciona un correo válido.")
    @NotBlank(message = "Por favor ingresar un correo válido.")
    private String correo;

    @NotBlank(message = "Por favor proporciona tu contraseña.")
    @Size(min = 8, message ="La contraseña debe tener al menor 8 caracteres.")
    private String password;

    public UsuarioLogin() {
    }

    public UsuarioLogin(String correo, String password){
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    
}
