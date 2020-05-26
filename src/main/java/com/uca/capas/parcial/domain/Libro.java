package com.uca.capas.parcial.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(schema ="public", name ="cat_libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="c_libro")
    private Integer id_libro;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="c_categoria")
    private Categoria categoria;

    @Size(message = "El campo no debe contener mas de 500 caracteres", max = 500)
    @NotEmpty(message = "Este campo no puede estar vacio")
    @Column(name="s_titulo")
    private String titulo;

    @Size(message = "El campo no debe contener mas de 150 caracteres", max = 150)
    @NotEmpty(message = "Este campo no puede estar vacio")
    @Column(name="s_autor")
    private String autor;

    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm")
    @Column(name="f_ingreso")
    private Date fIngreso;

    @Column(name = "b_estado")
    private Boolean estado;

    @Size(message = "El campo no debe contener mas de 10 caracteres", max = 10)
    @Column(name = "s_isbn")
    private String isbn;


    public Libro() {}

    public String getEstadoDelegate(){
        if(this.estado == null) return "";
        else{
            return estado == true ? "Activo" : "Inactivo";
        }
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getIsbn() {
        return isbn;
    }
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getId_libro() {
        return id_libro;
    }

    public void setId_libro(Integer id_libro) {
        this.id_libro = id_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getfIngreso() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        String strFecha = formato.format(fIngreso);
        return strFecha;
    }

    public void setfIngreso(Date fIngreso) {
        this.fIngreso = fIngreso;
    }
}
