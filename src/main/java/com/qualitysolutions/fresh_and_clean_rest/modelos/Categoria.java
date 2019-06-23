package com.qualitysolutions.fresh_and_clean_rest.modelos;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "Categorias")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id")
    private Long id;
    @Column(length = 50, nullable = false)
    @NotEmpty(message = "La imagen no puede estar vacio")
    private String nombre;

    public Categoria() {
    }

    public Categoria(@NotEmpty(message = "La imagen no puede estar vacio") String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

