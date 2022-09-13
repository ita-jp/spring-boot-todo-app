package com.example.todo.service;

public record TaskEntity(
        long taskId,
        String title,
        boolean isCompleted
) {
}
