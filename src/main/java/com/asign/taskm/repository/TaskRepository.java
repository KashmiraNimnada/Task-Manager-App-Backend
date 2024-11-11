package com.asign.taskm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asign.taskm.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long>{
    
}
