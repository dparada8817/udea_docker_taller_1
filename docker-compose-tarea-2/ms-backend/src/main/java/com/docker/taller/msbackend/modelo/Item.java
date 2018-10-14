package com.docker.taller.msbackend.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by DavidAlexander on 05/12/2017.
 */
@Entity
public class Item {
    @Id
    @GeneratedValue
    private Long idItem;
    private String nombre;

    public Item() {
    }


    public Item(String producto) {
        this.nombre = producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Item{" +
                "idItem=" + idItem +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
