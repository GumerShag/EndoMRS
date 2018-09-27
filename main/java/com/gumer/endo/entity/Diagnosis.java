/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gumer.endo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Gumer
 */
@Entity
@Table (name = "diagnosis" ,
        schema = "public")
public class Diagnosis implements Serializable {
    
    private int id;
    private String surveyType;
    private String diagnosisName;

    public Diagnosis() {
    }

    public Diagnosis(int id, String surveyType, String diagnosisName) {
        this.id = id;
        this.surveyType = surveyType;
        this.diagnosisName = diagnosisName;
    }
    
    @Id
    @Column (name = "id", unique = true)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column (name = "survey_type")
    public String getSurveyType() {
        return surveyType;
    }

    public void setSurveyType(String surveyType) {
        this.surveyType = surveyType;
    }
    @Column (name = "diagnosis_name")
    public String getDiagnosisName() {
        return diagnosisName;
    }

    public void setDiagnosisName(String diagnosisName) {
        this.diagnosisName = diagnosisName;
    }
    
}
