package com.alura.desafioapi.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.alura.desafioapi.principal.Principal;


@SpringBootApplication
public class DesafioapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafioapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal();
		principal.muestraElMenu();

	}
}
