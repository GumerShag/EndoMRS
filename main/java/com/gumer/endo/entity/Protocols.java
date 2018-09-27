package com.gumer.endo.entity;
// Generated May 17, 2016 5:50:10 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Protocols generated by hbm2java
 */
@Entity
@Table(name="protocols"
    ,schema="public"
)
public class Protocols  implements java.io.Serializable {


     private int id;
     private String surveyName;
     private String description;
     private String conclusion;

   

    public Protocols() {
    }

    public Protocols(int id, String surveyName, String conclusion, String description) {
       this.id = id;
       this.conclusion = conclusion;
       this.surveyName = surveyName;
       this.description = description;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    @Column(name="conclusion", nullable = false)
    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
    
    @Column(name="survey_name", nullable=false)
    public String getSurveyName() {
        return this.surveyName;
    }
    
    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    
    @Column(name="description", nullable=false)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }




}


