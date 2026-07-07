package com.javaSpring.examen.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.javaSpring.examen.Modelos.Usuario;
import com.javaSpring.examen.Modelos.UsuarioLogin;
import com.javaSpring.examen.Servicios.ServicioUsuario;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorUsuarios {
    @Autowired
    private ServicioUsuario servicioUsuario;

    @GetMapping("/registro")
    public String formularioRegistro(Model modelo){
        modelo.addAttribute("usuario", new Usuario());
        return"registro.jsp";
    }

    @PostMapping("/procesa/registro")
    public String procesaRegistro(@Valid @ModelAttribute("usuario") Usuario usuario,BindingResult validaciones, HttpSession sesion, Model modelo){
        validaciones = this.servicioUsuario.validarRegistro(validaciones, usuario);
        if(validaciones.hasErrors()){
            return"registro.jsp";
        }
        Usuario usuarioCreado = this.servicioUsuario.crearUsuario(usuario);
        sesion.setAttribute("usuario", usuarioCreado.getNombre() + "" + usuarioCreado.getApellido());
        sesion.setAttribute("idUsuario", usuarioCreado.getId());

        return"redirect:/inicio/series";
    }

    @GetMapping("/login")
    public String muestraLogin(Model modelo){
        modelo.addAttribute("usuarioLogin", new UsuarioLogin());
        return"login.jsp";
    }

    @PostMapping("/procesa/login")
    public String procesaLogin(@Valid @ModelAttribute ("usuarioLogin")UsuarioLogin usuarioLogin, BindingResult validaciones, HttpSession sesion, Model modelo){
        validaciones = this.servicioUsuario.validarLogin(validaciones, usuarioLogin);
        if(validaciones.hasErrors()){
            return"login.jsp";
        }
        Usuario usuarioEnSesion = this.servicioUsuario.obtenerPorCorreo(usuarioLogin.getCorreo());
        sesion.setAttribute("usuarioEnSesion", usuarioEnSesion.getNombre() + " " + usuarioEnSesion.getApellido());
        sesion.setAttribute("idUsuario", usuarioEnSesion.getId());
        return"redirect:/inicio/series";
    }

    @GetMapping("/logout")
    public String logout(HttpSession sesion){
        sesion.invalidate();
        return"redirect:/login";
    }

    




}
