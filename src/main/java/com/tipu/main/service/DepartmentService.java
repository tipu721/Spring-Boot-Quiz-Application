package com.tipu.main.service;

import com.tipu.main.base.BaseService;
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
public class DepartmentService extends BaseService{

    @Autowired
    DepartmentRepo departmentRepo;
    public void save(Department department) {
        departmentRepo.save(department);
    }

    public List<Department> getList(Integer pageStart, Integer pageLength, Integer sortColumnNo) {
        return departmentRepo.findByPage(pageStart, pageLength, sortColumnNo);
    }

    public Map<String, Object> getPage(Map<String, Object>reqMap) {

        Pageable pagereq = this.preparePageRequest(reqMap);
        Page page = departmentRepo.findAll(pagereq);
        Map<String, Object>response = new HashMap<>();
        response.put("recordsTotal", page.getTotalElements());
        response.put("recordsFiltered", page.getTotalElements() );
        response.put("data", page.getContent());

        return  response;


    }
}
