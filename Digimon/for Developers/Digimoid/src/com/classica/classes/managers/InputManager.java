package com.classica.classes.managers;

import java.util.ArrayList;

import android.text.format.Time;
import android.util.Log;

import com.classica.classes.Element;
import com.classica.classes.events.CounterEvent;
import com.classica.classes.events.Event;
import com.classica.classes.events.TimerEvent;

public class InputManager {
	private ArrayList<Event> event_stack;
	private ArrayList<CounterEvent> counter_stack;
	private ArrayList<Element> element_array;
	private Time time;
	public InputManager(){
		this.event_stack = new ArrayList<Event>();
		this.counter_stack = new ArrayList<CounterEvent>();
		Time time = new Time("Asia/Tokyo");
		time.setToNow();
		this.time = time;
	}
	public void pushEvent(Event event){
		this.event_stack.add(0, event);
	
	}
	public Event popEvent(){
		if(this.event_stack.size() > 0){
			Event event = event_stack.get(0);
			event_stack.remove(event);
			return event;
		}
		else{
			return null;
		}
	}
	public void requestCount(int count){
		if(count > 0){
			CounterEvent event = new CounterEvent();
			event.setObject(count);
			this.counter_stack.add(0, event);
		}
	}
	public void updateFrame(){
		this.event_stack.clear();
		if(this.counter_stack.size() > 0){
			CounterEvent event = this.counter_stack.get(0);
			event.updateCounter();
			this.event_stack.add(event);
			if(event.isFinished() == true){
				this.counter_stack.remove(0);
			}
		}
		Time time = new Time("Asia/Tokyo");
		time.setToNow();
		if(!this.time.equals(time)){
			this.time = time;
			TimerEvent event = new TimerEvent();
			event.setObject(time);
			this.event_stack.add(event);
		}
	}
	public void destoryCount(){
		if(this.counter_stack.size() > 0){
			this.counter_stack.remove(0);
		}
	}
	public Element referDatabaseFromId(int digimon_id){
		return element_array.get(digimon_id);
	}
	public void setDatabase(ArrayList<Element> list){
		this.element_array = list;
	}
}
