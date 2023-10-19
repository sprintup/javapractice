package com.javapractice.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.javapractice.domain.Request.TodoRequest;
import com.javapractice.domain.Response.TodoResponse;
import com.javapractice.interactors.interfaces.IaddTodo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
class TodoController {
	private final IaddTodo addTodoInteractor;

	//constructor that injects addTodoInteractor
	public TodoController(IaddTodo addTodoInteractor) {
		this.addTodoInteractor = addTodoInteractor;
	}
	
	@GetMapping("/")
	public String hello() {
		return "Hello, World 6!";
	}

	//endpoint for addTodoInteractor
	@PostMapping("/addTodo")
	public TodoResponse addTodo(@RequestBody TodoRequest request) {
		return this.addTodoInteractor.addTodo(request);
	}
}