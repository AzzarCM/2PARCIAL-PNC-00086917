package com.uca.capas.parcial.service;

import com.uca.capas.parcial.dao.LibroDAO;
import com.uca.capas.parcial.domain.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    LibroDAO libroDAO;

    @Override
    public List<Libro> findAllLibros() throws DataAccessException {
        return libroDAO.findAllLibros();
    }

    @Override
    public void insertarLibro(Libro libro) throws DataAccessException {
        libroDAO.insertarLibro(libro);
    }
}
