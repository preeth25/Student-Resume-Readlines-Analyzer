package com.resume.dao;

import java.util.List;
import com.resume.bean.Student;

public interface StudentDAO {

    boolean addStudent(Student student);

    List<Student> getAllStudents();

    boolean updateStudent(Student student);

    boolean deleteStudent(int studentId);
}