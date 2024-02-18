package com.tipu.main.service;

import com.tipu.main.model.Question;
import com.tipu.main.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionRepo;
    public void save(Question question) {
        questionRepo.save(question);
    }

    public List<Question> getList() {

        return questionRepo.findAll();

    }
}
