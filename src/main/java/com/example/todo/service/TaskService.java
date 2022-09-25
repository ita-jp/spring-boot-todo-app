package com.example.todo.service;

import com.example.todo.repository.TaskRecord;
import com.example.todo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Transactional
    public void create(String title) {
        taskRepository.insert(title);
    }

    public Optional<TaskEntity> find(long taskId) {
        return taskRepository.selectByTaskId(taskId)
                .map(TaskRecord::toEntity);
    }
}
