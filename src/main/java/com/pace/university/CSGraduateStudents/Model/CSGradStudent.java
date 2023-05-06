package com.pace.university.CSGraduateStudents.Model;

import java.util.HashMap;

public class CSGradStudent {
    private int id;
    private String name;
    private String email;
    private String phone;
    private int age;
    private HashMap<String,String> courseRegistered;


    public CSGradStudent(){

    }

    public CSGradStudent(int id, String name, String email, String phone, int age, HashMap<String,String> courseRegistered) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.courseRegistered = courseRegistered;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public HashMap<String, String> getCourseRegistered() {
        return courseRegistered;
    }

    public void setCourseRegistered(HashMap<String,String> courseRegistered) {
        this.courseRegistered = courseRegistered;
    }

}
