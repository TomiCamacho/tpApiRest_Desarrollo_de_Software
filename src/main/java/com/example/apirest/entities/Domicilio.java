package com.example.apirest.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "domicilio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Audited
public class Domicilio extends Base {

    @Column(name = "calle")
    private String calle;

    @Column(name="numero")
    private int numero;

    @ManyToOne(optional = false) //Siempre el domicilio va a tener una localidad
    @JoinColumn(name = "fk_localidad")
    private Localidad localidad;

}
