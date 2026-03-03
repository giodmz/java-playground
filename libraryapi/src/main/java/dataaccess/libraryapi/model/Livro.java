package dataaccess.libraryapi.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "livro")
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

    @Column(name = "genero", length = 150, nullable = false)
    private String genero;

    @Column(name = "preco", precision = 18, scale = 2) // 18 posições 2 sendo decimais
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "id_autor") // mapeamento da coluna
    private Autor autor;
}
