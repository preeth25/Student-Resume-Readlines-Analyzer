package com.resume.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.resume.dao.ResumeDAO;
import com.resume.util.ConnectionFactory;

public class ResumeDAOImpl implements ResumeDAO {

    @Override
    public void viewResume(int studentId) {

        try (Connection con = ConnectionFactory.getConnection()) {

            String sql = "SELECT s.name, s.email, s.phone, "
                    + "sk.skill_name, p.title, c.cert_name "
                    + "FROM students s "
                    + "LEFT JOIN skills sk ON s.student_id = sk.student_id "
                    + "LEFT JOIN projects p ON s.student_id = p.student_id "
                    + "LEFT JOIN certifications c ON s.student_id = c.student_id "
                    + "WHERE s.student_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Phone: " + rs.getString("phone"));
                System.out.println("Skill: " + rs.getString("skill_name"));
                System.out.println("Project: " + rs.getString("title"));
                System.out.println("Certification: " + rs.getString("cert_name"));
                System.out.println("----------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void analyzeResume(int studentId) {

        try (Connection con = ConnectionFactory.getConnection()) {

            int score = 0;

            PreparedStatement ps1 = con.prepareStatement(
                    "SELECT COUNT(*) FROM skills WHERE student_id=?");
            ps1.setInt(1, studentId);
            ResultSet rs1 = ps1.executeQuery();
            if (rs1.next()) score += rs1.getInt(1) * 10;

            PreparedStatement ps2 = con.prepareStatement(
                    "SELECT COUNT(*) FROM projects WHERE student_id=?");
            ps2.setInt(1, studentId);
            ResultSet rs2 = ps2.executeQuery();
            if (rs2.next()) score += rs2.getInt(1) * 15;

            PreparedStatement ps3 = con.prepareStatement(
                    "SELECT COUNT(*) FROM certifications WHERE student_id=?");
            ps3.setInt(1, studentId);
            ResultSet rs3 = ps3.executeQuery();
            if (rs3.next()) score += rs3.getInt(1) * 5;

            System.out.println("Resume Score: " + score + "/100");

            if (score >= 70)
                System.out.println("Excellent Resume");
            else if (score >= 40)
                System.out.println("Good Resume - Improve More");
            else
                System.out.println("Needs Improvement");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}