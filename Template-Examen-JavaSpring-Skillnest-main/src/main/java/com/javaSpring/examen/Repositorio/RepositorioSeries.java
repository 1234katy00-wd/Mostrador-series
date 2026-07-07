package com.javaSpring.examen.Repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javaSpring.examen.Modelos.Serie;
import java.util.Optional;


@Repository
public interface RepositorioSeries extends CrudRepository <Serie, Long> {
    Optional<Serie>findByTitulo(String titulo);

}
