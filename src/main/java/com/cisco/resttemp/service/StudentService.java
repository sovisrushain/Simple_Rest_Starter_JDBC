package com.cisco.resttemp.service;

import com.cisco.resttemp.dto.StudentDTO;

import java.util.List;


public interface StudentService {
    Integer saveStudent(StudentDTO studentDTO);
    StudentDTO getStudentById(String id);
    List<StudentDTO> getAllStudents();
    Integer deleteStudent(String id);
    Integer updateStudent(StudentDTO studentDTO);
}
