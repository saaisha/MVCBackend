package com.saaisha.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.saaisha.bean.Event;

public class EventsDAO {

	public int insertEvent(Event e){
		
		Configuration cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory factory=cfg.buildSessionFactory();
	    Session session=factory.openSession();
	    session.beginTransaction();
	    session.save(e);
	    session.getTransaction().commit();
	    factory.close();
	    return e.getEid();
	}
}
