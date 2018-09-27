/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gumer.beans;

import com.gumer.endo.entity.DAO.DepartmentDAO;
import com.gumer.endo.entity.Departments;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Евгений
 */
@ManagedBean (name = "department")
@ViewScoped
public class DepartmentBean {
    
    private int id;
     private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addDepartment(){
        DepartmentDAO departmentDAO = new DepartmentDAO();
        Departments departments = new Departments(id, name);
        departmentDAO.addDepartment(departments);
    }
}
