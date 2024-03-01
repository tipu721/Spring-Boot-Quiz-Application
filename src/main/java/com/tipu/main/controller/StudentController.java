package com.tipu.main.controller;

import com.tipu.main.model.Student;
import com.tipu.main.repository.StudentRepo;
import com.tipu.main.service.DepartmentService;
import com.tipu.main.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller

@RequestMapping("/Student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    StudentRepo studentRepo;

    @GetMapping("/add")
    String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("departmentList", departmentService.getList());
        return "student/add";
    }

    @PostMapping("/save")
   String saveStudent(Student student){
        studentService.save(student);
        return "redirect:/Student/list";
    }
    @GetMapping("/list")
    String listStudent(Model model){
        List<Student> studentList = studentService.getList();
        model.addAttribute("studentList", studentList);
        return "/student/list";
    }
}
