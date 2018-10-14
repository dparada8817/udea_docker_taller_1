package com.docker.taller.msbackend.repositorio;

import com.docker.taller.msbackend.modelo.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Created by DavidAlexander on 05/12/2017.
 */
@Component
public interface ItemRepositorio extends JpaRepository<Item, Long> {
}
