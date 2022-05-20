package com.cisco.resttemp.controller;

import com.cisco.resttemp.dto.StudentDTO;
import com.cisco.resttemp.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Integer saveStudent(@RequestBody StudentDTO studentDTO){
        logger.info("student controller - post student: {}", studentDTO);
        return studentService.saveStudent(studentDTO);
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable String id){
        logger.info("student controller - get Student: {}", id);
        return studentService.getStudentById(id);
    }

    @GetMapping
    public List<StudentDTO> getAllStudents(){
        logger.info("student controller - get all students");
        return studentService.getAllStudents();
    }

    @PutMapping("/{id}")
    public Integer updateStudent(@RequestBody StudentDTO studentDTO){
        logger.info("student controller - update student: {}", studentDTO);
        return studentService.updateStudent(studentDTO);
    }

    @DeleteMapping("/{id}")
    public Integer deleteStudent(@PathVariable String id){
        logger.info("student controller - delete student: {}", id);
        return studentService.deleteStudent(id);
    }

}
