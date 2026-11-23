package com.prasad.taskmanager.service;

import com.prasad.taskmanager.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public Task createTask(String title) {
        System.out.println("Creating task with title: " + title);
        Task task = new Task(nextId++, title, "PENDING");
        tasks.add(task);
        return task;
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task getTaskById(Integer id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Task updateTask(Integer id, String title, String status) {
        Task task = getTaskById(id);

        if (task != null) {
            task.setTitle(title);
            task.setStatus(status);
        }

        return task;
    }

    public boolean deleteTask(Integer id) {
        return tasks.removeIf(task -> task.getId().equals(id));
    }
}