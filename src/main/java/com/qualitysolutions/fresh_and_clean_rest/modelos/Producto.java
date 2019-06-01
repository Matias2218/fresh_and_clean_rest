package com.qualitysolutions.fresh_and_clean_rest.modelos;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Productos")
public class Producto  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="producto_id")
    private Long id;
    @NotEmpty(message = "El nombre no puede estar vacio")
    @Column(length = 80,nullable = false)
    private String nombre;
    @NotEmpty(message = "La descripcion no puede estar vacio")
    @Column(length = 255,nullable = false)
    private String descripcion;
    @Column(length = 250)
    private String imagen;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="marca_id")
    private Marca marca;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="categoria_id")
    private Categoria categoria;
    @NotNull
    private int stock;


    public Producto()
    {
    }
    public Producto(@NotEmpty(message = "El nombre no puede estar vacio") String nombre, @NotEmpty(message = "La descripcion no puede estar vacio") String descripcion,@NotNull Marca marca, @NotNull Categoria categoria, @NotNull int stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.categoria = categoria;
        this.stock = stock;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


}
