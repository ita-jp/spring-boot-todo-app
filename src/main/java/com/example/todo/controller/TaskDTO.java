package com.example.todo.controller;

import com.example.todo.service.TaskEntity;

public record TaskDTO(
        long taskId,
        String title,
        boolean isCompleted
) {
    public static TaskDTO toDTO(TaskEntity entity) {
        return new TaskDTO(entity.taskId(), entity.title(), entity.isCompleted());
    }
}
