package com.tipu.main.controller;


import com.tipu.main.model.Register;
import com.tipu.main.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Register")
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @GetMapping("/add")
    String registerAddForm(Model model) {
        model.addAttribute("register", new Register());
        return "register/add.html";
    }

    @PostMapping("/save")
    String saveRegister(Register register){
        registerService.save(register);
        return "redirect:/Resigter/list";
    }

    @GetMapping("/list")
    String listRegister(Model model){
        List<Register> registerList = registerService.getList();
        model.addAttribute("registerList", registerList);
        return "/register/list";
    }
}
