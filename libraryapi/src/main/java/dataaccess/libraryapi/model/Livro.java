package dataaccess.libraryapi.model;

import dataaccess.libraryapi.model.enums.GeneroLivro;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "livro")
@Data
@ToString(exclude = "autor")
public class Livro {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "isbn", length = 20, nullable = false)
    public String isbn;

    @Column(name = "titulo", length = 150, nullable = false)
    public String titulo;

    @Column(name = "data_publicacao")
    private LocalDate dataPublicacao;

    @Enumerated(EnumType.STRING) // evitar problemas caso a posição mude
    @Column(name = "genero", length = 30, nullable = false)
    private GeneroLivro genero;

    @Column(name = "preco", precision = 18, scale = 2) // 18 posições 2 sendo decimais
    private BigDecimal preco;
    // private Double preco;

    @ManyToOne(// cascade = CascadeType.ALL
            // fetch = FetchType.EAGER -> EAGER é o padrão, vai buscar tudo
            fetch = FetchType.LAZY // Lazy só vai buscar o que for necessário, ou seja, se buscar um livro não vai buscar o autor também
    )
    @JoinColumn(name = "id_autor") // mapeamento da coluna
    private Autor autor;
}
