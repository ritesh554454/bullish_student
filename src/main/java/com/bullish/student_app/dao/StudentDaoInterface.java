package com.bullish.student_app.dao;

import com.bullish.student_app.studentAttributes.Student;

import java.util.List;
import java.util.Map;

public interface StudentDaoInterface {
    public List<Student> findAllStudents();
    public Student createStudent(Student student);
    public Student deleteStudent(Student student);
    public Student updateStudent(Student student);
    public List<Student> findStudentByID(int id);
    public List<Student> findStudentByClass(String stud_class);
    public List<Student> findStudent(Map<String, String> dataQuery);


}
