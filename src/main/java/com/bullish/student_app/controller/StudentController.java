package com.bullish.student_app.controller;

import com.bullish.student_app.dao.StudentDaoInterface;
import com.bullish.student_app.studentAttributes.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {
    @Autowired
    private StudentDaoInterface studentDao;

    @GetMapping("/students")
    public List<Student> getStudents(@RequestParam Map<String, String> dataQuery) {
        return studentDao.findStudent(dataQuery);
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return studentDao.createStudent(student);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        if(student != null && student.getId() > 0) {
            return studentDao.updateStudent(student);
        }
        return studentDao.updateStudent(student);
    }

    @DeleteMapping(value = "/students")
    public Student deleteStudent(@RequestBody Student student) {
            return studentDao.deleteStudent(student);
    }

}
