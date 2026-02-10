package io.github.giodmz.springarchitecture.todos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {

    boolean existsByDescricao(String descricao); // apenas para saber se existe, não busca o dados
    // TodoEntity findByDescricao(String descricao); // busca os dados
}
