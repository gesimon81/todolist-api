package com.gesimon.todolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.gesimon.todolist.model.Task;
import com.gesimon.todolist.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	//Methods for the API
	public Optional<Task> getTask(final Long id) {
		return taskRepository.findById(id);
	}
	
	public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
	
	@EventListener(ApplicationReadyEvent.class)
	public void checkData() {
	    System.out.println("🟢 Nombre de tâches en base : " + taskRepository.count());
	}
}
