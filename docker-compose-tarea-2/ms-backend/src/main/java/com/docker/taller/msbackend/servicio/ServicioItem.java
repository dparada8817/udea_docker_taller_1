package com.docker.taller.msbackend.servicio;

import com.docker.taller.msbackend.modelo.Item;
import com.docker.taller.msbackend.modelo.PersistenciaException;
import com.docker.taller.msbackend.repositorio.ItemRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by DavidAlexander.
 */

@Component
public class ServicioItem {


    @Autowired
    ItemRepositorio itemRepositorio;


    public Item saveItem(Item item) throws PersistenciaException  {

        Item save = itemRepositorio.save(item);
        if(save!=null){
        System.out.println(save);
        return save;
        }else{
            throw new PersistenciaException("Error al guardar la Factura");
        }
    }

    public List<Item> getItems() {
        List<Item> items = itemRepositorio.findAll();
        System.out.println(items);
        return items;
    }
}
