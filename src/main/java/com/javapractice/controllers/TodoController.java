package com.javapractice.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.javapractice.domain.Request.DeleteTodoRequest;
import com.javapractice.domain.Request.TodoRequest;
import com.javapractice.domain.Response.DeleteTodoResponse;
import com.javapractice.domain.Response.TodoResponse;
import com.javapractice.interactors.deleteTodoInteractor;
import com.javapractice.interactors.interfaces.IaddTodo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
class TodoController {
	private final IaddTodo addTodoInteractor;
	private final deleteTodoInteractor deletedTodoLogInteractor;

	//constructor that injects addTodoInteractor
	public TodoController(IaddTodo addTodoInteractor,
		deleteTodoInteractor deletedTodoLogInteractor) {
		this.addTodoInteractor = addTodoInteractor;
		this.deletedTodoLogInteractor = deletedTodoLogInteractor;
	}
	
	@GetMapping("/")
	public String hello() {
		return "Hello, World 6!";
	}

	@PostMapping("/addTodo")
	public TodoResponse addTodo(@RequestBody TodoRequest request) {
		return this.addTodoInteractor.addTodo(request);
	}

	@PostMapping("/deleteTodo")
	public DeleteTodoResponse deleteTodo(@RequestBody DeleteTodoRequest request) {
		return this.deletedTodoLogInteractor.deleteTodo(request);
	}

}