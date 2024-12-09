package com.proyecto1.proyecto1.DTO;

import java.util.List;

import com.proyecto1.proyecto1.persistance.models.Project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TechnologyDTO {

    // Identificador único de la tecnología
    private Integer techId;

    // Nombre de la tecnología (por ejemplo, "Java", "React", "Spring Boot")
    private String techName;

    // Lista de proyectos que utilizan esta tecnología
    private List<Project> projects;

}
