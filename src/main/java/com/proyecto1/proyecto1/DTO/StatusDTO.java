package com.proyecto1.proyecto1.DTO;

import java.time.LocalDate;
import java.util.List;

import com.proyecto1.proyecto1.persistance.models.Developer;
import com.proyecto1.proyecto1.persistance.models.Project;
import com.proyecto1.proyecto1.persistance.models.Status;
import com.proyecto1.proyecto1.persistance.models.Technology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusDTO {
    
    // Identificador único del estado
    private Integer statusId;

    // Nombre del estado del proyecto (por ejemplo, "En desarrollo", "En produccion", "En testing")
    private String statusName;

    // Lista de proyectos que tienen este estado
    private List<Project> projects;
    

}