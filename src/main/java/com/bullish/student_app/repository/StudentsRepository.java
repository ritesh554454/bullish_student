package com.bullish.student_app.repository;

import com.bullish.student_app.studentAttributes.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public class StudentsRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Student> findAll() {
        return jdbcTemplate.query("select * from students", new BeanPropertyRowMapper<Student>(Student.class));
    }

    public Student createStudent(Student student) {
        int result = jdbcTemplate.update("insert into students(id, firstName, lastName, className, nationality) values(?, ?, ?, ?, ?)",
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getClassName(),
                student.getNationality()
                );
        return student;
    }

    public Student deleteStudent(Student student){
        String deleteQuery = "delete from students where";
        if(null!=student.getClassName()) {
            deleteQuery = deleteQuery.concat(" CLASSNAME='").concat(student.getClassName().concat("',"));
        }else
            deleteQuery = deleteQuery.concat(" id=").concat(Integer.toString(student.getId()));
        int result = jdbcTemplate.update(deleteQuery);
        return student;
    }

    public Student updateStudent(Student student) {
        String _updateQuery = "update students set";
        String _valueQuery = " values(?";
        if(null != student.getFirstName()) {
            _updateQuery = _updateQuery.concat(" FIRSTNAME='").concat(student.getFirstName()).concat("',");
        }
        if(null != student.getLastName()) {
            _updateQuery = _updateQuery.concat(" LASTNAME='").concat(student.getLastName()).concat("',");
        }
        if(null != student.getClassName()) {
            _updateQuery = _updateQuery.concat(" CLASSNAME='").concat(student.getClassName()).concat("',");
        }
        if(null != student.getNationality()) {
            _updateQuery = _updateQuery.concat(" NATIONALITY='").concat(student.getNationality()).concat("',");
        }
        _updateQuery=_updateQuery.substring(0, _updateQuery.length() - 1);
        _updateQuery=_updateQuery.concat(" WHERE id=").concat(Integer.toString(student.getId()));

        System.out.println("update query: ".concat(_updateQuery));
        int result = jdbcTemplate.update(_updateQuery);
        return student;
    }

    public List<Student> findById(int id) {
        String sql = "SELECT * FROM students WHERE ID = ?";
        return jdbcTemplate.query(sql,new Object[]{id}, new BeanPropertyRowMapper<Student>(Student.class));

    }

    public List<Student> findByClass(String stud_class) {
        String sql = "SELECT * FROM students WHERE className = ?";
        return jdbcTemplate.query(sql,new Object[]{stud_class}, new BeanPropertyRowMapper<Student>(Student.class));
    }

    public List<Student> findStudent(Map<String, String> dataQuery) {
        String _query = "SELECT * FROM students where 1=1";
        if(dataQuery.containsKey("id")) {
            _query=_query.concat(" AND ID='").concat(dataQuery.get("id")).concat("'");
        }
        if(dataQuery.containsKey("firstName")) {
            _query=_query.concat(" AND FIRSTNAME='").concat(dataQuery.get("firstName")).concat("'");
        }
        if(dataQuery.containsKey("lastName")) {
            _query=_query.concat(" AND LASTNAME='").concat(dataQuery.get("lastName")).concat("'");
        }
        if(dataQuery.containsKey("class")) {
            _query=_query.concat(" AND CLASSNAME='").concat(dataQuery.get("class")).concat("'");
        }
        if(dataQuery.containsKey("nationality")) {
            _query=_query.concat(" AND NATIONALITY='").concat(dataQuery.get("nationality")).concat("'");
        }
        System.out.println(_query);
        return jdbcTemplate.query(_query, new BeanPropertyRowMapper<Student>(Student.class));
    }

}
