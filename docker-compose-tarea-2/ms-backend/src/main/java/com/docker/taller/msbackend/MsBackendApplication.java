package com.docker.taller.msbackend;

import com.docker.taller.msbackend.modelo.Item;
import com.docker.taller.msbackend.repositorio.ItemRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBackendApplication.class, args);
	}
}
