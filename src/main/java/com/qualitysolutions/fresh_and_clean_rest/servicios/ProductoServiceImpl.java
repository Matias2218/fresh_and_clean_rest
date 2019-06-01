package com.qualitysolutions.fresh_and_clean_rest.servicios;


import com.qualitysolutions.fresh_and_clean_rest.dao.ICategoriaDao;
import com.qualitysolutions.fresh_and_clean_rest.dao.IMarcaDao;
import com.qualitysolutions.fresh_and_clean_rest.dao.IProductoDao;
import com.qualitysolutions.fresh_and_clean_rest.modelos.Categoria;
import com.qualitysolutions.fresh_and_clean_rest.modelos.Marca;
import com.qualitysolutions.fresh_and_clean_rest.modelos.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    IProductoDao productoDao;
    @Autowired
    ICategoriaDao categoriaDao;
    @Autowired
    IMarcaDao marcaDao;

    @Override
    @Transactional(readOnly = true)
    public Page<Producto> findAll(Pageable pageable) {
        return productoDao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {

        return productoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Marca> findAllMarca() {
        return (List<Marca>) marcaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> findAllCategorias() {
        return (List<Categoria>) categoriaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Long id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional()
    public Producto save(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    @Transactional()
    public void deleteById(Long id) {
        productoDao.deleteById(id);
    }
}
