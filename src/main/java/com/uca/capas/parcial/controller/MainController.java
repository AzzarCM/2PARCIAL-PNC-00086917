package com.uca.capas.parcial.controller;

import com.uca.capas.parcial.domain.Categoria;
import com.uca.capas.parcial.domain.Libro;
import com.uca.capas.parcial.service.CategoriaService;
import com.uca.capas.parcial.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private LibroService libroService;
    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping("/ingresarCategoria")
    public ModelAndView categoria(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("categoria", new Categoria());
        mav.setViewName("categoria");
        return mav;
    }
    @PostMapping("/ingcategoria")
    public ModelAndView insertarCat(@Valid @ModelAttribute Categoria categoria, BindingResult result){
        ModelAndView mav = new ModelAndView();

        if(result.hasErrors()){
            mav.setViewName("categoria");
        }else{
            try {
                String strCategoria = "La categoria ha sido guardada!";
                categoriaService.insertarCategoria(categoria);
                mav.addObject("strCategoria",strCategoria);
                mav.setViewName("index");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return mav;
    }

    @RequestMapping("/ingresarLibro")
    public ModelAndView libros(){
        ModelAndView mav = new ModelAndView();
        List<Categoria> categorias;
        categorias = categoriaService.allCategorias();
        mav.addObject("categorias", categorias);
        mav.addObject("libro", new Libro());
        mav.setViewName("libro");
        return mav;
    }

    @RequestMapping("/inglibro")
    public ModelAndView insertarLibro(@Valid @ModelAttribute Libro libro, BindingResult result){
        ModelAndView mav = new ModelAndView();
        List<Categoria> categorias = null;
        if(result.hasErrors()){
            categorias = categoriaService.allCategorias();
            mav.addObject("categorias",categorias);
            mav.setViewName("libro");
        }else{
            Date date = new Date();
            libro.setfIngreso(date);
            try {
                String strLibro = "El libro ha sido guardado!";
                libroService.insertarLibro(libro);
                mav.addObject("strlibro", strLibro);
                mav.setViewName("index");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return mav;
    }

    @RequestMapping("/index")
    public ModelAndView initMain() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }


    @PostMapping("/libros")
    public ModelAndView lista(){
        ModelAndView mav = new ModelAndView();
        List<Libro> libros = null;
        try{
            libros = libroService.findAllLibros();
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("libros", libros);
        mav.setViewName("lista");
        return mav;
    }



}
