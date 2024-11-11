package com.asign.taskm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.asign.taskm.dto.TaskDto;
import com.asign.taskm.entity.Task;

@Service
public interface TaskService {
    
    Task createtask(Task task);
    List<Task> getAllTasks();
    Task updateTask(Long id,TaskDto taskDto);
}
