package com.docker.taller.msbackend.controller;


import com.docker.taller.msbackend.modelo.Item;
import com.docker.taller.msbackend.modelo.PersistenciaException;
import com.docker.taller.msbackend.servicio.ServicioItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**facturaEntities
 * Created by DavidAlexander on 05/12/2017.
 */
@RestController
public class ItemController {


    @Autowired
    ServicioItem servicioItem;


    @RequestMapping(method = RequestMethod.POST, value = "/item")
    public ResponseEntity<Object> crearFactura(@RequestBody Item item){
        ResponseEntity<Object> respuesta = null;
        try{
            Item idFactura = servicioItem.saveItem(item);
            respuesta = new ResponseEntity<Object>(idFactura, HttpStatus.ACCEPTED);
        }catch (PersistenciaException e){
            respuesta = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return respuesta;
    }

    @RequestMapping(value = "/item",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Item>> listItems(){
        List<Item> facturas = servicioItem.getItems();
        return new ResponseEntity<List<Item>>(facturas, HttpStatus.OK);
    };
}
