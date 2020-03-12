package com.example.TodoApp.models;

public class Task {

    public Task(String name, String description, boolean checked) {
        this.name = name;
        this.description = description;
        this.checked = checked;
    }

    public String name;
    public String description;
    public boolean checked;

}
