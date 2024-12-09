package com.proyecto1.proyecto1.persistance.models;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Data
@Table(name = "projects")
public class Project {
  
  // Identificador único del proyecto, generado automáticamente.
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "project_id")
  private Integer projectId;

  // Nombre del proyecto, no puede ser nulo ni vacío.
  @NotBlank(message = "El nombre del proyecto no puede ser nulo ni vacío")
  @Column(name = "project_name")
  private String projectName;

  // Descripción del proyecto, no puede ser nula ni vacía.
  @NotBlank(message = "La descripción del proyecto no puede ser nula ni vacía")
  @Column(name = "description")
  private String description;

  // Fecha de inicio del proyecto, no puede ser nula ni vacía.
  @NotBlank(message = "La fecha de inicio del proyecto no puede ser nula ni vacía")
  @DateTimeFormat(pattern = "yyyy-mm-dd")  // Formato de fecha
  @Column(name = "start_date")
  private LocalDate startDate;

  // Fecha de fin del proyecto, no puede ser nula ni vacía.
  @NotBlank(message = "La fecha de fin del proyecto no puede ser nula ni vacía")
  @DateTimeFormat(pattern = "yyyy-mm-dd")  // Formato de fecha
  @Column(name = "end_date")
  private LocalDate endDate;

  // URL del repositorio, debe ser segura (comenzar con 'https') y no contener espacios.
  @NotBlank(message = "La URL del repositorio no puede ser nula ni vacía o contener espacios")
  @URL(protocol = "https", message = "La URL del repositorio debe ser segura y comenzar con 'https'")
  @Column(name = "repository_url")
  private String repositoryUrl;

  // URL del demo, debe ser segura (comenzar con 'https') y no contener espacios.
  @NotBlank(message = "La URL del repositorio no puede ser nula ni vacía o contener espacios")
  @URL(protocol = "https", message = "La URL del repositorio debe ser segura y comenzar con 'https'")
  @Column(name = "demo_url")
  private String demoUrl;

  // URL de la imagen del proyecto, no puede ser vacía.
  @NotBlank(message = "La URL de la imagen no puede estar vacía.")
  @Column(name = "picture")
  private String picture;

  // Relación muchos a uno con el estado del proyecto (Status).
  @ManyToOne
  @JoinColumn(name = "status_status_id")  // Clave foránea en la tabla del proyecto
  private Status status;
  
  // Relación muchos a muchos con la entidad Technology (Tecnologías utilizadas en el proyecto).
  @ManyToMany
  @JoinTable(
      name = "technologies_used_in_projects",
      joinColumns = @JoinColumn(name = "projects_project_id"),
      inverseJoinColumns = @JoinColumn(name = "technologies_tech_id")
  )
  private @Valid List<Technology> technologies;

  // Relación muchos a muchos con la entidad Developer (Desarrolladores que trabajaron en el proyecto).
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "developers_worked_on_projects",
      joinColumns = @JoinColumn(name = "projects_project_id"),
      inverseJoinColumns = @JoinColumn(name = "developers_dev_id")
  )
  private @Valid List<Developer> developers;

}