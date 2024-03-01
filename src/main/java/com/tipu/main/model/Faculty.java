package com.tipu.main.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "faculty_id", referencedColumnName = "id")
    List<Department> departmentList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    

}
