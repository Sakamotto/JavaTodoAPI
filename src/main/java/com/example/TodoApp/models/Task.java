package com.example.TodoApp.models;

import com.example.TodoApp.models.interfaces.IAudit;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Task")
public class Task extends IAudit {

    private Task() {}

    public Task(String name, String description, boolean checked) {
        this.name = name;
        this.description = description;
        this.checked = checked;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Size(min = 1, max = 200)
    private String name;

    @Size(max = 4000)
    private String description;
    private boolean checked;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
