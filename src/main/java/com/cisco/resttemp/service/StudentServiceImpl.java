package com.cisco.resttemp.service;


import com.cisco.resttemp.dto.StudentDTO;
import com.cisco.resttemp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Integer saveStudent(StudentDTO studentDTO) {
        return studentRepository.saveStudent(studentDTO);
    }

    @Override
    public StudentDTO getStudentById(String id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @Override
    public Integer deleteStudent(String id) {
        return studentRepository.deleteStudent(id);
    }

    @Override
    public Integer updateStudent(StudentDTO studentDTO) {
        return studentRepository.updateStudent(studentDTO);
    }

}
