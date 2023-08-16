package id.ac.ui.cs.exercise0.service;

import id.ac.ui.cs.exercise0.exception.StudentNotFoundException;
import id.ac.ui.cs.exercise0.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
public class StudentServiceImpl implements Service.StudentService {
    private Map<String, Student> studentMap = new HashMap<>();

    @Override
    public Student createStudent(Student student) {
        studentMap.put(student.getStudentId(), student);
        return student;
    }

    @Override
    public List<Student> findAllStudent() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public Student findByStudentId(String studentId) {
        Student target = studentMap.get(studentId);
        if (target == null) {
            throw new StudentNotFoundException(String.format(
                    "Can't find student with id: %s", studentId));
        }

        return target;
    }
}
