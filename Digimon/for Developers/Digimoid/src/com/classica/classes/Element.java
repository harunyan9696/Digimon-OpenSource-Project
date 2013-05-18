package com.classica.classes;

import java.util.ArrayList;

public class Element {
	private int id;
	private int type;
	private int level;
	private int species_power;
	private int min_weight;
	private ArrayList<Integer> next_digimons;
	private ArrayList<Integer> require_dps;
	private String dot_pattern;
	private int attack_type;
	public Element(){
		this.next_digimons = new ArrayList<Integer>();
		this.require_dps = new ArrayList<Integer>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getSpecies_power() {
		return species_power;
	}
	public void setSpecies_power(int species_power) {
		this.species_power = species_power;
	}
	public int getMin_weight() {
		return min_weight;
	}
	public void setMin_weight(int min_weight) {
		this.min_weight = min_weight;
	}
	public ArrayList<Integer> getNext_digimons() {
		return next_digimons;
	}
	public void setNext_digimons(ArrayList<Integer> next_digimons) {
		this.next_digimons = next_digimons;
	}
	public ArrayList<Integer> getRequire_dps() {
		return require_dps;
	}
	public void setRequire_dps(ArrayList<Integer> require_dps) {
		this.require_dps = require_dps;
	}
	public String getDot_pattern() {
		return dot_pattern;
	}
	public void setDot_pattern(String dot_pattern) {
		this.dot_pattern = dot_pattern;
	}
	public int getAttack_type() {
		return attack_type;
	}
	public void setAttack_type(int attack_type) {
		this.attack_type = attack_type;
	}
	public String toString(){
		String returndata = "id:"+id+"type:"+type+"level:"+level+"species_power"+species_power+"min_weight"+min_weight+"\n";
		for(int i = 0;i<this.next_digimons.size();i++){
			returndata+=i+"[id:"+next_digimons.get(i)+",dp:"+require_dps.get(i)+"]\n";
		}
		return returndata;
	}
}
