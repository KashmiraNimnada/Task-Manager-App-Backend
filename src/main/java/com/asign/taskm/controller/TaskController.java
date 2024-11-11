package com.asign.taskm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asign.taskm.dto.TaskDto;
import com.asign.taskm.entity.Task;
import com.asign.taskm.entity.User;
import com.asign.taskm.service.UserService;

@RestController
public class TaskController {

    @Autowired
    private UserService userService;

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody TaskDto taskDto){

        Task task = new Task();
        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        task.setDuedate(taskDto.getDuedate());
        task.setStatus(taskDto.getStatus());

        User user = userService.getUserById(taskDto.getUser_id());
        task.setUser(user);
        return ResponseEntity.status(201).body(task);
    } 

}
