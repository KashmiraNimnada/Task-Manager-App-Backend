package com.asign.taskm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asign.taskm.entity.Task;
import com.asign.taskm.service.TaskService;

@RestController
public class TaskController {
    
    @Autowired
    private TaskService taskService;

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        return ResponseEntity.status(201).body(taskService.createtask(task));
    } 

}
