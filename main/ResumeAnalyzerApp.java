package com.resume.main;

import java.util.List;
import java.util.Scanner;

import com.resume.bean.*;
import com.resume.dao.*;
import com.resume.daoimpl.*;

public class ResumeAnalyzerApp {

    static Scanner sc = new Scanner(System.in);

    static UserDAO userDAO = new UserDAOImpl();
    static StudentDAO studentDAO = new StudentDAOImpl();
    static SkillDAO skillDAO = new SkillDAOImpl();
    static ProjectDAO projectDAO = new ProjectDAOImpl();
    static CertificationDAO certDAO = new CertificationDAOImpl();
    static ResumeDAO resumeDAO = new ResumeDAOImpl();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\nEnter Choice:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    registerUser();
                    break;

                case 2:
                    User user = loginUser();
                    if (user != null) {
                        System.out.println("Login Successful!");
                        userMenu(user.getUserId());
                    } else {
                        System.out.println("Invalid Credentials!");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 3);
    }

    // ================= REGISTER =================
    private static void registerUser() {
        sc.nextLine();
        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        if (userDAO.register(user))
            System.out.println("Registration Successful!");
        else
            System.out.println("Registration Failed!");
    }

    // ================= LOGIN =================
    private static User loginUser() {
        sc.nextLine();
        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        return userDAO.login(username, password);
    }

    // ================= USER MENU =================
    private static void userMenu(int userId) {

        int choice;

        do {
            System.out.println("\n1.Student CRUD");
            System.out.println("2.Skill CRUD");
            System.out.println("3.Project CRUD");
            System.out.println("4.Certification CRUD");
            System.out.println("5.View Resume");
            System.out.println("6.Analyze Resume");
            System.out.println("7.Logout");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    studentCRUD(userId);
                    break;

                case 2:
                    skillCRUD();
                    break;

                case 3:
                    projectCRUD();
                    break;

                case 4:
                    certificationCRUD();
                    break;

                case 5:
                    System.out.print("Enter Student ID: ");
                    resumeDAO.viewResume(sc.nextInt());
                    break;

                case 6:
                    System.out.print("Enter Student ID: ");
                    resumeDAO.analyzeResume(sc.nextInt());
                    break;

                case 7:
                    System.out.println("Logged Out Successfully!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);
    }

    // ================= STUDENT CRUD =================
    private static void studentCRUD(int userId) {

        System.out.println("1.Add 2.View 3.Update 4.Delete");
        int ch = sc.nextInt();

        switch (ch) {

            case 1:
                sc.nextLine();
                Student s = new Student();
                s.setUserId(userId);

                System.out.print("Enter Name: ");
                s.setName(sc.nextLine());

                System.out.print("Enter Email: ");
                s.setEmail(sc.nextLine());

                System.out.print("Enter Phone: ");
                s.setPhone(sc.nextLine());

                studentDAO.addStudent(s);
                break;

            case 2:
                List<Student> list = studentDAO.getAllStudents();
                for (Student st : list)
                    System.out.println(st);
                break;

            case 3:
                sc.nextLine();
                Student updateStudent = new Student();

                System.out.print("Enter Student ID to Update: ");
                updateStudent.setStudentId(sc.nextInt());
                sc.nextLine();

                System.out.print("Enter New Name: ");
                updateStudent.setName(sc.nextLine());

                System.out.print("Enter New Email: ");
                updateStudent.setEmail(sc.nextLine());

                System.out.print("Enter New Phone: ");
                updateStudent.setPhone(sc.nextLine());

                studentDAO.updateStudent(updateStudent);
                break;

            case 4:
                System.out.print("Enter Student ID to Delete: ");
                studentDAO.deleteStudent(sc.nextInt());
                break;
        }
    }

    // ================= SKILL CRUD =================
    private static void skillCRUD() {

        System.out.println("1.Add 2.Update 3.Delete");
        int ch = sc.nextInt();
        Skill skill = new Skill();

        switch (ch) {

            case 1:
                System.out.print("Enter Student ID: ");
                skill.setStudentId(sc.nextInt());
                sc.nextLine();

                System.out.print("Enter Skill Name: ");
                skill.setSkillName(sc.nextLine());

                System.out.print("Enter Level: ");
                skill.setLevel(sc.nextLine());

                skillDAO.addSkill(skill);
                break;

            case 2:
                System.out.print("Enter Skill ID to Update: ");
                skill.setSkillId(sc.nextInt());
                sc.nextLine();

                System.out.print("Enter New Skill Name: ");
                skill.setSkillName(sc.nextLine());

                System.out.print("Enter New Level: ");
                skill.setLevel(sc.nextLine());

                skillDAO.updateSkill(skill);
                break;

            case 3:
                System.out.print("Enter Skill ID to Delete: ");
                skillDAO.deleteSkill(sc.nextInt());
                break;
        }
    }

    // ================= PROJECT CRUD =================
    private static void projectCRUD() {

        System.out.println("1.Add 2.Update 3.Delete");
        int ch = sc.nextInt();
        Project project = new Project();

        switch (ch) {

            case 1:
                System.out.print("Enter Student ID: ");
                project.setStudentId(sc.nextInt());
                sc.nextLine();

                System.out.print("Enter Project Title: ");
                project.setTitle(sc.nextLine());

                System.out.print("Enter Description: ");
                project.setDescription(sc.nextLine());

                projectDAO.addProject(project);
                break;

            case 2:
                System.out.print("Enter Project ID to Update: ");
                project.setProjectId(sc.nextInt());
                sc.nextLine();

                System.out.print("Enter New Title: ");
                project.setTitle(sc.nextLine());

                System.out.print("Enter New Description: ");
                project.setDescription(sc.nextLine());

                projectDAO.updateProject(project);
                break;

            case 3:
                System.out.print("Enter Project ID to Delete: ");
                projectDAO.deleteProject(sc.nextInt());
                break;
        }
    }

    // ================= CERTIFICATION CRUD =================
    private static void certificationCRUD() {

        System.out.println("1.Add 2.Update 3.Delete");
        int ch = sc.nextInt();
        Certification cert = new Certification();

        switch (ch) {

            case 1:
                System.out.print("Enter Student ID: ");
                cert.setStudentId(sc.nextInt());
                sc.nextLine();

                System.out.print("Enter Certification Name: ");
                cert.setCertName(sc.nextLine());

                System.out.print("Enter Organization: ");
                cert.setOrganization(sc.nextLine());

                certDAO.addCertification(cert);
                break;

            case 2:
                System.out.print("Enter Certification ID to Update: ");
                cert.setCertId(sc.nextInt());
                sc.nextLine();

                System.out.print("Enter New Certification Name: ");
                cert.setCertName(sc.nextLine());

                System.out.print("Enter New Organization: ");
                cert.setOrganization(sc.nextLine());

                certDAO.updateCertification(cert);
                break;

            case 3:
                System.out.print("Enter Certification ID to Delete: ");
                certDAO.deleteCertification(sc.nextInt());
                break;
        }
    }
}