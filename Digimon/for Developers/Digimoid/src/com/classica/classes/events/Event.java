package com.classica.classes.events;

public class Event {
	private int event_type;
	private Object object;
	public Event(){
		
	}
	public void setEventType(int type){
		this.event_type = type;
	}
	public int getEventType(){
		return this.event_type;
	}
	public Object getObject(){
		return this.object;
	}
	public boolean setObject(Object source){
		this.object = source;
		return true;
	}
}
