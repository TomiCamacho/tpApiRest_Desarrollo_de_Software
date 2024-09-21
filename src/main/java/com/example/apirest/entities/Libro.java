package com.example.apirest.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "libro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Audited
public class Libro extends Base {

    @Column(name="titulo")
    private String titulo;

    @Column(name="fecha")
    private int fecha;

    @Column(name="genero")
    private String genero;

    @Column(name="paginas")
    private int paginas;

    @ManyToMany(cascade = CascadeType.REFRESH) //Si persisto un libro se actualiza si hay cambios en los autores
    @JoinTable(
            name="libro_autor",
            joinColumns = @JoinColumn(name="libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    @Builder.Default
    private Set<Autor> autores = new HashSet<Autor>();
}
