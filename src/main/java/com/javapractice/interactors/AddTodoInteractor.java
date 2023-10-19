package com.javapractice.interactors;

import org.springframework.stereotype.Service;

import com.javapractice.domain.Request.TodoRequest;
import com.javapractice.domain.Response.TodoResponse;
import com.javapractice.gateways.ITodoRepository;
import com.javapractice.interactors.interfaces.IaddTodo;

// This @service decorator allows this repository to enter the inversion of control (IOC) container. 
// It basically just means it's now injectable into the controller. This is the boundary between the controller and the Interactor.
@Service
public class AddTodoInteractor implements IaddTodo{
    private final ITodoRepository todoRepository;
    
    // Notice how the ITodoRepository interface (previous file) is injected into the interactor. 
    // This is the boundary between the interactor and the gateway.
    // The implementation of this interface is in the infrastructure folder.
    public AddTodoInteractor(ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // As a user
    // When I add a todo
    // Then I should see the todo in the list 
    @Override
    public TodoResponse addTodo(TodoRequest request) {
        //This is where you would want to put in guards, but Java does this for you automatically in the model definitions (domain directory). 
        // Otherwise, this is where you'd be changing from data transfer objects (DTOs) to data access objects (DAOs).
        this.todoRepository.addTodo(
            request.todo
        );
        return new TodoResponse(request.todo);
    }
    
}
