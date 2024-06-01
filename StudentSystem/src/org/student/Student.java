package org.student;

public class Student {
    private String id;
    private String name;
    private String gender;
    private double score;

    public Student(String id, String name, String gender, double score) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.score = score;
    }

    // getters and setters
    // ...

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}