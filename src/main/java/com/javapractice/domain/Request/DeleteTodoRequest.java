package com.javapractice.domain.Request;

import lombok.Data;

@Data
public class DeleteTodoRequest {
    public int id;
    public String username;
}
