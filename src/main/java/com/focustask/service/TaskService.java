package com.focustask.service;

import com.focustask.entity.Task;
import com.focustask.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {

        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(UUID id) {

        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa nao encontrada no banco!"));

    }

    public void deleteTask(UUID id){
        Task task = getTaskById(id);
        taskRepository.delete(task);
    }
}

