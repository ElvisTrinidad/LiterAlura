package com.alura.desafioapi.principal;

import com.alura.desafioapi.datos.Datos;
import com.alura.desafioapi.datos.DatosLibros;
import com.alura.desafioapi.service.ConsumoAPI;
import com.alura.desafioapi.service.ConvierteDatos;
import org.apache.logging.log4j.util.PropertySource;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Principal {

    private Scanner teclado = new Scanner(System.in);

    private ConsumoAPI consumoApi = new ConsumoAPI();

    private static final String URL_BASE = "https://gutendex.com/books/";

    private ConvierteDatos conversor = new ConvierteDatos();

    public ConsumoAPI getConsumoApi() {
        return consumoApi;
    }

    public void setConsumoApi(ConsumoAPI consumoApi) {
        this.consumoApi = consumoApi;
    }

    public ConvierteDatos getConversor() {
        return conversor;
    }

    public void setConversor(ConvierteDatos conversor) {
        this.conversor = conversor;
    }

    public void muestraElMenu() {

        var json = consumoApi.obtenerDatos(URL_BASE);
        System.out.println(json);

        var datos = conversor.obtenerDatos(json, Datos.class);
        System.out.println(datos);

        //Top 10 libros mas descargados
        System.out.println("Top 10 libros más descargados: ");
        datos.getResultados().stream()
                .sorted(Comparator.comparing(DatosLibros::getNumeroDeDescargas).reversed())
            //    .peek(e -> System.out.println("Segunda Ordenación (M>m)" + e))
                .map(l -> l.getTitulo().toUpperCase())
            //    .peek(e -> System.out.println("Tercer filtro Mayúscula (m>M)" + e))
                .limit(10)
                .forEach(System.out::println);

        //Busqueda de libros por nombre
        System.out.println("Ingrese el nombre del libro que desea buscar: ");
       var tituloLibro = teclado.nextLine();
       json = consumoApi.obtenerDatos(URL_BASE+"?search=" + tituloLibro.replace(" ", "+"));
       var datosBusqueda = conversor.obtenerDatos(json, Datos.class);

       Optional<DatosLibros> libroBuscado = datosBusqueda.getResultados().stream()
               .filter(l -> l.getTitulo().toUpperCase().contains(tituloLibro.toUpperCase()))
               .findFirst();

       if (libroBuscado.isPresent()) {
           System.out.println(("Libro encontrado."));
           System.out.println(libroBuscado.get());  //get trae todo s los datos
       }else {
           System.out.println("Libro no encontrado.");
       }

        //RECOLECTANDO ESTADISTICAS
        DoubleSummaryStatistics estadistica = datos.getResultados().stream()
                .filter(d -> d.getNumeroDeDescargas() > 0)
                .collect(Collectors.summarizingDouble(DatosLibros::getNumeroDeDescargas));
        //System.out.println("\nEstadisticas totales: " + estadistica);//calcula todas las estadisticas
        // aqui personalizamos la salida
        System.out.println("\nMedia de las descargas: " + estadistica.getAverage());
        System.out.println("Libro más descargado: " + estadistica.getMax());
        System.out.println("Libro menos descargado: " + estadistica.getMin());
        System.out.println("Cantidad de descargas: " + estadistica.getCount());
   }
}