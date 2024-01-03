package com.jttrinh.restfullapi.user;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDate;

public class User {

    private int id;
    @NotEmpty(message = "name is not empty")
    private String name;
    private LocalDate dataBird;


    public User(int id, String name, LocalDate dataBird) {
        this.id = id;
        this.name = name;
        this.dataBird = dataBird;
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

    public LocalDate getDataBird() {
        return dataBird;
    }

    public void setDataBird(LocalDate dataBird) {
        this.dataBird = dataBird;
    }
}
