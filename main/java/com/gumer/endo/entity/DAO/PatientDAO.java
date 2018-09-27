/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gumer.endo.entity.DAO;

import com.gumer.beans.PatientBean;
import com.gumer.endo.entity.HibernateUtil;
import com.gumer.endo.entity.Patient;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Евгений
 */
public class PatientDAO implements DAO{

    private int id;
     
    
    public int getPatientId() {
        return id;
    }
    
    @Override
    public void add() {
        
    }

    @Override
    public void delete() {
        
    }
    @Override
    public void update() {
        
    }
    
    public void addPatient(Patient patient){
        System.out.print("Transaction started");
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
       try{
        tx = session.beginTransaction();
        session.save(patient);
        id = patient.getId();
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
    
     public void updatePatient(Patient patient){
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
       try{
        tx = session.beginTransaction();
        session.update(patient);
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
