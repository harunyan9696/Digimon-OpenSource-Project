package com.classica.classes.events;

import android.text.format.Time;

public class TimerEvent extends Event {
	private Time object;
	public final static int EVENT_TIMER = 200;
	public TimerEvent(){
		this.setEventType(EVENT_TIMER);
	}
	public void setObject(Time source){
		this.object = source;
	}
	public Time getObject(){
		return this.object;
	}

}
