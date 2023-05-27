package com.example.libreria;

import com.example.libreria.entitie.Autor;
import com.example.libreria.entitie.Editorial;
import com.example.libreria.repository.AutorRepository;
import com.example.libreria.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibreriaApplication implements CommandLineRunner {

	@Autowired
	EditorialRepository editorialRepository;

	@Autowired
	AutorRepository autorRepository;

	public static void main(String[] args) {
		SpringApplication.run(LibreriaApplication.class, args);
	}


	@Override
	public void run(String... args)  {
		Editorial editorial = new Editorial(null, "name 1", "desc 1");
		Editorial editorial2 = new Editorial(null, "name 2", "desc 2");
		editorialRepository.save(editorial);
		editorialRepository.save(editorial2);

		Autor autor = new Autor(null,"Manuel", "Gutierrez", "Low3","example1@gmail.com");
		Autor autor2 = new Autor(null,"Alejadro", "Lopera", "sample","example2@gmail.com");
		autorRepository.save(autor);
		autorRepository.save(autor2);
	}
}
