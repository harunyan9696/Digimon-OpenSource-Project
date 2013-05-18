package com.classica.classes.managers;

import java.util.ArrayList;

import com.classica.classes.Element;
import com.classica.classes.digimon.Digimon;

public class StatusManager {
	public final static int EVENING = 1;
	public final static int MORNING = 0;
	public final static int NIGHT = 2;

	private static int getCurrentTimeArea(int current_time) {
		// TODO �����������������\�b�h�E�X�^�u
		if(current_time>=400 && current_time<1200){
			return MORNING;
		}
		else if(current_time>=1200 && current_time<2000){
			return EVENING;
		}
		else if((current_time >2000 && current_time <2400)||(current_time >=0 && current_time < 400)){
			return NIGHT;
		}
		return -1;
	}
	private int current_time;
	private ArrayList<Digimon> digimon_list;
	private ArrayList<Integer> enemy_hit_pattern;
	InputManager input_manager;

	private boolean is_host;
	private int next_enemy_id;
	private int selected_index;
	private int win_type;

	private boolean battle() {
		// TODO �����������������\�b�h�E�X�^�u
		this.enemy_hit_pattern = new ArrayList<Integer>();
		Digimon digimon = digimon_list.get(selected_index);
		int power_me = digimon.getActual_power();
		int power_you = digimon.enemy_power;
		int[] hits_me = digimon.getMegahits();
		ArrayList<Boolean> hits_you = digimon.enemy_megahits;
		int type_me = digimon.getType();
		int type_you = this.input_manager.referDatabaseFromId(this.next_enemy_id).getType();
		if(type_me == 0){
			if(type_you == 1){
				power_you*=1.2;
			}
			else if(type_you == 2){
				power_me*=1.2;
			}
		}
		else if(type_me == 1){
			if(type_you == 0){
				power_me*=1.2;
			}
			else if(type_you == 2){
				power_you*=1.2;
			}
		}
		else if(type_me == 2){
			if(type_you == 0){
				power_you *= 1.2;
			}
			else if(type_you == 1){
				power_me *= 1.2;
			}
		}
		int hp_me = power_me;
		int hp_you = power_you;
		ArrayList<Boolean> hit_pattern = new ArrayList<Boolean>();
		for(int i = 0;i<5;i++){
			int attack_me = hits_me[i];
			if(attack_me == 1){
				attack_me*=0.35*power_me;
			}
			else{
				attack_me = (int) (0.2*power_me);
			}
			boolean attack_pyou = hits_you.get(i);
			int attack_you;
			if(attack_pyou == true){
				attack_you = (int) (1*0.35*power_you);
			}
			else{
				attack_you = (int) (1*0.2*power_you);
			}
			int random = (int) (Math.random()*100);
			int random2 = (int) (Math.random()*100);
			if(random <= 60){
				attack_me*=0.1;
				this.enemy_hit_pattern.add(0);
			}
			else{
				this.enemy_hit_pattern.add(1);
			}
			if(random2<=60){
				attack_you*=0.1;
				hit_pattern.add(false);
			}
			else{
				hit_pattern.add(true);
			}
			hp_me-=attack_you;
			hp_you-=attack_me;
		}
		digimon.hit_pattern = hit_pattern;
		boolean win = false;
		if(hp_me < hp_you){
			win = false;
			this.win_type = 1;
		}
		else{
			win = true;
			this.win_type = -1;
		}
		return win;
	}

	public void calcurateAttackPatternForOfflineBattleWithShakeCount(
			int shake_counter) {
		// TODO �����������������\�b�h�E�X�^�u
		Digimon digimon = this.digimon_list.get(selected_index);
		String pattern1 = "1010000101010101010010101010101010101001010000001010101010101010101010101010101010101000100101000101011";
		String pattern2 = "1001010101010111001011001100100101010101000000100010101010101010101010010010010101010101010100110101000";
		String pattern3 = "1001010011010101000010101010101010101010100000101010101001010101010101010001010101010101010010100101001";
		String pattern4 = "1010010101101010110101010101101010001001010010101010110101000100000000000101010100010101010001010101001";
		String pattern5 = "1001001010101010010001010101001010010101010100001010111010101010110101110101001010010101010110101000101";
		int megahit[] = {0,0,0,0,0};
		ArrayList<Boolean> enemy_megahit = new ArrayList<Boolean>();
		int point = digimon.getPendulum_type()*shake_counter+1;
		int point2 = (int) (Math.random()*pattern1.length());
		if(point2 == pattern1.length()){
			point2%=pattern1.length();
		}
		if(point>pattern1.length()){
			point%=pattern1.length();
		}
		if(pattern1.charAt(point) == '1'){
			megahit[0] = 1;
		}
		if(pattern2.charAt(point) == '1'){
			megahit[1] = 1;
		}
		if(pattern3.charAt(point) == '1'){
			megahit[2] = 1;
		}
		if(pattern4.charAt(point) == '1'){
			megahit[3] = 1;
		}
		if(pattern5.charAt(point) == '1'){
			megahit[4] = 1;
		}
		if(pattern1.charAt(point2) == '1'){
			enemy_megahit.add(true);
		}
		else{
			enemy_megahit.add(false);
		}
		if(pattern2.charAt(point2) == '1'){
			enemy_megahit.add(true);
		}
		else{
			enemy_megahit.add(false);
		}
		if(pattern3.charAt(point2) == '1'){
			enemy_megahit.add(true);
		}
		else{
			enemy_megahit.add(false);
		}
		if(pattern4.charAt(point2) == '1'){
			enemy_megahit.add(true);
		}
		else{
			enemy_megahit.add(false);
		}
		if(pattern5.charAt(point2) == '1'){
			enemy_megahit.add(true);
		}
		else{
			enemy_megahit.add(false);
		}
		digimon.setMegahits(megahit);
		digimon.enemy_megahits = enemy_megahit;
	}

	public void calcurateAttackPatternForOnlineBattleWithShakeCount(
			int shake_counter) {
		// TODO �����������������\�b�h�E�X�^�u
		Digimon digimon = this.digimon_list.get(selected_index);
		String pattern1 = "1010000101010101010010101010101010101001010000001010101010101010101010101010101010101000100101000101011";
		String pattern2 = "1001010101010111001011001100100101010101000000100010101010101010101010010010010101010101010100110101000";
		String pattern3 = "1001010011010101000010101010101010101010100000101010101001010101010101010001010101010101010010100101001";
		String pattern4 = "1010010101101010110101010101101010001001010010101010110101000100000000000101010100010101010001010101001";
		String pattern5 = "1001001010101010010001010101001010010101010100001010111010101010110101110101001010010101010110101000101";
		int megahit[] = {0,0,0,0,0};
		int point = digimon.getPendulum_type()*shake_counter+1;
		if(point>pattern1.length()){
			point%=pattern1.length();
		}
		if(pattern1.charAt(point) == '1'){
			megahit[0] = 1;
		}
		if(pattern2.charAt(point) == '1'){
			megahit[1] = 1;
		}
		if(pattern3.charAt(point) == '1'){
			megahit[2] = 1;
		}
		if(pattern4.charAt(point) == '1'){
			megahit[3] = 1;
		}
		if(pattern5.charAt(point) == '1'){
			megahit[4] = 1;
		}
		System.out.println("calcurated megahits:"+megahit[0]+":"+megahit[1]+":"+megahit[2]+":"+megahit[3]+":"+megahit[4]);
		digimon.setMegahits(megahit);
	}

