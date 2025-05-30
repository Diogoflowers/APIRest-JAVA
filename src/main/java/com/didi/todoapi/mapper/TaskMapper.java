package com.didi.todoapi.mapper;

import com.didi.todoapi.domain.Task;
import com.didi.todoapi.dto.TaskRequestDTO;
import com.didi.todoapi.dto.TaskResponseDTO;


import java.time.LocalDateTime;

public class TaskMapper {

    public static Task toEntity(TaskRequestDTO task) {
        return Task.builder()
                .title(task.getTitle())
                .description(task.getDescription())
                .createdAt(LocalDateTime.now())
                .completed(false)
                .build();
    }

    public static TaskResponseDTO toResponse(Task task) {
        return TaskResponseDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .completed(task.isCompleted())
                .createdAt(task.getCreatedAt())
                .build();
    }
}
