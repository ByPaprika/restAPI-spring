package com.example.hookahRest.model;

import javax.persistence.*;

@Entity
public class TableInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phone;

    private String description;

    private String count;

    private String data;

    private String time;


    public TableInfo() {
    }

    public TableInfo(String name, String phone, String description, String count, String data, String time) {
        this.name = name;
        this.phone = phone;
        this.description = description;
        this.count = count;
        this.data = data;
        this.time = time;
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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Бронировение столов " +
                "id=" + id +
                ", ФИО='" + name + '\'' +
                ", Телефон='" + phone + '\'' +
                ", Описание='" + description + '\'' +
                ", Количество людей='" + count + '\'' +
                ", Дата='" + data + '\'' +
                ", Время='" + time + '\'' ;
    }
}
