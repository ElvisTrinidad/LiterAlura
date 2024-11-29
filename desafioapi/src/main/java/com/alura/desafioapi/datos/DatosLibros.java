package com.alura.desafioapi.datos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

public class DatosLibros {

    @JsonAlias("title") private String titulo;

    @JsonAlias("authors") private List<DatosAutor> autor;

    @JsonAlias("languages") private List<String> idiomas;

    @JsonAlias("download_count") private Double numeroDeDescargas;

    @Override   // ccon record no sobreescribes @override
    public String toString(){      //estos son los datos que imprime Datos Libros despues d libro encontrado
        return "DatosLibros[Titulo= " + titulo + ", Autor= " + autor + ", Idiomas= " + idiomas + ", numeroDeDescargas= " + numeroDeDescargas + "]";
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<DatosAutor> getAutor() {
        return autor;
    }

    public void setAutor(List<DatosAutor> autor) {
        this.autor = autor;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }


}