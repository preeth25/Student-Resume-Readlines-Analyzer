package com.resume.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.resume.bean.Project;
import com.resume.dao.ProjectDAO;
import com.resume.util.ConnectionFactory;

public class ProjectDAOImpl implements ProjectDAO {

    @Override
    public boolean addProject(Project project) {

        try (Connection con = ConnectionFactory.getConnection()) {

            String sql = "INSERT INTO projects(student_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, project.getStudentId());
            ps.setString(2, project.getTitle());
            ps.setString(3, project.getDescription());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Project> getProjectsByStudent(int studentId) {

        List<Project> list = new ArrayList<>();

        try (Connection con = ConnectionFactory.getConnection()) {

            String sql = "SELECT * FROM projects WHERE student_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Project p = new Project();
                p.setProjectId(rs.getInt("project_id"));
                p.setStudentId(rs.getInt("student_id"));
                p.setTitle(rs.getString("title"));
                p.setDescription(rs.getString("description"));

                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean updateProject(Project project) {

        try (Connection con = ConnectionFactory.getConnection()) {

            String sql = "UPDATE projects SET title=?, description=? WHERE project_id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, project.getTitle());
            ps.setString(2, project.getDescription());
            ps.setInt(3, project.getProjectId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteProject(int projectId) {

        try (Connection con = ConnectionFactory.getConnection()) {

            String sql = "DELETE FROM projects WHERE project_id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, projectId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}