package com.prasad.taskmanager.controller;

import com.prasad.taskmanager.model.Task;
import com.prasad.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @GetMapping("/hello")
    public String hello() {
        return "Task Manager application is running! to hello , taskmanager running ";
    }
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestParam String title) {
        System.out.println("Creating task with title: " + title);
        return taskService.createTask(title);
    }

    @GetMapping
    public List<Task> getAllTasks() {
       return taskService.getAllTasks();

    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Integer id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(
            @PathVariable Integer id,
            @RequestParam String title,
            @RequestParam String status) {
        return taskService.updateTask(id, title, status);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Integer id) {
        boolean deleted = taskService.deleteTask(id);
        return deleted ? "Task deleted successfully" : "Task not found";
    }
}