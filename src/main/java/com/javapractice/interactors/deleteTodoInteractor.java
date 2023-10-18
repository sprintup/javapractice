package com.javapractice.interactors;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.javapractice.domain.Request.DeleteTodoRequest;
import com.javapractice.domain.Response.DeleteTodoResponse;
import com.javapractice.gateways.ILogger;
import com.javapractice.gateways.ILoki;
import com.javapractice.gateways.ITodoRepository;
import com.javapractice.interactors.interfaces.IdeleteTodoInteractor;

@Service
public class deleteTodoInteractor implements IdeleteTodoInteractor {

    private final ITodoRepository todoRepository;
    private final ILoki loki;

    public deleteTodoInteractor(ITodoRepository todoRepository, ILoki loki) {
        this.todoRepository = todoRepository;
        this.loki = loki;
    }

    //As a user
    // When I delete an todo
    // Then I want the item deleted and a log persisted to long term storage
    @Override
    public DeleteTodoResponse deleteTodo(DeleteTodoRequest request) {
        
        ArrayList<ILogger> loggers = getLoggers();


        String result = getResult(request, loggers);

        return new DeleteTodoResponse(result);
    }

    private String getResult(DeleteTodoRequest request, ArrayList<ILogger> loggers) {
        StringBuilder resultBuilder = new StringBuilder();

        for (ILogger logger : loggers) {
            String response = logger.deleteTodo(request);
            if (resultBuilder.length() > 0) {
                resultBuilder.append("| ");
            }
            resultBuilder.append(response);
        }

        return resultBuilder.toString();
    }

    private ArrayList<ILogger> getLoggers() {
        ArrayList<ILogger> loggers = new ArrayList<ILogger>();
        loggers.add(todoRepository);
        loggers.add(loki);
        return loggers;
    }
}
