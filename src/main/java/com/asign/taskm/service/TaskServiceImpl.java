package com.asign.taskm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asign.taskm.dto.TaskDto;
import com.asign.taskm.entity.Task;
import com.asign.taskm.entity.User;
import com.asign.taskm.repository.TaskRepository;
import com.asign.taskm.repository.UserRepository;

@Service
public class TaskServiceImpl implements TaskService{
    
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createtask(Task task) {
        return taskRepository.save(task);
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(Long id,TaskDto taskDto) {

        Task task = taskRepository.findById(id).orElse(null);

        if(task==null) {
            return null;
        } else {
            task.setName(taskDto.getName());
            task.setDescription(taskDto.getDescription());
            task.setDuedate(taskDto.getDuedate());
            task.setStatus(taskDto.getStatus());
            User user = userRepository.findById(taskDto.getUser_id()).orElse(null);
            task.setUser(user);
            return taskRepository.save(task);
        }
    
    }

}
