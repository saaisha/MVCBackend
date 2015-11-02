package com.saaisha.bean;

import java.sql.Date;

public class Event {

	private int eid;
	private Date dateCreated;
	private Date date;
	private String type;
	private String descrip;
	private float locationLat;
	private float locationLong;
	private int reqdPeople;
	private int registeredPeople;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public float getLocationLat() {
		return locationLat;
	}
	public void setLocationLat(float locationLat) {
		this.locationLat = locationLat;
	}
	public float getLocationLong() {
		return locationLong;
	}
	public void setLocationLong(float locationLong) {
		this.locationLong = locationLong;
	}
	public int getReqdPeople() {
		return reqdPeople;
	}
	public void setReqdPeople(int reqdPeople) {
		this.reqdPeople = reqdPeople;
	}
	public int getRegisteredPeople() {
		return registeredPeople;
	}
	public void setRegisteredPeople(int registeredPeople) {
		this.registeredPeople = registeredPeople;
	}
	
	
}