	public void calcurateAttackPatternForTrainingWithShakeCount(
			int shake_counter) {
		// TODO �����������������\�b�h�E�X�^�u
		Digimon digimon = this.digimon_list.get(selected_index);
		String pattern1 = "1010000101010101010010101010101010101001010000001010101010101010101010101010101010101000100101000101011";
		String pattern2 = "1001010101010111001011001100100101010101000000100010101010101010101010010010010101010101010100110101000";
		String pattern3 = "1001010011010101000010101010101010101010100000101010101001010101010101010001010101010101010010100101001";
		String pattern4 = "1010010101101010110101010101101010001001010010101010110101000100000000000101010100010101010001010101001";
		String pattern5 = "1001001010101010010001010101001010010101010100001010111010101010110101110101001010010101010110101000101";
		int megahit[] = {0,0,0,0,0};
		int point = digimon.getPendulum_type()*shake_counter+1;
		if(point>pattern1.length()){
			point%=pattern1.length();
		}
		if(pattern1.charAt(point) == '1'){
			megahit[0] = 1;
		}
		if(pattern2.charAt(point) == '1'){
			megahit[1] = 1;
		}
		if(pattern3.charAt(point) == '1'){
			megahit[2] = 1;
		}
		if(pattern4.charAt(point) == '1'){
			megahit[3] = 1;
		}
		if(pattern5.charAt(point) == '1'){
			megahit[4] = 1;
		}
		digimon.setMegahits(megahit);
	}

	public boolean canCareInjure() {
		// TODO �����������������\�b�h�E�X�^�u
		Digimon digimon = digimon_list.get(selected_index);
		if(digimon.isIs_injured() == false || digimon.isIs_sleeping() == true){
			return false;
		}
		else{
			return true;
		}
	}

	public boolean canCareSick() {
		// TODO �����������������\�b�h�E�X�^�u
		Digimon digimon = digimon_list.get(selected_index);
		if(digimon.isIs_sick() == false || digimon.isIs_sleeping() == true){
			return false;
		}
		else{
			return true;
		}
	}

	public boolean canDoJogress() {
		// TODO �����������������\�b�h�E�X�^�u
		return false;
	}

	public boolean canDoOfflineBattle() {
		// TODO �����������������\�b�h�E�X�^�u
		Digimon digimon = digimon_list.get(selected_index);
		if(digimon.getDp()<=0 || digimon.isIs_sick() == true || digimon.isIs_injured() == true || (digimon.isIs_sleeping() == true && digimon.isIs_light_on() == false) || digimon.isBattle_enable() == false){
			return false;
		}
		else{
			return true;
		}
	}

	public boolean canDoOnlineBattle() {
		// TODO �����������������\�b�h�E�X�^�u
		Digimon digimon = digimon_list.get(selected_index);
		if(digimon.getDp()<=0 || digimon.isIs_sick() == true || digimon.isIs_injured() == true || (digimon.isIs_sleeping() == true && digimon.isIs_light_on() == false) || digimon.isBattle_enable() == false){
			return false;
		}
		else{
			return true;
		}
	}

	public boolean canDoTraining() {
		// TODO �����������������\�b�h�E�X�^�u
		Digimon digimon = digimon_list.get(selected_index);
		if((digimon.getDp()<=0 && digimon.isDp_half() == false) || digimon.isIs_sick() == true || digimon.isIs_injured() == true || (digimon.isIs_sleeping() == true && digimon.isIs_light_on() == false)){
			return false;
		}
		else{
			return true;
		}
	}

	public boolean canEatMeat() {
		// TODO �����������������\�b�h�E�X�^�u
		Digimon digimon = this.digimon_list.get(selected_index);
		int eat_max_count = digimon.getMax_eat();
		int current_hungry = digimon.getHungry();
		if(current_hungry < eat_max_count){
			boolean is_sleeping = digimon.isIs_sleeping();
			boolean is_lighting = digimon.isIs_light_on();
			if(is_sleeping == true && is_lighting == false){
				return false;
			}
			else{
				boolean is_sick = digimon.isIs_sick();
				if(is_sick != true){
					return true;
				}
			}
		}
		else{
			return false;
		}
		return false;
	}

	public boolean canEatProtein() {
		// TODO �����������������\�b�h�E�X�^�u
		Digimon digimon = this.digimon_list.get(selected_index);
		boolean is_sleeping = digimon.isIs_sleeping();
		boolean is_lighting = digimon.isIs_light_on();
		if(is_sleeping == true && is_lighting == false){
			return false;
		}
		else{
			boolean is_sick = digimon.isIs_sick();
			if(is_sick != true){
				return true;
			}
		}
		return false;
	}

	public boolean canOperate() {
		// TODO �����������������\�b�h�E�X�^�u
		Digimon digimon = this.digimon_list.get(selected_index);
		return (digimon.isIs_egg() == false && digimon.isIs_living());
	}

	public void careInjure() {
		// TODO �����������������\�b�h�E�X�^�u
		Digimon digimon = digimon_list.get(selected_index);
		digimon.setIs_injured(false);

		if(StatusManager.getCurrentTimeArea(this.current_time) == MORNING){
			digimon.setLifetime(digimon.getLifetime()+1);
		}
		else if(StatusManager.getCurrentTimeArea(this.current_time) == NIGHT){
			digimon.setLifetime(digimon.getLifetime()-1);
		}
	}

	public void careSick() {
		// TODO �����������������\�b�h�E�X�^�u
		Digimon digimon = digimon_list.get(selected_index);
		digimon.setIs_sick(false);

		if(StatusManager.getCurrentTimeArea(this.current_time) == MORNING){
			digimon.setLifetime(digimon.getLifetime()+1);
		}
		else if(StatusManager.getCurrentTimeArea(this.current_time) == NIGHT){
			digimon.setLifetime(digimon.getLifetime()-1);
		}
	}

	public void changeSelected(int digimon_selection_index) {
		// TODO �����������������\�b�h�E�X�^�u
		if (digimon_selection_index >= 0
				&& digimon_selection_index < this.digimon_list.size()) {
			this.selected_index = digimon_selection_index;
		}
		for (int i = 0; i < digimon_list.size(); i++) {
			if (this.selected_index != i) {
				digimon_list.get(i).breakDrawPart();
			} else {
				this.digimon_list.get(i).setDotPattern(this.input_manager.referDatabaseFromId(digimon_list.get(i).getDigimon_id()).getDot_pattern());
				this.digimon_list.get(i).reloadFrame();
			}
		}
	}

