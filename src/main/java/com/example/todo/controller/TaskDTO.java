package com.example.todo.controller;

public record TaskDTO(
        long taskId,
        String title,
        boolean isCompleted
) {
}
