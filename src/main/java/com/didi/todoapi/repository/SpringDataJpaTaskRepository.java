package com.didi.todoapi.repository;

import com.didi.todoapi.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaTaskRepository extends JpaRepository<Task, Long> {

}
