package com.javapractice.mocks;
import org.springframework.stereotype.Repository;

import com.javapractice.domain.Request.DeleteTodoRequest;
import com.javapractice.gateways.ITodoRepository;

@Repository
public class PostgressMock implements ITodoRepository {

    @Override
    public String deleteTodo(DeleteTodoRequest request) {
        return "Todo with ID " + request.id + " has been deleted.";
    }

    @Override
    public int addTodo(String todo) {
        return 1;
    }
}
