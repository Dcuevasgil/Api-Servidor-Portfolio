package com.proyecto1.proyecto1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto1.proyecto1.persistance.models.Project;
import com.proyecto1.proyecto1.persistance.repository.ProjectRepository;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4321/")
@RestController
@RequestMapping("/api/v1")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/projects")
    public ResponseEntity<?> getAllProjects() {
        try {
            // Obtener todos los proyectos
            List<Project> project = projectRepository.findAll();

            // Devuelvo la lista de proyectos
            return new ResponseEntity<>(project, HttpStatus.OK);
        } catch(Exception e) {
            // Manejo de errores al obtener los proyectos
            return new ResponseEntity<>("Error al obtener el proyecto " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/projects/find-name/{word}")
    public ResponseEntity<?> getProjectByWord(@PathVariable String word) {
        try {
            // Valido que la palabra no esté vacía
            if(word == null || word.isEmpty()) {
                return new ResponseEntity<>("La palabra no puede estar vacia", HttpStatus.BAD_REQUEST);
            }

            // Busco los proyectos que coincidan con la palabra introducida
            List<Project> project = projectRepository.findByProjectName(word);

            // Devuelvo un mensaje si no se encontraron los proyectos
            if(project.isEmpty()) {
                return new ResponseEntity<>("No se encontraron proyectos con esa palabra", HttpStatus.NOT_FOUND);
            }

            // Retornar la lista de proyectos encontrados
            return new ResponseEntity<>(project, HttpStatus.OK);
        } catch(Exception e) {
            // Manejar errores al buscar proyectos
            return new ResponseEntity<>("Error al obtener el proyecto " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/projects")
    public ResponseEntity<?> createProject(@Valid @RequestBody Project project) {
        try {
            // Crear un nuevo proyecto
            Project saveProject = projectRepository.save(project);
            // Retornar el proyecto creado
            return new ResponseEntity<>(saveProject, HttpStatus.CREATED);
        } catch(Exception e) {
            // Manejar errores al crear el proyecto
            return new ResponseEntity<>("Error al crear el proyecto " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<?> updateProject(@Valid @PathVariable Integer id, @Valid @RequestBody Project project) {
        try {
            // Verificar si el proyecto existe
            if(!projectRepository.existsById(id)) {
                return new ResponseEntity<>("No se encontro el proyecto", HttpStatus.NOT_FOUND);
            }
            // Actualizar el ID del proyecto
            project.setProjectId(id);

            // Guardar los cambios del proyecto
            Project updateProject = projectRepository.save(project);

            // Retornar el proyecto actualizado
            return new ResponseEntity<>(updateProject, HttpStatus.OK);
        } catch(Exception e) {

            // Manejar errores al actualizar el proyecto
            return new ResponseEntity<>("Error al actualizar el proyecto " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable Integer id) {
        try {
            // Verificar si el proyecto existe
            if(!projectRepository.existsById(id)) {
                return new ResponseEntity<>("El proyecto con el id " + id + " no se ha encontrado", HttpStatus.NOT_FOUND);
            }

            // Eliminar el proyecto
            projectRepository.deleteById(id);

            // Retornar mensaje de confirmación de eliminación
            return new ResponseEntity<>("El proyecto con el id " + id + " se ha eliminado", HttpStatus.OK);
        } catch(Exception e) {
            // Manejar errores al eliminar el proyecto
            return new ResponseEntity<>("Error al eliminar el proyecto " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}