package com.javapractice.domain.Response;

import lombok.Data;

@Data
public class TodoResponse {
    public String response;
    //constructor
    public TodoResponse(String todo) {
        this.response = todo;
    }
}