	private boolean checkForProgress(int index) {
		// TODO �����������������\�b�h�E�X�^�u
		Digimon digimon = digimon_list.get(index);
		float aptitude =0.0f;
		int lifetype = 1;
		if(digimon.getLifetime()>12*digimon.getLevel()){
			lifetype = 0;
		}
		else if(digimon.getLifetime()<-12*digimon.getLevel()){
			lifetype = 2;
		}
		Element element = this.input_manager.referDatabaseFromId(digimon.getDigimon_id());
		ArrayList<Integer> next_ids = element.getNext_digimons();
		ArrayList<Integer> next_values = element.getRequire_dps();
		System.out.println(next_ids+"\n:ids:"+next_values+"\ndatas\n");
		float sub = 0.0f;
		int current_index = -1;
		int current_require_dp = 0;
		for(int i = 0;i<next_ids.size();i++){
			aptitude = 0.0f;
			aptitude += digimon.getWin_count();
			if(digimon.getBattle_count() > 0){
				aptitude*=100.0f/digimon.getBattle_count();
			}
			else{
				aptitude = 1.0f;
			}
			float battle_c_check = digimon.getBattle_count();
			battle_c_check/=next_values.get(i);
			aptitude*=battle_c_check;
			Element next_ele = this.input_manager.referDatabaseFromId(next_ids.get(i));
			int next_type = next_ele.getType();
			int weight = next_ele.getMin_weight();
			if(digimon.getType() == next_type){
				aptitude*=1.2;
			}
			if(lifetype == digimon.getType()){
				aptitude*=1.25;
			}
			float rate = (float)weight-(float)digimon.getWeight();
			rate/=(float)weight;
			rate = Math.abs(rate);
			rate = (float) Math.min(0.3, rate);
			aptitude*=(1.0f-rate);
			int value = next_values.get(i);
			System.out.println("value:"+value+"		aptitude:"+aptitude);
			if(aptitude >= value){
				System.out.println("aptitude*value:"+aptitude*value+"		sub*current_require_dp:"+sub*current_require_dp);
				if(aptitude*value>=sub*current_require_dp){
					sub=aptitude;
					current_index = i;
					current_require_dp = value;
				}
			}
			System.out.println("current_index:"+current_index);
			if(current_index != -1){
				int next_digimon = next_ids.get(current_index);
				this.progress(next_digimon,index);
			}
		}
		return false;
	}

	public void decideEnemy() {
		// TODO �����������������\�b�h�E�X�^�u
		int[] randoms = {(int) (Math.random()*521),(int) (Math.random()*521),(int) (Math.random()*521),(int) (Math.random()*521)};
		for(int i = 0;i<randoms.length;i++){
			if(randoms[i] == 521){
				randoms[i] = 520;
			}
		}
		Digimon digimon = digimon_list.get(selected_index);
		int power = digimon.getPotential_power();
		int enemy_id = 0;
		int suitable_value = Integer.MAX_VALUE;
		for(int i = 0;i<4;i++){
			Element element = this.input_manager.referDatabaseFromId(randoms[i]);
			int sub_power = (int)Math.pow(element.getSpecies_power()-power,2);
			if(sub_power < suitable_value && element.getLevel() > 1){
				suitable_value = sub_power;
				enemy_id = randoms[i];
			}
			element = null;
		}
		this.next_enemy_id = enemy_id;
		Element enemy_element = this.input_manager.referDatabaseFromId(enemy_id);
		String enemy_dots = enemy_element.getDot_pattern();
		ArrayList<Boolean> dots_by_bool = new ArrayList<Boolean>();
		for(int i = 0;i<enemy_dots.length();i++){
			if(enemy_dots.charAt(i) == '0'){
				dots_by_bool.add(true);
			}
			else{
				dots_by_bool.add(false);
			}
		}
		enemy_dots = null;
		digimon.enemy_dots = dots_by_bool;
		digimon.enemy_attack_type = enemy_element.getAttack_type();
		digimon.enemy_power = enemy_element.getSpecies_power();

		digimon = null;
		dots_by_bool = null;
		enemy_element = null;
	}

	private void doForceWakingUp() {
		// TODO �����������������\�b�h�E�X�^�u
		Digimon digimon = digimon_list.get(selected_index);
		digimon.setIs_sleeping(false);
		digimon.setHealth(digimon.getHealth()-2);
		int sleeptime = digimon.getSleep_time();
		sleeptime += 200;
		if(sleeptime > 400 && sleeptime < 1200){
			sleeptime = 400;
			digimon.setHealth(digimon.getHealth()-2);
		}
		digimon.setSleep_time(sleeptime);
	}

	public void doJogress() {
		// TODO �����������������\�b�h�E�X�^�u

	}

	public void doOfflineBattle() {
		// TODO �����������������\�b�h�E�X�^�u
		Digimon digimon = this.digimon_list.get(selected_index);
		if(digimon.isIs_sleeping() == true && digimon.isIs_light_on() == true){
			this.doForceWakingUp();
		}
		if(this.battle()==true){
			digimon.setWin_count(digimon.getWin_count()+1);
			digimon.setOffline_battle_count(digimon.getOffline_battle_count()+1);
			int battlecount = 0;
			for(int i = 0;i<digimon_list.size();i++){
				battlecount+=digimon_list.get(i).getOffline_battle_count();
			}
			if(battlecount!=0 && battlecount%100 == 0){
				this.digimon_list.add(new Digimon());
			}
			digimon.setReaction(true);
		}
		else{
			digimon.setReaction(false);
		}
		digimon.setWeight(Math.max(digimon.getWeight()-2, digimon.getMin_weight()));
		digimon.setDp(Math.max(0, digimon.getDp()-1));
		digimon.setBattle_count(digimon.getBattle_count()+1);
	}

	public void doOnlineBattle() {
		// TODO �����������������\�b�h�E�X�^�u
		Digimon digimon = this.digimon_list.get(selected_index);
		if (digimon.isIs_sleeping() == true && digimon.isIs_light_on() == true) {
			this.doForceWakingUp();
		}
		if (this.is_host == true) {
			if (this.battle() == true) {
				digimon.setWin_count(digimon.getWin_count() + 1);
				digimon.setOffline_battle_count(digimon
						.getOffline_battle_count() + 1);
				digimon.setReaction(true);
			} else {
				digimon.setReaction(false);
			}
			digimon.setWeight(Math.max(digimon.getWeight() - 2,
					digimon.getMin_weight()));
			digimon.setDp(Math.max(0, digimon.getDp() - 2));
			digimon.setBattle_count(digimon.getBattle_count() + 1);
		} else {
			if (this.win_type > 0) {
				digimon.setWin_count(digimon.getWin_count() + 2);
				digimon.setOffline_battle_count(digimon
						.getOffline_battle_count() + 2);
				digimon.setReaction(true);
			} else {
				digimon.setReaction(false);
			}
			digimon.setWeight(Math.max(digimon.getWeight() - 2,
					digimon.getMin_weight()));
			digimon.setDp(Math.max(0, digimon.getDp() - 1));
			digimon.setBattle_count(digimon.getBattle_count() + 1);
		}
	}

