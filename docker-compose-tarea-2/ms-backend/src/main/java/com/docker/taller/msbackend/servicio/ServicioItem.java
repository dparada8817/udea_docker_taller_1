package com.docker.taller.msbackend.servicio;

import com.docker.taller.msbackend.modelo.Item;
import com.docker.taller.msbackend.modelo.PersistenciaException;
import com.docker.taller.msbackend.repositorio.ItemRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by DavidAlexander.
 */

@Component
public class ServicioItem {

    Logger logger = Logger.getLogger("com.docker.taller.msbackend.servicio.ServicioItem");


    @Autowired
    ItemRepositorio itemRepositorio;


    public Item saveItem(Item item) throws PersistenciaException  {

        Item save = itemRepositorio.save(item);
        if(save!=null){
        System.out.println(save);
        logger.log(Level.INFO, save.toString());
        return save;
        }else{
            throw new PersistenciaException("Error al guardar el item");
        }
    }

    public List<Item> getItems() {
        List<Item> items = itemRepositorio.findAll();
        logger.log(Level.INFO, items.toString());
        return items;
    }
}
