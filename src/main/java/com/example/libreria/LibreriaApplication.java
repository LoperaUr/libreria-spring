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
public class LibreriaApplication {

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
