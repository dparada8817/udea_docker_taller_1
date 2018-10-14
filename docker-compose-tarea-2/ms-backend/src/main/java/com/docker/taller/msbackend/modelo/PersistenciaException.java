package com.docker.taller.msbackend.modelo;

/**
 * Created by DavidAlexander on 08/12/2017.
 */
public class PersistenciaException extends Exception {

    public PersistenciaException(String mensaje){
        super(mensaje);
    }
}
