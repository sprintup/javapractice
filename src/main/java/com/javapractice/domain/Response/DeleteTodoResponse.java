package com.javapractice.domain.Response;

public class DeleteTodoResponse {
    public String message;

    public DeleteTodoResponse(int id) {
        this.message = "Deleted todo with id: " + id;
    }
}
