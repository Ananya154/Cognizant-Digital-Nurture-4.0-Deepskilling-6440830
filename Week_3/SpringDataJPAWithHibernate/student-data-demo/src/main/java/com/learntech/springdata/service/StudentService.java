package com.learntech.springdata.service;

import com.learntech.springdata.model.Student;
import com.learntech.springdata.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;
@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Transactional
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
}
