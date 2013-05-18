package com.classica.classes.events;


public class ShakeEvent extends Event {
	public final static int EVENT_SHAKE = 400;
	public ShakeEvent(){
		this.setEventType(EVENT_SHAKE);
	}
}
