package id.ac.ui.cs.exercise0.service;

import id.ac.ui.cs.exercise0.model.Student;

import java.util.List;

public class Service {

    public interface StudentService {

        Student createStudent(Student student);
        List<Student> findAllStudent();
        Student findByStudentId(String studentId);
    }
}
