package com.example.hookahRest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String phone;

    private String description;

    private String email;

    public Event() {
    }

    @Override
    public String toString() {
        return "Мероприятие " +
                "id=" + id +
                ", ФИО='" + name + '\'' +
                ", Телефон='" + phone + '\'' +
                ", Описание='" + description + '\'' +
                ", email='" + email + '\'';
    }

    public Event(String name, String phone, String description, String email) {
        this.name = name;
        this.phone = phone;
        this.description = description;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
