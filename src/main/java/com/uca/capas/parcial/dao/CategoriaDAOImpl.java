package com.uca.capas.parcial.dao;

import com.uca.capas.parcial.domain.Categoria;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CategoriaDAOImpl implements CategoriaDAO {

    @PersistenceContext(unitName = "capas")
    private EntityManager entityManager;

    @Override
    public List<Categoria> allCategorias() throws DataAccessException {
        StringBuffer sb = new StringBuffer();
        sb.append("select * from public.cat_categoria");
        Query query = entityManager.createNativeQuery(sb.toString(), Categoria.class);
        List<Categoria> categoriaList = query.getResultList();

        return categoriaList;
    }

    @Override
    @Transactional
    public void insertarCategoria(Categoria categoria) throws DataAccessException {
        try {
            if(categoria.getId_categoria() == null) {
                entityManager.persist(categoria);
            }else {
                entityManager.merge(categoria);
                entityManager.flush();
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
