package com.cognizant.springrest.dao;

import com.cognizant.springrest.exception.EmployeeNotFoundException;
import com.cognizant.springrest.model.Skill;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SkillDao {

    private static List<Skill> skillList = new ArrayList<>();

    static {
        skillList.add(new Skill(1, "Java"));
        skillList.add(new Skill(2, "Spring Boot"));
        skillList.add(new Skill(3, "React"));
    }

    public List<Skill> getAllSkills() {
        return skillList;
    }

    public void addSkill(Skill skill) {
        skillList.add(skill);
    }

    public void updateSkill(Skill updatedSkill) throws EmployeeNotFoundException {
        boolean found = false;
        for (int i = 0; i < skillList.size(); i++) {
            if (skillList.get(i).getId().equals(updatedSkill.getId())) {
                skillList.set(i, updatedSkill);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new EmployeeNotFoundException("Skill with ID " + updatedSkill.getId() + " not found");
        }
    }

    public void deleteSkill(Integer id) throws EmployeeNotFoundException {
        Skill toDelete = null;
        for (Skill s : skillList) {
            if (s.getId().equals(id)) {
                toDelete = s;
                break;
            }
        }
        if (toDelete != null) {
            skillList.remove(toDelete);
        } else {
            throw new EmployeeNotFoundException("Skill with ID " + id + " not found");
        }
    }
}
