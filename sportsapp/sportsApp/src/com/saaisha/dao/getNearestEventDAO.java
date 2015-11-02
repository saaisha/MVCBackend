package com.saaisha.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.saaisha.bean.nearestEvent;
import com.saaisha.bean.nearestEvent;

public class getNearestEventDAO {

	public List<nearestEvent> getEvents(float latitude,float longitude){
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
	    SessionFactory factory=cfg.buildSessionFactory();
	    Session session=factory.openSession();
	    Query sqlQ = session.createSQLQuery("SELECT name,lati, longi, distance FROM (SELECT z.name,z.lati, z.longi,p.radius,p.distance_unit * DEGREES(ACOS(COS(RADIANS(p.latpoint)) * COS(RADIANS(z.lati)) * COS(RADIANS(p.longpoint - z.longi)) + SIN(RADIANS(p.latpoint)) * SIN(RADIANS(z.lati)))) AS distance FROM testevent AS z JOIN (SELECT :latparam AS latpoint, :longparam AS longpoint,5000.0 AS radius,111.045 AS distance_unit) AS p ON 1=1 WHERE z.lati BETWEEN p.latpoint - (p.radius / p.distance_unit) AND p.latpoint + (p.radius / p.distance_unit) AND z.longi BETWEEN p.longpoint - (p.radius / (p.distance_unit * COS(RADIANS(p.latpoint)))) AND p.longpoint + (p.radius / (p.distance_unit * COS(RADIANS(p.latpoint))))  ) AS d  WHERE distance <= radius  ORDER BY distance LIMIT 30;").setParameter("latparam", latitude).setParameter("longparam", longitude);
	    ((SQLQuery) sqlQ).addEntity(nearestEvent.class);
	    //List<nearestEvent> nearestEvents = new ArrayList<nearestEvent>();
	    //nearestEvents = sqlQ.list();
	    return sqlQ.list();
	    //System.out.println(nearestEvents.get(5).getDistance());
		
		
	}
}
