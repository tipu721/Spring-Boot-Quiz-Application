package com.tipu.main.service;

import com.tipu.main.model.Department;
import com.tipu.main.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepo departmentRepo;
    public void save(Department department) {
        departmentRepo.save(department);
    }

    public List<Department> getList(Integer pageStart, Integer pageLength, Integer sortColumnNo) {
        return departmentRepo.findByPage(pageStart, pageLength, sortColumnNo);
    }

    public Map<String, Object> getPage(Map<String, Object>reqMap) {

        Map<String, Object>response = new HashMap<>();

        Integer start = Integer.valueOf((String) reqMap.get("start"));
        Integer length = Integer.valueOf((String) reqMap.get("length"));


        Pageable pagereq = null;

        if(reqMap.get("order[0][column]") != null){

            Integer sortColumnNo = Integer.valueOf((String) reqMap.get("order[0][column]"));
            String mapKey = "columns["+sortColumnNo+"][data]";
            String  sortColumnName = (String) reqMap.get(mapKey);
            if(reqMap.get("order[0][dir]").equals("desc")){
                pagereq = PageRequest.of((start/length), length, Sort.by(Sort.Direction.DESC,sortColumnName));
            }
            else if(reqMap.get("order[0][dir]").equals("asc")) {
                pagereq = PageRequest.of((start/length), length, Sort.by(Sort.Direction.ASC,sortColumnName));
            }

        }
        else{
            pagereq = PageRequest.of((start/length), length);
        }

        Page page = departmentRepo.findAll(pagereq);
        response.put("recordsTotal", page.getTotalElements());
        response.put("recordsFiltered", page.getTotalElements() );
        response.put("data", page.getContent());

        return  response;


    }
}
