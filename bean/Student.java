package com.resume.bean;

public class Student {

    private int studentId;
    private int userId;
    private String name;
    private String email;
    private String phone;

    public Student() {}

    public Student(int studentId, int userId, String name, String email, String phone) {
        this.studentId = studentId;
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "Student [studentId=" + studentId + 
               ", name=" + name + 
               ", email=" + email + 
               ", phone=" + phone + "]";
    }
}