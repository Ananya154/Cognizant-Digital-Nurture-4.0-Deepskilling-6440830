package com.cognizant.springrest.controller;

import com.cognizant.springrest.exception.EmployeeNotFoundException;
import com.cognizant.springrest.model.Skill;
import com.cognizant.springrest.service.SkillService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SkillController.class);

    @Autowired
    private SkillService skillService;

    @GetMapping
    public List<Skill> getAllSkills() {
        LOGGER.info("Start getAllSkills");
        return skillService.getAllSkills();
    }

    @PostMapping
    public void addSkill(@RequestBody @Valid Skill skill) {
        LOGGER.info("Start addSkill");
        skillService.addSkill(skill);
    }

    @PutMapping
    public void updateSkill(@RequestBody @Valid Skill skill) throws EmployeeNotFoundException {
        LOGGER.info("Start updateSkill");
        skillService.updateSkill(skill);
    }

    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Integer id) throws EmployeeNotFoundException {
        LOGGER.info("Start deleteSkill");
        skillService.deleteSkill(id);
    }
}
