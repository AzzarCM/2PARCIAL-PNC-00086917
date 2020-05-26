package com.uca.capas.parcial.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(schema="public",name="cat_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="c_categoria")
    private Integer id_categoria;

    @Size(message = "El campo no debe contener mas de 50 caracteres", max = 50)
    @NotEmpty(message = "Este campo no puede estar vacio")
    @Column(name="s_categoria")
    private String s_categoria;


    @OneToMany(mappedBy="categoria",fetch= FetchType.EAGER)
    private List<Libro> libro;

    public Categoria(){}

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getS_categoria() {
        return s_categoria;
    }

    public void setS_categoria(String s_categoria) {
        this.s_categoria = s_categoria;
    }

    public List<Libro> getLibro() {
        return libro;
    }

    public void setLibro(List<Libro> libro) {
        this.libro = libro;
    }
}