	public void doReloadProcessingWithElapsedMinutesAndLastTime(int much, int from) {
		// TODO �����������������\�b�h�E�X�^�u
		for(int i = 0;i<much;i++){
			this.updateStatusByMinutes(from);
			if(from % 10 == 9){
				if((from -9)%100 == 50){
					if((from - 59)/100 == 23){
						from = 0;
					}
					else{
						from-=59;
						from+=100;
					}
				}
				else{
					from-=9;
					from+=10;
				}
			}
			else{
				from++;
			}
		}
	}

	public void doTraining() {
		// TODO �����������������\�b�h�E�X�^�u
		Digimon digimon = digimon_list.get(selected_index);
		if(digimon.isIs_sleeping() == true && digimon.isIs_light_on() == true){
			this.doForceWakingUp();
		}
		if(digimon.getMegahits()[0] == 1 || digimon.getMegahits()[1] == 1 || digimon.getMegahits()[2] == 1 || digimon.getMegahits()[3]==1||digimon.getMegahits()[4]==1){
			digimon.setReaction(true);
			digimon.setStrength(Math.min(digimon.getStrength()+1, 8));
		}
		else{
			digimon.setReaction(false);
		}
		digimon.setWeight(Math.max(digimon.getWeight()-2, digimon.getMin_weight()));
		if(digimon.isDp_half() == true){
			digimon.setDp_half(false);
		}
		else{
			digimon.setDp_half(true);
			digimon.setDp(digimon.getDp()-1);
		}
		digimon.setHidden_power((float) (digimon.getHidden_power()+digimon.getHidden_power_rate()/100.0));
		digimon.setActual_power((int) (digimon.getHidden_power()+digimon.getPotential_power()));
	}

	public void eatMeat() {
		// TODO �����������������\�b�h�E�X�^�u
		Digimon digimon = digimon_list.get(selected_index);
		if(digimon.isIs_sleeping() == true && digimon.isIs_light_on() == true){
			this.doForceWakingUp();
		}
		digimon.setHungry(digimon.getHungry()+1);
		if(digimon.getHungry() > digimon.getMax_eat()){
			digimon.setHungry(digimon.getMax_eat());
		}
		digimon.setWeight(digimon.getWeight()+1);
		if(digimon.getWeight() > 99){
			digimon.setWeight(99);
		}
		digimon.setHungry_elapsed_minutes(0);

		if(StatusManager.getCurrentTimeArea(this.current_time) == MORNING){
			digimon.setLifetime(digimon.getLifetime()+1);
		}
		else if(StatusManager.getCurrentTimeArea(this.current_time) == NIGHT){
			digimon.setLifetime(digimon.getLifetime()-1);
		}
	}

	public void eatProtein() {
		// TODO �����������������\�b�h�E�X�^�u
		Digimon digimon = digimon_list.get(selected_index);
		if(digimon.isIs_sleeping() == true && digimon.isIs_light_on() == true){
			this.doForceWakingUp();
		}
		digimon.setStrength(digimon.getStrength()+1);
		if(digimon.getStrength() > 8){
			digimon.setStrength(8);
		}
		digimon.setWeight(digimon.getWeight()+2);
		if(digimon.getWeight() > 99){
			digimon.setWeight(99);
		}
		digimon.setProtein_count(digimon.getProtein_count()+1);
		if(digimon.getProtein_count() > 3){
			digimon.setProtein_count(0);
			digimon.setDp(digimon.getDp());
			if(digimon.getDp()>digimon.getMax_dp()){
				digimon.setDp(digimon.getMax_dp());
			}
		}
		digimon.setStrength_elapsed_minutes(0);

		if(StatusManager.getCurrentTimeArea(this.current_time) == MORNING){
			digimon.setLifetime(digimon.getLifetime()+1);
		}
		else if(StatusManager.getCurrentTimeArea(this.current_time) == NIGHT){
			digimon.setLifetime(digimon.getLifetime()-1);
		}
	}

	public String getBattleString(boolean ishost){
	    this.setIshost(false);
	    Digimon digimon = digimon_list.get(selected_index);//[self->digimon_list objectAtIndex:selected_index];
	    int random = (int) (Math.random()*12);
	    System.out.println("random:"+random);
	    char data[] = new char[9];
	    char random_c = (char) (random+'0');
	    System.out.println("random_c:"+random_c);
	    data[8] = random_c;
	    if(ishost == true){
	        char host = (char) ('H'+random);
	        System.out.println("host type:"+host);
	        data[7] = host;
	        int megahits = digimon.getMegahits()[0] + digimon.getMegahits()[1]*2 + digimon.getMegahits()[2]*4+digimon.getMegahits()[3]*8+digimon.getMegahits()[4]*16;
	        System.out.println("megahits:"+digimon.getMegahits()[0] + ":"+digimon.getMegahits()[1]+":"+digimon.getMegahits()[2]+":"+digimon.getMegahits()[3]+":"+digimon.getMegahits()[4]);
	        System.out.println("megahits_int:"+megahits);
	        data[6] = (char) (megahits+'0' + random);
	        System.out.println("megahits_char:"+data[6]);
	        int digi_id = digimon.getDigimon_id();
	        System.out.println("digimon id:"+digi_id);
	        int id_1 = digi_id%23;
	        System.out.println("id_1:"+id_1);
	        digi_id-= id_1;
	        digi_id/=23;
	        int id_2 =digi_id % 23;
	        System.out.println("id_2:"+id_2);
	        data[5] = (char) (id_2 + '0' + random);
	        data[4] = (char) (id_1 + '0' + random);
	        System.out.println("id_chars :" +data[4]+""+data[5]);
	        int random2 =(int) (Math.random()*12);
	        data[3] = (char) (random2+'0'+random_c);
	        data[2] = (char) (this.win_type + '0' + random);
	        System.out.println("win_type:"+this.win_type);
	        data[1] = (char) (this.enemy_hit_pattern.get(0)+this.enemy_hit_pattern.get(1)*2+this.enemy_hit_pattern.get(2)*4+this.enemy_hit_pattern.get(3)*8+this.enemy_hit_pattern.get(4)*16+random+'0');//[this.enemy_hit_pattern objectAtIndex:0]intValue] + [[self->enemy_hit_pattern objectAtIndex:1]intValue]*2 + [[self->enemy_hit_pattern objectAtIndex:2]intValue]*4 + [[self->enemy_hit_pattern objectAtIndex:3]intValue]*8 + [[self->enemy_hit_pattern objectAtIndex:4]intValue]*16+'0'+random;
	        System.out.println("client_hit_pattern:"+enemy_hit_pattern.get(0)+":"+enemy_hit_pattern.get(1)+":"+enemy_hit_pattern.get(2)+":"+enemy_hit_pattern.get(3)+":"+enemy_hit_pattern.get(4));
	        System.out.println("client_hit_pattern_c:"+data[1]);
	        System.out.println("host_hit_pattern:"+digimon.hit_pattern.get(0)+":"+digimon.hit_pattern.get(1)+":"+digimon.hit_pattern.get(2)+":"+digimon.hit_pattern.get(3)+":"+digimon.hit_pattern.get(4));

	        int random3 = (int) (Math.random()*12);
	        data[0] = (char) (random3+'0'+random);
	    }
	    else if(ishost == false){
	        char client = (char) ('C'+random);
	        System.out.println("client type:"+client);
	        data[7] = client;
	        int megahits = digimon.getMegahits()[0] + digimon.getMegahits()[1]*2 + digimon.getMegahits()[2]*4+digimon.getMegahits()[3]*8+digimon.getMegahits()[4]*16;
	        System.out.println("megahits:"+digimon.getMegahits()[0] + ":"+digimon.getMegahits()[1]+":"+digimon.getMegahits()[2]+":"+digimon.getMegahits()[3]+":"+digimon.getMegahits()[4]);
	        System.out.println("megahits_int:"+megahits);
	        data[6] = (char) (megahits+'0'+random);
	        System.out.println("megahits_char:"+data[6]);
	        int digi_id = digimon.getDigimon_id();
	        System.out.println("digimon id:"+digi_id);
	        int id_1 = digi_id%23;
	        System.out.println("id_1:"+id_1);
	        digi_id-= id_1;
	        digi_id/=23;
	        int id_2 =digi_id % 23;
	        data[5] = (char) (id_2 + '0' + random);
	        data[4] = (char) (id_1 + '0' + random);
	        System.out.println("id_2:"+id_2);
	        System.out.println("id_chars :" +data[4]+""+data[5]);
	        int random2 = (int) (Math.random()*12);
	        data[3] = (char) (random2+'0'+random);
	        int power = digimon.getActual_power();
	        System.out.println("power:"+power);
	        int power_1 = power % 22;
	        power -= power_1;
	        power/=22;
	        int power_2 = power%22;
	        power -= power_2;
	        power/=22;
	        int power_3 = power%22;
	        char power_c1 = (char) (power_1+'0'+random);
	        char power_c2 = (char) (power_2+'0'+random);
	        char power_c3 = (char) (power_3+'0'+random);
	        data[2] = power_c3;
	        data[1] = power_c2;
	        data[0] = power_c1;
	        System.out.println("power_c"+data[2]+""+data[1]+""+data[0]);
	    }
	    String return_data = ""+data[0]+""+data[1]+""+data[2]+""+data[3]+""+data[4]+""+data[5]+""+data[6]+""+data[7]+""+data[8];
	    return return_data;
	}

