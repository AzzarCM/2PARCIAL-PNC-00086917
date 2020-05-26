package com.uca.capas.parcial.dao;

import com.uca.capas.parcial.domain.Libro;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class LibroDAOImpl implements LibroDAO {

    @PersistenceContext(unitName = "capas")
    private EntityManager entityManager;

    @Override
    public List<Libro> findAllLibros() throws DataAccessException {
        StringBuffer sb = new StringBuffer();
        sb.append("select * from public.cat_libro");
        Query query = entityManager.createNativeQuery(sb.toString(), Libro.class);
        List<Libro> listaLibros = query.getResultList();

        return listaLibros;
    }

    @Override
    @Transactional
    public void insertarLibro(Libro libro) throws DataAccessException {

        try {
            if(libro.getId_libro() == null) {
                entityManager.persist(libro);
            }else {
                entityManager.merge(libro);
                entityManager.flush();
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
