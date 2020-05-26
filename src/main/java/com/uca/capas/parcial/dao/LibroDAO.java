package com.uca.capas.parcial.dao;

import com.uca.capas.parcial.domain.Libro;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface LibroDAO {
    public List<Libro> findAllLibros() throws DataAccessException;

    public void insertarLibro(Libro libro) throws DataAccessException;
}
