package com.bullish.student_app.studentAttributes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    @JsonProperty("class")
    private String className;
    private String nationality;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String clazz) {
        this.className = clazz;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
