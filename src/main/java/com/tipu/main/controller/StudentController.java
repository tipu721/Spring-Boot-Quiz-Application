package com.tipu.main.controller;

import com.tipu.main.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/Student")
public class StudentController {

    @RequestMapping("/add")
    String addForm(){
        return "student/add.html";
    }

}
