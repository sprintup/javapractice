package com.javapractice.gateways;

import java.io.IOException;

import com.javapractice.domain.Request.DeleteTodoRequest;

public interface ILogger {
    public String deleteTodo(DeleteTodoRequest request);
}

