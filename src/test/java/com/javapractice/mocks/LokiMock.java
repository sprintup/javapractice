package com.javapractice.mocks;


import org.springframework.stereotype.Repository;

import com.javapractice.domain.Request.DeleteTodoRequest;
import com.javapractice.gateways.ILoki;

@Repository
public class LokiMock implements ILoki {

    @Override
    public String deleteTodo(DeleteTodoRequest request) {
        return "Wrote to file and Logged to Loki";
    }
    
}
