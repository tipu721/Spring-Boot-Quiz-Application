package com.tipu.main.controller;

import com.tipu.main.model.Question;
import com.tipu.main.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Question")
public class QuestionController {

    @Autowired
    QuestionService questionService;




    @RequestMapping("/add")
    String addForm(Model model){
        model.addAttribute("question", new Question());
        return "question/add.html";
    }
    @PostMapping("/save")
    String save(Question question, Model model){
        questionService.save(question);
        List<Question> questionList = new ArrayList<>();
        questionList = questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question/list.html";

    }
}
