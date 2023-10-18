package com.javapractice.interactors;

import org.springframework.stereotype.Service;

import com.javapractice.domain.Request.DeleteTodoRequest;
import com.javapractice.domain.Response.DeleteTodoResponse;
import com.javapractice.gateways.ITodoRepository;
import com.javapractice.interactors.interfaces.IdeleteTodoInteractor;

@Service
public class deleteTodoInteractor implements IdeleteTodoInteractor {

    private final ITodoRepository todoRepository;

    public deleteTodoInteractor(ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public DeleteTodoResponse deleteTodo(DeleteTodoRequest request) {
        this.todoRepository.deleteTodo(request.id);
        return new DeleteTodoResponse(request.id);
    }
}
