package com.resume.dao;

public interface ResumeDAO {

    // JOIN Query - View Full Resume
    void viewResume(int studentId);

    // Resume Analysis Logic
    void analyzeResume(int studentId);
}