package com.tipu.main.service;


import com.tipu.main.model.Register;
import com.tipu.main.repository.RegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService {


    @Autowired
    RegisterRepo registerRepo;




    public void save(Register register) {

//        encoder.encode(register.getPassword());
        registerRepo.save(register);
    }

    public List<Register> getList() {

        return registerRepo.findAll();
    }
}
