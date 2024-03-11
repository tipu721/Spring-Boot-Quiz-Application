package com.tipu.main.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class User {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;


    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            joinColumns={@JoinColumn(name="user_id", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
    private List<UserRole> roleList = new ArrayList<>();


    public User() {
    }

    public User(String name, String email, String password, List<UserRole> roleList) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roleList = roleList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<UserRole> roleList) {
        this.roleList = roleList;
    }
}
