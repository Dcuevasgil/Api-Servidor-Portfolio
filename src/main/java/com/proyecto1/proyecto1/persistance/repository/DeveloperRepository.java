package com.proyecto1.proyecto1.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto1.proyecto1.persistance.models.Developer;

@Repository  // Marca esta interfaz como un repositorio de Spring Data JPA.
public interface DeveloperRepository extends JpaRepository<Developer, Integer> {

    // JpaRepository ya proporciona los métodos básicos CRUD (crear, leer, actualizar, eliminar)
    // para la entidad Developer, por lo que no es necesario agregar métodos adicionales a menos
    // que necesites consultas personalizadas.

}
