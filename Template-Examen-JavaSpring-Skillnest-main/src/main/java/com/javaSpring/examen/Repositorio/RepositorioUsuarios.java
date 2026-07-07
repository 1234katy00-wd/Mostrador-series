package com.javaSpring.examen.Repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javaSpring.examen.Modelos.Usuario;

import java.util.Optional;


@Repository
public interface RepositorioUsuarios extends CrudRepository <Usuario, Long> {
    Optional<Usuario>findByCorreo(String correo);
    
} 