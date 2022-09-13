package com.example.todo.service;

import com.example.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskEntity> findAll() {
        return taskRepository.select()
                .stream()
                .map(record -> new TaskEntity(record.getTaskId(), record.getTitle(), record.isCompleted()))
                .toList();
    }
}
