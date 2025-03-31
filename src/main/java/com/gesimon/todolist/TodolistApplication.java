package com.gesimon.todolist;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.gesimon.todolist.controller.TaskController;
import com.gesimon.todolist.model.Task;
import com.gesimon.todolist.service.TaskService;

@SpringBootApplication 
public class TodolistApplication implements CommandLineRunner {

    private final TaskController taskController;

	@Autowired
	private TaskService ts;

    TodolistApplication(TaskController taskController) {
        this.taskController = taskController;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Task> tasksList = ts.getAllTasks();
		
		for(Task task : tasksList) {
			System.out.println(task);
		}
	}

}
