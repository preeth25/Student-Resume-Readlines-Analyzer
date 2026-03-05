package com.resume.dao;

import java.util.List;
import com.resume.bean.Skill;

public interface SkillDAO {

    boolean addSkill(Skill skill);

    List<Skill> getSkillsByStudent(int studentId);

    boolean updateSkill(Skill skill);

    boolean deleteSkill(int skillId);
}