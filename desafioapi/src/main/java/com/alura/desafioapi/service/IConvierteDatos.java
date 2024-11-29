package com.alura.desafioapi.service;

public interface IConvierteDatos {
    //datos genericos <T> T
    <T> T obtenerDatos(String json, Class<T> clase);
}
