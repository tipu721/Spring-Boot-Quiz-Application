package com.tipu.main.controller;

import com.tipu.main.model.Department;
import com.tipu.main.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/add")
    String showAddDepartmentForm(Model model) {
        model.addAttribute("department", new Department());
        return "department/add";
    }

    @PostMapping("/save")
    String saveStudent(Department department){
        departmentService.save(department);
        return "redirect:/Department/list";
    }
    @GetMapping("/list")
    String listStudent(Model model){
        List<Department> departmentList = departmentService.getList();
        model.addAttribute("departmentList", departmentList);
        return "/department/list";
    }
}
