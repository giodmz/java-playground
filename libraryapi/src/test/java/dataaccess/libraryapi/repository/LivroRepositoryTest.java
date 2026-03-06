package dataaccess.libraryapi.repository;

import dataaccess.libraryapi.model.Autor;
import dataaccess.libraryapi.model.Livro;
import dataaccess.libraryapi.model.enums.GeneroLivro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class LivroRepositoryTest {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    AutorRepository autorRepository;

    @Test
    public void salvarTest(){
        Livro livro = new Livro();
        livro.setIsbn("12345-54321");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setDataPublicacao(LocalDate.of(1999, 8, 22));
        livro.setTitulo("Título Teste 2");

        Autor autor = autorRepository
                .findById(UUID.fromString("f14abc23-33c6-44be-a1a1-1e5f09fbca27"))
                .orElse(null);

        livro.setAutor(autor);

        livroRepository.save(livro);
        System.out.println("Livro salvo: " + livro.getTitulo() + " | " + autor.getNome());

    }

    // cascade vai salvar o livro e o autor logo em seguida sem necessidade de chamar os 2 (pode ser burrice usar isso)
    @Test
    public void salvarTestCascade(){
        Livro livro = new Livro();
        livro.setIsbn("12345-54321");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.MISTERIO);
        livro.setDataPublicacao(LocalDate.of(2010, 8, 22));
        livro.setTitulo("Título Teste 3");

        Autor autor = new Autor();
        autor.setNome("Jill Valentine");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1994, 5, 13));

        livro.setAutor(autor);

        livroRepository.save(livro);

        System.out.println("Autor salvo: " + autor.getNome() + " | " + livro.getTitulo());
    }
}
