package com.javapractice.interactors.interfaces;

import com.javapractice.domain.Request.DeleteTodoRequest;
import com.javapractice.domain.Response.DeleteTodoResponse;

public interface IdeleteTodoInteractor {
    public DeleteTodoResponse deleteTodo(DeleteTodoRequest request);
}
