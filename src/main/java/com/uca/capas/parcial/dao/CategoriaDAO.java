package com.uca.capas.parcial.dao;

import com.uca.capas.parcial.domain.Categoria;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface CategoriaDAO {

    public List<Categoria> allCategorias() throws DataAccessException;

    public void insertarCategoria(Categoria categoria) throws DataAccessException;

}
