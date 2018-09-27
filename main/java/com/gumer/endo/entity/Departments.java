package com.gumer.endo.entity;
// Generated May 17, 2016 5:50:10 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Departments generated by hbm2java
 */
@Entity
@Table(name="departments"
    ,schema="public"
)
public class Departments  implements java.io.Serializable {


     private int id;
     private String name;

    public Departments() {
    }

    public Departments(int id, String name) {
       this.id = id;
       this.name = name;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="name", nullable=false)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }




}

