/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gumer.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Евгений
 */
@ManagedBean (name = "boot")
@SessionScoped
public class LoginBean {

    private String lastname = "";
    private String firstname = "";
     
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
  
  
 
    public void save(){
         System.out.println("Last name + first name");
         System.out.println("Last name= "+ lastname + firstname);
                
    }
}
