package com.uca.capas.parcial.service;

import com.uca.capas.parcial.dao.CategoriaDAO;
import com.uca.capas.parcial.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService  {
    @Autowired
    CategoriaDAO categoriaDAO;

    @Override
    public List<Categoria> allCategorias() throws DataAccessException {
        return categoriaDAO.allCategorias();
    }

    @Override
    public void insertarCategoria(Categoria categoria) throws DataAccessException {
        categoriaDAO.insertarCategoria(categoria);
    }
}
