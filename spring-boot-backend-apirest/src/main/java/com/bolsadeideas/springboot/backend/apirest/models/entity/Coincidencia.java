package com.bolsadeideas.springboot.backend.apirest.models.entity;

import java.util.List;

public class Coincidencia {
    public List<String> coincidencias;

    public List<String> getCoincidencias() {
        return coincidencias;
    }

    public void setCoincidencias(List<String> coincidencias) {
        this.coincidencias = coincidencias;
    }
}
