package com.didi.todoapi.controller;


import com.didi.todoapi.domain.Task;
import com.didi.todoapi.dto.TaskRequestDTO;
import com.didi.todoapi.dto.TaskResponseDTO;
import com.didi.todoapi.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("tasks")
@CrossOrigin(origins = "*")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAll() {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.getAll());
    }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody @Valid TaskRequestDTO dto) {
        TaskResponseDTO task = service.createTask(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);

    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<TaskResponseDTO> editTask(@PathVariable Long id, @RequestParam boolean completed) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.editTask(id, completed));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

}
