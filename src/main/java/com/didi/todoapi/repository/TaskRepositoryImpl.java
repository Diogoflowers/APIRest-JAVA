package com.didi.todoapi.repository;

import com.didi.todoapi.domain.Task;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private final SpringDataJpaTaskRepository jpaRepository;

    public TaskRepositoryImpl(SpringDataJpaTaskRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Task save(Task task) {
        return jpaRepository.save(task);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<Task> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
