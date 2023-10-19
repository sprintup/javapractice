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
public class DeleteTodoInteractor implements IdeleteTodoInteractor {

    private final ITodoRepository todoRepository;
    private final ILoki loki;


    // As a user
    // When I delete an todo
    // Then I want the item deleted and a log persisted to long term storage
    public DeleteTodoInteractor(ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
        this.loki = loki;
    }

    // Whenever you open a clean code architecture project, you should automatically be looking for the interactors. 
    // As a matter of convention, the constructor should have a use case in "As", "When", "Then" format.

    // As a user
    // When I delete an todo
    // Then I want the item deleted and a log persisted to long term storage
    @Override
    public DeleteTodoResponse deleteTodo(DeleteTodoRequest request) {
        
        // We can use the shape of the ILogger to ensure all the concrete implementations have the '.deleteTodo()' method seen on line 48.
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
