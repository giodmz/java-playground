package io.github.giodmz.springarchitecture.todos;

import org.springframework.stereotype.Service;

@Service // service pode ser um @Component, o @Service é usado por motivos de semântica
public class TodoService {

    // @Autowired -> dispensável quando há um construtor
    private TodoRepository repository;
    private TodoValidator validator;
    private MailSender mailSender;

    // dependencias que o service vai receber
    public TodoService(MailSender mailSender, TodoRepository repository, TodoValidator validator) {
        this.mailSender = mailSender;
        this.repository = repository;
        this.validator = validator;
    }

    public TodoEntity salvar(TodoEntity newTodo){ // um novo to do
        validator.validar(newTodo);
        return repository.save(newTodo);
    }

    public void attStatus(TodoEntity todos){
        repository.save(todos);
        String status = todos.getConcluido() == Boolean.TRUE ? "concluído" : "não concluído";
        mailSender.enviar("Todo: " + todos.getDescricao() + " foi " + status);
    }

    public TodoEntity buscarPorId(Integer id){
        return repository.findById(id).orElse(null);
    }
}
