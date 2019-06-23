package com.qualitysolutions.fresh_and_clean_rest;

import com.qualitysolutions.fresh_and_clean_rest.dao.ICategoriaDao;
import com.qualitysolutions.fresh_and_clean_rest.modelos.Categoria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitTestJPA {

    @Autowired
    ICategoriaDao categoriaDao;

    @Autowired
    TestEntityManager entityManager;

    @Test
    public void testSaveCategoria()
    {
        Categoria categoria = new Categoria("Cabello");
        categoria=entityManager.persist(categoria);
        Categoria categoriaDesdeBD= categoriaDao.findById(categoria.getId()).orElse(null);
        assertThat(categoriaDesdeBD).isEqualTo(categoria);
    }

    @Test
    public void testGetCategoria()
    {
        Categoria categoria = new Categoria("Cabello");
        categoria=entityManager.persist(categoria);
        Categoria categoriaDesdeBD= categoriaDao.findById(categoria.getId()).orElse(null);
        assertThat(categoriaDesdeBD).isEqualTo(categoria);
    }

    @Test
    public void testUpdateCategoria()
    {
        Categoria categoria = new Categoria("Cabello");
        categoria=entityManager.persist(categoria);
        categoria.setNombre("Pies");
        entityManager.persist(categoria);
        Categoria categoriaDesdeBD= categoriaDao.findById(categoria.getId()).orElse(null);
        assertThat(categoriaDesdeBD.getNombre()).isEqualTo("Pies");
    }

    @Test
    public void testDeleteCategoria()
    {
        Categoria categoria = new Categoria("Cabello");
        categoria=entityManager.persist(categoria);
        categoriaDao.delete(categoria);
    }



}
