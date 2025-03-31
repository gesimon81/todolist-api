package com.gesimon.todolist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gesimon.todolist.model.Task;
import com.gesimon.todolist.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	private final TaskService taskService;
	
	
	public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
	
	@GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable("id") Long id) {
        return taskService.getTask(id);
    }
}