	public boolean isDieing() {
		Digimon digimon = digimon_list.get(selected_index);
		return !digimon.isIs_living();
	}

	public boolean ishost() {
		return is_host;
	}

	private void progress(int next_digimon, int index) {
		// TODO �����������������\�b�h�E�X�^�u
		Digimon digimon = this.digimon_list.get(index);
		Element ele = this.input_manager.referDatabaseFromId(next_digimon);
		digimon.setDigimon_id(ele.getId());
		digimon.setType(ele.getType());
		digimon.setMin_weight(ele.getMin_weight());
		digimon.setWeight(digimon.getMin_weight());
		digimon.setPotential_power(ele.getSpecies_power());
		digimon.setHidden_power_rate(1);
		digimon.setActual_power((int) (digimon.getHidden_power()+digimon.getPotential_power()));
		digimon.setDotPattern(ele.getDot_pattern());
		digimon.setAttack_type(ele.getAttack_type());
		int r = 0;
		while(r== 0){r = (int) (Math.random()*30*(digimon.getActual_power()+1));
			r %=25;
		}
		
		digimon.setPendulum_type(r);
		if(digimon.getPendulum_type() == 0){
			digimon.setPendulum_type(1);
		}
		digimon.setLevel(ele.getLevel());
		if(digimon.getLevel() < 2){
			digimon.setBattle_enable(false);
			digimon.setJogress_enable(false);
		}
		else{
			digimon.setBattle_enable(true);
			digimon.setJogress_enable(true);
		}
		digimon.setMax_eat(8+digimon.getLevel()*2+digimon.getMin_weight()/5);
		digimon.setHungry_interval_minutes(digimon.getLevel()*20);
		digimon.setStrength_interval_minutes(digimon.getLevel()*22);
		digimon.setHungry_death_minutes(digimon.getHungry_interval_minutes()*15);
		digimon.setStrength_death_minutes(digimon.getStrength_interval_minutes()*15);
		digimon.setUnko_interval_minutes(digimon.getLevel()*10);
		digimon.setHealth(10+5*digimon.getLevel());
		
		int random = (int) (Math.random()*100);
		float rate = random;
		rate/=1000.0f;
		rate-=0.05f;
		rate+=1.0f;
		float rate2 = rate*2.0f;
		int sleep_time = 1800;
		int wakeup_time = 700;
		sleep_time += 100*digimon.getType();
		wakeup_time+=100*digimon.getType();
		for(int i = 0;i<digimon.getLevel();i++){
			sleep_time+=30;
			wakeup_time+=30;
			if(sleep_time%100 == 60){
				sleep_time = (sleep_time/100+1)*100;
				wakeup_time = (wakeup_time/100+1)*100;
			}
		}
		digimon.setSleep_time(sleep_time);
		digimon.setWakeup_time(wakeup_time);
		if(digimon.getLevel() == 1){
			digimon.setProgress_counter((int) (360*rate2));
			digimon.setLife((int) ((720.0f*rate2)+digimon.getLife()),"StatusManager.progress.if(digiomon.getlevel() == 1)");
			int default_dp = (int) (16*rate);
			digimon.setMax_dp(default_dp);
			digimon.setDp(digimon.getMax_dp());
			digimon.setHidden_power_rate(5);
		}
		else if(digimon.getLevel() == 2){
			digimon.setProgress_counter((int) (2880*rate2));
			digimon.setLife((int) ((7200.0f*rate2)+digimon.getLife()),"StatusManager.progress.if(digiomon.getlevel() == 2)");
			int default_dp = (int) (28*rate);
			default_dp*=(1.0+digimon.getPotential_power()/351.0);
			digimon.setMax_dp(default_dp);
			digimon.setDp(digimon.getMax_dp());
			int default_hrate = 20;
			default_hrate*=(1.0+digimon.getPotential_power()/351.0);
			digimon.setHidden_power_rate(default_hrate);
		}
		else if(digimon.getLevel() == 3){
			digimon.setProgress_counter((int) (5760*rate2));
			digimon.setLife((int) ((10080.0*rate2)+digimon.getLife()),"StatusManager.progress.if(digiomon.getlevel() == 3)");
			int default_dp = (int) (42*rate);
			default_dp*=(1.0+digimon.getPotential_power()/430.0);
			digimon.setMax_dp(default_dp);
			digimon.setDp(digimon.getMax_dp());
			int default_hrate = 45;
			default_hrate*=(1.0+digimon.getPotential_power()/430.0);
			digimon.setHidden_power_rate(default_hrate);
		}
		else if(digimon.getLevel() == 4){
			digimon.setProgress_counter((int) (8352.0f*rate2));
			digimon.setLife((int) ((10080.0f*rate2)+digimon.getLife()),"StatusManager.progress.if(digiomon.getlevel() == 4)");
			int default_dp = (int) (55*rate);
			default_dp*=(1.0+digimon.getPotential_power()/517.0);
			digimon.setMax_dp(default_dp);
			digimon.setDp(digimon.getMax_dp());
			int default_hrate = 100;
			default_hrate*=(1.0+digimon.getPotential_power()/517.0);
			digimon.setHidden_power_rate(default_hrate);
		}
		else if(digimon.getLevel() ==5){
			digimon.setProgress_counter(0);
			digimon.setLife((int) (digimon.getLife()*0.55),"StatusManager.progress.if(digiomon.getlevel() == 5)");
			int default_dp = (int) (68*rate);
			default_dp*=(1.0+digimon.getPotential_power()/667.0);
			digimon.setMax_dp(default_dp);
			digimon.setDp(digimon.getMax_dp());
			int default_hrate = 145;
			default_hrate*=(1.0+digimon.getPotential_power()/667.0);
			digimon.setHidden_power_rate(default_hrate);
		}
		else if(digimon.getLevel() ==6){
			digimon.setProgress_counter(0);
			digimon.setLife((int) (digimon.getLife()*0.55),"StatusManager.progress.if(digiomon.getlevel() == 6)");
			int default_dp = (int) (72*rate);
			default_dp*=(1.0+digimon.getPotential_power()/1000.0);
			digimon.setMax_dp(default_dp);
			digimon.setDp(digimon.getMax_dp());
			int default_hrate = 145;
			default_hrate*=(1.0+digimon.getPotential_power()/1000.0);
			digimon.setHidden_power_rate(default_hrate);
		}
		if(digimon.getType() == 0){
			digimon.setLife((int) (digimon.getLife()*1.25),"StatusManager.progress.if(digimon.getType() == 0");
		}
		else if(digimon.getType() == 2){
			digimon.setLife((int) (digimon.getLife()*0.75),"StatusManager.progress.if(digimon.getType() == 0");
		}
		System.out.println(digimon.getLife());
	}

