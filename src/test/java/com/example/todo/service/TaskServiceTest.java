package com.example.todo.service;

import com.example.todo.repository.TaskRecord;
import com.example.todo.repository.TaskRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository mockTaskRepository;

    @InjectMocks
    private TaskService cut;


    @Test
    @DisplayName("repository が空のリストを返したとき、service は空のリストを返す")
    public void returnEmptyList() {
        // ## Arrange ##
        when(mockTaskRepository.select()).thenReturn(List.of());

        // ## Act ##
        var actual = cut.findAll();

        // ## Assert ##
        assertThat(actual).isEmpty();
    }

    @Test
    @DisplayName("repository が record を含むリストを返したとき、service はその record を entity に変換したリストを返す")
    public void returnNotEmptyList() {
        // ## Arrange ##
        var record1 = new TaskRecord(1L, "__TITLE_1__", true);
        var record2 = new TaskRecord(2L, "__TITLE_2__", false);
        when(mockTaskRepository.select()).thenReturn(List.of(record1, record2));

        // ## Act ##
        var actual = cut.findAll();

        // ## Assert ##
        assertThat(actual).hasSize(2);

        assertThat(actual.get(0).taskId()).isEqualTo(record1.getTaskId());
        assertThat(actual.get(0).title()).isEqualTo(record1.getTitle());
        assertThat(actual.get(0).isCompleted()).isEqualTo(record1.isCompleted());

        assertThat(actual.get(1).taskId()).isEqualTo(record2.getTaskId());
        assertThat(actual.get(1).title()).isEqualTo(record2.getTitle());
        assertThat(actual.get(1).isCompleted()).isEqualTo(record2.isCompleted());
    }

}