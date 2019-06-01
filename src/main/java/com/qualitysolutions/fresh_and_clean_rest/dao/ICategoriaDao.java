package com.qualitysolutions.fresh_and_clean_rest.dao;

import com.qualitysolutions.fresh_and_clean_rest.modelos.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface ICategoriaDao extends CrudRepository<Categoria,Long>
{

}
