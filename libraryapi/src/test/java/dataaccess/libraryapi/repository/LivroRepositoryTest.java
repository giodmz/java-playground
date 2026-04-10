package dataaccess.libraryapi.repository;

import dataaccess.libraryapi.model.Autor;
import dataaccess.libraryapi.model.Livro;
import dataaccess.libraryapi.model.enums.GeneroLivro;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
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

    @Test
    public void atualizarAutorDoLivro(){
        UUID id = UUID.fromString("2c3eeac6-ceba-407e-a5fa-9980dd2964d3");
        var livroParaAtualizar = livroRepository.findById(id).orElse(null);

        UUID idAutor = UUID.fromString("a8c4b612-4faa-45fb-86d1-41b83122c722");
        var novoAutorLivro = autorRepository.findById(idAutor);

        livroParaAtualizar.setAutor(novoAutorLivro.get());

        livroRepository.save(livroParaAtualizar);

        System.out.println("Novo autor do livro (" + livroParaAtualizar.getTitulo() + "): " + livroParaAtualizar.getAutor().getNome());

    }

    @Test
    // @Transactional // Transactional vai abrir uma transação para que o autor possa ser buscado mesmo// com o mét.odo LAZY de chamada
    public void findAutorDoLivro(){
        UUID id = UUID.fromString("40350e70-8be3-4b22-8ec2-164a143708ad");
        Livro livro = livroRepository.findById(id).orElse(null);

        System.out.println("Autor: " + livro.getAutor().getNome() + " | Livro: " + livro.getTitulo());
    }

    @Test
    public void findLivrosDoAutor(){
        UUID id = UUID.fromString("f14abc23-33c6-44be-a1a1-1e5f09fbca27");
        Autor autor = autorRepository.findById(id).orElse(null);

        List<Livro> livrosLista = livroRepository.findByAutor(autor);
        autor.setLivros(livrosLista);

        autor.getLivros().forEach(System.out::println);
    }

    @Test
    public void findLivroPeloTitulo() {
        List<Livro> livro = livroRepository.findByTitulo("Resident Evil");
        livro.forEach(System.out::println);
    }

    @Test
    public void findLivroPeloIsbn(){
        List<Livro> livro = livroRepository.findByIsbn("77771-22222");
        livro.forEach(System.out::println);
    }

    @Test
    public void findLivroPeloTituloEIsbn(){
        var titulo = "Resident Evil";
        var isbn = "19402-93281";

        List<Livro> livro = livroRepository.findByTituloAndIsbn(titulo, isbn);
        livro.forEach(System.out::println);

    }

    @Test
    public void findLivroDataAndPreco(){
        var data = LocalDate.of(1998,03,21);
        var preco = BigDecimal.valueOf(100);

        List<Livro> livro = livroRepository.findByDataPublicacaoAndPreco(data, preco);
        livro.forEach(System.out::println);
    }


}
