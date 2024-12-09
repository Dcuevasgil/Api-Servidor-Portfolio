package com.proyecto1.proyecto1.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto1.proyecto1.persistance.models.Technology;
import com.proyecto1.proyecto1.persistance.repository.TechnologyRepository;


@Service
public class TechnologyServiceImpl implements TechnologyServiceI {

    // Inyección de dependencia del repositorio TechnologyRepository
    @Autowired
    private TechnologyRepository technologyRepository;

    // Implementación del método para obtener todas las tecnologías
    @Override
    public List<Technology> getAllTechnologies() {
        return technologyRepository.findAll();  // Devuelve todas las tecnologías almacenadas
    }

    // Implementación del método para verificar si existe una tecnología por su ID
    @Override
    public boolean existsTechnologiesById(Integer id) {
        return technologyRepository.existsById(id);  // Devuelve true si la tecnología con el ID existe
    }

    // Implementación del método para crear una nueva tecnología
    @Override
    public List<Technology> createTechnology(@Valid List<Technology> technology) {
        return technologyRepository.saveAll(technology);  // Guarda la nueva tecnología en la base de datos
    }

    // Implementación del método para eliminar una tecnología por su ID
    @Override
    public void deleteTechnology(Integer id) {
        technologyRepository.deleteById(id);  // Elimina la tecnología con el ID proporcionado
    }

}
