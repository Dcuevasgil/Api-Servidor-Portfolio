package com.proyecto1.proyecto1.persistance.repository;

import org.springframework.stereotype.Repository;

import com.proyecto1.proyecto1.persistance.models.Status;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository // Marca esta interfaz como un repositorio de Spring, lo que indica que esta clase gestionará la interacción con la base de datos.
public interface StatusRepository extends JpaRepository<Status, Integer> {
    
}
