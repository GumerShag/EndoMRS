
package com.gumer.beans;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Gumer
 */
@ManagedBean (name = "user")
@SessionScoped
public class UserBean {
    private String firstName ;
    private String lastName;
    private String fatherName;
    private String qualfication;
    private String password;
    private String info;
    private UIComponent mybutton;
    public static String surveyNameIndicator = "fgds";

    public String getSurveyTypeIndicator() {
        return surveyNameIndicator;
    }

    public void setSurveyTypeIndicator(String surveyTypeIndicator) {
        this.surveyNameIndicator = surveyTypeIndicator;
        
    }

    public String getName() {
        return firstName;
    }

    public void setName(String name) {
        this.firstName = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMybutton(UIComponent mybutton) {
        this.mybutton = mybutton;
    }

    public UIComponent getMybutton() {
        return mybutton;
    }    
    
    public void navigate() throws IOException {
    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    externalContext.redirect("faces/main.xhtml");
    }
    
    
    public void getInfo(){
        
            FacesMessage message = new FacesMessage("Invalid password length");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(mybutton.getClientId(context), message);
    
    }
    
    public void updateIndicator(){
              
    }
}
