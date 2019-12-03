package com.mercury.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory FACTORY;
    
    static {
        try {
        	// /hibernate.cfg.xml, / : classpath (where class is loaded from)
            FACTORY = new Configuration().configure().buildSessionFactory();
        } catch(Exception e){
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    
    private static final ThreadLocal<Session> SESSION_THREADLOCAL = new ThreadLocal<Session>(){
        @Override
        protected Session initialValue(){
        	// create a new session and put into the thread local as a prototype
            return FACTORY.openSession();
        }
    };
    
    public static SessionFactory getSessionFactory(){
        return FACTORY;
    }
    
    public static Session currentSession(){
        Session s = SESSION_THREADLOCAL.get();
        if(s == null){
            s = FACTORY.openSession();
            SESSION_THREADLOCAL.set(s);
        }
        return s;
    }
    
    public static void closeSession() {
        Session s = SESSION_THREADLOCAL.get();
        if(s != null) {
            s.close();
        }
        
        SESSION_THREADLOCAL.set(null);
    }
    
}