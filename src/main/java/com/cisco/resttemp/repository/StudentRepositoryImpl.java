package com.cisco.resttemp.repository;

import com.cisco.resttemp.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer saveStudent(StudentDTO studentDTO) {
        String sql = "insert into student (id, name) values (:id, :name)";

        Map<String, String> params = new HashMap<>();
        params.put("id", studentDTO.getId());
        params.put("name", studentDTO.getName());

        return namedParameterJdbcTemplate.update(sql, params);
    }

    @Override
    public StudentDTO getStudentById(String id) {
        String sql = "select * from student where id=?";
        return jdbcTemplate.queryForObject(sql,
                (rs, rowNum) -> new StudentDTO(rs.getString("id"), rs.getString("name")),
                id);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        String sql = "select * from student";
        return jdbcTemplate.query(sql,
                (rs, rowNum) -> new StudentDTO(rs.getString("id"), rs.getString("name")));
        }

    @Override
    public Integer deleteStudent(String id) {
        String sql = "delete from student where id=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Integer updateStudent(StudentDTO studentDTO) {
        String sql = "update student set name=:name where id=:id";
        Map<String, String> params = new HashMap<>();
        params.put("id", studentDTO.getId());
        params.put("name", studentDTO.getName());
        return namedParameterJdbcTemplate.update(sql, params);
    }

}
