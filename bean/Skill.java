package com.resume.bean;

public class Skill {

    private int skillId;
    private int studentId;
    private String skillName;
    private String level;

    public Skill() {}

    public Skill(int skillId, int studentId, String skillName, String level) {
        this.skillId = skillId;
        this.studentId = studentId;
        this.skillName = skillName;
        this.level = level;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Skill [skillId=" + skillId + 
               ", skillName=" + skillName + 
               ", level=" + level + "]";
    }
}