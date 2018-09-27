package com.gumer.endo.entity;
// Generated May 17, 2016 5:50:10 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Patients generated by hbm2java
 */
@Entity
@Table(name="patient"
    ,schema="public"
)
public class Patient  implements java.io.Serializable {


     private int id;
     private String firstName;
     private String lastName;
     private String fatherName;
     private String adress;
     private String gengre;
     private String region;
     private String socialStatus;
     private String birthDate;
     private int age;
     private Set surveyses = new HashSet(0);

    public Patient() {
    }

	
    public Patient(int id, String firstName, String lastName, String fatherName, String adress, String gengre, String region, String socialStatus, String birthDate, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.adress = adress;
        this.gengre = gengre;
        this.region = region;
        this.socialStatus = socialStatus;
        this.birthDate = birthDate;
        this.age = age;
    }
    public Patient(int id, String firstName, String lastName, String fatherName, String adress, String gengre, String region, String socialStatus, String birthDate, int age, Set surveyses) {
       this.id = id;
       this.firstName = firstName;
       this.lastName = lastName;
       this.fatherName = fatherName;
       this.adress = adress;
       this.gengre = gengre;
       this.region = region;
       this.socialStatus = socialStatus;
       this.birthDate = birthDate;
       this.age = age;
       this.surveyses = surveyses;
    }
   
    @Id 
    @Column(name="id")
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="first_name")
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    @Column(name="last_name")
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    @Column(name="father_name")
    public String getFatherName() {
        return this.fatherName;
    }
    
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    
    @Column(name="adress")
    public String getAdress() {
        return this.adress;
    }
    
    public void setAdress(String adress) {
        this.adress = adress;
    }

    
    @Column(name="gengre")
    public String getGengre() {
        return this.gengre;
    }
    
    public void setGengre(String gengre) {
        this.gengre = gengre;
    }

    
    @Column(name="region")
    public String getRegion() {
        return this.region;
    }
    
    public void setRegion(String region) {
        this.region = region;
    }

    
    @Column(name="social_status")
    public String getSocialStatus() {
        return this.socialStatus;
    }
    
    public void setSocialStatus(String socialStatus) {
        this.socialStatus = socialStatus;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="birth_date", length=13)
    public String getBirthDate() {
        return this.birthDate;
    }
    
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    
    @Column(name="age")
    public int getAge() {
        return this.age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }


}


