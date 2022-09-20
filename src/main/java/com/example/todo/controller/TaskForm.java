package com.example.todo.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record TaskForm(
        @NotBlank
        @Size(max = 256)
        String title
) {
}