package com.example.todo.controller;

import javax.validation.constraints.NotBlank;

public record TaskForm(
        @NotBlank String title
) {
}