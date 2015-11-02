package com.saaisha.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.saaisha.bean.Sports;

public class SportsDAO {

	public int insertUser(Sports sp){
		Configuration cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory factory=cfg.buildSessionFactory();
	    Session session=factory.openSession();
	    session.beginTransaction();
	    session.save(sp);
	    session.getTransaction().commit();
	    factory.close();
	    return sp.getUid();
	}
}
