package com.gesimon.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gesimon.todolist.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
