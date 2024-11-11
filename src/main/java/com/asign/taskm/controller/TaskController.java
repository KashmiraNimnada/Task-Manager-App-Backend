package com.asign.taskm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asign.taskm.dto.TaskDto;
import com.asign.taskm.entity.Task;
import com.asign.taskm.entity.User;
import com.asign.taskm.service.TaskService;
import com.asign.taskm.service.UserService;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody TaskDto taskDto){

        Task task = new Task();
        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        task.setDuedate(taskDto.getDuedate());
        task.setStatus(taskDto.getStatus());
        System.out.println(taskDto.getUser_id());
        User user = userService.getUserById(taskDto.getUser_id());
        System.out.println(user);
        task.setUser(user);

        return ResponseEntity.status(201).body(taskService.createtask(task));
    }
    
    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.status(200).body(tasks);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id,@RequestBody TaskDto taskDto) {
        Task task = taskService.updateTask(id, taskDto);
        
        if(task==null) {
            return ResponseEntity.status(404).body(null);
        }else {
            return ResponseEntity.status(200).body(task);
        }
    }
    

}
