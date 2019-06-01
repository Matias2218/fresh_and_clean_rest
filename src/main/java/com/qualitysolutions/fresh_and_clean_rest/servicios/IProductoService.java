package com.qualitysolutions.fresh_and_clean_rest.servicios;


import com.qualitysolutions.fresh_and_clean_rest.modelos.Categoria;
import com.qualitysolutions.fresh_and_clean_rest.modelos.Marca;
import com.qualitysolutions.fresh_and_clean_rest.modelos.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductoService{
    Page<Producto> findAll(Pageable pageable);
    List<Producto> findAll();
    List<Marca> findAllMarca();
    List<Categoria> findAllCategorias();
    Producto findById(Long id);
    Producto save(Producto producto);
    void deleteById(Long id);
}
