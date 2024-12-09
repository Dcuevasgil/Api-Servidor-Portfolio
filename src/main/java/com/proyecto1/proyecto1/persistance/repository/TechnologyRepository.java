package com.proyecto1.proyecto1.persistance.repository;

import com.proyecto1.proyecto1.persistance.models.Project;
import com.proyecto1.proyecto1.persistance.models.Technology;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Marca esta interfaz como un repositorio de Spring, indicando que gestionará la interacción con la base de datos para la entidad Technology.
public interface TechnologyRepository extends JpaRepository<Technology, Integer> {

}
