package com.resume.daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.resume.bean.Student;
import com.resume.dao.StudentDAO;
import com.resume.util.ConnectionFactory;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean addStudent(Student student) {
        try (Connection con = ConnectionFactory.getConnection()) {

            String sql = "INSERT INTO students(user_id, name, email, phone) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, student.getUserId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getPhone());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Student> getAllStudents() {

        List<Student> list = new ArrayList<>();

        try (Connection con = ConnectionFactory.getConnection()) {

            String sql = "SELECT * FROM students";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student s = new Student();
                s.setStudentId(rs.getInt("student_id"));
                s.setUserId(rs.getInt("user_id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setPhone(rs.getString("phone"));

                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean updateStudent(Student student) {

        try (Connection con = ConnectionFactory.getConnection()) {

            String sql = "UPDATE students SET name=?, email=?, phone=? WHERE student_id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getPhone());
            ps.setInt(4, student.getStudentId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteStudent(int studentId) {

        try (Connection con = ConnectionFactory.getConnection()) {

            String sql = "DELETE FROM students WHERE student_id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, studentId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}