package com.qualitysolutions.fresh_and_clean_rest.dao;

import com.qualitysolutions.fresh_and_clean_rest.modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IProductoDao extends JpaRepository<Producto,Long>
{

}
