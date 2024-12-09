package com.proyecto1.proyecto1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto1.proyecto1.persistance.models.Project;
import com.proyecto1.proyecto1.persistance.repository.ProjectRepository;

import javax.validation.Valid;

@Service
public class ProjectServiceImpl implements ProjectServiceI {

    @Autowired
    private ProjectRepository projectRepository;

    // Implementación de la interfaz para obtener todos los proyectos
    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll(); // Retorna todos los proyectos de la base de datos
    }

    // Implementación de la interfaz para obtener un proyecto por su ID
    @Override
    public Project getProjectById(Integer id) {
        // Utiliza el repositorio para buscar el proyecto por su ID
        return projectRepository.findById(id).get(); // Se asume que el proyecto existe, por lo que se utiliza .get()
    }

    // Implementación de la interfaz para crear un nuevo proyecto
    @Override
    public Project createProject(@Valid Project project) {
        // Valida el objeto Project y lo guarda en la base de datos
        return projectRepository.save(project); // Retorna el proyecto creado
    }

    // Implementación de la interfaz para actualizar un proyecto existente
    @Override
    public Project updateProject(@Valid Integer id,@Valid Project project) {
        // Guarda el proyecto actualizado, asumiendo que el ID existe en la base de datos
        return projectRepository.save(project); // Retorna el proyecto actualizado
    }

    // Implementación de la interfaz para eliminar un proyecto por su ID
    @Override
    public void deleteProject(Integer id) {
        // Elimina el proyecto basado en su ID
        projectRepository.deleteById(id); // Elimina el proyecto de la base de datos
    }

    // Implementación de la interfaz para obtener proyectos según su estado
    @Override
    public List<Project> getProjectsByStatus(Integer statusId) {
        // Utiliza el repositorio para buscar proyectos con el estado correspondiente
        return projectRepository.findByStatus_StatusId(statusId); // Retorna los proyectos con el estado dado
    }

    // Implementación de la interfaz para obtener proyectos según la tecnología usada
    @Override
    public List<Project> getProjectsByTechnology(Integer techId) {
        // Busca proyectos que utilizan la tecnología especificada por techId
        return projectRepository.findByTechnology_Id(techId); // Retorna los proyectos que usan la tecnología indicada
    }

    // Implementación de la interfaz para obtener proyectos por desarrollador
    @Override
    public List<Project> getProjectsByDeveloper(Integer devId) {
        // Busca proyectos en los que trabaja el desarrollador especificado
        return projectRepository.findByDeveloper_Id(devId); // Retorna los proyectos en los que trabaja el desarrollador indicado
    }

    // Implementación de la interfaz para buscar proyectos por nombre
    @Override
    public List<Project> getProjectForName(String projectName) {
        // Busca proyectos cuyos nombres coinciden parcialmente con projectName
        return projectRepository.findByProjectName(projectName); // Retorna los proyectos cuyo nombre contiene el valor buscado
    }
    
}
