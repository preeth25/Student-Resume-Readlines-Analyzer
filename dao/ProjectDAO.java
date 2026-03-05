package com.resume.dao;

import java.util.List;
import com.resume.bean.Project;

public interface ProjectDAO {

    boolean addProject(Project project);

    List<Project> getProjectsByStudent(int studentId);

    boolean updateProject(Project project);

    boolean deleteProject(int projectId);
}