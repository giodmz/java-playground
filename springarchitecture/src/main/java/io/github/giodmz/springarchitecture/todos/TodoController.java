package io.github.giodmz.springarchitecture.todos;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("todos")
public class TodoController {

    private TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todo) {
        try {
        return this.service.salvar(todo);
        } catch (IllegalArgumentException ex) {
            var msgError = ex.getMessage();
            // throw new ResponseStatusException(HttpStatus.BAD_REQUEST, msgError); // quando tem erro no cliente
            throw new ResponseStatusException(HttpStatus.CONFLICT, msgError); // quando há um conflito (ex: codigo ja cadastrado)
        }
    }

    @PutMapping("{id}")
    public void attStatus(@PathVariable("id") Integer id, @RequestBody TodoEntity todo){
        todo.setId(id);
        service.attStatus(todo);
    }

    @GetMapping("{id}")
    public TodoEntity buscar(@PathVariable("id") Integer id) {
        return service.buscarPorId(id);
    }

}
