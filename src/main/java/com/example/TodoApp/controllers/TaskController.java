package com.example.TodoApp.controllers;

import com.example.TodoApp.exception.ResourceNotFoundException;
import com.example.TodoApp.models.Task;
import com.example.TodoApp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("")
    public List<Task> get() {
        return this.taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public Task get(@PathVariable long id) {
        return this.taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task não encontrada com o id: " + id));
    }

    @PostMapping()
    public ResponseEntity<Task> post(@RequestBody Task task) {
        Task retorno = this.taskRepository.save(task);
        return new ResponseEntity<Task>(retorno, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> put(@PathVariable long id, @RequestBody Task task) {

        return this.taskRepository.findById(id).map(t -> {
            t.setChecked(task.isChecked());
            t.setDescription(task.getDescription());
            t.setName(task.getName());
            return new ResponseEntity<Task>(this.taskRepository.save(t), HttpStatus.OK);
        }).orElseThrow(() -> new ResourceNotFoundException("Task não encontrada com o id: " + id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        return this.taskRepository.findById(id).map(t -> {
            this.taskRepository.delete(t);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("[delete] Task não encontrada com o id " + id));
    }

}
