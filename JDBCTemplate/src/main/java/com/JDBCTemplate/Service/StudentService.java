package com.JDBCTemplate.Service;

import com.JDBCTemplate.Controller.StudentController;
import com.JDBCTemplate.Model.Student;
import com.JDBCTemplate.Repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Service
@Slf4j
public class StudentService {
	Logger logger = LoggerFactory.getLogger(StudentService.class);
    @Autowired
    private StudentRepository studentRepository;

    public int createNewStudent(Student student) {
        log.info("Student Body Received:", student.toString());
        return studentRepository.createNewStudent(student);
    }

    public List<Student> fetchAllStudents() {
        List<Student> studentList = studentRepository.fetchAllStudent();
        if(studentList.isEmpty()) {
            log.error("No students exist");
            throw new RuntimeException("No Students Exist");
        }
        return studentList;
    }
    public Student fetchStudentById(Integer id) {
        Student student = studentRepository.fetchStudentById(id);
        if(student == null) {
            log.error("No student exist");
            throw new RuntimeException("No Student Exist");
        }
        return student;
    }
}