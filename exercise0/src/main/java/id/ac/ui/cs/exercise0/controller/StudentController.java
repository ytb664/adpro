package id.ac.ui.cs.exercise0.controller;

import id.ac.ui.cs.exercise0.model.Student;
import id.ac.ui.cs.exercise0.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private Service.StudentService studentService;

    @GetMapping("/findAll")
    public String findAllStudent(Model model) {

        List<Student> student = studentService.findAllStudent();
        model.addAttribute("studentList", student);
        return "allstudent";
    }

    @GetMapping("/addNew")
    public String addNewStudent(Model model) {

        Student student = new Student();
        model.addAttribute("student", student);
        return "createstudent";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute("student") Student student) {

        studentService.createStudent(student);
        return "redirect:/student/findAll";
    }
}
