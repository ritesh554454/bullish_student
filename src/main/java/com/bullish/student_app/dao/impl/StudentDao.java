package com.bullish.student_app.dao.impl;

import com.bullish.student_app.dao.StudentDaoInterface;
import com.bullish.student_app.studentAttributes.Student;
import com.bullish.student_app.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

@Component
public class StudentDao implements StudentDaoInterface {

    @Autowired
    private StudentsRepository studentsRepository;

    @Override
    public List<Student> findAllStudents() {
        return studentsRepository.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        return studentsRepository.createStudent(student);
    }

    @Override
    public Student deleteStudent(Student student) {
         return studentsRepository.deleteStudent(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentsRepository.updateStudent(student);
    }

    @Override
    public List<Student> findStudentByID(int id){
        return studentsRepository.findById(id);
    }

    @Override
    public List<Student> findStudentByClass(String stud_class){
        return studentsRepository.findByClass(stud_class);
    }

    public List<Student> findStudent(Map<String, String> dataQuery){
        return studentsRepository.findStudent(dataQuery);
    }



}