	public void recovery() {
		Digimon digimon = this.digimon_list.get(selected_index);
		digimon.setIs_living(true);
		System.out.println("set true because recovery");
		digimon.setIs_egg(true);
		digimon.setEgg_id(99999);
		digimon.setDm(0);
		digimon.setLife(100,"StatusManager.recovery()");
		digimon.setHungry(0);
		digimon.setHungry_interval_minutes(10);
		digimon.setHungry_elapsed_minutes(-1);
		digimon.setHungry_death_minutes(30);
		digimon.setStrength(0);
		digimon.setStrength_interval_minutes(10);
		digimon.setStrength_elapsed_minutes(-1);
		digimon.setStrength_death_minutes(30);
		digimon.setUnko_interval_minutes(10);
		digimon.setUnko_elapsed_minutes(-1);
		digimon.setHealth_check_interval_minutes(10);
		digimon.setNumber_of_unko(0,1);
		digimon.setMax_dp(8);
		digimon.setDp(8);
		digimon.setIs_sick(false);
		digimon.setIs_injured(false);
		digimon.setIs_sleeping(false);
		digimon.setSleep_time(-1);
		digimon.setLevel(0);
		digimon.setBattle_count(0);
		digimon.setWin_count(0);
		digimon.setBattle_enable(false);
		digimon.setJogress_enable(false);
		digimon.setMax_eat(8);
		digimon.setHealth(0);
		digimon.setLifetime(0);
		digimon.setIs_light_on(true);
		digimon.setProgress_counter(17);
		if(digimon.getEgg_id() == 99999){
			int random = (int)(Math.random()*27);
			if(random == 27){
				random--;
			}
			digimon.setEgg_id(random);
			Element element = this.input_manager.referDatabaseFromId(random);
			digimon.setDigimon_id(element.getId());
			digimon.setType(element.getType());
			digimon.setLevel(element.getLevel());
			digimon.setMin_weight(element.getMin_weight());
			digimon.setWeight(digimon.getMin_weight());
			digimon.setPotential_power(element.getSpecies_power());
			digimon.setHidden_power(digimon.getHidden_power()*0.1f);
			digimon.setActual_power(digimon.getPotential_power()+(int)digimon.getHidden_power());
			digimon.setHidden_power_rate(1);
			digimon.setDotPattern(element.getDot_pattern());
			digimon.setAttack_type(element.getAttack_type());

			int random2 = (int)(Math.random())*30*(digimon.getActual_power()+1);
			random2%=25;
			digimon.setPendulum_type(random2);
		}
		else if(digimon.getEgg_id() != 99999){
			Element element = this.input_manager.referDatabaseFromId(digimon.getEgg_id());
			digimon.setEgg_id(99999);
			digimon.setDigimon_id(element.getId());
			digimon.setType(element.getType());
			digimon.setLevel(element.getLevel());
			digimon.setMin_weight(element.getMin_weight());
			digimon.setWeight(digimon.getMin_weight());
			digimon.setPotential_power(element.getSpecies_power());
			digimon.setHidden_power(digimon.getHidden_power()*0.35f);
			digimon.setActual_power(digimon.getPotential_power()+(int)digimon.getHidden_power());
			digimon.setHidden_power_rate(1);
			digimon.setDotPattern(element.getDot_pattern());
			digimon.setAttack_type(element.getAttack_type());

			int random2 = (int)(Math.random())*30*(digimon.getActual_power()+1);
			random2%=25;
			digimon.setPendulum_type(random2);
		}
		if(digimon.getPendulum_type() == 0){
			digimon.setPendulum_type(1);
		}
		System.out.println("\n\nrecovery\n\n"+digimon.toString());
	}

	public void setDigimonList(ArrayList<Digimon> digimon_list) {
		this.digimon_list = digimon_list;
	}

