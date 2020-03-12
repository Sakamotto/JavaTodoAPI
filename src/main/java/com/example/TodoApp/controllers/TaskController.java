package com.example.TodoApp.controllers;

import com.example.TodoApp.models.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("task")
public class TaskController {

    @GetMapping("")
    public List<Task> get() {
        Task t1 = new Task("Estudar Java", "Criar uma api básica para entender o funcionamento do Spring Boot", false);
        List<Task> result = new ArrayList<>();
        result.add(t1);

        return result;
    }

    @GetMapping("/{id}")
    public List<Task> get(@PathVariable int id) {
        Task t1 = new Task("Estudar Node", "Uma descrição aleatória aqui ...", true);
        List<Task> result = new ArrayList<>();
        result.add(t1);

        return result;
    }

    @PostMapping()
    public ResponseEntity<String> post(@RequestBody Task task) {
        return new ResponseEntity<>("rota de criação acionada com sucesso", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> put(@RequestBody Task task) {
        return new ResponseEntity<>("rota de atualização acionada com sucesso", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete() {
        return new ResponseEntity<>("rota de deleção acionada com sucesso", HttpStatus.OK);
    }

}
