package com.proyecto1.proyecto1.services;

import java.util.List;

import com.proyecto1.proyecto1.persistance.models.Status;

public interface StatusServiceI {
    
    // Método para obtener todos los estados
    List<Status> getAllStatus();

    // Método para crear un nuevo estado
    Status createStatus(Status status);

    // Método para eliminar un estado por su ID
    void deleteStatus(Integer id);
    
    // Método para verificar si un estado existe por su ID
    boolean existsStatusById(Integer id);

}