	public void setInputManager(InputManager manager) {
		this.input_manager = manager;
	}
	public void setIshost(boolean is_host) {
		this.is_host = is_host;
	}
	public boolean setPromptArg(String arg){
	    Digimon digimon = digimon_list.get(selected_index);
	    /*NSInteger pattern_number1 = 0;
	     pattern_number1+=digimon.getMegahits[0];
	     pattern_number1+=2*digimon.getMegahits[1];
	     pattern_number1+=4*digimon.getMegahits[2];
	     pattern_number1+=8*digimon.getMegahits[3];
	     pattern_number1+=16*digimon.getMegahits[4];
	     NSInteger pattern_number2 = 0;
	     pattern_number2+=1;
	     pattern_number2+=2;
	     pattern_number2+=4;
	     pattern_number2+=8;
	     pattern_number2+=16;
	     NSInteger power = digimon.getActualPower;
	     char c1 = power/10000+'0';
	     char c2 = (power%10000)/1000+'0';
	     char c3 = (power%1000)/100+'0';
	     char c4 = (power%100)/10+'0';
	     char c5 = (power%10)+'0';
	     char c6 = pattern_number1+'0';
	     char c7 = pattern_number2+'0';
	     printf("%c%c%c%c%c%c%c",c1,c2,c3,c4,c5,c6,c7);*/
	    System.out.println(arg.length()+":length");
	    if(arg.length() == 9){
	        int random = arg.charAt(8)-'0';
	        System.out.println("random:"+random);
	        char connect_type = (char) (arg.charAt(7)-random);//[arg characterAtIndex:7]-random;
	        //NSLog(@"%c",connect_type);
	        System.out.println("part of connection:"+connect_type);
	        if(connect_type == 'H'){
	            this.setIshost(false);
	            int mega = arg.charAt(6)-random-'0';//[arg characterAtIndex:6]-random;
	            int index_5 = mega%2;
	            mega-=index_5;
	            mega/=2;
	            int index_4 = mega%2;
	            mega-=index_4;
	            mega/=2;
	            int index_3 = mega%2;
	            mega-=index_3;
	            mega/=2;
	            int index_2 = mega%2;
	            mega-=index_2;
	            mega/=2;
	            int index_1 = mega%1;
	            ArrayList<Boolean>array = new ArrayList<Boolean>();
	            array.add(index_5==1);
	            array.add(index_4==1);
	            array.add(index_3==1);
	            array.add(index_2==1);
	            array.add(index_1==1);
	            //[NSArray arrayWithObjects:[NSNumber numberWithInt:index_1],[NSNumber numberWithInt:index_2],[NSNumber numberWithInt:index_3],[NSNumber numberWithInt:index_4],[NSNumber numberWithInt:index_5], nil];
	            char id_c1 = (char) (arg.charAt(5)-random);//[arg characterAtIndex:5]-random;
	            char id_c2 = (char) (arg.charAt(4)-random);//[arg characterAtIndex:4]-random;
	            int digi_id = 0;
	            digi_id+=id_c1 - '0';
	            digi_id*=23;
	            digi_id+=id_c2 - '0';
	            char win = (char) (arg.charAt(2)-random);//[arg characterAtIndex:2]-random;
	            this.win_type = win - '0';
	            int hitsp = arg.charAt(1)-random-'0';//[arg characterAtIndex:1]-random;
	            index_5 = hitsp%2;
	            hitsp-=index_5;
	            hitsp/=2;
	            index_4 = hitsp%2;
	            hitsp-=index_4;
	            hitsp/=2;
	            index_3 = hitsp%2;
	            hitsp-=index_3;
	            hitsp/=2;
	            index_2 = hitsp%2;
	            hitsp-=index_2;
	            hitsp/=2;
	            index_1 = hitsp%1;
	            ArrayList<Boolean> hitsarray  = new ArrayList<Boolean>();
	            hitsarray.add(index_1==1);
	            hitsarray.add(index_2==1);
	            hitsarray.add(index_3==1);
	            hitsarray.add(index_4==1);
	            hitsarray.add(index_5==1);//[NSArray arrayWithObjects:[NSNumber numberWithInt:index_1],[NSNumber numberWithInt:index_2],[NSNumber numberWithInt:index_3],[NSNumber numberWithInt:index_4],[NSNumber numberWithInt:index_5], nil];
	            Element dic = this.input_manager.referDatabaseFromId(digi_id);//NSDictionary *dic = [self->input referDatabaseFromId:digi_id];
	            String dots = dic.getDot_pattern();//[dic objectForKey:@"DOT_PATTERN"];
	            ArrayList<Boolean> dots_bool = new ArrayList<Boolean>();//NSMutableArray *dots_bool = [NSMutableArray array];
	            for(int i = 0;i<dots.length();i++){
	                if(dots.charAt(i) == '0'){
	                    dots_bool.add(true);//[dots_bool addObject:[NSNumber numberWithBool:YES]];
	                }
	                else{
	                    //[dots_bool addObject:[NSNumber numberWithBool:NO]];
	                    dots_bool.add(false);
	                }
	            }
	            System.out.println("enemy_megahits"+array.toString());
	            System.out.println("enemy_hitpatern"+hitsarray.toString());
	            digimon.enemy_dots = dots_bool;
	            digimon.enemy_attack_type = dic.getAttack_type();
	            digimon.enemy_megahits = array;
	            digimon.hit_pattern = hitsarray;
	            this.next_enemy_id = digi_id;
	            return true;

	        }
	        else if(connect_type == 'C'){
	            this.setIshost(true);
	            int mega = arg.charAt(6)-random-'0';//[arg characterAtIndex:6]-random;
	            int index_5 = mega%2;
	            mega-=index_5;
	            mega/=2;
	            int index_4 = mega%2;
	            mega-=index_4;
	            mega/=2;
	            int index_3 = mega%2;
	            mega-=index_3;
	            mega/=2;
	            int index_2 = mega%2;
	            mega-=index_2;
	            mega/=2;
	            int index_1 = mega%1;
	            ArrayList<Boolean>array = new ArrayList<Boolean>();
	            array.add(index_5==1);
	            array.add(index_4==1);
	            array.add(index_3==1);
	            array.add(index_2==1);
	            array.add(index_1==1);
	            char id_c1 = (char) (arg.charAt(5)-random);//[arg characterAtIndex:5]-random;
	            char id_c2 = (char) (arg.charAt(4)-random);//[arg characterAtIndex:4]-random;
	            int digi_id = 0;
	            digi_id+=id_c1 - '0';
	            digi_id*=23;
	            digi_id+=id_c2 - '0';
	            char power_c1 = (char) (arg.charAt(2)-random - '0');//[arg characterAtIndex:2]-random;
	            char power_c2 = (char) (arg.charAt(1)-random - '0');//[arg characterAtIndex:1]-random;
	            char power_c3 = (char) (arg.charAt(0)-random - '0');//[arg characterAtIndex:0]-random;
	            int power = 0;
	            power+=(power_c1)*22*22;
	            power+=(power_c2)*22;
	            power+=power_c3;
	            digimon.enemy_power = power;
	            System.out.println("digimon power:"+power);
	            Element dic = this.input_manager.referDatabaseFromId(digi_id);//NSDictionary *dic = [self->input referDatabaseFromId:digi_id];
	            String dots = dic.getDot_pattern();//NSString *dots = [dic objectForKey:@"DOT_PATTERN"];
	            ArrayList<Boolean> dots_bool = new ArrayList<Boolean>();//NSMutableArray *dots_bool = [NSMutableArray array];
	            for(int i = 0;i<dots.length();i++){
	                if(dots.charAt(i) == '0'){
	                   dots_bool.add(true);
	                }
	                else{
	                    dots_bool.add(false);//[dots_bool addObject:[NSNumber numberWithBool:NO]];
	                    
	                }
	            }
	            digimon.enemy_dots = dots_bool;
	            System.out.println("enemy_megahits:"+array.toString());
	            digimon.enemy_attack_type = dic.getAttack_type();
	            digimon.enemy_megahits = array;
	            this.next_enemy_id = digi_id;
	            return true;
	        }
	        else{
	            return false;
	        }
	    }
	    return false;
	}

	public void turnLight(boolean on) {
		// TODO �����������������\�b�h�E�X�^�u
		Digimon digimon = digimon_list.get(selected_index);
		digimon.setIs_light_on(on);
		int sleeptime = digimon.getSleep_time();
		int current_time2 = digimon.getSleep_time();
		if(on == false){
			if(digimon.getWakeup_time() > digimon.getSleep_time()){
				sleeptime+=digimon.getWakeup_time();
			}
			else{
				sleeptime+=digimon.getWakeup_time()+(2400-digimon.getSleep_time());
			}
			if(current_time2 >= digimon.getSleep_time()){
				current_time2+=this.current_time;
			}
			else{
				current_time2+=this.current_time+(2400-digimon.getSleep_time());
			}
			if(sleeptime>=current_time2){
				digimon.setIs_sleeping(true);
			}
		}
	}

