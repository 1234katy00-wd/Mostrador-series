package com.javaSpring.examen.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.javaSpring.examen.Modelos.Serie;
import com.javaSpring.examen.Servicios.ServicioSeries;
import com.javaSpring.examen.Servicios.ServicioUsuario;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorSeries {
    @Autowired
    private ServicioSeries servicioSeries;

    @Autowired
    private ServicioUsuario servicioUsuario;
    
    @GetMapping("/inicio/series")
    public String todasLasSeries(Model modelo, HttpSession sesion){
        Long idUsuario = (Long) sesion.getAttribute("idUsuario");
        if(idUsuario == null){
            return"redirect:/registro";
        }
        List<Serie> series = this.servicioSeries.obtenerTodas();
        modelo.addAttribute("listaSeries", series);
        return"series.jsp";
    }

    @GetMapping("/agregar/serie")
    public String agregarSerie(Model modelo, HttpSession sesion) {
        Long idUsuario = (Long) sesion.getAttribute("idUsuario");
        if(idUsuario == null){
            return"redirect:/registro";
        }
        modelo.addAttribute("serie", new Serie());
        return"agregar.jsp";
    }

    @PostMapping("/procesar/agregar/serie")
    public String procesarAgreagarSerie(@Valid @ModelAttribute("serie") Serie serie, BindingResult validaciones, HttpSession sesion, Model modelo){
        validaciones= this.servicioSeries.validarSerieUnica(validaciones, serie);
        if (validaciones.hasErrors()) {
            return"agregar.jsp";
        }
        this.servicioSeries.crear((serie));
        return"redirect:/inicio/series";
    }

    @GetMapping("/editar/serie/{id}")
    public String editarSerie(HttpSession sesion, Model modelo,@PathVariable("id")Long id){
        Long idUsuario = (Long) sesion.getAttribute("idUsuario");
        if(idUsuario == null){
            return"redirect:/registro";
        }
        modelo.addAttribute("serie", this.servicioSeries.obtenerSeriePorId(id));
        return"editar.jsp";
    }

    @PutMapping("/procesar/editar/serie")
    public String procesaEditarSerie (@Valid @ModelAttribute("serie")Serie serie, BindingResult validaciones, Model modelo, HttpSession sesion){
        if(validaciones.hasErrors()){
            return"editar.jsp";
        }
        this.servicioSeries.actualizar((serie));
        return"redirect:/inicio/series";
    }

    @DeleteMapping("/eliminar/serie/{id}")
    public String eliminarSerie(@PathVariable("id")Long id, HttpSession sesion){
        Long idUsuario = (Long) sesion.getAttribute("idUsuario");
        if(idUsuario == null){
            return"redirect:/login";
        }
        Serie.obtenerSeriePorId = this.servicioSeries.obtenerSeriePorId(id);

        if (serie == null || !idUsuario.equals(serie.getUsuarioLogin().getId())) {
        return "Acceso no válido."; 
        }
        this.servicioSeries.eliminarSerie(id);
        return "redirect:/inicio/series";
    }

    @GetMapping("/detalle/serie/{id}")
    public String detalleSerie(@PathVariable ("id")Long id,Model modelo, HttpSession sesion){
        Long idUsuario = (Long) sesion.getAttribute("idUsuario");
        if(idUsuario == null){
            return"redirect:/registro";
        }
        modelo.addAttribute("serie", this.servicioSeries.obtenerSeriePorId(id));
        return"detalle.jsp";
    }
}
