package com.tipu.main.controller;

import com.tipu.main.model.Department;
import com.tipu.main.model.Faculty;
import com.tipu.main.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Faculty")
public class FacultyController {

    @Autowired
    FacultyService facultyService;

    @GetMapping("/add")
    String addForm(Model model){
        Faculty faculty = new Faculty();
        List<Department>departmentList = new ArrayList<>();
        for(int i=0; i<3; i++){
            departmentList.add(new Department());
        }
        faculty.setDepartmentList(departmentList);
        model.addAttribute("faculty", faculty);
        return "faculty/add.html";
    }
    @PostMapping("/save")
    String saveFaculty(Faculty faculty){
        facultyService.save(faculty);
        return "redirect:/Faculty/list";
    }

    @GetMapping("/list")
    String listFaculty(Model model){
        List<Faculty> facultyList = facultyService.getList();
        model.addAttribute("facultyList", facultyList);
        return "/faculty/list";
    }

    @GetMapping("/ajax/{id}")
    @ResponseBody
    Optional<Faculty> GetFaculty(@PathVariable("id") Integer id){
         return facultyService.getFaculty(id);
    }

}
