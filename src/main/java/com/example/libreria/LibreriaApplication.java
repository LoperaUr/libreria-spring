package com.example.libreria;

import com.example.libreria.entitie.Editorial;
import com.example.libreria.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibreriaApplication implements CommandLineRunner {

	@Autowired
	EditorialRepository editorialRepository;

	public static void main(String[] args) {
		SpringApplication.run(LibreriaApplication.class, args);
	}


	@Override
	public void run(String... args)  {
		Editorial editorial = new Editorial(null, "name 1", "desc 1");
		Editorial editorial2 = new Editorial(null, "name 2", "desc 2");
		editorialRepository.save(editorial);
		editorialRepository.save(editorial2);

	}
}
