package com.proyecto1.proyecto1.persistance.models;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import javax.validation.Valid;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "developers")
public class Developer {

    // Identificador único del desarrollador
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dev_id")
    private Integer devId;

    // Nombre del desarrollador 
    @NotBlank(message = "El nombre del proyecto no puede ser nulo ni vacío")
    @Column(name = "dev_name")
    private String devName;

    // Apellido del desarrollador 
    @NotBlank(message = "El apellido del proyecto no puede ser nulo ni vacío")
    @Column(name = "dev_surname")
    private String devSurname;

    // Correo electrónico del desarrollador (debe ser válido)
    @NotBlank(message = "El correo electrónico no puede ser nulo ni vacío")
    @Email(message = "El correo electrónico no es válido")
    @Column(name = "email")
    private String email;

    // URL de LinkedIn del desarrollador (debe ser válida y comenzar con "https")
    @NotBlank(message = "La URL de LinkedIn no puede ser nula ni vacía o contener espacios")
    @URL(protocol = "https", message = "La URL de LinkedIn debe ser segura y comenzar con 'https'")
    private String linkedinUrl;

    // URL de GitHub del desarrollador (debe ser válida y comenzar con "https")
    @NotBlank(message = "La URL de GitHub no puede ser nula ni vacía o contener espacios")
    @URL(protocol = "https", message = "La URL de GitHub debe ser segura y comenzar con 'https'")
    private String githubUrl;

    // Correo electrónico alternativo del desarrollador (debe ser válido)
    @NotBlank(message = "El correo electrónico no puede ser nulo ni vacío")
    @Email(message = "El correo electrónico no es válido")
    @Column(name = "dev_email")
    private String dev_email;

    // Relación de muchos a muchos con los proyectos
    @ManyToMany(mappedBy = "developers")
    @JsonBackReference("project-developer")
    private @Valid List<Project> projects;

}