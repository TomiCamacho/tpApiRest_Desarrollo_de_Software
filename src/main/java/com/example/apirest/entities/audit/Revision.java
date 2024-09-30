package com.example.apirest.entities.audit;

import com.example.apirest.config.CustomRevisionListener;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import java.io.Serializable;
import java.util.Date;

// Marca la clase como una entidad JPA
@Entity
// Define el nombre de la tabla en la base de datos
@Table(name = "REVISION_INFO")
// Indica que esta entidad será gestionada por CustomRevisionListener para auditoría
@RevisionEntity(CustomRevisionListener.class)
// Genera automáticamente getters, setters, toString, equals y hashCode con Lombok
@Data
public class Revision implements Serializable {

    // Marca el campo id como la clave primaria
    @Id
    // Define la estrategia de generación de valores para la clave primaria
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "revision_seq")
    // Configura el generador de secuencias para la clave primaria (es referenciado arriba por @GeneratedValue)
    @SequenceGenerator(name = "revision_seq", sequenceName = "rbac.seq_revision_id")
    // Marca el campo id como el número de revisión en Envers
    @RevisionNumber
    private int id;

    // Define la columna para almacenar la fecha de la revisión
    @Column(name = "REVISION_DATE")
    // Especifica que el campo date debe ser tratado como un TIMESTAMP en la base de datos
    @Temporal(TemporalType.TIMESTAMP)
    // Marca el campo date como el timestamp de la revisión en Envers
    @RevisionTimestamp
    private Date date;

}

// Este código define una entidad Revision que se utiliza para almacenar información de auditoría en la base de datos.
// Utiliza Envers para gestionar las revisiones y Lombok para generar automáticamente métodos comunes.
// La clase CustomRevisionListener se encarga de personalizar el comportamiento de auditoría.