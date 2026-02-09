package io.github.giodmz.springarchitecture.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    // @Autowired -> dispensável quando há um construtor
    private TodoRepository repository;

    public TodoService(TodoRepository todoRepository) { // dependencias que o service vai receber
        this.repository = todoRepository;
    }

    public TodoEntity salvar(TodoEntity newTodo){ // um novo to do
        return repository.save(newTodo);
    }
}
