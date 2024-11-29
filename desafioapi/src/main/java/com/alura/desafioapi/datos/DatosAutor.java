package com.alura.desafioapi.datos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class DatosAutor{
        @JsonAlias("name")private String nombre;
        @JsonAlias("birth_year")private Integer fechaDeNacimiento;

@Override       // ccon record no sobreescribes @override
public String toString(){       //estos son los datos que imprime Datos Libros despues d libro encontrado
        return "Nombre= " + nombre + ", Fecha de Nacimiento= " + fechaDeNacimiento;
}

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public Integer getFechaDeNacimiento() {
                return fechaDeNacimiento;
        }

        public void setFechaDeNacimiento(Integer fechaDeNacimiento) {
                this.fechaDeNacimiento = fechaDeNacimiento;
        }
}
