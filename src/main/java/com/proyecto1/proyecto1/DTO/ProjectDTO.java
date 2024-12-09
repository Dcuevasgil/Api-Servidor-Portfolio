package com.proyecto1.proyecto1.DTO;

import java.util.Date;
import java.util.List;

import com.proyecto1.proyecto1.persistance.models.Developer;
import com.proyecto1.proyecto1.persistance.models.Status;
import com.proyecto1.proyecto1.persistance.models.Technology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    
    // Identificador único del proyecto
    private Integer projectId;

    // Nombre del proyecto
    private String projectName;

    // Descripción del proyecto
    private String description;

    // Fecha de inicio del proyecto
    private Date startDate;

    // Fecha de finalización del proyecto
    private Date endDate;

    // URL del repositorio donde se encuentra el código del proyecto
    private String repositoryUrl;

    // URL de la demo del proyecto
    private String demoUrl;

    // URL de la imagen relacionada con el proyecto
    private String picture;

    // Estado actual del proyecto (por ejemplo, en progreso, completado)
    private Status status;

    // Lista de tecnologías utilizadas en el proyecto
    private List<Technology> technologies;

    // Lista de desarrolladores asociados al proyecto
    private List<Developer> developers;

}
