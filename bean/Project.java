package com.resume.bean;

public class Project {

    private int projectId;
    private int studentId;
    private String title;
    private String description;

    public Project() {}

    public Project(int projectId, int studentId, String title, String description) {
        this.projectId = projectId;
        this.studentId = studentId;
        this.title = title;
        this.description = description;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Project [projectId=" + projectId + 
               ", title=" + title + "]";
    }
}