package com.gesimon.todolist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	@Column(name = "ISCOMPLETED")  // Précise le nom exact de la colonne dans H2
	private boolean isCompleted;

	public Task() {
		
	}
	
	public Task(Long id, String description, boolean isCompleted) {
		super();
		this.id = id;
		this.description = description;
		this.isCompleted = isCompleted;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
	    return "Task{id=" + id +
	           ", description='" + description + '\'' +
	           ", completed=" + (isCompleted ? "✔" : "✘") +
	           '}';
	}
	
	
}
