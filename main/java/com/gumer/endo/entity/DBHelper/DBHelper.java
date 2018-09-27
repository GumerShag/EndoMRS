
package com.gumer.endo.entity.DBHelper;

import com.gumer.endo.entity.Departments;
import com.gumer.endo.entity.Diagnosis;
import com.gumer.endo.entity.Doctors;
import com.gumer.endo.entity.HibernateUtil;
import com.gumer.endo.entity.Manipulation;
import com.gumer.endo.entity.Patient;
import com.gumer.endo.entity.Protocols;
import com.gumer.endo.entity.Surveys;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author 
 */
public class DBHelper {
    private SessionFactory sessionFactory = null;
    private static DBHelper dbHelper;

    public DBHelper() {
     sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    public static DBHelper getInstance(){
        return dbHelper == null ? new DBHelper() : dbHelper;
    }
    
    private Session getSession(){
        return sessionFactory.openSession();
    }
    public List<Surveys> getAllSurveys(){
        return getSession().createCriteria(Surveys.class).list();
    }
    
    public List<Doctors> getAllDoctors(){
        return getSession().createCriteria(Doctors.class).list();
    }
    
    public List<Patient> getAllPatients(){
        return getSession().createCriteria(Patient.class).list();
    }
    
     public Patient getPatientById(int id){
        return (Patient) getSession().createCriteria(Patient.class).add(Restrictions.eq("id", id)).uniqueResult();
    }
    
     public Surveys getSurveyById(int id){
        return (Surveys) getSession().createCriteria(Surveys.class).add(Restrictions.eq("id", id)).uniqueResult();
    }
     public List<Surveys> getSurveyByPatientId(int id){
        return getSession().createCriteria(Surveys.class).add(Restrictions.eq("patientId", id)).list();
    }
     
     public List<Departments> getDepartmetsList(){
        return getSession().createCriteria(Departments.class).list();
                
     }
     
     public List<Protocols> getProtocolBySurveyName(String name){
         return getSession().createCriteria(Protocols.class).add(Restrictions.eq("surveyName", name)).list();
     }
     
     public List<Diagnosis> getDiagnosisBySurveyType(String name){
         return getSession().createCriteria(Diagnosis.class).add(Restrictions.eq("surveyType", name)).list();
     }

     public List<Manipulation> getManipulationBySurveyType(String name){
         return getSession().createCriteria(Manipulation.class).add(Restrictions.eq("surveyType", name)).list();
     }
     
     
    
    
    
    
}
