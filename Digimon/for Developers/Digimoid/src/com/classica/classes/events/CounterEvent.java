package com.classica.classes.events;

import java.util.ArrayList;


public class CounterEvent extends Event {
	private boolean finished;
	private ArrayList<Integer> object;
	public final static int EVENT_COUNTER = 300;
	public CounterEvent(){
		this.setEventType(EVENT_COUNTER);
		this.finished=false;
		this.object = new ArrayList<Integer>();
	}
	public ArrayList<Integer> getObject(){
		return this.object;
	}
	public void setObject(int object){
		this.object.add(0);
		this.object.add(object);
	}
	public void updateCounter(){
		int current_count = this.object.get(0);
		int requested_count = this.object.get(1);
		current_count++;
		if(current_count >= requested_count){
			this.finished = true;
		}
		this.object.clear();
		this.object.add(current_count);
		this.object.add(requested_count);
	}
	public boolean isFinished(){
		return this.finished;
	}
}
