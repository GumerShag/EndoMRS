/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gumer.endo.entity.DAO;

import com.gumer.endo.entity.HibernateUtil;
import com.gumer.endo.entity.Surveys;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Евгений
 */
public class SurveyDAO {
   
    public void saveSurvey(Surveys survey){
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
       try{
        tx = session.beginTransaction();
        System.out.println("Survey saving" + survey.toString());
        session.save(survey);
        session.getTransaction().commit();
       }catch(RuntimeException e){
           if(tx != null){
               tx.rollback();
           } e.printStackTrace();
       }finally{
           session.flush();
           session.close();
       }
    }
    
    public void loadSurveyById(int id){
        
    }
    
    public void updateProtocolInfo(Surveys survey){
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
       try{
        tx = session.beginTransaction();
        session.update(survey);
        session.getTransaction().commit();
       }catch(RuntimeException e){
           if(tx != null){
               tx.rollback();
           } e.printStackTrace();
       }finally{
           session.flush();
           session.close();
       }
    }
}
