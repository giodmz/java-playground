package dataaccess.libraryapi.repository;

import dataaccess.libraryapi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository repository;

    @Test
    void salvarAutorTest(){
        Autor autor = new Autor();

        autor.setNome("Autor 2");
        autor.setNacionalidade("Brasileiro");
        autor.setDataNascimento(LocalDate.of(2002, 5, 15));

        var autorSalvo = repository.save(autor);
        System.out.println("Autor salvo: " + autorSalvo);
    }

    @Test
    void atualizarAutorTest() {
        var id = UUID.fromString("f14abc23-33c6-44be-a1a1-1e5f09fbca27");

        Optional<Autor> possivelAutor = repository.findById(id);

        if(possivelAutor.isPresent()) {

            var autorEncontrado = possivelAutor.get();
            autorEncontrado.setNome("Leon Kennedy");
            repository.save(autorEncontrado);

        }


    }

}
