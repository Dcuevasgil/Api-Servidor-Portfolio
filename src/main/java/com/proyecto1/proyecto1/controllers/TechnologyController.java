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

import com.proyecto1.proyecto1.persistance.models.Technology;
import com.proyecto1.proyecto1.services.TechnologyServiceI;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4321/")
@RestController
@RequestMapping("/api/v1")
public class TechnologyController {

    @Autowired
    private TechnologyServiceI technologyService;


    @GetMapping("/technology")
    public ResponseEntity<?> getAllTechnologies() {
        try {
            // Obtener todas las tecnologías
            List<Technology> technology = technologyService.getAllTechnologies();
            // Retornar la lista de tecnologías
            return new ResponseEntity<>(technology, HttpStatus.OK);
        } catch(Exception e) {
            // Manejar errores al obtener las tecnologías
            return new ResponseEntity<>("Error al obtener la tecnología " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/technology")
    public ResponseEntity<?> createTechnology(@Valid @RequestBody List<Technology> technology) {
        try {
            // Crear una nueva tecnología
            List<Technology> saveTechnology = technologyService.createTechnology(technology);
            // Retornar la tecnología creada
            return new ResponseEntity<>(saveTechnology, HttpStatus.CREATED);
        } catch(Exception e) {
            // Manejar errores al crear la tecnología
            return new ResponseEntity<>("Error al crear la tecnología " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/technology/{id}")
    public ResponseEntity<?> deleteTechnology(@PathVariable Integer id) {
        try {
            // Verificar si la tecnología existe
            if(!technologyService.existsTechnologiesById(id)) {
                // Retornar mensaje si no se encuentra la tecnología
                return new ResponseEntity<>("La tecnología con el id " + id + " no se ha encontrado", HttpStatus.NOT_FOUND);
            }
            // Eliminar la tecnología
            technologyService.deleteTechnology(id);
            // Retornar mensaje de confirmación de eliminación
            return new ResponseEntity<>("La tecnología con el id " + id + " se ha eliminado", HttpStatus.OK);
        } catch(Exception e) {
            // Manejar errores al eliminar la tecnología
            return new ResponseEntity<>("Error al eliminar la tecnología " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}