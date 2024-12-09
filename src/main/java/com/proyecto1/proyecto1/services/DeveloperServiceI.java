package com.proyecto1.proyecto1.services;

import java.util.List;

import com.proyecto1.proyecto1.persistance.models.Developer;

public interface DeveloperServiceI {
    
    // Método para obtener todos los desarrolladores de la base de datos.
    List<Developer> getAllDevelopers();

    // Método para crear un nuevo desarrollador en la base de datos.
    Developer createDeveloper(Developer developer);

    // Método para eliminar un desarrollador de la base de datos mediante su ID.
    void deleteDeveloper(Integer id);

    // Método para verificar si existe un desarrollador con un ID específico.
    boolean existsDeveloperById(Integer id);

}
