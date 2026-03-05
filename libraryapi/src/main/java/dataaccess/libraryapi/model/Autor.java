package dataaccess.libraryapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "autor")
@Data
@ToString
public class Autor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "nacionalidade", length = 50, nullable = false)
    private String nacionalidade;

    @OneToMany(mappedBy = "autor") // está mapeado pela propriedade autor // diz que essa entidade não tem essa coluna apenas está mapeando
    private List<Livro> livros;

    /* Não é necessário mapear as columns, Spring faz isso automaticamente quando os nomes são iguais
    aos da database
    * */

}
