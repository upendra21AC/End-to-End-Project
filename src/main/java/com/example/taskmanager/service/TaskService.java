package com.example.taskmanager.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.taskmanager.model.Task;

@Service
public class TaskService {
	
    private final Map<Long, Task> tasks = new HashMap<>();

    private Long nextId = 1L;

    // Create task
    public Task createTask(Task task) {

        task.setId(nextId++);

        tasks.put(task.getId(), task);

        return task;
    }

    // Get all tasks
    public List<Task> getAllTasks() {

        return new ArrayList<>(tasks.values());
    }

    // Get task by ID
    public Task getTaskById(Long id) {

        return tasks.get(id);
    }

    // Update task
    public Task updateTask(Long id, Task updatedTask) {

        if (!tasks.containsKey(id)) {
            return null;
        }

        updatedTask.setId(id);

        tasks.put(id, updatedTask);

        return updatedTask;
    }

    // Delete task
    public boolean deleteTask(Long id) {

        return tasks.remove(id) != null;
    }

}
