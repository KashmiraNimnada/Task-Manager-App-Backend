package com.asign.taskm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asign.taskm.dto.TaskDto;
import com.asign.taskm.entity.Task;
import com.asign.taskm.entity.User;
import com.asign.taskm.repository.UserRepository;
import com.asign.taskm.service.TaskService;

@RestController
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody TaskDto taskDto){
        Task task = new Task();
        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        task.setDuedate(taskDto.getDuedate());
        task.setStatus(taskDto.getStatus());
        User user = userRepository.findByUsername(taskDto.getUser_name()).orElse(null);
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

    @DeleteMapping("/tasks/{id}") 
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

}
