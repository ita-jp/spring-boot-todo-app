package com.example.todo.controller;

import com.example.todo.service.TaskEntity;
import com.example.todo.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @MockBean
    private TaskService mockTaskService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnTask() throws Exception {
        // ## Arrange ##
        var taskEntity = new TaskEntity(987, "__title__", true);
        when(mockTaskService.findAll()).thenReturn(List.of(taskEntity));

        // ## Act ##
        // ## Assert ##
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attribute("taskList", List.of(new TaskDTO(987, "__title__", true))))
                .andExpect(content().string(containsString("987")))
                .andExpect(content().string(containsString("__title__")))
                .andExpect(content().string(containsString("完了")));
    }

    @Test
    public void shouldShowTaskCreationForm() throws Exception {
        mockMvc.perform(get("/tasks/new"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("tasks/form"));
    }

    @Test
    public void shouldCreateTasks() throws Exception {
        mockMvc.perform(post("/tasks"))
                .andExpect(status().isOk()); // TODO 301 redirect
    }
}