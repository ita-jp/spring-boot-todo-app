package com.example.todo.service;

import com.example.todo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<TaskEntity> findAll() {
        return taskRepository.select()
                .stream()
                .map(record -> new TaskEntity(record.getTaskId(), record.getTitle(), record.isCompleted()))
                .toList();
    }

    public void create(String title) {
        taskRepository.insert(title);
    }
}
