package com.asign.taskm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asign.taskm.entity.Task;
import com.asign.taskm.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{
    
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createtask(Task task) {
        return taskRepository.save(task);
    }

}