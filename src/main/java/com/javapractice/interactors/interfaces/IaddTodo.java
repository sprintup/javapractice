package com.javapractice.interactors.interfaces;

import com.javapractice.domain.Request.TodoRequest;
import com.javapractice.domain.Response.TodoResponse;

public interface IaddTodo {
    public TodoResponse addTodo(TodoRequest todo);
}
