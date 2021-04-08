package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "activity_type")
public class ActivityType {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_activity_type")
    private short idActivityType;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String color;

    public ActivityType() {
    }

    public ActivityType(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public ActivityType(short idActivityType, String name, String color) {
        this.idActivityType = idActivityType;
        this.name = name;
        this.color = color;
    }

    public short getIdActivityType() {
        return idActivityType;
    }

    public void setIdActivityType(short idActivityType) {
        this.idActivityType = idActivityType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
