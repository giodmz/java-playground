package dataaccess.libraryapi.repository;

import dataaccess.libraryapi.model.Autor;
import dataaccess.libraryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {

    // query method
    // select * from livro where id_autor =id
    List<Livro> findByAutor(Autor autor);

    List<Livro> findByIsbn(String isbn);

    List<Livro> findByTitulo(String titulo);

    List<Livro> findByTituloAndIsbn(String titulo, String isbn);

    List<Livro> findByDataPublicacaoAndPreco(LocalDate dataPublicacao, BigDecimal preco);
}
