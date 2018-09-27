/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gumer.endo.entity.DAO;

import com.gumer.endo.entity.HibernateUtil;
import com.gumer.endo.entity.Protocols;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Евгений
 */
public class ProtocolDAO {
    
    public void addProtocol(Protocols protocol){
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
       try{
        tx = session.beginTransaction();
        session.save(protocol);
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
    
    public void updateProtocol(Protocols protocol){
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
       try{
        tx = session.beginTransaction();
        session.update(protocol);
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
