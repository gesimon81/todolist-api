package com.gesimon.todolist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gesimon.todolist.model.Task;
import com.gesimon.todolist.service.TaskService;

@CrossOrigin(origins = "http://localhost:4200")  // Autoriser Angular
@RestController
@RequestMapping("/tasks")
public class TaskController {
	@Autowired
	private TaskService taskService;

	
	/**
	 * Read - Get all tasks
	 * @return - A List object of Task full filled
	 */
	@GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

	/**
	 * Read - Get one task 
	 * @param id The id of the task
	 * @return An Task object full filled
	 */
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable("id") Long id) {
        return taskService.getTask(id);
    }
    
    
    /**
	 * Create - Add a new task
	 * @param task An object Task
	 * @return The Task object saved
	 */
	@PostMapping
	public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task savedTask = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }
}
