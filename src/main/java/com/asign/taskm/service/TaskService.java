package com.asign.taskm.service;

import org.springframework.stereotype.Service;

import com.asign.taskm.entity.Task;

@Service
public interface TaskService {
    
    Task createtask(Task task);

}
