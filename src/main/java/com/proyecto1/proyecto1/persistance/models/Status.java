package com.proyecto1.proyecto1.persistance.models;


import java.util.List;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "status")
public class Status {

    // Identificador único para cada estado, mapeado a la columna 'status_id' en la base de datos.
    @Id
    @Column(name = "status_id")
    private Integer statusId;

    // Nombre del estado del proyecto, mapeado a la columna 'status_name'.
    @Column(name = "status_name")
    private String statusName;

    // Relación uno a muchos con la entidad Project (un estado puede estar asociado a varios proyectos).
    // La propiedad 'status' en Project es la que se usa para la relación.
    @OneToMany(mappedBy = "status") 
    @JsonBackReference  // Evita que se genere un ciclo infinito al serializar.
    private List<Project> projects;

}
