package com.cognizant.springrest.service;

import com.cognizant.springrest.dao.SkillDao;
import com.cognizant.springrest.exception.EmployeeNotFoundException;
import com.cognizant.springrest.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillDao skillDao;

    public List<Skill> getAllSkills() {
        return skillDao.getAllSkills();
    }

    public void addSkill(Skill skill) {
        skillDao.addSkill(skill);
    }

    public void updateSkill(Skill skill) throws EmployeeNotFoundException {
        skillDao.updateSkill(skill);
    }

    public void deleteSkill(Integer id) throws EmployeeNotFoundException {
        skillDao.deleteSkill(id);
    }
}
