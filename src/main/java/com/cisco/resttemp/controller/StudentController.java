package com.cisco.resttemp.controller;

import com.cisco.resttemp.dto.StudentDTO;
import com.cisco.resttemp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Integer saveStudent(@RequestBody StudentDTO studentDTO){
        return studentService.saveStudent(studentDTO);
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable String id){
        return studentService.getStudentById(id);
    }

    @GetMapping
    public List<StudentDTO> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PutMapping("/{id}")
    public Integer updateStudent(@RequestBody StudentDTO studentDTO){
        return studentService.updateStudent(studentDTO);
    }

    @DeleteMapping("/{id}")
    public Integer deleteStudent(@PathVariable String id){
        return studentService.deleteStudent(id);
    }

}
