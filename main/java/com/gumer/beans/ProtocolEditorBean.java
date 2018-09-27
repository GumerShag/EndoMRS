/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gumer.beans;

import com.gumer.endo.entity.DAO.ProtocolDAO;
import com.gumer.endo.entity.DBHelper.DBHelper;
import com.gumer.endo.entity.Protocols;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Евгений
 */
@ManagedBean (name = "protocoleditor")
@ViewScoped
public class ProtocolEditorBean {

    private String surveyName;
    private List<Protocols> protocolList;
    private String protocol;
    private String protocolDescr;
    private int protocolId;
    
    private String protocolNew;
    private String protocolDescrNew;

    public String getProtocolNew() {
        return protocolNew;
    }

    public void setProtocolNew(String protocolNew) {
        this.protocolNew = protocolNew;
    }

    public String getProtocolDescrNew() {
        return protocolDescrNew;
    }

    public void setProtocolDescrNew(String protocolDescrNew) {
        this.protocolDescrNew = protocolDescrNew;
    }
    
    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getProtocolDescr() {
        return protocolDescr;
    }

    public void setProtocolDescr(String protocolDescr) {
        this.protocolDescr = protocolDescr;
    }
    
    
    public void getProtocolList(){
        DBHelper dbHelper = DBHelper.getInstance();
        protocolList = dbHelper.getProtocolBySurveyName(surveyName); 
       // System.out.println(protocolList.get(1).getConclusion());
    }
    
     public void updateDescr(){
        for (Protocols protocols : protocolList) {
            //System.out.println(protocol + "protocol value" + "from server = " + protocols.getConclusion());
            if(protocols.getConclusion().equals(protocol)){
                protocolDescr = protocols.getDescription();
                protocolId = protocols.getId();
            }
        }
       
    }
   
     public List<String> getProtocolConslusion() {
        List<String> protocolConslusionList = new ArrayList<>();
        getProtocolList();
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
     
     public String getSurveyNameInRussian(){
         String localSurveyName;
         if (surveyName != null){
                switch(surveyName){
                   case "fks": localSurveyName = "ФКС";
                       break;
                   case "fbs": localSurveyName = "ФБС";
                       break;
                   case "fgds": localSurveyName = "ФГДС";
                       break;
                   default: localSurveyName = "Error";
                       break;
               }
            return localSurveyName;
         } else return "Error";
     }
     
     public void updateProtocolInfo(){
         ProtocolDAO protocolDAO = new ProtocolDAO();
         Protocols protocols = new Protocols(protocolId, surveyName ,protocol, protocolDescr);
         protocolDAO.updateProtocol(protocols);
     }
     
     public void addNewProtocol(){
         ProtocolDAO protocolDAO = new ProtocolDAO();
         Protocols protocols = new Protocols(0, surveyName ,protocolNew, protocolDescrNew);
         protocolDAO.addProtocol(protocols);
     }
}
