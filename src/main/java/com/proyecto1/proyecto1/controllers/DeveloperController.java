package com.proyecto1.proyecto1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto1.proyecto1.persistance.models.Developer;
import com.proyecto1.proyecto1.services.DeveloperServiceI;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4321/")
@RestController
@RequestMapping("/api/v1")
public class DeveloperController {

    @Autowired
    private DeveloperServiceI developerService;

    @GetMapping("/developers")
    public ResponseEntity<?> getAllDevelopers() {
        try {
            // Obtener todos los desarrolladores
            List<Developer> developer = developerService.getAllDevelopers();

            // Retornar la lista de desarrolladores
            return new ResponseEntity<>(developer, HttpStatus.OK);
        } catch(Exception e) {
            // Manejar errores al obtener los desarrolladores 
            return new ResponseEntity<>("Error al obtener el desarrollador " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @PostMapping("/developers")
    public ResponseEntity<?> createDeveloper(@Valid @RequestBody Developer developer) {
        try {
            // Crear un nuevo desarrollador
            Developer saveDeveloper = developerService.createDeveloper(developer);

            // Retorno el desarrollador creado
            return new ResponseEntity<>(saveDeveloper, HttpStatus.CREATED);
        } catch(Exception e) {
            // Manejo el error en la creacion del desarrollador
            return new ResponseEntity<>("Error al crear el desarrollador " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/developers/{id}")
    public ResponseEntity<?> deleteDeveloper(@PathVariable Integer id) {
        try {
            // Verifico si el desarrollador existe
            if(!developerService.existsDeveloperById(id)) {
                // Retorno un mensaje si el desarrollador no se encuentra
                return new ResponseEntity<>("El desarrollador con el id " + id + " no se ha encontrado", HttpStatus.NOT_FOUND);
            }

            // Elimino el desarrollador
            developerService.deleteDeveloper(id);

            // Devuelvo un mensaje de confirmación de eliminación del desarrollador
            return new ResponseEntity<>("El desarrollador con el id " + id + " se ha eliminado", HttpStatus.OK);
        } catch(Exception e) {
            // Manejo el error en la eliminacion del desarrollador
            return new ResponseEntity<>("Error al eliminar el desarrollador " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}