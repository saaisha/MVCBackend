package com.saaisha.bean;

public class Sports {

	private int uid;
	private String name;
	private int events_created;
	private int events_attended;
	private int curr_active_event;
	private int no_active_event;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEvents_created() {
		return events_created;
	}
	public void setEvents_created(int events_created) {
		this.events_created = events_created;
	}
	public int getEvents_attended() {
		return events_attended;
	}
	public void setEvents_attended(int events_attended) {
		this.events_attended = events_attended;
	}

	public int getCurr_active_event() {
		return curr_active_event;
	}
	public void setCurr_active_event(int curr_active_event) {
		this.curr_active_event = curr_active_event;
	}
	public int getNo_active_event() {
		return no_active_event;
	}
	public void setNo_active_event(int no_active_event) {
		this.no_active_event = no_active_event;
	}
	

	
}
