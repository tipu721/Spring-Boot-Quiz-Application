package com.tipu.main.controller;

import com.tipu.main.model.Department;
import com.tipu.main.model.Student;
import com.tipu.main.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    String saveDepartment(Department department){
        departmentService.save(department);
        return "redirect:/Department/list";
    }
//    @GetMapping("/list")
//    String listDepartment(Model model){
//        List<Department> departmentList = departmentService.getList();
//        model.addAttribute("departmentList", departmentList);
//        return "/department/list";
//    }

    @RequestMapping("/list/ajax")
    @ResponseBody
    Map<String,Object> getPageList(@RequestParam(name = "start") Integer start, @RequestParam(name="length") Integer pageLength, @RequestParam(name="order[0][column]") Integer sortColumn, @RequestParam(name="order[0][dir]") String orderDir){

        Map<String, Object>responseMap = new HashMap<>();

        List<Department>departmentList =  departmentService.getList(start, pageLength, sortColumn+1);

        if(orderDir.equals("desc")){
            Collections.sort(departmentList, Collections.reverseOrder());
        }

        responseMap.put("data",departmentList);
        Integer totalRow = departmentService.getTotalRow();
        responseMap.put("recordsTotal",totalRow);
        responseMap.put("recordsFiltered",totalRow);

        return responseMap;

    }

}
