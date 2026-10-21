package com.javaSpring.examen.Servicios;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.javaSpring.examen.Modelos.Usuario;
import com.javaSpring.examen.Modelos.UsuarioLogin;
import com.javaSpring.examen.Repositorio.RepositorioUsuarios;

@Service
public class ServicioUsuario {
    @Autowired 
    private RepositorioUsuarios repositorioUsuarios;

    public List<Usuario> mostrarTodo (){
        return(List<Usuario>) this.repositorioUsuarios.findAll();
    }

    public Usuario obtenerPorId(Long id){
        return this.repositorioUsuarios.findById(id).orElse(null);
    }

    public Usuario obtenerPorCorreo(String correo){
        return this.repositorioUsuarios.findByCorreo(correo).orElse(null);
    }

    public Usuario nuevoUsuario(Usuario usuario){
        return this.repositorioUsuarios.save(usuario);
    }

    public void eliminarUsuario(Long id){
        this.repositorioUsuarios.deleteById(id);
    }

    public Usuario actualizar (Usuario usuario){
        return this.repositorioUsuarios.save(usuario);
    }

    //Validaciones

    public BindingResult validarRegistro(BindingResult validaciones, Usuario usuario){
        Usuario usuarioBD = this.obtenerPorCorreo(usuario.getCorreo());
        if(usuarioBD != null){
            validaciones.rejectValue("correo", "usuarioExistente", "Este usuario ya existe.");
        }
        if(!usuario.getPassword().equals(usuario.getConfirmarPassword())){
            validaciones.rejectValue("confirmarPassword", "contrasenaNoCoincide", "Las constraseñas no coinciden");
        }
        
        return validaciones;
    }

    //Encriptar 
    public Usuario crearUsuario(Usuario usuario){
        String newPassword = BCrypt.hashpw(usuario.getPassword(),BCrypt.gensalt());
        usuario.setPassword(newPassword);
        return this.repositorioUsuarios.save(usuario);
        
    }

    //Validar Login
    public BindingResult validarLogin(BindingResult validaciones, UsuarioLogin usuarioLogin){
        Usuario usuarioBD = this.obtenerPorCorreo(usuarioLogin.getCorreo());
        if(usuarioBD == null){
            validaciones.rejectValue("correo", "usuarioInexistente", "Este usuario no existe.");
        }else{
            if(!BCrypt.checkpw(usuarioLogin.getPassword(), usuarioBD.getPassword())){
                validaciones.rejectValue("password", "passwordIncorrecta", "Credenciales incorrectas");
            }
        }
        return validaciones;
    }

}
