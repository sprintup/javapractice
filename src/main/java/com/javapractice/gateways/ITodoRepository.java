package com.javapractice.gateways;

//In other words, the injected Interfaces extend the shared interface.
public interface ITodoRepository extends ILogger {
    public int addTodo(String todo);
}

