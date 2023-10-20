package com.javapractice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.javapractice.domain.Request.DeleteTodoRequest;
import com.javapractice.domain.Response.DeleteTodoResponse;
import com.javapractice.gateways.ILoki;
import com.javapractice.gateways.ITodoRepository;
import com.javapractice.interactors.deleteTodoInteractor;
import com.javapractice.interactors.interfaces.IdeleteTodoInteractor;
import com.javapractice.mocks.PostgressMock;
import com.javapractice.mocks.LokiMock;

public class DeleteTodoTests {
    private ITodoRepository todoRepository;
    private ILoki loki;
    private IdeleteTodoInteractor deleteTodoInteractor;

    public DeleteTodoTests(){
        todoRepository = new PostgressMock();
        loki = new LokiMock();
        deleteTodoInteractor = new deleteTodoInteractor(todoRepository, loki);
    }

    // name the test method uow_ic_er()
    // unit of work (uow) - what is being tested
    // initial condition (ic) - what is the initial state
    // expected result (er) - what is the expected result
    // ex. deleteTodo_todoExists_todoAdded()
    @Test
    public void deleteTodo_todoExists_todoAdded() {
        
        // Arrange
        DeleteTodoRequest request = new DeleteTodoRequest();
        request.id = 1;
        request.username = "username";

        // Act
        DeleteTodoResponse result = deleteTodoInteractor.deleteTodo(
            request
        );
        
        // Assert
        Assertions.assertEquals(5, result, "2 + 3 should equal 5");
    }
}
