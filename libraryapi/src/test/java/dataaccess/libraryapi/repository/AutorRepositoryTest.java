package dataaccess.libraryapi.repository;

import dataaccess.libraryapi.model.Autor;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository repository;

    @Test
    void salvarAutorTest(){
        Autor autor = new Autor();

        autor.setNome("Claire Redfield");
        autor.setNacionalidade("Brasileira");
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

    // listar, deletar, deletar por id, count

    @Test
    @Transactional
    public void listarAutores(){
        List<Autor> autores = repository.findAll();
        autores.forEach(System.out::println);

    }

    @Test
    public void deletarById(){
        var id = UUID.fromString("6c7ef32e-4a29-4421-a142-fab2eb6269c9");
        repository.deleteById(id);
    }

    @Test
    public  void deletarPorObjeto(){
        var id = UUID.fromString("f2f0c83f-1e78-44ba-91cf-334d176d6379");
        Optional<Autor> autorParaDeletar = repository.findById(id);

        autorParaDeletar.ifPresent(autorEncontrado -> repository.delete(autorEncontrado));

    }

    @Test
    public void countAutores(){
        long autores = repository.count();
        System.out.println("Número de autores: " + autores);
    }

}
