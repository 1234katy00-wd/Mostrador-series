package com.javaSpring.examen.Servicios;

import com.javaSpring.examen.Repositorio.RepositorioUsuarios;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.javaSpring.examen.Modelos.Serie;
import com.javaSpring.examen.Modelos.Usuario;
import com.javaSpring.examen.Repositorio.RepositorioSeries;

@Service
public class ServicioSeries {
    @Autowired
    private RepositorioSeries repositorioSeries;

    @Autowired
    private RepositorioUsuarios repositorioUsuarios;
    
    public List<Serie> obtenerTodas(){
        return (List<Serie>)this.repositorioSeries.findAll();
    }

    public Serie obtenerSeriePorId (Long id){
        return this.repositorioSeries.findById(id).orElse(null);
    }

    public Serie actualizar(Serie serie){
        return this.repositorioSeries.save(serie);
    }

    public Serie obtenerPorTitulo(String titulo){
        return this.repositorioSeries.findByTitulo(titulo).orElse(null);
    }

    public Serie crear (Serie serie){
        return this.repositorioSeries.save(serie);
    }

    public void eliminarSerie(Long id){
        this.repositorioSeries.deleteById(id);
    }

    public Serie imagenSerie (Serie imagen){
        return this.repositorioSeries.save(imagen);
    }

    public Usuario buscUsuario(Long id){
        return this.repositorioUsuarios.findById(id).orElse(null);
    }

    //Validaciones
    public BindingResult validarSerieUnica(BindingResult validaciones, Serie serie){
        Serie serieBD = this.obtenerPorTitulo(serie.getTitulo());
        if(serieBD != null){
            validaciones.rejectValue("titulo", "tituloSerieRepetido", "la serie debe ser única");
        }
        return validaciones;
    }


    
}
