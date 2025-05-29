package com.didi.todoapi.service;


import com.didi.todoapi.domain.Task;
import com.didi.todoapi.dto.TaskRequestDTO;
import com.didi.todoapi.dto.TaskResponseDTO;
import com.didi.todoapi.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAll() {
        return repository.findAll();
    }


    public TaskResponseDTO createTask(@RequestBody TaskRequestDTO dto) {
        Task task = Task.builder().
                title(dto.getTitle()).
                description(dto.getDescription()).
                completed(false).
                createdAt(LocalDateTime.now())
                .build();

        Task saved = repository.save(task);

        return TaskResponseDTO.builder()
                .id(saved.getId())
                .title(saved.getTitle())
                .description(saved.getDescription())
                .completed(saved.isCompleted())
                .createdAt(saved.getCreatedAt())
                .build();
    }
}