	public void updateStatusByMinutes(int current_time2) {
		// TODO �����������������\�b�h�E�X�^�u
		System.out.println("update status :"+current_time2);
		this.current_time = current_time2;
		for(int i = 0;i<this.digimon_list.size();i++){
			Digimon digimon = digimon_list.get(i);
			if(digimon.isIs_living()){
				boolean calling = false;
				if(digimon.isIs_egg() == true && digimon.getProgress_counter() == 15){
					digimon.setIs_egg(false);
					digimon.setIs_calling(true);
					calling = true;
				}
				if(digimon.getLevel() < 5){
					digimon.setLife(digimon.getLife()-1,"StatusManager.updateStatusByMinutes.digimon.getLevel() < 5");
				}
				int health = digimon.getHealth();
				if(digimon.getType() == 0){
					health*=1.2;
				}
				if(digimon.getType() != 2){
					digimon.setLife((int)(digimon.getLife() - health*0.8),"StatusManager.updateStatusByMinutes.digimon.getType()!=2");
				}
				else{
					digimon.setLife((int)(digimon.getLife() - health*0.4),"StatusManager.updateStatusByMinutes.digimon.getType()==2");
				}
				digimon.setProgress_counter(digimon.getProgress_counter()-1);
				if(digimon.getProgress_counter() <= 0){
					boolean result = this.checkForProgress(i);
				}
				if(digimon.getLife() <= 0){
					digimon.setIs_living(false);
					System.out.println("set false because no life");
				}
				if(current_time == 0){
					digimon.setDm(digimon.getDm()+1);
				}
				digimon.setUnko_elapsed_minutes(digimon.getUnko_elapsed_minutes()+1);
				if((digimon.isIs_sleeping() == false &&digimon.getUnko_elapsed_minutes() >= digimon.getUnko_interval_minutes())){
					digimon.setUnko_elapsed_minutes(0);
					digimon.setNumber_of_unko(digimon.getNumber_of_unko()+1,100);
					if(digimon.getNumber_of_unko() > 8){
						digimon.setNumber_of_unko(8,110);
					}
				}
				digimon.setHungry_elapsed_minutes(digimon.getHungry_elapsed_minutes()+1);
				if((digimon.getHungry_elapsed_minutes() >= digimon.getHungry_interval_minutes() && digimon.isIs_sleeping() == false) || (digimon.isIs_sleeping() == true && digimon.getHungry_elapsed_minutes() >= digimon.getHungry_interval_minutes()*2)){
					digimon.setHungry(digimon.getHungry()-1);
					if(digimon.getHungry() <0){
						digimon.setHungry(0);
					}
					else{
						digimon.setHungry_elapsed_minutes(0);
					}
				}
				if(digimon.getHungry_elapsed_minutes() >= digimon.getHungry_death_minutes()){
					digimon.setIs_living(false);
					System.out.println("set false because hungry");
				}
				digimon.setStrength_elapsed_minutes(digimon.getStrength_elapsed_minutes()+1);
				if(digimon.getStrength_elapsed_minutes()>=digimon.getStrength_interval_minutes()){
					digimon.setStrength(digimon.getStrength()-1);
					if(digimon.getStrength() < 0){
						digimon.setStrength(0);
					}
					else{
						digimon.setStrength_elapsed_minutes(0);
					}
				}
				if((digimon.getStrength_elapsed_minutes() >= digimon.getStrength_death_minutes() && digimon.isIs_sleeping() == false) || (digimon.getStrength_elapsed_minutes() >= digimon.getStrength_death_minutes()*2 && digimon.isIs_sleeping() == true)){
					digimon.setIs_living(false);
					System.out.println("set false because week");
				}
				if(this.current_time == digimon.getSleep_time()){
					digimon.setSlept_time(current_time);
					digimon.setIs_sleeping(true);
				}
				if(this.current_time == digimon.getWakeup_time()){
					digimon.setIs_sleeping(false);
					digimon.setIs_light_on(true);
					int sleeptime = 0;
					if(digimon.getSlept_time() > digimon.getWakeup_time()){
						sleeptime += 2400-digimon.getSlept_time();
						sleeptime += digimon.getWakeup_time();
					}
					else{
						sleeptime += digimon.getWakeup_time() - digimon.getSlept_time();
					}
					if(sleeptime >= 800){
						digimon.setDp(digimon.getMax_dp());
						digimon.setDp_half(false);
						digimon.setHealth(digimon.getHealth()+1);
					}
				}
				digimon.setHealth_check_elapsed_minutes(digimon.getHealth_check_elapsed_minutes()+1);
				if((digimon.getHealth_check_elapsed_minutes() >= digimon.getHealth_check_interval_minutes() && digimon.isIs_sleeping() == false)||(digimon.getHealth_check_elapsed_minutes() >= digimon.getHealth_check_interval_minutes()*2 && digimon.isIs_sleeping() == true)){
					digimon.setHealth_check_elapsed_minutes(0);
					if(digimon.getNumber_of_unko() >= 8){
						digimon.setIs_sick(true);
						digimon.setHealth(digimon.getHealth()-1);
						digimon.setIs_calling(true);
						calling = true;
					}
					if(digimon.getNumber_of_unko() >4){
						digimon.setHealth(digimon.getHealth()-1);
						digimon.setIs_calling(true);
						calling = true;
					}
					if(digimon.getHungry() == 0 && digimon.getHungry_elapsed_minutes() >= digimon.getHungry_interval_minutes()){
						digimon.setIs_calling(true);
						calling = true;
					}
					if(digimon.getHungry() == 0 && digimon.getHungry_elapsed_minutes() >= digimon.getHungry_interval_minutes()*2){
						digimon.setIs_calling(true);
						digimon.setHealth(digimon.getHealth()-1);
						calling = true;
					}
					if(digimon.getStrength() == 0&& digimon.getStrength_elapsed_minutes() >= digimon.getHungry_interval_minutes()){
						digimon.setIs_calling(true);
						calling = true;
					}
					if(digimon.getStrength() == 0 && digimon.getStrength_elapsed_minutes() >= digimon.getStrength_interval_minutes()*2){
						digimon.setIs_calling(true);
						calling = true;
						digimon.setHealth(digimon.getHealth()-1);
					}
					if(calling == false){
						digimon.setIs_calling(false);
					}
				}
			}
		}
	}

	public void washUnko() {
		// TODO �����������������\�b�h�E�X�^�u
		Digimon digimon = digimon_list.get(selected_index);
		digimon.setNumber_of_unko(0,2);
		digimon.setReaction(true);
		if(StatusManager.getCurrentTimeArea(this.current_time) == MORNING){
			digimon.setLifetime(digimon.getLifetime()+1);
		}
		else if(StatusManager.getCurrentTimeArea(this.current_time) == NIGHT){
			digimon.setLifetime(digimon.getLifetime()-1);
		}
	}
}
