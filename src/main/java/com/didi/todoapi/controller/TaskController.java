package com.didi.todoapi.controller;


import com.didi.todoapi.domain.Task;
import com.didi.todoapi.dto.TaskRequestDTO;
import com.didi.todoapi.dto.TaskResponseDTO;
import com.didi.todoapi.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("tasks")
public class TaskController{
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAll () {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.getAll());
    }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask (@RequestBody TaskRequestDTO dto) {
        TaskResponseDTO task = service.createTask(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);

    }

}
