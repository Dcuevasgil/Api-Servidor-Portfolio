package com.proyecto1.proyecto1.services;

import java.util.List;

import com.proyecto1.proyecto1.persistance.models.Technology;

public interface TechnologyServiceI {

    // Método para obtener todas las tecnologías
    List<Technology> getAllTechnologies();

    // Método para verificar si existe una tecnología por su ID
    boolean existsTechnologiesById(Integer id);

    // Método para crear una nueva tecnología
    List<Technology> createTechnology(List<Technology> technology);

    // Método para eliminar una tecnología por su ID
    void deleteTechnology(Integer id);

}
