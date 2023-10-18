package com.javapractice.gateways;


public interface ITodoRepository extends ILogger {
    public int addTodo(String todo);
}

