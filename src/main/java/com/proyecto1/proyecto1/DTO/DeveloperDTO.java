package com.proyecto1.proyecto1.DTO;

import java.util.List;

import com.proyecto1.proyecto1.persistance.models.Project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperDTO {
    
    // Identificador único del desarrollador
    private Integer devId;

    // Nombre del desarrollador
    private String devName;

    // Apellido del desarrollador
    private String devSurname;

    // Correo electrónico principal del desarrollador
    private String email;

    // URL del perfil de LinkedIn del desarrollador
    private String linkedinUrl;

    // URL del perfil de GitHub del desarrollador
    private String githubUrl;

    // Correo electrónico alternativo del desarrollador
    private String dev_email;

    // Lista de proyectos asociados al desarrollador
    private List<Project> projects;

}
