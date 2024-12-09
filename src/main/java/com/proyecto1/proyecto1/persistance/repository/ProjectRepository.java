package com.proyecto1.proyecto1.persistance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto1.proyecto1.persistance.models.Project;

@Repository  // Marca esta interfaz como un repositorio de Spring Data JPA, lo que permite la automatización de operaciones de base de datos.
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    // Método para obtener proyectos filtrados por el ID de estado (status)
    List<Project> findByStatus_StatusId(Integer statusId);

    // Método personalizado utilizando JPQL para obtener proyectos por tecnología específica
    @Query("SELECT p FROM Project p JOIN p.technologies t WHERE t.techId = :techId")
    List<Project> findByTechnology_Id(@Param("techId") Integer techId);

    // Método personalizado utilizando JPQL para obtener proyectos por desarrollador específico
    @Query("SELECT p FROM Project p JOIN p.developers d WHERE d.devId = :developerId")
    List<Project> findByDeveloper_Id(@Param("developerId") Integer developerId);

    // Método personalizado para buscar proyectos que contengan una palabra específica en el nombre
    @Query("SELECT p FROM Project p WHERE p.projectName LIKE CONCAT('%', :projectName, '%')")
    List<Project> findByProjectName(@Param("projectName") String projectName);
}