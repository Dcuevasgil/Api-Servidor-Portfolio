package com.proyecto1.proyecto1.persistance.models;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "technologies")
public class Technology {

    // Identificador único para cada tecnología, mapeado a la columna 'tech_id' en la base de datos.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tech_id")
    private Integer techId;

    // Nombre de la tecnología, mapeado a la columna 'tech_name' en la base de datos.
    @NotBlank(message = "El nombre de la tecnologia no puede ser nulo ni vacio")
    @Column(name = "tech_name")
    private String techName;

    // Relación muchos a muchos con la entidad Project (una tecnología puede ser utilizada en muchos proyectos).
    // La propiedad 'technologies' en Project es la que se usa para la relación.
    @ManyToMany(mappedBy = "technologies")
    private @Valid List<Project> projects;
}