package com.proyecto1.proyecto1.services;

import java.util.List;


import com.proyecto1.proyecto1.persistance.models.Project;

public interface ProjectServiceI {
    
    // Método para obtener todos los proyectos
    List<Project> getAllProjects();

    // Método para obtener proyectos por nombre, permitiendo realizar búsquedas parciales
    List<Project> getProjectForName(String projectName);

    // Método para obtener un proyecto por su ID
    Project getProjectById(Integer id);

    // Método para crear un nuevo proyecto
    Project createProject(Project project);

    // Método para actualizar un proyecto existente
    Project updateProject(Integer id, Project project);

    // Método para eliminar un proyecto por su ID
    void deleteProject(Integer id);

    // Método para obtener proyectos según su estado
    List<Project> getProjectsByStatus(Integer statusId);

    // Método para obtener proyectos según una tecnología específica
    List<Project> getProjectsByTechnology(Integer techId);

    // Método para obtener proyectos según un desarrollador específico
    List<Project> getProjectsByDeveloper(Integer devId);
    
}
