package com.classica.classes.events;

import android.graphics.Point;
import android.util.Log;


public class TouchEvent extends Event {
	private Point object;
	private int event_state;
	public final static int EVENT_TOUCH = 100;
	public final static int TOUCH_TOUCHED = 1000;
	public final static int TOUCH_CONTINUED = 2000;
	public final static int TOUCH_RELEASED = 3000;
	public TouchEvent(){
		this.setEventType(EVENT_TOUCH);
	}
	public void setObject(Point source){
		this.object = source;
	}
	public Point getObject(){
		return this.object;
	}
	public void setState(int state){
		this.event_state = state;
	}
	public int getState(){
		return this.event_state;
	}
}
