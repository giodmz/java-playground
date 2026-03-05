package dataaccess.libraryapi;

import dataaccess.libraryapi.model.Autor;
import dataaccess.libraryapi.repository.AutorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class LibraryapiApplication {

	public static void main(String[] args) {

		var context = SpringApplication.run(LibraryapiApplication.class, args);

	}


}
