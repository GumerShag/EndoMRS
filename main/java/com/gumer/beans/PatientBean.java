package com.gumer.beans;

import com.gumer.endo.entity.DAO.PatientDAO;
import com.gumer.endo.entity.DBHelper.DBHelper;
import com.gumer.endo.entity.Patient;
import com.gumer.endo.entity.Surveys;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.PeriodType;

/**
 *
 * @author Gumer
 */
@ManagedBean(name = "patient")
@ViewScoped
public class PatientBean {

    private int id;
    private String firstname;
    private String lastname;
    private String fathername;
    private String adress;
    private String gengre;
    private String region;
    private String socialstatus = "Статус";
    private String birthDate;
    private int age;
    private String navigate = "newsurvey";
    private List<Surveys> surveyList = new ArrayList<>();
    

//    public String navigate() {
//        return navigate;
//    }
//    public void setNavigate(String navigate) {
//        this.navigate = navigate;
//    }
    public void navigate() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("newsurvey.xhtml" + "?" + "patientId=" + id);
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    //Date helper stings
    private String day;
    private String month;
    private String year;

    public void clearAll() {
        this.firstname = "";
        this.lastname = "";
        this.fathername = "";
        this.adress = "";
        this.gengre = "";
        this.region = "";
        this.socialstatus = "";
        this.birthDate = null;
        this.age = 0;
    }

    public int countAge(int year, int month, int day) {
        LocalDate birthDate = new LocalDate(year, month, day);
        LocalDate todayDate = new LocalDate();
        Period period = new Period(birthDate, todayDate, PeriodType.yearMonthDay());

        return Integer.valueOf(period.getYears());

    }

    public void savePatient() {

        PatientDAO dao = new PatientDAO();
        //countAge();
        printvalues();
        age = countAge(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));
        birthDate = day + "." + month + "." + year;
        Patient patient = new Patient(id, firstname, lastname, fathername, adress, gengre, region, socialstatus, birthDate, age);
        dao.addPatient(patient);
        id = dao.getPatientId();
        clearAll();

    }

    public void loadPatientById() {
        if (id != 0) {
            DBHelper dbHelper = DBHelper.getInstance();
            Patient patient = dbHelper.getPatientById(id);
            firstname = patient.getFirstName();
            lastname = patient.getLastName();
            fathername = patient.getFatherName();
            birthDate = patient.getBirthDate();
            age = patient.getAge();
            adress = patient.getAdress();
            region = patient.getRegion();
            gengre = patient.getGengre();
            List<Surveys> rowList = new ArrayList();
            rowList = dbHelper.getSurveyByPatientId(id);
            for (Surveys surveys : rowList) {
                if(surveys.getSurveyName().equals("fgds")){
                    surveys.setSurveyName("Фиброгастродуэндоскопия");
                }
                if(surveys.getSurveyName().equals("fks")){
                    surveys.setSurveyName("Фиброколоноскопия");
                }
                if(surveys.getSurveyName().equals("fbs")){
                    surveys.setSurveyName("Фибробронхоскопия");
                }
                surveyList.add(surveys);
            }
        }
    }
    
    public void updatePatientInfo(){
        PatientDAO patientDAO = new PatientDAO();
        Patient patient = new Patient(id, firstname, lastname, fathername, adress, gengre, region, socialstatus, birthDate, age);
        patientDAO.updatePatient(patient);
    }
    public List<Patient> getAllPatients(){
        List<Patient> patientList = new ArrayList<>();
        DBHelper dBHelper = DBHelper.getInstance();
        List<Patient> rowList = dBHelper.getAllPatients();
        for (Patient patient : rowList) {
            patient.setFirstName(patient.getLastName() + " " + patient.getFirstName() + " " + patient.getFatherName());
            patientList.add(patient);
        }
        return patientList;
    }
    
    public List<Surveys> getSurveyList() {
        return surveyList;
    }

    public void setSurveyList(List<Surveys> surveyList) {
        this.surveyList = surveyList;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fatherName) {
        this.fathername = fatherName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getGengre() {
        return gengre;
    }

    public void setGengre(String gengre) {
        this.gengre = gengre;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSocialstatus() {
        return socialstatus;
    }

    public void setSocialstatus(String socialStatus) {
        this.socialstatus = socialStatus;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void printvalues() {

        System.out.println("Vales = " + lastname + firstname + fathername + day + month + year + gengre + adress
                + region + socialstatus);
    }
    
    

}
