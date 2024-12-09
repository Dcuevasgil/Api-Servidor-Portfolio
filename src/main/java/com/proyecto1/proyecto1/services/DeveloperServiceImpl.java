package com.proyecto1.proyecto1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto1.proyecto1.persistance.models.Developer;
import com.proyecto1.proyecto1.persistance.repository.DeveloperRepository;

@Service
public class DeveloperServiceImpl implements DeveloperServiceI {

    // Inyección de dependencias para el repositorio de Developer
    @Autowired
    private DeveloperRepository developerRepository;

    // Implementación del método que obtiene todos los desarrolladores
    @Override
    public List<Developer> getAllDevelopers() {
        return developerRepository.findAll(); // Llama al repositorio para obtener todos los desarrolladores
    }

    // Implementación del método que verifica si un desarrollador existe por su ID
    @Override
    public boolean existsDeveloperById(Integer id) {
        return developerRepository.existsById(id); // Verifica si existe un desarrollador con el ID dado
    }

    // Implementación del método para crear un nuevo desarrollador
    @Override
    public Developer createDeveloper(Developer developer) {
        return developerRepository.save(developer); // Guarda el desarrollador en la base de datos
    }

    // Implementación del método para eliminar un desarrollador por su ID
    @Override
    public void deleteDeveloper(Integer id) {
        developerRepository.deleteById(id); // Elimina el desarrollador de la base de datos
    }
}
