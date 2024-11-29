package com.alura.desafioapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvierteDatos {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        //return null;
        try {
            return objectMapper.readValue(json, clase);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }
}
