package com.uca.capas.parcial.service;


import com.uca.capas.parcial.domain.Categoria;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface CategoriaService {

    public List<Categoria> allCategorias() throws DataAccessException;

    public void insertarCategoria(Categoria categoria) throws DataAccessException;
}
