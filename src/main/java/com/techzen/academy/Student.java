package com.techzen.academy;

import java.util.UUID;

public class Student {
    private UUID id;
    private String name;
    private Double score;

    public Student() {
    }

    public Student(UUID id, String name, Double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
