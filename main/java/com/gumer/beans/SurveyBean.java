/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gumer.beans;

import com.gumer.endo.entity.DAO.PatientDAO;
import com.gumer.endo.entity.DAO.SurveyDAO;
import com.gumer.endo.entity.DBHelper.DBHelper;
import com.gumer.endo.entity.Departments;
import com.gumer.endo.entity.Diagnosis;
import com.gumer.endo.entity.Manipulation;
import com.gumer.endo.entity.Patient;
import com.gumer.endo.entity.Patients;
import com.gumer.endo.entity.Protocols;
import com.gumer.endo.entity.Surveys;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import pdf.PdfCreator;

/**
 *
 * @author Евгений
 */
@ManagedBean (name = "survey")
@ViewScoped
public class SurveyBean implements Serializable{
    private int id = 0;
    private String patientData;
    private int patientId;
    private String surveyName;
    private List<Protocols> protocolList;
    private String protocolDescr ;
    private String diagnosis;
    private String guider;
     private String surveyType;
     private String anethesia ;
     private String surgeonName;
     private String nurseName;
     private String protocol ;
     private String manipulation;
     private String conclusion ;
     private String helicoTest ;
     private String acidityTest;
     private String todaydate;
     private String surveydate;
     
    public void navigate() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("patientcard.xhtml" + "?" + "patientId=" + patientId);
    }

    public String getSurveydate() {
        return surveydate;
    }

    public void setSurveydate(String surveydate) {
        this.surveydate = surveydate;
    }
     
     public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getGuider() {
        return guider;
    }

    public void setGuider(String guider) {
        this.guider = guider;
    }

    public String getAnethesia() {
        return anethesia;
    }

    public void setAnethesia(String anethesia) {
        this.anethesia = anethesia;
    }

    public String getSurgeonName() {
        return surgeonName;
    }

    public void setSurgeonName(String surgeonName) {
        this.surgeonName = surgeonName;
    }
     public String getSurveyType() {
        return surveyType;
    }

    public void setSurveyType(String surveyType) {
        this.surveyType = surveyType;
    }

    public String getNurseName() {
        return nurseName;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
       
    }

    public String getManipulation() {
        return manipulation;
    }

    public void setManipulation(String manipulation) {
        this.manipulation = manipulation;
    }

    public String getHelicoTest() {
        return helicoTest;
    }

    public void setHelicoTest(String helicoTest) {
        this.helicoTest = helicoTest;
    }

    public String getAcidityTest() {
        return acidityTest;
    }

    public void setAcidityTest(String acidityTest) {
        this.acidityTest = acidityTest;
    }

   
    public void setProtocolDescr(String protocolDescr) {
        this.protocolDescr = protocolDescr;
    }

    public String getProtocolDescr() {
        return protocolDescr;
    }
    

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

     public int getPatientId() {
      
         return patientId;
        
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
        
                  
    }

    public void setPatientdata(String patientData) {
        this.patientData = patientData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
  //TODO DB Helper inside the class as it being use in other methods
    public String getPatientdata(){
        DBHelper dBHelper = DBHelper.getInstance();
        Patient patient = new Patient();
        if(patientId != 0){
          patient = dBHelper.getPatientById(patientId);  
          return "Пациент: " + patient.getLastName() + " " + patient.getFirstName() + " " + patient.getFatherName()+ "." + " Пол: " + patient.getGengre() + "."
                  + " Возраст: " + patient.getAge() + " лет.";
        }else return "Error!";
    }
    
    
    public List<String> getDepartmentsList(){
        DBHelper dbhelper = DBHelper.getInstance();
        List<Departments>  departmentList = dbhelper.getDepartmetsList();
        List<String> depNameList = new ArrayList<>();
        if (departmentList != null){
            for (Departments departments : departmentList) {
                depNameList.add(departments.getName());
            }
        } else{
            depNameList.add("Error in loading");
        }       
        return depNameList; 
        
    }
    //TODO: Rename this method to getProtocolsBySystemSurveyName
    public void getProtocols(){
        DBHelper dbHelper = DBHelper.getInstance();
        if(surveyName == null){
        protocolList = dbHelper.getProtocolBySurveyName(UserBean.surveyNameIndicator);
        } else protocolList = dbHelper.getProtocolBySurveyName(surveyName);
    }
    
    
    
    public List<String> getDiagnosisList(){
        DBHelper dBHelper = DBHelper.getInstance();
        List<Diagnosis> diagnosisesList;
        if(surveyName == null){
        diagnosisesList = dBHelper.getDiagnosisBySurveyType(UserBean.surveyNameIndicator);
        } else diagnosisesList = dBHelper.getDiagnosisBySurveyType(surveyName);
        List<String> diagnosNameList = new ArrayList<>();
        if(diagnosisesList != null){
            for (Diagnosis d : diagnosisesList) {
                diagnosNameList.add(d.getDiagnosisName());
            }
        } else {
                diagnosNameList.add("Error in loading");
                }
        return diagnosNameList;
    }
    
    public List<String> getManipualtionList(){
        DBHelper dBHelper = DBHelper.getInstance();
        List<Manipulation> manipulationList; 
        if(surveyName == null){
        manipulationList = dBHelper.getManipulationBySurveyType(UserBean.surveyNameIndicator);
        } else manipulationList = dBHelper.getManipulationBySurveyType(surveyName);
        
        List<String> manipulationNameList = new ArrayList<>();
        if(manipulationList != null){
            for (Manipulation m : manipulationList) {
                manipulationNameList.add(m.getManipulationName());
            }
        } else {
                 manipulationNameList.add("Error in loading");
                }
        return  manipulationNameList;
    }
    
    public String getSurveyName(){
        String type = "";
        if(UserBean.surveyNameIndicator.equals("fgds")){
            type  = "ФГДС";
            surveyName = "fgds";
        }else if (UserBean.surveyNameIndicator.equals("fks")){
            type = "ФКС";
            surveyName = "fks";
        } else if(UserBean.surveyNameIndicator.equals("fbs")) {
            type = "ФБС";
            surveyName = "fbs";
        }
     return type;
         }
    
    public String convertSurveyNameFromEnglish(){
        String result;
        switch(surveyName){
            case "fks": result = "ФКС";
                break;
            case "fbs": result = "ФБС";
                break;
            case "fgds": result = "ФГДС";
                break;
            default: result = "Error";
                break;
        }
        return result;
    }
    private String convertSurveyNameToEnglish(String surveyName){
          
        switch(surveyName){
            case "ФКС": surveyName = "fks";
                break;
            case "ФБС": surveyName = "fbs";
                break;
            case "ФГДС": surveyName = "fgds";
                break;
            default: surveyName = "Error";
                break;
        }
        return surveyName;
    }
    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public List<String> getProtocolConslusion() {
        List<String> protocolConslusionList = new ArrayList<>();
        getProtocols();
        if (protocolList != null) {
            for (Protocols protocol : protocolList) {
                protocolConslusionList.add(protocol.getConclusion());
            }
        } else {
            protocolConslusionList.add("Error in loading");
        }
        updateDescr();
        return protocolConslusionList;
    }
    
    public void updateDescr(){
        for (Protocols protocols : protocolList) {
           // System.out.println(protocol + "protocol value" + "from server = " + protocols.getConclusion());
            if(protocols.getConclusion().equals(protocol)){
                protocolDescr= protocols.getDescription();
            }
        }
       
    }
    
   public String getTodaydate(){
       DateTime dt = new DateTime() ;
       this.todaydate = dt.toString("dd.MM.yyyy");
       return this.todaydate;
   }
   
   public String getTodayDateFromField(){
       return this.todaydate;
   }
   
   public void setTodayDateFromField(String todaydate){
       this.todaydate = todaydate;
   }
   
   public void setTodaydate(String todaydate) {
        this.todaydate = todaydate;
    }
   
     
   public void saveSurvey(){
      
     Surveys survey  = new Surveys(id, this.patientId, getJDKDate(todaydate), surveyName, diagnosis, guider, surveyType, 
              anethesia, surgeonName, nurseName, protocol, protocolDescr, manipulation, conclusion, helicoTest, acidityTest );
      System.out.println(survey.toString());
      SurveyDAO dao = new SurveyDAO();
      dao.saveSurvey(survey);
   }
   
   public void loadSurveyById(){
       if (id != 0) {
           DBHelper dbHelper = DBHelper.getInstance();
           Surveys survey = dbHelper.getSurveyById(id);
           patientId = survey.getPatientId();
           surveyName = survey.getSurveyName();
           diagnosis = survey.getGuideDiagnosis();
           guider = survey.getGuide();
           surveyType = survey.getSurveyType();
           anethesia = survey.getAnethesia();
           surgeonName = survey.getSurgeonName();
           nurseName = survey.getNurseName();
           protocol = survey.getProtocol();
           protocolDescr = survey.getProtocolDescr();
           manipulation = survey.getManipulation();
           conclusion = survey.getConclusion();
           helicoTest = survey.getHelicoTest();
           acidityTest = survey.getAcidityTest();
           surveydate = getStringFromDate(survey.getDate());
           getPatientdata();
       }
       
   }
   
   public void updateSurveyInfo(){
       SurveyDAO surveyDAO = new SurveyDAO();
       Surveys survey = new Surveys(id, patientId, getJDKDate(surveydate), surveyName, diagnosis, guider, surveyType, anethesia, surgeonName, nurseName, protocol, protocolDescr, manipulation, conclusion, helicoTest, acidityTest);
       surveyDAO.updateProtocolInfo(survey);
       
   }
   
   private Date getJDKDate(String strDate){
      
       int day = 0, month = 0, year = 0;
       Pattern pattern = Pattern.compile("(\\d+).(\\d+).(\\d+)");
       Matcher matcher = pattern.matcher(strDate);
       while(matcher.find()){
           day = Integer.valueOf(matcher.group(1));
           month = Integer.valueOf(matcher.group(2));
           year = Integer.valueOf(matcher.group(3));
       }
       LocalDate date = new LocalDate(year, month, day);
       return date.toDate();
   }
   
   private String getStringFromDate (Date date){
       DateTime dt = new DateTime(date);
       return dt.toString("dd.MM.yyyy");
   }
   
   
   public void printSurveyProtocol(){
       saveSurvey();
       Patient patient = new Patient();
       DBHelper dbHelper = DBHelper.getInstance();
       patient = dbHelper.getPatientById(patientId);
       String patientName = patient.getLastName() + " " + patient.getFirstName() + " " + patient.getFatherName();
       System.out.println("Patient = " + patient.getLastName());
       PdfCreator pdfCreator = new PdfCreator(convertSurveyNameFromEnglish(), patientName, patient.getAge(),getTodaydate(), patient.getGengre(), patient.getAdress(), 
               patient.getRegion(), diagnosis, surveyType, anethesia, protocolDescr, helicoTest, acidityTest, conclusion, surgeonName);
        try {
            pdfCreator.download();
        } catch (IOException ex) {
            Logger.getLogger(SurveyBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(SurveyBean.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   
     public void printSurveyProtocolFromSaved(){
       Patient patient = new Patient();
       DBHelper dbHelper = DBHelper.getInstance();
       patient = dbHelper.getPatientById(patientId);
       String patientName = patient.getLastName() + " " + patient.getFirstName() + " " + patient.getFatherName();
       System.out.println("Patient = " + patient.getLastName());
       PdfCreator pdfCreator = new PdfCreator(convertSurveyNameFromEnglish(), patientName, patient.getAge(),getStringFromDate(getJDKDate(surveydate)), patient.getGengre(), patient.getAdress(), 
               patient.getRegion(), diagnosis, surveyType, anethesia, protocolDescr, helicoTest, acidityTest, conclusion, surgeonName);
        try {
            pdfCreator.download();
        } catch (IOException ex) {
            Logger.getLogger(SurveyBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(SurveyBean.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
}
