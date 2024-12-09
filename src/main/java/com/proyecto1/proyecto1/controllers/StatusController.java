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

import com.proyecto1.proyecto1.persistance.models.Status;
import com.proyecto1.proyecto1.services.StatusServiceI;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4321/")
@RestController
@RequestMapping("/api/v1")
public class StatusController {

    @Autowired
    private StatusServiceI statusService;

    @GetMapping("/status")
    public ResponseEntity<?> getAllStatus() {
        try {
            // Obtener todos los estados
            List<Status> status = statusService.getAllStatus();
            // Retornar la lista de estados
            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch(Exception e) {
            // Manejar errores al obtener los estados
            return new ResponseEntity<>("Error al obtener el estado " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @PostMapping("/status")
    public ResponseEntity<?> createStatus(@Valid @RequestBody Status status) {
        try {
            // Crear un nuevo estado
            Status saveStatus = statusService.createStatus(status);
            // Retornar el estado creado
            return new ResponseEntity<>(saveStatus, HttpStatus.CREATED);
        } catch(Exception e) {
            // Manejar errores al crear el estado
            return new ResponseEntity<>("Error al crear el status " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/status/{id}")
    public ResponseEntity<?> deleteStatus(@PathVariable Integer id) {
        try {
            // Verificar si el estado existe
            if(!statusService.existsStatusById(id)) {
                // Retornar mensaje si no se encuentra el estado
                return new ResponseEntity<>("El status con el id " + id + " no se ha encontrado", HttpStatus.NOT_FOUND);
            }
            // Eliminar el estado
            statusService.deleteStatus(id);
            // Retornar mensaje de confirmación de eliminación
            return new ResponseEntity<>("El status con el id " + id + " se ha eliminado", HttpStatus.OK);
        } catch(Exception e) {
            // Manejar errores al eliminar el estado
            return new ResponseEntity<>("Error al eliminar el status " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}