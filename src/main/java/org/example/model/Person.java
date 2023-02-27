package org.example.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


public class Person {
    private int id;
    @NotEmpty(message = "Name should be not empty!")
    @Size(min = 2, max = 20, message = "Name should be between 2 and 20!")
    private String name;
    @NotEmpty(message = "Email should be not empty!")
    @Email(message = "Incorrect email")
    private String email;


    public Person() {
    }

    public Person(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
