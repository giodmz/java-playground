package dataaccess.libraryapi.repository;

import dataaccess.libraryapi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {

    List<Autor> findByNomeAndDataNascimento(String nome, LocalDate dataNascimento);

}
