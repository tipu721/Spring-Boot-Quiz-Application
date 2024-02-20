package com.tipu.main.controller;

import com.tipu.main.model.Student;
import com.tipu.main.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

@RequestMapping("/Student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/add")
    String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/add";
    }

    @PostMapping("/save")
   String saveStudent(Student student){
        studentService.save(student);
        return "redirect:/Student/list";
    }
    @GetMapping("/list")
    @ResponseBody
    Object listStudent(Model model, @RequestParam(value = "param", required=false) String param){
        List<Student>studentList = studentService.getList();
        if(param != null && param.equals("ajax")){
            return studentList;
        }

        model.addAttribute("studentList", studentList);
        return "/student/list";
    }

    @GetMapping("/list1")

    List<Student> listStudentData(){
        return  studentService.getList();
    }
}
