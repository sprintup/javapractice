package com.javapractice.interactors;

import org.springframework.stereotype.Service;

import com.javapractice.domain.Request.TodoRequest;
import com.javapractice.domain.Response.TodoResponse;
import com.javapractice.gateways.ITodoRepository;
import com.javapractice.interactors.interfaces.IaddTodo;

@Service
public class AddTodoInteractor implements IaddTodo{
    private final ITodoRepository todoRepository;
    
    public AddTodoInteractor(ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public TodoResponse addTodo(TodoRequest request) {
        this.todoRepository.addTodo(
            request.todo
        );
        return new TodoResponse(request.todo);
    }
    
}
