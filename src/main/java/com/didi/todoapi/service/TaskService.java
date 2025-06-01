package com.didi.todoapi.service;


import com.didi.todoapi.domain.Task;
import com.didi.todoapi.dto.TaskRequestDTO;
import com.didi.todoapi.dto.TaskResponseDTO;
import com.didi.todoapi.mapper.TaskMapper;
import com.didi.todoapi.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
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


    public TaskResponseDTO createTask(TaskRequestDTO dto) {
        Task task = TaskMapper.toEntity(dto);

        Task saved = repository.save(task);

        return TaskMapper.toResponse(saved);
    }

    public TaskResponseDTO editTask(long id, boolean completed){
        Task task = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada"));
        task.setCompleted(completed);
        repository.save(task);
        return TaskMapper.toResponse(task);

    }

    public void deleteTask(Long id){
        repository.deleteById(id);
    }
}
