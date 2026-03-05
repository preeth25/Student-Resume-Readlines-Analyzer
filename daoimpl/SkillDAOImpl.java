package com.resume.daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.resume.bean.Skill;
import com.resume.dao.SkillDAO;
import com.resume.util.ConnectionFactory;

public class SkillDAOImpl implements SkillDAO {

    @Override
    public boolean addSkill(Skill skill) {

        try (Connection con = ConnectionFactory.getConnection()) {

            String sql = "INSERT INTO skills(student_id, skill_name, level) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, skill.getStudentId());
            ps.setString(2, skill.getSkillName());
            ps.setString(3, skill.getLevel());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Skill> getSkillsByStudent(int studentId) {

        List<Skill> list = new ArrayList<>();

        try (Connection con = ConnectionFactory.getConnection()) {

            String sql = "SELECT * FROM skills WHERE student_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Skill s = new Skill();
                s.setSkillId(rs.getInt("skill_id"));
                s.setStudentId(rs.getInt("student_id"));
                s.setSkillName(rs.getString("skill_name"));
                s.setLevel(rs.getString("level"));

                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean updateSkill(Skill skill) {

        try (Connection con = ConnectionFactory.getConnection()) {

            String sql = "UPDATE skills SET skill_name=?, level=? WHERE skill_id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, skill.getSkillName());
            ps.setString(2, skill.getLevel());
            ps.setInt(3, skill.getSkillId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteSkill(int skillId) {

        try (Connection con = ConnectionFactory.getConnection()) {

            String sql = "DELETE FROM skills WHERE skill_id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, skillId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}