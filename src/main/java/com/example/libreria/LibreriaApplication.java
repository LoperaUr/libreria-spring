package com.example.libreria;

import com.example.libreria.entitie.Autor;
import com.example.libreria.entitie.Categoria;
import com.example.libreria.entitie.Editorial;
import com.example.libreria.entitie.Ubicacion;
import com.example.libreria.repository.AutorRepository;
import com.example.libreria.repository.CategoriaRepository;
import com.example.libreria.repository.EditorialRepository;
import com.example.libreria.repository.UbicacionRepository;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibreriaApplication implements CommandLineRunner {

    @Autowired
    private EditorialRepository editorialRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private UbicacionRepository ubicacionRepository;

    public static void main(String[] args) {
        SpringApplication.run(LibreriaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Editorial editorial = new Editorial(null, "Editorial 1", "desc 1");
        Editorial editorial2 = new Editorial(null, "Editorial 2", "desc 2");
        editorialRepository.save(editorial);
        editorialRepository.save(editorial2);

        Autor autor = new Autor(null, "autorNombre1", "autorApellido1", "Colombia", "pseudo1", "email1@gmail.com");
        Autor autor2 = new Autor(null, "autorNombre2", "autorApellido2", "Colombia", "pseudo2", "email2@gmail.com");
        autorRepository.save(autor);
        autorRepository.save(autor2);

        Categoria categoria = new Categoria(null, "categoria 1", "desc 1");
        Categoria categoria2 = new Categoria(null, "categoria 2", "desc 2");
        categoriaRepository.save(categoria);
        categoriaRepository.save(categoria2);

        Ubicacion ubicacion = new Ubicacion(null, "Piso 1", "Salon 1", "Estante 1");
        Ubicacion ubicacion2 = new Ubicacion(null, "Piso 2", "Salon 2", "Estante 2");
        ubicacionRepository.save(ubicacion);
        ubicacionRepository.save(ubicacion2);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Swagger docs")
                        .version("1.0")
                        .description("Documentation Libreria")
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
