/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gumer.beans;

import com.gumer.endo.entity.HibernateUtil;
import com.gumer.endo.entity.Nurses;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pdf.PdfCreator;

@ManagedBean (name = "nurse")
@SessionScoped
public class NurseBean {
     private int id;
     private String firstName;
     private String lastName;
     private String fatherName;

    public NurseBean() {
     
    }
    
    public void download() throws FileNotFoundException, IOException, DocumentException{
        PdfCreator creator = new PdfCreator();
        creator.download();

       
    }

     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }
     

}
