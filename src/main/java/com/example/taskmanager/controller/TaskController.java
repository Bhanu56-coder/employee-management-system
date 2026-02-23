package com.example.taskmanager.controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.taskmanager.entity.Task;
import com.example.taskmanager.repository.TaskRepository;

@RestController
@RequestMapping("/tasks")
public class TaskController {
private final TaskRepository repo;
public TaskController(TaskRepository repo){this.repo=repo;}

@GetMapping
public List<Task> getAll(){
return repo.findAll();
}

@PostMapping
public Task create(@RequestBody Task task){
return repo.save(task);
}

@DeleteMapping("/{id}")
public void delete(@PathVariable Long id){
repo.deleteById(id);
}
}