package com.learntech.springdata;

import com.learntech.springdata.model.Student;
import com.learntech.springdata.service.StudentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class StudentDataDemoApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentDataDemoApplication.class);
    private static StudentService studentService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StudentDataDemoApplication.class, args);        studentService = context.getBean(StudentService.class);

        LOGGER.info("Inside main method");
        testGetAllStudents();
    }
    private static void testGetAllStudents() {
        LOGGER.info("START: testGetAllStudents");
        List<Student> students = studentService.getAllStudents();
        LOGGER.debug("Students List = {}", students);
        LOGGER.info("END: testGetAllStudents");
    }
}
