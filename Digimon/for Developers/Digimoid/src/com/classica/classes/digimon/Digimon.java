package com.classica.classes.digimon;

import java.io.IOException;
import java.util.ArrayList;

import org.xmlpull.v1.XmlSerializer;

import android.graphics.PointF;

public class Digimon {
	public final static float DOT_DEFAULT_SCALE = 0.075f;
	public final static float DOT_SIDE_LENGTH_FINAL_VALUE = 0.075f;
	public final static float DOT_IMAGE_DEFAULT_POSITION_X = -0.35f;
	public final static float DOT_IMAGE_DEFAULT_POSITION_Y = -0.15f;
	public final static float SUB_DOT_DEFAULT_SCALE = 0.15f;
	public final static float SUB_DOT_SIDE_LENGTH_FINAL_VALUE = 0.15f;
	public final static float SUB_DOT_IMAGE_DEFAULT_POSITION_X = -0.55f;
	public final static float SUB_DOT_IMAGE_DEFAULT_POSITION_Y = -0.2f;

	private boolean is_living;
	private int dm;
	private int weight;
	private int hungry;
	private int strength;
	private int number_of_unko;
	private int dp;
	private boolean dp_half;
	private int battle_count;
	private int win_count;
	private int type;
	private boolean battle_enable;
	private boolean jogress_enable;
	private boolean is_sleeping;
	private boolean is_light_on;
	private boolean is_egg;
	private int egg_id;
	private boolean is_sick;
	private boolean is_injured;
	private ArrayList<Boolean> dot_pattern;
	private ArrayList<PointF> dot_positions;
	private ArrayList<PointF> sub_dot_positions;
	private ArrayList<PointF> random_values;
	private ArrayList<PointF> sub_random_values;
	private int attack_type;
	private boolean is_calling;
	private int digimon_id;
	private int level;
	private int protein_count;
	private int min_weight;
	private int max_eat;
	private int max_dp;
	private int potential_power;
	private float hidden_power;
	private int hidden_power_rate;
	private int actual_power;
	private int health;
	private int health_check_interval_minutes;
	private int health_check_elapsed_minutes;
	private int pendulum_type;
	private int hungry_elapsed_minutes;
	private int hungry_interval_minutes;
	private int hungry_death_minutes;
	private int strength_elapsed_minutes;
	private int strength_interval_minutes;
	private int strength_death_minutes;
	private int sleep_time;
	private int wakeup_time;
	private int slept_time;
	private int wokeup_time;
	private int unko_elapsed_minutes;
	private int unko_interval_minutes;
	private int life;
	private int progress_counter;
	private int[] megahits;
	private boolean reaction;
	private Frame frame;
	private int lifetime;
	private int offline_battle_count;
	public ArrayList<Boolean> enemy_dots;
	public int enemy_attack_type;
	public int enemy_power;
	public ArrayList<Boolean> enemy_megahits;
	public ArrayList<Boolean> hit_pattern;

	public Digimon() {
		this.dot_pattern = new ArrayList<Boolean>();
		this.enemy_dots = new ArrayList<Boolean>();
		this.frame = new Frame();
		this.frame.setBody_color_type((int) (Math.random()*14));
		this.frame.setFrame_color_type((int) (Math.random()*13));
		this.frame.setButton_color_type((int) (Math.random()*13));
		this.is_living = false;
		this.dot_positions = new ArrayList<PointF>();
		this.sub_dot_positions = new ArrayList<PointF>();
		this.random_values = new ArrayList<PointF>();
		this.sub_random_values = new ArrayList<PointF>();
	}

	public boolean isIs_living() {
		return is_living;
	}

	public void setIs_living(boolean is_living) {
		this.is_living = is_living;
	}

	public int getDm() {
		return dm;
	}

	public void setDm(int dm) {
		this.dm = dm;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHungry() {
		return hungry;
	}

	public void setHungry(int hungry) {
		this.hungry = hungry;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getNumber_of_unko() {
		return number_of_unko;
	}

	public void setNumber_of_unko(int number_of_unko,int type) {
		this.number_of_unko = number_of_unko;
		//System.out.println("type:"+type);
	}

	public int getDp() {
		return dp;
	}

	public void setDp(int dp) {
		this.dp = dp;
	}

	public boolean isDp_half() {
		return dp_half;
	}

	public void setDp_half(boolean dp_half) {
		this.dp_half = dp_half;
	}

	public int getBattle_count() {
		return battle_count;
	}

	public void setBattle_count(int battle_count) {
		this.battle_count = battle_count;
	}

	public int getWin_count() {
		return win_count;
	}

	public void setWin_count(int win_count) {
		this.win_count = win_count;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean isBattle_enable() {
		return battle_enable;
	}

	public void setBattle_enable(boolean battle_enable) {
		this.battle_enable = battle_enable;
	}

	public boolean isJogress_enable() {
		return jogress_enable;
	}

	public void setJogress_enable(boolean jogress_enable) {
		this.jogress_enable = jogress_enable;
	}

	public boolean isIs_sleeping() {
		return is_sleeping;
	}

	public void setIs_sleeping(boolean is_sleeping) {
		this.is_sleeping = is_sleeping;
	}

	public boolean isIs_light_on() {
		return is_light_on;
	}

	public void setIs_light_on(boolean is_light_on) {
		this.is_light_on = is_light_on;
	}

	public boolean isIs_egg() {
		return is_egg;
	}

	public void setIs_egg(boolean is_egg) {
		this.is_egg = is_egg;
	}

	public int getEgg_id() {
		return egg_id;
	}

	public void setEgg_id(int egg_id) {
		this.egg_id = egg_id;
	}

	public boolean isIs_sick() {
		return is_sick;
	}

	public void setIs_sick(boolean is_sick) {
		this.is_sick = is_sick;
	}

	public boolean isIs_injured() {
		return is_injured;
	}

	public void setIs_injured(boolean is_injured) {
		this.is_injured = is_injured;
	}

	public ArrayList<Boolean> getDot_pattern() {
		return dot_pattern;
	}

	public void setDot_pattern(ArrayList<Boolean> dot_pattern) {
		this.dot_pattern = dot_pattern;
	}

	public int getAttack_type() {
		return attack_type;
	}

	public void setAttack_type(int attack_type) {
		this.attack_type = attack_type;
	}

	public boolean isIs_calling() {
		return is_calling;
	}

	public void setIs_calling(boolean is_calling) {
		this.is_calling = is_calling;
	}

	public int getDigimon_id() {
		return digimon_id;
	}

	public void setDigimon_id(int digimon_id) {
		this.digimon_id = digimon_id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getProtein_count() {
		return protein_count;
	}

	public void setProtein_count(int protein_count) {
		this.protein_count = protein_count;
	}

	public int getMin_weight() {
		return min_weight;
	}

	public void setMin_weight(int min_weight) {
		this.min_weight = min_weight;
	}

	public int getMax_eat() {
		return max_eat;
	}

	public void setMax_eat(int max_eat) {
		this.max_eat = max_eat;
	}

	public int getMax_dp() {
		return max_dp;
	}

	public void setMax_dp(int max_dp) {
		this.max_dp = max_dp;
	}

	public int getPotential_power() {
		return potential_power;
	}

	public void setPotential_power(int potential_power) {
		this.potential_power = potential_power;
	}

	public float getHidden_power() {
		return hidden_power;
	}

	public void setHidden_power(float hidden_power) {
		this.hidden_power = hidden_power;
	}

	public int getHidden_power_rate() {
		return hidden_power_rate;
	}

	public void setHidden_power_rate(int hidden_power_rate) {
		this.hidden_power_rate = hidden_power_rate;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getHealth_check_interval_minutes() {
		return health_check_interval_minutes;
	}

	public void setHealth_check_interval_minutes(
			int health_check_interval_minutes) {
		this.health_check_interval_minutes = health_check_interval_minutes;
	}

	public int getHealth_check_elapsed_minutes() {
		return health_check_elapsed_minutes;
	}

	public void setHealth_check_elapsed_minutes(int health_check_elapsed_minutes) {
		this.health_check_elapsed_minutes = health_check_elapsed_minutes;
	}

	public int getPendulum_type() {
		return pendulum_type;
	}

	public void setPendulum_type(int pendulum_type) {
		this.pendulum_type = pendulum_type;
	}

	public int getHungry_elapsed_minutes() {
		return hungry_elapsed_minutes;
	}

	public void setHungry_elapsed_minutes(int hungry_elapsed_minutes) {
		this.hungry_elapsed_minutes = hungry_elapsed_minutes;
	}

	public int getHungry_interval_minutes() {
		return hungry_interval_minutes;
	}

	public void setHungry_interval_minutes(int hungry_interval_minutes) {
		this.hungry_interval_minutes = hungry_interval_minutes;
	}

	public int getHungry_death_minutes() {
		return hungry_death_minutes;
	}

	public void setHungry_death_minutes(int hungry_death_minutes) {
		this.hungry_death_minutes = hungry_death_minutes;
	}

	public int getStrength_elapsed_minutes() {
		return strength_elapsed_minutes;
	}

	public void setStrength_elapsed_minutes(int strength_elapsed_minutes) {
		this.strength_elapsed_minutes = strength_elapsed_minutes;
	}

	public int getStrength_interval_minutes() {
		return strength_interval_minutes;
	}

	public void setStrength_interval_minutes(int strength_interval_minutes) {
		this.strength_interval_minutes = strength_interval_minutes;
	}

	public int getStrength_death_minutes() {
		return strength_death_minutes;
	}

	public void setStrength_death_minutes(int strength_death_minutes) {
		this.strength_death_minutes = strength_death_minutes;
	}

	public int getSleep_time() {
		return sleep_time;
	}

	public void setSleep_time(int sleep_time) {
		this.sleep_time = sleep_time;
	}

	public int getWakeup_time() {
		return wakeup_time;
	}

	public void setWakeup_time(int wakeup_time) {
		this.wakeup_time = wakeup_time;
	}

	public int getSlept_time() {
		return slept_time;
	}

	public void setSlept_time(int slept_time) {
		this.slept_time = slept_time;
	}

	public int getWokeup_time() {
		return wokeup_time;
	}

	public void setWokeup_time(int wokeup_time) {
		this.wokeup_time = wokeup_time;
	}

	public int getUnko_elapsed_minutes() {
		return unko_elapsed_minutes;
	}

	public void setUnko_elapsed_minutes(int unko_elapsed_minutes) {
		this.unko_elapsed_minutes = unko_elapsed_minutes;
	}

	public int getUnko_interval_minutes() {
		return unko_interval_minutes;
	}

	public void setUnko_interval_minutes(int unko_interval_minutes) {
		this.unko_interval_minutes = unko_interval_minutes;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life,String from) {
		this.life = life;
		System.out.println(from+" to "+life);
	}

	public int getProgress_counter() {
		return progress_counter;
	}

	public void setProgress_counter(int progress_counter) {
		this.progress_counter = progress_counter;
	}

	public int[] getMegahits() {
		return megahits;
	}

	public void setMegahits(int[] megahits) {
		this.megahits = megahits;
	}

	public boolean isReaction() {
		return reaction;
	}

	public void setReaction(boolean reaction) {
		this.reaction = reaction;
	}

	public Frame getFrame() {
		return frame;
	}

	public void setFrame(Frame frame) {
		this.frame = frame;
	}

	public int getLifetime() {
		return lifetime;
	}

	public void setLifetime(int lifetime) {
		this.lifetime = lifetime;
	}

	public int getOffline_battle_count() {
		return offline_battle_count;
	}

	public void setOffline_battle_count(int offline_battle_count) {
		this.offline_battle_count = offline_battle_count;
	}

	public void breakDrawPart() {
		// TODO 自動生成されたメソッド・スタブ
		this.dot_pattern.clear();
		this.dot_positions.clear();
		this.sub_dot_positions.clear();
		this.random_values.clear();
		this.sub_random_values.clear();
	}

	public void setDotPattern(String dot_pattern) {
		// TODO 自動生成されたメソッド・スタブ
		this.dot_pattern = new ArrayList<Boolean>();
		//System.out.println(dot_pattern);
		for (int i = 0; i < dot_pattern.length(); i++) {
			if (dot_pattern.charAt(i) == '0') {
				this.dot_pattern.add(true);
			} else {
				this.dot_pattern.add(false);
			}
		}
		//System.out.println("dot pattern is set");
	}

	public void reloadFrame() {
		// TODO 自動生成されたメソッド・スタブ
		this.frame.reload();
	}

	public int getActual_power() {
		return actual_power;
	}

	public void setActual_power(int actual_power) {
		this.actual_power = actual_power;
	}

	public ArrayList<PointF> getDot_positions() {
		return dot_positions;
	}

	public ArrayList<PointF> getsub_dot_positions() {
		return sub_dot_positions;
	}

	public ArrayList<PointF> getRandom_values() {
		return random_values;
	}

	public ArrayList<PointF> getSub_random_values() {
		return sub_random_values;
	}

	public String loadAttackDot(int id) {

		String dotdata = null;
		if (id == 0) {
			dotdata = "1100001110111101010011100101111001111110010111101011110111000011";
		}
		if (id == 1) {
			dotdata = "1100011110111011010111010111010101100101101110111100011111111111";
		}
		if (id == 2) {
			dotdata = "1100001110111101011011100111101001111010011001101011110111000011";
		}
		if (id == 3) {
			dotdata = "1001111101101111011010111001111111100111110110111101101011100111";
		}
		if (id == 4) {
			dotdata = "1100111110110111011110110111101010110111110011011111101011111101";
		}
		if (id == 5) {
			dotdata = "1111000110010100101000101100000000000011010001010010101010001100";
		}
		if (id == 6) {
			dotdata = "1001111101011111011001101011100001000100011111011011100111000011";
		}
		if (id == 7) {
			dotdata = "1111000011010000100000101100011100001011000101110011111100011111";
		}
		if (id == 8) {
			dotdata = "1100000110000011001100010111100000110001100000111100000111111111";
		}
		if (id == 9) {
			dotdata = "1110000011011110101000000100000010100000110111101110000011111111";
		}
		if (id == 10) {
			dotdata = "1100001010101111010110010101010001010000010110011010111111000010";
		}
		if (id == 11) {
			dotdata = "1100001010101111110110011101010011010000110110011010111111000010";
		}
		if (id == 12) {
			dotdata = "1100001010001111001000100100000101000001001000101000111111000010";
		}
		if (id == 13) {
			dotdata = "0100011111110011100010010000010000000100100010011111001101000111";
		}
		if (id == 14) {
			dotdata = "1111001111101101100001100110001000000011000000110000001110000111";
		}
		if (id == 15) {
			dotdata = "0000011111100111000000111110001110000000111100001111000011000011";
		}
		if (id == 16) {
			dotdata = "1111111110011101011010100110110110011111111110111111010111111011";
		}
		if (id == 17) {
			dotdata = "1111111111100000100111000100000000000000100000001110000011111111";
		}
		if (id == 18) {
			dotdata = "1111111111000100100110110100000100000001100000111100010011111111";
		}
		if (id == 19) {
			dotdata = "1111111111000010101011000100111000001110100011001100001011111111";
		}
		if (id == 20) {
			dotdata = "1111111111000000101000100100001000000010100000101100000011111111";
		}
		if (id == 21) {
			dotdata = "1111111010010000010011100000111010011001111101001111000011111001";
		}
		if (id == 22) {
			dotdata = "1100000110000000101101101000000010001000110000011101010111111111";
		}
		if (id == 23) {
			dotdata = "0000001101111001010000010011110010100000100110101011011011100000";
		}
		if (id == 24) {
			dotdata = "1110000010000000000000000001111000111110010000000011111101111111";
		}
		if (id == 25) {
			dotdata = "1111111110011111000000110001100000000100010000000000001110011111";
		}
		if (id == 26) {
			dotdata = "1111000011000101101111010110010101000101010001011010101111000111";
		}
		if (id == 27) {
			dotdata = "1111111110011111000001110000000100000000000000010000011110011111";
		}
		if (id == 28) {
			dotdata = "1111011011100100100100100011111001111100011111010011100110000011";
		}
		if (id == 29) {
			dotdata = "0000001110011001110011010000011010000110110011011001100100000011";
		}
		if (id == 30) {
			dotdata = "1000001001011100101110101100011110000010010111001011101011000111";
		}
		if (id == 31) {
			dotdata = "1001001101100101001011011001001101101001010011011001001111111111";
		}
		if (id == 32) {
			dotdata = "1001001101101101010001011001001101000101011011011001001111111111";
		}
		if (id == 33) {
			dotdata = "0011110001011010101001011101001111000011101001010101101000111100";
		}
		if (id == 34) {
			dotdata = "1101011110000011000000011001001100000001100000111101011111111111";
		}
		if (id == 35) {
			dotdata = "1100001110000101001100100011010000000110010110101010110111000011";
		}
		if (id == 36) {
			dotdata = "0010011101011011101110110111011101101011100101011111101011111100";
		}
		if (id == 37) {
			dotdata = "1111111111111000110001100011110111000110111110001111111111111111";
		}
		if (id == 38) {
			dotdata = "1111111111111100110000100011111011000010111111001111111111111111";
		}
		if (id == 39) {
			dotdata = "1000011111010011111010011110100111101001111010011101001110000111";
		}
		if (id == 40) {
			dotdata = "1000000111011000111011001111011011110010111011001101100010000001";
		}
		if (id == 41) {
			dotdata = "0000001110100001110100001110100011110100111010101101000010000001";
		}
		if (id == 42) {
			dotdata = "1001001101000001010000010000000110000011110001111110111111111111";
		}
		if (id == 43) {
			dotdata = "1111111110010011000010010001000100001001100100111101011111101111";
		}
		if (id == 44) {
			dotdata = "1001111101011111001011111101011111101011111101001111101011111001";
		}
		if (id == 45) {
			dotdata = "1000111101011111010111110100111101000111101000001101000011100000";
		}
		if (id == 46) {
			dotdata = "1111111111000001101111100111111000000110011110101111110011111111";
		}
		if (id == 47) {
			dotdata = "1111111100111111010011111011000011011110111001101111100011111111";
		}
		if (id == 48) {
			dotdata = "1111111111111100011110100000011001111110101111101100000111111111";
		}
		if (id == 49) {
			dotdata = "1111111111111100000000101011111011001110111100001111111111111111";
		}
		if (id == 50) {
			dotdata = "1110001110011101011011100011101001110010010111011011101111000111";
		}
		if (id == 51) {
			dotdata = "1100000010000000001111000100000000111110011111101111111011111110";
		}
		if (id == 52) {
			dotdata = "1100011100101011110111011101111011011110110111101110110111010010";
		}
		if (id == 53) {
			dotdata = "1101111011110111011000111100100111100011101101100101111110111011";
		}
		if (id == 54) {
			dotdata = "0001111111000010101000000001100100011001101000001100001000011111";
		}
		if (id == 55) {
			dotdata = "1100001110100101101111101101100010101000011101100110100100011111";
		}
		if (id == 56) {
			dotdata = "1111101011010001100010100000011110001010110100011111101011111111";
		}
		if (id == 57) {
			dotdata = "1111111111111111110001111011001110100001110001111111111111111111";
		}
		if (id == 58) {
			dotdata = "1100000010011000001100000000000000001000101111001100000011111111";
		}
		if (id == 59) {
			dotdata = "1100010110011011001101111001101111000101100110110011011110011011";
		}
		if (id == 60) {
			dotdata = "1111111111111001110010011100111111111001100100001001000011111001";
		}
		if (id == 61) {
			dotdata = "1111110011000111101110110111110101111101101110111100011111111100";
		}
		if (id == 62) {
			dotdata = "1011111101011011010101010101010101010101010101010101101110111111";
		}
		if (id == 63) {
			dotdata = "1111011111110001111100001111011010000110010001010000011110001111";
		}
		if (id == 64) {
			dotdata = "1111000011000000110001101101111011011110110110000001100000011111";
		}
		if (id == 65) {
			dotdata = "1100001110011001001001000101001001000010001001001001100111000011";
		}
		if (id == 66) {
			dotdata = "1111111111100111100100010110101001001000010000001000000111111111";
		}
		if (id == 67) {
			dotdata = "1111111110000111000000110000000000111010010000101000000011111111";
		}
		if (id == 68) {
			dotdata = "1100000110111100010110100100011001110010011001001001110111000011";
		}
		if (id == 69) {
			dotdata = "1100100110110110100010001111011110010111010001110000111110011111";
		}
		if (id == 70) {
			dotdata = "1100000010011001001100110110000100110011100110011100000011111111";
		}
		if (id == 71) {
			dotdata = "0111111100101111001001010010010000100100001001010010111101111111";
		}
		if (id == 72) {
			dotdata = "1111100100001001001101011101110110111011101011001001000010011111";
		}
		if (id == 73) {
			dotdata = "1111000111101011110101111011011110100111101001111010001111000001";
		}
		if (id == 74) {
			dotdata = "1100000010100111010011110100111101001111010011111010011111000000";
		}
		if (id == 75) {
			dotdata = "1110000111010011101001111010011110100111101001111101001111100001";
		}
		if (id == 76) {
			dotdata = "1100011110111001101111100111111001111110011111011001101111100001";
		}
		if (id == 77) {
			dotdata = "1100011110111011011011010101110101011101011000111011110111000000";
		}
		if (id == 78) {
			dotdata = "1111101011010001100010100010011110001010110100011111101011111111";
		}
		if (id == 79) {
			dotdata = "1000111100000111000001110000011110000111111000111111110111111111";
		}
		if (id == 80) {
			dotdata = "1100000110000000000000000000000000010001000111110000111110000010";
		}
		if (id == 81) {
			dotdata = "1100001110000001000000000000000000000000000000011000011111000010";
		}
		if (id == 82) {
			dotdata = "1111101111111101000000010111110010000001111111011111101111111111";
		}
		if (id == 83) {
			dotdata = "1111111111111011000000001011100011000011111110111111111111111111";
		}
		if (id == 84) {
			dotdata = "1100001110100001000000000000000001000000010000001010000111000011";
		}
		if (id == 85) {
			dotdata = "1111000011100011110001111000000111100011110001111000111100011111";
		}
		if (id == 86) {
			dotdata = "1111111011101100110010001000000100000011001001110110111111111111";
		}
		if (id == 87) {
			dotdata = "1110000111100001100001111000011110011111000111110111111111111111";
		}
		if (id == 88) {
			dotdata = "1111100011110001111000111100000111100011110001111000111100011111";
		}
		if (id == 89) {
			dotdata = "1100011111001111110101111111101111111101111110111110011111100111";
		}
		if (id == 90) {
			dotdata = "1110000110000111111111110000011111100001111111111000011111100001";
		}
		if (id == 91) {
			dotdata = "1111111111000011001110111100001111111111111100001100111011110000";
		}
		if (id == 92) {
			dotdata = "1111111111111011100000100000110010000010111110111111111111111111";
		}
		if (id == 93) {
			dotdata = "1111111110111111110111011011011011100101110100111010000110000001";
		}
		if (id == 94) {
			dotdata = "1110000111010011101001110100111101001111101001111101001111100001";
		}
		if (id == 95) {
			dotdata = "0011001110011001110011001110011011100110110011001001100100110011";
		}
		if (id == 96) {
			dotdata = "1011010100100100110110110010010110100100110110110010010010101101";
		}
		if (id == 97) {
			dotdata = "1100110010011001001100110110011101100111001100111001100111001100";
		}
		if (id == 98) {
			dotdata = "1111000011101110110101011010110110011011101101110000111111111111";
		}
		if (id == 99) {
			dotdata = "1110000000100011100011110001011100101111001111110111111101111111";
		}
		if (id == 100) {
			dotdata = "1111111100011111110011110000000011001111000111111111111111111111";
		}
		return dotdata;
	}

	public String loadAttackDot() {

		String dotdata = null;
		if (this.attack_type == 0) {
			dotdata = "1100001110111101010011100101111001111110010111101011110111000011";
		}
		if (this.attack_type == 1) {
			dotdata = "1100011110111011010111010111010101100101101110111100011111111111";
		}
		if (this.attack_type == 2) {
			dotdata = "1100001110111101011011100111101001111010011001101011110111000011";
		}
		if (this.attack_type == 3) {
			dotdata = "1001111101101111011010111001111111100111110110111101101011100111";
		}
		if (this.attack_type == 4) {
			dotdata = "1100111110110111011110110111101010110111110011011111101011111101";
		}
		if (this.attack_type == 5) {
			dotdata = "1111000110010100101000101100000000000011010001010010101010001100";
		}
		if (this.attack_type == 6) {
			dotdata = "1001111101011111011001101011100001000100011111011011100111000011";
		}
		if (this.attack_type == 7) {
			dotdata = "1111000011010000100000101100011100001011000101110011111100011111";
		}
		if (this.attack_type == 8) {
			dotdata = "1100000110000011001100010111100000110001100000111100000111111111";
		}
		if (this.attack_type == 9) {
			dotdata = "1110000011011110101000000100000010100000110111101110000011111111";
		}
		if (this.attack_type == 10) {
			dotdata = "1100001010101111010110010101010001010000010110011010111111000010";
		}
		if (this.attack_type == 11) {
			dotdata = "1100001010101111110110011101010011010000110110011010111111000010";
		}
		if (this.attack_type == 12) {
			dotdata = "1100001010001111001000100100000101000001001000101000111111000010";
		}
		if (this.attack_type == 13) {
			dotdata = "0100011111110011100010010000010000000100100010011111001101000111";
		}
		if (this.attack_type == 14) {
			dotdata = "1111001111101101100001100110001000000011000000110000001110000111";
		}
		if (this.attack_type == 15) {
			dotdata = "0000011111100111000000111110001110000000111100001111000011000011";
		}
		if (this.attack_type == 16) {
			dotdata = "1111111110011101011010100110110110011111111110111111010111111011";
		}
		if (this.attack_type == 17) {
			dotdata = "1111111111100000100111000100000000000000100000001110000011111111";
		}
		if (this.attack_type == 18) {
			dotdata = "1111111111000100100110110100000100000001100000111100010011111111";
		}
		if (this.attack_type == 19) {
			dotdata = "1111111111000010101011000100111000001110100011001100001011111111";
		}
		if (this.attack_type == 20) {
			dotdata = "1111111111000000101000100100001000000010100000101100000011111111";
		}
		if (this.attack_type == 21) {
			dotdata = "1111111010010000010011100000111010011001111101001111000011111001";
		}
		if (this.attack_type == 22) {
			dotdata = "1100000110000000101101101000000010001000110000011101010111111111";
		}
		if (this.attack_type == 23) {
			dotdata = "0000001101111001010000010011110010100000100110101011011011100000";
		}
		if (this.attack_type == 24) {
			dotdata = "1110000010000000000000000001111000111110010000000011111101111111";
		}
		if (this.attack_type == 25) {
			dotdata = "1111111110011111000000110001100000000100010000000000001110011111";
		}
		if (this.attack_type == 26) {
			dotdata = "1111000011000101101111010110010101000101010001011010101111000111";
		}
		if (this.attack_type == 27) {
			dotdata = "1111111110011111000001110000000100000000000000010000011110011111";
		}
		if (this.attack_type == 28) {
			dotdata = "1111011011100100100100100011111001111100011111010011100110000011";
		}
		if (this.attack_type == 29) {
			dotdata = "0000001110011001110011010000011010000110110011011001100100000011";
		}
		if (this.attack_type == 30) {
			dotdata = "1000001001011100101110101100011110000010010111001011101011000111";
		}
		if (this.attack_type == 31) {
			dotdata = "1001001101100101001011011001001101101001010011011001001111111111";
		}
		if (this.attack_type == 32) {
			dotdata = "1001001101101101010001011001001101000101011011011001001111111111";
		}
		if (this.attack_type == 33) {
			dotdata = "0011110001011010101001011101001111000011101001010101101000111100";
		}
		if (this.attack_type == 34) {
			dotdata = "1101011110000011000000011001001100000001100000111101011111111111";
		}
		if (this.attack_type == 35) {
			dotdata = "1100001110000101001100100011010000000110010110101010110111000011";
		}
		if (this.attack_type == 36) {
			dotdata = "0010011101011011101110110111011101101011100101011111101011111100";
		}
		if (this.attack_type == 37) {
			dotdata = "1111111111111000110001100011110111000110111110001111111111111111";
		}
		if (this.attack_type == 38) {
			dotdata = "1111111111111100110000100011111011000010111111001111111111111111";
		}
		if (this.attack_type == 39) {
			dotdata = "1000011111010011111010011110100111101001111010011101001110000111";
		}
		if (this.attack_type == 40) {
			dotdata = "1000000111011000111011001111011011110010111011001101100010000001";
		}
		if (this.attack_type == 41) {
			dotdata = "0000001110100001110100001110100011110100111010101101000010000001";
		}
		if (this.attack_type == 42) {
			dotdata = "1001001101000001010000010000000110000011110001111110111111111111";
		}
		if (this.attack_type == 43) {
			dotdata = "1111111110010011000010010001000100001001100100111101011111101111";
		}
		if (this.attack_type == 44) {
			dotdata = "1001111101011111001011111101011111101011111101001111101011111001";
		}
		if (this.attack_type == 45) {
			dotdata = "1000111101011111010111110100111101000111101000001101000011100000";
		}
		if (this.attack_type == 46) {
			dotdata = "1111111111000001101111100111111000000110011110101111110011111111";
		}
		if (this.attack_type == 47) {
			dotdata = "1111111100111111010011111011000011011110111001101111100011111111";
		}
		if (this.attack_type == 48) {
			dotdata = "1111111111111100011110100000011001111110101111101100000111111111";
		}
		if (this.attack_type == 49) {
			dotdata = "1111111111111100000000101011111011001110111100001111111111111111";
		}
		if (this.attack_type == 50) {
			dotdata = "1110001110011101011011100011101001110010010111011011101111000111";
		}
		if (this.attack_type == 51) {
			dotdata = "1100000010000000001111000100000000111110011111101111111011111110";
		}
		if (this.attack_type == 52) {
			dotdata = "1100011100101011110111011101111011011110110111101110110111010010";
		}
		if (this.attack_type == 53) {
			dotdata = "1101111011110111011000111100100111100011101101100101111110111011";
		}
		if (this.attack_type == 54) {
			dotdata = "0001111111000010101000000001100100011001101000001100001000011111";
		}
		if (this.attack_type == 55) {
			dotdata = "1100001110100101101111101101100010101000011101100110100100011111";
		}
		if (this.attack_type == 56) {
			dotdata = "1111101011010001100010100000011110001010110100011111101011111111";
		}
		if (this.attack_type == 57) {
			dotdata = "1111111111111111110001111011001110100001110001111111111111111111";
		}
		if (this.attack_type == 58) {
			dotdata = "1100000010011000001100000000000000001000101111001100000011111111";
		}
		if (this.attack_type == 59) {
			dotdata = "1100010110011011001101111001101111000101100110110011011110011011";
		}
		if (this.attack_type == 60) {
			dotdata = "1111111111111001110010011100111111111001100100001001000011111001";
		}
		if (this.attack_type == 61) {
			dotdata = "1111110011000111101110110111110101111101101110111100011111111100";
		}
		if (this.attack_type == 62) {
			dotdata = "1011111101011011010101010101010101010101010101010101101110111111";
		}
		if (this.attack_type == 63) {
			dotdata = "1111011111110001111100001111011010000110010001010000011110001111";
		}
		if (this.attack_type == 64) {
			dotdata = "1111000011000000110001101101111011011110110110000001100000011111";
		}
		if (this.attack_type == 65) {
			dotdata = "1100001110011001001001000101001001000010001001001001100111000011";
		}
		if (this.attack_type == 66) {
			dotdata = "1111111111100111100100010110101001001000010000001000000111111111";
		}
		if (this.attack_type == 67) {
			dotdata = "1111111110000111000000110000000000111010010000101000000011111111";
		}
		if (this.attack_type == 68) {
			dotdata = "1100000110111100010110100100011001110010011001001001110111000011";
		}
		if (this.attack_type == 69) {
			dotdata = "1100100110110110100010001111011110010111010001110000111110011111";
		}
		if (this.attack_type == 70) {
			dotdata = "1100000010011001001100110110000100110011100110011100000011111111";
		}
		if (this.attack_type == 71) {
			dotdata = "0111111100101111001001010010010000100100001001010010111101111111";
		}
		if (this.attack_type == 72) {
			dotdata = "1111100100001001001101011101110110111011101011001001000010011111";
		}
		if (this.attack_type == 73) {
			dotdata = "1111000111101011110101111011011110100111101001111010001111000001";
		}
		if (this.attack_type == 74) {
			dotdata = "1100000010100111010011110100111101001111010011111010011111000000";
		}
		if (this.attack_type == 75) {
			dotdata = "1110000111010011101001111010011110100111101001111101001111100001";
		}
		if (this.attack_type == 76) {
			dotdata = "1100011110111001101111100111111001111110011111011001101111100001";
		}
		if (this.attack_type == 77) {
			dotdata = "1100011110111011011011010101110101011101011000111011110111000000";
		}
		if (this.attack_type == 78) {
			dotdata = "1111101011010001100010100010011110001010110100011111101011111111";
		}
		if (this.attack_type == 79) {
			dotdata = "1000111100000111000001110000011110000111111000111111110111111111";
		}
		if (this.attack_type == 80) {
			dotdata = "1100000110000000000000000000000000010001000111110000111110000010";
		}
		if (this.attack_type == 81) {
			dotdata = "1100001110000001000000000000000000000000000000011000011111000010";
		}
		if (this.attack_type == 82) {
			dotdata = "1111101111111101000000010111110010000001111111011111101111111111";
		}
		if (this.attack_type == 83) {
			dotdata = "1111111111111011000000001011100011000011111110111111111111111111";
		}
		if (this.attack_type == 84) {
			dotdata = "1100001110100001000000000000000001000000010000001010000111000011";
		}
		if (this.attack_type == 85) {
			dotdata = "1111000011100011110001111000000111100011110001111000111100011111";
		}
		if (this.attack_type == 86) {
			dotdata = "1111111011101100110010001000000100000011001001110110111111111111";
		}
		if (this.attack_type == 87) {
			dotdata = "1110000111100001100001111000011110011111000111110111111111111111";
		}
		if (this.attack_type == 88) {
			dotdata = "1111100011110001111000111100000111100011110001111000111100011111";
		}
		if (this.attack_type == 89) {
			dotdata = "1100011111001111110101111111101111111101111110111110011111100111";
		}
		if (this.attack_type == 90) {
			dotdata = "1110000110000111111111110000011111100001111111111000011111100001";
		}
		if (this.attack_type == 91) {
			dotdata = "1111111111000011001110111100001111111111111100001100111011110000";
		}
		if (this.attack_type == 92) {
			dotdata = "1111111111111011100000100000110010000010111110111111111111111111";
		}
		if (this.attack_type == 93) {
			dotdata = "1111111110111111110111011011011011100101110100111010000110000001";
		}
		if (this.attack_type == 94) {
			dotdata = "1110000111010011101001110100111101001111101001111101001111100001";
		}
		if (this.attack_type == 95) {
			dotdata = "0011001110011001110011001110011011100110110011001001100100110011";
		}
		if (this.attack_type == 96) {
			dotdata = "1011010100100100110110110010010110100100110110110010010010101101";
		}
		if (this.attack_type == 97) {
			dotdata = "1100110010011001001100110110011101100111001100111001100111001100";
		}
		if (this.attack_type == 98) {
			dotdata = "1111000011101110110101011010110110011011101101110000111111111111";
		}
		if (this.attack_type == 99) {
			dotdata = "1110000000100011100011110001011100101111001111110111111101111111";
		}
		if (this.attack_type == 100) {
			dotdata = "1111111100011111110011110000000011001111000111111111111111111111";
		}
		return dotdata;
	}

	public void generateDrawPart(int status, int count) {
		////System.out.println(count+":count"+this.is_living+"is_living"+this.toString());
		if (this.is_living == false) {
			////System.out.println(this.is_living+"is_living == false??");
			this.dot_positions.clear();
			this.sub_dot_positions.clear();
			String dotdata = "11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000001111111111111111111111111111111110111111011111111111111111111111111111110110000110111111111111111111111111111111011111111011111111111111111111111111111101100001101111111111111111111111111111110111111110111111111111111111111111111111011111111011111111111111111111111111111101111111101111111111111111111111111111110111111110111111111111111111111111111111011111111011111111111111111111111111111000000000000111111111111111111111111111101111111111011111111111111111111111111110000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
			for (int y = 0; y < 20; y++) {
				for (int x = 0; x < 40; x++) {
					if (dotdata.charAt(y * 40 + x) == '0') {
						float xf = (float) x;
						float yf = (float) y;
						sub_dot_positions.add(new PointF(xf
								* SUB_DOT_SIDE_LENGTH_FINAL_VALUE, yf
								* SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
					}
				}
			}
		} else if (this.is_egg == true) {
			this.dot_positions.clear();
			this.sub_dot_positions.clear();
			String dotdata = "11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100001111111111111111111111111111111111101111011111111111111111111111111111111100011110111111111111111111111111111111101100111101111111111111111111111111111110111111100111111111111111111111111111110111111000001111111111111111111111111111011110000110111111111111111111111111111101111111111011111111111111111111111111110001111111101111111111111111111111111111000011111110111111111111111111111111111110111100010111111111111111111111111111111101111100111111111111111111111111111111111000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
			for (int y = 0; y < 20; y++) {
				for (int x = 0; x < 40; x++) {
					if (dotdata.charAt(y * 40 + x) == '0') {
						sub_dot_positions.add(new PointF(x
								* SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y
								* SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
					}
				}
			}
		} else if (count != 0) {
			if (status == 10000) {
				if (this.is_light_on == false && this.is_sleeping == true) {
					if ((count % 40) == 1) {
						this.dot_positions.clear();
						this.sub_dot_positions.clear();
						String dotdata = "00000000000000000000000000000000000000000000000000000000000000111111100000000000000000000000000000000000000010000000000000000000000000000000000000010000000000000000000000000000000000000010000000000000000000000000000000000000010000000000000000000000000000000000000010000000000000000000000000000000000000010000000000000000000000000000000000000010000000000000000000000000000000000000001111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
						for (int y = 0; y < 20; y++) {
							for (int x = 0; x < 40; x++) {
								if (dotdata.charAt(y * 40 + x) == '0') {
									sub_dot_positions
											.add(new PointF(
													x
															* SUB_DOT_SIDE_LENGTH_FINAL_VALUE,
													y
															* SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
								}
							}
						}
					} else if ((count + 20) % 40 == 1) {
						this.dot_positions.clear();
						this.sub_dot_positions.clear();
						String dotdata = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000000000000000000000000010000000000000000000000000000000000000010000000000000000000000000000000000000010000000000000000000000000000000000000010000000000000000000000000000000000000010000000000000000000000000000000000000001111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
						for (int y = 0; y < 20; y++) {
							for (int x = 0; x < 40; x++) {
								if (dotdata.charAt(y * 40 + x) == '0') {
									sub_dot_positions
											.add(new PointF(
													x
															* SUB_DOT_SIDE_LENGTH_FINAL_VALUE,
													y
															* SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
								}
							}
						}
					}
				} else if (this.is_light_on == false) {
					if (count == 1) {
						this.dot_positions.clear();
						this.sub_dot_positions.clear();
						for (int y = 0; y < 20; y++) {
							for (int x = 0; x < 40; x++) {
								sub_dot_positions.add(new PointF(x
										* SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y
										* SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
							}
						}
					}
				} else if (this.is_sleeping == true) {
					if (count % 40 == 1) {
						this.dot_positions.clear();
						this.sub_dot_positions.clear();
						String dotdata = "00000000000000000000000000000000000000000000000000000000000000111111100000000000000000000000000000000000000010000000000000000000000000000000000000010000000000000000000000000000000000000010000000000000000000000000000000000000010000000000000000000000000000000000000010000000000000000000000000000000000000010000000000000000000000000000000000000010000000000000000000000000000000000000001111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
						for (int y = 0; y < 20; y++) {
							for (int x = 0; x < 40; x++) {
								if (dotdata.charAt(y * 40 + x) == '1') {
									sub_dot_positions
											.add(new PointF(
													x
															* SUB_DOT_SIDE_LENGTH_FINAL_VALUE,
													y
															* SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
								}
							}
						}
						for (int y = 0; y < 68; y += 2) {
							for (int x = 0; x < 52; x += 2) {
								if (this.dot_pattern.get(y * 52 + x) == true) {
									dot_positions
											.add(new PointF(
													x
															* DOT_SIDE_LENGTH_FINAL_VALUE,
													(68.0f * 0.3f + y * 0.7f)
															* DOT_SIDE_LENGTH_FINAL_VALUE));
								}
							}
						}
					}
					if ((count + 20) % 40 == 1) {
						this.dot_positions.clear();
						this.sub_dot_positions.clear();
						String dotdata = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111100000000000000000000000000000000000000010000000000000000000000000000000000000010000000000000000000000000000000000000010000000000000000000000000000000000000010000000000000000000000000000000000000010000000000000000000000000000000000000001111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
						for (int y = 0; y < 20; y++) {
							for (int x = 0; x < 40; x++) {
								if (dotdata.charAt(y * 40 + x) == '1') {
									sub_dot_positions
											.add(new PointF(
													x
															* SUB_DOT_SIDE_LENGTH_FINAL_VALUE,
													y
															* SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
								}
							}
						}
						for (int y = 0; y < 68; y += 2) {
							for (int x = 0; x < 52; x += 2) {
								if (this.dot_pattern.get(y * 52 + x) == true) {
									dot_positions
											.add(new PointF(
													x
															* DOT_SIDE_LENGTH_FINAL_VALUE,
													(68.0f * 0.3f + y * 0.7f)
															* DOT_SIDE_LENGTH_FINAL_VALUE));
								}
							}
						}
					}
				} else if (this.is_sick == true) {
					if (count == 1) {
						this.dot_positions.clear();
						this.sub_dot_positions.clear();
						String dotdata = "1011110110000000000000000100100001001100001000001000001110100101";
						for (int y = 0; y < 8; y++) {
							for (int x = 0; x < 8; x++) {
								if (dotdata.charAt(8 * y + x) == '0') {
									sub_dot_positions
											.add(new PointF(
													x
															* SUB_DOT_SIDE_LENGTH_FINAL_VALUE,
													y
															* SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
								}
							}
						}
						for (int y = 0; y < 68; y += 2) {
							for (int x = 0; x < 52; x += 2) {
								if (this.dot_pattern.get(y * 52 + x) == true) {
									dot_positions
											.add(new PointF(
													x
															* DOT_SIDE_LENGTH_FINAL_VALUE,
													(68.0f * 0.3f + y * 0.7f)
															* DOT_SIDE_LENGTH_FINAL_VALUE));
								}
							}
						}
					}
				} else if (this.is_injured == true) {
					if (count == 1) {
						this.dot_positions.clear();
						this.sub_dot_positions.clear();
						String dotdata = "110000011101111101011111110010101010011111110101111101110100011111011111111111111";
						for (int y = 0; y < 9; y++) {
							for (int x = 0; x < 9; x++) {
								if (dotdata.charAt(9 * y + x) == '0') {
									sub_dot_positions
											.add(new PointF(
													x
															* SUB_DOT_SIDE_LENGTH_FINAL_VALUE,
													y
															* SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
								}
							}
						}
						for (int y = 0; y < 68; y += 2) {
							for (int x = 0; x < 52; x += 2) {
								if (this.dot_pattern.get(y * 52 + x) == true) {
									dot_positions
											.add(new PointF(
													x
															* DOT_SIDE_LENGTH_FINAL_VALUE,
													(68.0f * 0.3f + y * 0.7f)
															* DOT_SIDE_LENGTH_FINAL_VALUE));
								}
							}
						}
					}
				} else {
					if (count == 1) {
						this.random_values.clear();
						this.dot_positions.clear();
						this.sub_dot_positions.clear();
						for (int y = 0; y < 68; y += 2) {
							for (int x = 0; x < 52; x += 2) {
								if (this.dot_pattern.get(y * 52 + x) == true) {
									float angle = (float) (Math.random() * 720);
									angle -= 360.0f;
									float radius = (float) (Math.random() * 200);
									radius -= 100;
									this.random_values.add(new PointF(radius,
											angle));
									this.dot_positions
											.add(new PointF(
													(float) (radius
															* DOT_SIDE_LENGTH_FINAL_VALUE * Math
															.cos(angle
																	/ 180.0f
																	* 3.14f
																	+ x
																	* DOT_SIDE_LENGTH_FINAL_VALUE)),
													(float) (radius
															* DOT_SIDE_LENGTH_FINAL_VALUE
															* Math.sin(angle / 180.0f * 3.14f) + y
															* DOT_SIDE_LENGTH_FINAL_VALUE)));
								}
							}
						}
						for (int i = 0; i < this.number_of_unko; i++) {
							int x0 = 0, y0 = 0;
							switch (i) {
							case 0:
								x0 = 31;
								y0 = 11;
								break;
							case 1:
								x0 = 31;
								y0 = 1;
								break;
							case 2:
								x0 = 21;
								y0 = 11;
								break;
							case 3:
								x0 = 21;
								y0 = 1;
								break;
							case 4:
								x0 = 11;
								y0 = 11;
								break;
							case 5:
								x0 = 11;
								y0 = 1;
								break;
							case 6:
								x0 = 1;
								y0 = 11;
								break;
							case 7:
								x0 = 1;
								y0 = 1;
								break;
							default:
								break;
							}
							String dotdata = "0111111110111101011101101110010111000011101000010100000000000000";
							for (int y = 0; y < 8; y++) {
								for (int x = 0; x < 8; x++) {
									if (dotdata.charAt(8 * y + x) == '0') {
										this.sub_dot_positions
												.add(new PointF(
														(x + x0)
																* SUB_DOT_SIDE_LENGTH_FINAL_VALUE,
														(y + y0)
																* SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
									}
								}
							}
						}
					} else if (count <= 20) {
						this.dot_positions.clear();
						int index = 0;
						for (int y = 0; y < 68; y += 2) {
							for (int x = 0; x < 52; x += 2) {
								if (random_values.size() == index) {	
												float angle = (float) (Math
														.random() * 720);
												angle -= 360.0f;
												float radius = (float) (Math
														.random() * 200);
												radius -= 100;
												this.random_values
														.add(new PointF(radius,
																angle));
								}
								if (this.dot_pattern.get(y * 52 + x) == true) {
									PointF rpoint = this.random_values
											.get(index);
									float fx = (float) ((1.0 - count / 20.0)
											* rpoint.x
											* DOT_SIDE_LENGTH_FINAL_VALUE
											* Math.cos((1.0 - count / 20.0)
													* rpoint.y / 180.0 * 3.14) + x
											* DOT_SIDE_LENGTH_FINAL_VALUE);
									float fy = (float) ((1.0 - count / 20.0)
											* rpoint.x
											* DOT_SIDE_LENGTH_FINAL_VALUE
											* Math.sin((1.0 - count / 20.0)
													* rpoint.y / 180.0 * 3.14) + y
											* DOT_SIDE_LENGTH_FINAL_VALUE);
									this.dot_positions.add(new PointF(fx, fy));
									index++;
								}
							}
						}
					} else if (count < 235) {
						if ((count - 25) % 20 == 0) {
							this.dot_positions.clear();
							int num = (count - 25) / 20;
							int m = 0;
							switch (num) {
							case 0:
								m = 0;
								break;
							case 1:
								m = -1;
								break;
							case 2:
								m = -2;
								break;
							case 3:
								m = -2;
								break;
							case 4:
								m = -1;
								break;
							case 5:
								m = 0;
								break;
							case 6:
								m = 1;
								break;
							case 7:
								m = 2;
								break;
							case 8:
								m = 2;
								break;
							case 9:
								m = 1;
								break;
							case 10:
								m = 0;
								break;
							default:
								break;
							}
							for (int y = 0; y < 68; y += 2) {
								for (int x = 0; x < 52; x += 2) {
									if (this.dot_pattern.get(y * 52 + x) == true) {
										float fx = 0;
										float fy = 0;
										if (num == 0 || num == 1 || num == 2
												|| num == 8 || num == 9
												|| num == 10) {
											fx = (x + 26.0f * m)
													* DOT_SIDE_LENGTH_FINAL_VALUE;
										} else {
											fx = ((51 - x) + 26.0f * m)
													* DOT_SIDE_LENGTH_FINAL_VALUE;
										}
										if (num % 2 == 0) {
											fy = y
													* DOT_SIDE_LENGTH_FINAL_VALUE;
										} else {
											fy = (68.0f * 0.2f + y * 0.8f)
													* DOT_SIDE_LENGTH_FINAL_VALUE;
										}
										this.dot_positions.add(new PointF(fx,
												fy));
									}
								}
							}
						}
					} else if (count > 230) {
						this.dot_positions.clear();
						int index = 0;
						for (int y = 0; y < 68; y += 2) {
							for (int x = 0; x < 52; x += 2) {
								if (dot_pattern.get(y * 52 + x)) {
									if(random_values.size() == index){
										float angle = (float) (Math
												.random() * 720);
										angle -= 360.0f;
										float radius = (float) (Math
												.random() * 200);
										radius -= 100;
										this.random_values
												.add(new PointF(radius,
														angle));
									}
									PointF rpoint = this.random_values
											.get(index);
									if (random_values.size() == 0) {
										for (int y0 = 0; y0 < 68; y0 += 2) {
											for (int x0 = 0; x0 < 52; x0 += 2) {
												if (this.dot_pattern.get(y0
														* 52 + x0) == true) {
													float angle = (float) (Math
															.random() * 720);
													angle -= 360.0f;
													float radius = (float) (Math
															.random() * 200);
													radius -= 100;
													this.random_values
															.add(new PointF(
																	radius,
																	angle));
												}
											}
										}
									}
									float fx = (float) (((count - 230) / 20.0)
											* rpoint.x
											* DOT_SIDE_LENGTH_FINAL_VALUE
											* Math.cos(((count - 230) / 20.0)
													* rpoint.y / 180.0 * 3.14) + x
											* DOT_SIDE_LENGTH_FINAL_VALUE);
									float fy = (float) (((count - 230) / 20.0)
											* rpoint.x
											* DOT_SIDE_LENGTH_FINAL_VALUE
											* Math.sin(((count - 230) / 20.0)
													* rpoint.y / 180.0 * 3.14) + y
											* DOT_SIDE_LENGTH_FINAL_VALUE);
									this.dot_positions.add(new PointF(fx, fy));
									index++;
								}
							}
						}
					}
				}
			} else if (status == 10101) {
				if (count == 1) {
					this.dot_positions.clear();
					this.sub_dot_positions.clear();
					String dotdata = "10001111111111111111111111111111111111111011011111111111111111111111111111111111101101111111111111111111111110110101001110110111111111111111111111111011010011111011011111111111111111111111101101011111100010111011111111111111111110110101111111111001001111111111111111111101010111111111101010111111111111111111111001111111111110111011111111111111111110001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111101111111011111111111111111111111111111110000000001111111111111111111111100011111111101111111111111111111111111101110111110000000111111111111111111111110111111111011111011111111111111111111111011111111101101101111111111111111111111101000111110100010111111111111111111111110111011110000000001111111111111111111111100011111111111111111111111111111111111111111111";
					for (int y = 0; y < 20; y++) {
						for (int x = 0; x < 40; x++) {
							if (dotdata.charAt(y * 40 + x) == '0') {
								this.sub_dot_positions.add(new PointF(x
										* SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y
										* SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
							}
						}
					}
					String dotnumber = null;
					if (this.dm <= 99) {
						switch ((int) (this.dm / 10)) {
						case 0:
							dotnumber = "1001011001100110011001101001";
							break;
						case 1:
							dotnumber = "1001110111011101110111011101";
							break;
						case 2:
							dotnumber = "1001011011101101101101110000";
							break;
						case 3:
							dotnumber = "1001011011101101111001101001";
							break;
						case 4:
							dotnumber = "0101010101010000110111011101";
							break;
						case 5:
							dotnumber = "0000011101110001111011100001";
							break;
						case 6:
							dotnumber = "1001011101110001011001101001";
							break;
						case 7:
							dotnumber = "0000111011011011101110111011";
							break;
						case 8:
							dotnumber = "1001011001101001011001101001";
							break;
						case 9:
							dotnumber = "1001011001101000111011101001";
							break;
						default:
							break;
						}
					} else {
						dotnumber = "1001011001101000111011101001";
					}
					for (int y = 0; y < 7; y++) {
						for (int x = 0; x < 4; x++) {
							if (dotnumber.charAt(y * 4 + x) == '0') {
								float fx = (18 + x)
										* SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
								float fy = (1 + y)
										* SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
								this.sub_dot_positions.add(new PointF(fx, fy));
							}
						}
					}

					if (this.dm <= 99) {
						switch ((int) (this.dm % 10)) {
						case 0:
							dotnumber = "1001011001100110011001101001";
							break;
						case 1:
							dotnumber = "1001110111011101110111011101";
							break;
						case 2:
							dotnumber = "1001011011101101101101110000";
							break;
						case 3:
							dotnumber = "1001011011101101111001101001";
							break;
						case 4:
							dotnumber = "0101010101010000110111011101";
							break;
						case 5:
							dotnumber = "0000011101110001111011100001";
							break;
						case 6:
							dotnumber = "1001011101110001011001101001";
							break;
						case 7:
							dotnumber = "0000111011011011101110111011";
							break;
						case 8:
							dotnumber = "1001011001101001011001101001";
							break;
						case 9:
							dotnumber = "1001011001101000111011101001";
							break;
						default:
							break;
						}
					} else {
						dotnumber = "1001011001101000111011101001";
					}
					for (int y = 0; y < 7; y++) {
						for (int x = 0; x < 4; x++) {
							if (dotnumber.charAt(y * 4 + x) == '0') {
								float fx = (23 + x)
										* SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
								float fy = (1 + y)
										* SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
								this.sub_dot_positions.add(new PointF(fx, fy));
							}
						}
					}
					if (this.weight <= 99) {
						switch ((int) (this.weight / 10)) {
						case 0:
							dotnumber = "1001011001100110011001101001";
							break;
						case 1:
							dotnumber = "1001110111011101110111011101";
							break;
						case 2:
							dotnumber = "1001011011101101101101110000";
							break;
						case 3:
							dotnumber = "1001011011101101111001101001";
							break;
						case 4:
							dotnumber = "0101010101010000110111011101";
							break;
						case 5:
							dotnumber = "0000011101110001111011100001";
							break;
						case 6:
							dotnumber = "1001011101110001011001101001";
							break;
						case 7:
							dotnumber = "0000111011011011101110111011";
							break;
						case 8:
							dotnumber = "1001011001101001011001101001";
							break;
						case 9:
							dotnumber = "1001011001101000111011101001";
							break;
						default:
							break;
						}
					} else {
						dotnumber = "1001011001101000111011101001";
					}
					for (int y = 0; y < 7; y++) {
						for (int x = 0; x < 4; x++) {
							if (dotnumber.charAt(y * 4 + x) == '0') {
								float fx = (18 + x)
										* SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
								float fy = (12 + y)
										* SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
								this.sub_dot_positions.add(new PointF(fx, fy));
							}
						}
					}
					if (this.weight <= 99) {
						switch ((int) (this.weight % 10)) {
						case 0:
							dotnumber = "1001011001100110011001101001";
							break;
						case 1:
							dotnumber = "1001110111011101110111011101";
							break;
						case 2:
							dotnumber = "1001011011101101101101110000";
							break;
						case 3:
							dotnumber = "1001011011101101111001101001";
							break;
						case 4:
							dotnumber = "0101010101010000110111011101";
							break;
						case 5:
							dotnumber = "0000011101110001111011100001";
							break;
						case 6:
							dotnumber = "1001011101110001011001101001";
							break;
						case 7:
							dotnumber = "0000111011011011101110111011";
							break;
						case 8:
							dotnumber = "1001011001101001011001101001";
							break;
						case 9:
							dotnumber = "1001011001101000111011101001";
							break;
						default:
							break;
						}
					} else {
						dotnumber = "1001011001101000111011101001";
					}
					for (int y = 0; y < 7; y++) {
						for (int x = 0; x < 4; x++) {
							if (dotnumber.charAt(y * 4 + x) == '0') {
								float fx = (23 + x)
										* SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
								float fy = (12 + y)
										* SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
								this.sub_dot_positions.add(new PointF(fx, fy));
							}
						}
					}
				}
			} else if (status == 10102) {
				if (count == 1) {
					this.sub_dot_positions.clear();
					String dotdata = "10110111111111111111111111111111111111111011011111111111111111111111111111111111101101010100010001010101011111111111111110000101010101010100110101111111111111111011010101010101010111010111111111111111101101010101010001011110011111111111111110110100010101110101111101111111111111111111111111111100011111001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100100111100100111100100111100100111111101101101101101101101101101101101101111110111110110111110110111110110111110111111011111011011111011011111011011111011111110111011110111011110111011110111011111111101011111101011111101011111101011111111111011111111011111111011111111011111111111111111111111111111111111111111111111";
					for (int y = 0; y < 20; y++) {
						for (int x = 0; x < 40; x++) {
							if (dotdata.charAt(y * 40 + x) == '0') {
								this.sub_dot_positions.add(new PointF(x
										* SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y
										* SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
							}
						}
					}
					int hung = this.hungry;
					if (hung > 8) {
						hung = 8;
					}
					for (int i = hung; i > 0; i--) {
						String dotheart;
						if (i % 2 == 0) {
							dotheart = "1111001111100011110001111000111100111110111111111";
						} else {
							dotheart = "1001111010011101001110000111100011111001111110111";
						}
						for (int y = 0; y < 7; y++) {
							for (int x = 0; x < 7; x++) {
								if (dotheart.charAt(y * 7 + x) == '0') {
									float fx = x
											* SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
									float fy = (12 + y)
											* SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
									if (i == 8 || i == 7) {
										fx += 29 * SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
									} else if (i == 6 || i == 5) {
										fx += 20 * SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
									} else if (i == 3 || i == 4) {
										fx += 11 * SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
									} else if (i == 1 || i == 2) {
										fx += 2 * SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
									}
									this.sub_dot_positions.add(new PointF(fx,
											fy));
								}
							}
						}
					}
				}
			} else if (status == 10103) {
				if (count == 1) {
					this.sub_dot_positions.clear();
					String dotdata = "11001111111111111111111111111111111111111011011111111111111111111111110111111111101111101101010001000100011011011111111111001100010011010101010101000100011111111111011011011100010101010110110101111111101101101101110111010100011011010111111111001110010111000101011101100101011111111111111111111111111111000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100100111100100111100100111100100111111101101101101101101101101101101101101111110111110110111110110111110110111110111111011111011011111011011111011011111011111110111011110111011110111011110111011111111101011111101011111101011111101011111111111011111111011111111011111111011111111111111111111111111111111111111111111111";
					for (int y = 0; y < 20; y++) {
						for (int x = 0; x < 40; x++) {
							if (dotdata.charAt(y * 40 + x) == '0') {
								this.sub_dot_positions.add(new PointF(x
										* SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y
										* SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
							}
						}
					}
					int hung = this.strength;
					if (hung > 8) {
						hung = 8;
					}
					for (int i = hung; i > 0; i--) {
						String dotheart;
						if (i % 2 == 0) {
							dotheart = "1111001111100011110001111000111100111110111111111";
						} else {
							dotheart = "1001111010011101001110000111100011111001111110111";
						}
						for (int y = 0; y < 7; y++) {
							for (int x = 0; x < 7; x++) {
								if (dotheart.charAt(y * 7 + x) == '0') {
									float fx = x
											* SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
									float fy = (12 + y)
											* SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
									if (i == 8 || i == 7) {
										fx += 29 * SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
									} else if (i == 6 || i == 5) {
										fx += 20 * SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
									} else if (i == 3 || i == 4) {
										fx += 11 * SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
									} else if (i == 1 || i == 2) {
										fx += 2 * SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
									}
									this.sub_dot_positions.add(new PointF(fx,
											fy));
								}
							}
						}
					}
				}
			}
			else if(status == 10104){
                if(count == 1){
                    this.sub_dot_positions.clear();
                    String dotdata = "11111111111111111111111111111111111111111111000110001111111111111111111111111111111101101011011111111111111111111111111111110110101101111111111111111111111111111111011010001111111111111101111111111111111101101011111111111111101111111111111111110110101111111111111101111111111111111111000110111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111011111111111111011111111111111011111111110000000000000000000000000000011111111110111111111111111111111111111110111111111011111111111111111111111111111011111111101111111111111111111111111111101111111110111111111111111111111111111110111111111100000000000000000000000000000111111111111111111111111111111111111111111111";
                    
                    for(int y = 0;y<20;y++){
                        for(int x = 0;x<40;x++){
                            if(dotdata.charAt(40*y+x) == '0'){
                                this.sub_dot_positions.add(new PointF(x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                    String dotnumber = null;
                    if(this.dp <= 99){
                        switch ((int)(this.dp/10)) {
                            case 0:
                                dotnumber = "000010010010000";
                                break;
                            case 1:
                                dotnumber = "001101101101000";
                                break;
                            case 2:
                                dotnumber = "000110101011000";
                                break;
                            case 3:
                                dotnumber = "000110000110000";
                                break;
                            case 4:
                                dotnumber = "010010000110110";
                                break;
                            case 5:
                                dotnumber = "000011000110000";
                                break;
                            case 6:
                                dotnumber = "000011000010000";
                                break;
                            case 7:
                                dotnumber = "000110101101101";
                                break;
                            case 8:
                                dotnumber = "000010000010000";
                                break;
                            case 9:
                                dotnumber = "000010000110110";
                                break;
                            default:
                                break;
                        }
                    }
                    else{
                        dotnumber = "000010000110110";
                    }
                    for(int y = 0;y<5;y++){
                        for(int x = 0;x<3;x++){
                            if(dotnumber.charAt(3*y+x) == '0'){
                                float fx = (16+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                float fy = (3+y)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                this.sub_dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                    
                    if(this.dp <= 99){
                        switch ((int)(this.dp%10)) {
                            case 0:
                                dotnumber = "000010010010000";
                                break;
                            case 1:
                                dotnumber = "001101101101000";
                                break;
                            case 2:
                                dotnumber = "000110101011000";
                                break;
                            case 3:
                                dotnumber = "000110000110000";
                                break;
                            case 4:
                                dotnumber = "010010000110110";
                                break;
                            case 5:
                                dotnumber = "000011000110000";
                                break;
                            case 6:
                                dotnumber = "000011000010000";
                                break;
                            case 7:
                                dotnumber = "000110101101101";
                                break;
                            case 8:
                                dotnumber = "000010000010000";
                                break;
                            case 9:
                                dotnumber = "000010000110110";
                                break;
                            default:
                                break;
                        }
                    }
                    else{
                        dotnumber = "000010000110110";
                    }
                    for(int y = 0;y<5;y++){
                        for(int x = 0;x<3;x++){
                            if(dotnumber.charAt(3*y+x) == '0'){
                                float fx = (20+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                float fy = (3+y)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                this.sub_dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                    if(this.max_dp <= 99){
                        switch ((int)(this.max_dp/10)) {
                            case 0:
                                dotnumber = "000010010010000";
                                break;
                            case 1:
                                dotnumber = "001101101101000";
                                break;
                            case 2:
                                dotnumber = "000110101011000";
                                break;
                            case 3:
                                dotnumber = "000110000110000";
                                break;
                            case 4:
                                dotnumber = "010010000110110";
                                break;
                            case 5:
                                dotnumber = "000011000110000";
                                break;
                            case 6:
                                dotnumber = "000011000010000";
                                break;
                            case 7:
                                dotnumber = "000110101101101";
                                break;
                            case 8:
                                dotnumber = "000010000010000";
                                break;
                            case 9:
                                dotnumber = "000010000110110";
                                break;
                            default:
                                break;
                        }
                    }
                    else{
                        dotnumber = "000010000110110";
                    }
                    for(int y = 0;y<5;y++){
                        for(int x = 0;x<3;x++){
                            if(dotnumber.charAt(3*y+x) == '0'){
                                float fx = (28+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                float fy = (3+y)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                this.sub_dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                    
                    if(this.max_dp <= 99){
                        switch ((int)(this.max_dp%10)) {
                            case 0:
                                dotnumber = "000010010010000";
                                break;
                            case 1:
                                dotnumber = "001101101101000";
                                break;
                            case 2:
                                dotnumber = "000110101011000";
                                break;
                            case 3:
                                dotnumber = "000110000110000";
                                break;
                            case 4:
                                dotnumber = "010010000110110";
                                break;
                            case 5:
                                dotnumber = "000011000110000";
                                break;
                            case 6:
                                dotnumber = "000011000010000";
                                break;
                            case 7:
                                dotnumber = "000110101101101";
                                break;
                            case 8:
                                dotnumber = "000010000010000";
                                break;
                            case 9:
                                dotnumber = "000010000110110";
                                break;
                            default:
                                break;
                        }
                    }
                    else{
                        dotnumber = "000010000110110";
                    }
                    for(int y = 0;y<5;y++){
                        for(int x = 0;x<3;x++){
                            if(dotnumber.charAt(3*y+x) == '0'){
                                float fx = (32+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                float fy = (3+y)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                this.sub_dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                    int dp_count = (int) (dp / (max_dp / 15.0));
                    for(int i = dp_count;i>0;i--){
                        float fx = (7+(i-1)*2)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                        float fy1 = 15*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                        float fy2 = 16*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                        this.sub_dot_positions.add(new PointF(fx, fy1));
                        this.sub_dot_positions.add(new PointF(fx, fy2));
                    }
                }
            }
			else if(status == 10105){
                if(count == 1){
                    this.sub_dot_positions.clear();
                    String dotdata = "[11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110111111111111111111111111111111111111110111111111111111111111111111111111111110111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111101111011111111111111111111111111111111101011011111111111111111111111111111111110101011111111111111111111111111111111111101010111111111111111111111111111111111111010101111111111111111111111111111111111011010111111111111111111111111111111111011110111111111111111111111111111111111111111111111";
                    
                    for(int y = 0;y<20;y++){
                        for(int x = 0;x<40;x++){
                            if(dotdata.charAt(y*40+x) == '0'){
                                this.sub_dot_positions.add(new PointF(x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                    String dotnumber = null;
                    if(this.win_count <= 999){
                        switch ((int)(this.win_count/100)) {
                            case 0:
                                dotnumber = "000010010010000";
                                break;
                            case 1:
                                dotnumber = "001101101101000";
                                break;
                            case 2:
                                dotnumber = "000110101011000";
                                break;
                            case 3:
                                dotnumber = "000110000110000";
                                break;
                            case 4:
                                dotnumber = "010010000110110";
                                break;
                            case 5:
                                dotnumber = "000011000110000";
                                break;
                            case 6:
                                dotnumber = "000011000010000";
                                break;
                            case 7:
                                dotnumber = "000110101101101";
                                break;
                            case 8:
                                dotnumber = "000010000010000";
                                break;
                            case 9:
                                dotnumber = "000010000110110";
                                break;
                            default:
                                break;
                        }
                    }
                    else{
                        dotnumber = "000010000110110";
                    }
                    for(int y = 0;y<5;y++){
                        for(int x = 0;x<3;x++){
                            if(dotnumber.charAt(y*3+x) == '0'){
                                float fx = (7+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                float fy = (3+y)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                this.sub_dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                    if(this.win_count <= 999){
                        switch ((this.win_count%100)/10) {
                            case 0:
                                dotnumber = "000010010010000";
                                break;
                            case 1:
                                dotnumber = "001101101101000";
                                break;
                            case 2:
                                dotnumber = "000110101011000";
                                break;
                            case 3:
                                dotnumber = "000110000110000";
                                break;
                            case 4:
                                dotnumber = "010010000110110";
                                break;
                            case 5:
                                dotnumber = "000011000110000";
                                break;
                            case 6:
                                dotnumber = "000011000010000";
                                break;
                            case 7:
                                dotnumber = "000110101101101";
                                break;
                            case 8:
                                dotnumber = "000010000010000";
                                break;
                            case 9:
                                dotnumber = "000010000110110";
                                break;
                            default:
                                break;
                        }
                    }
                    else{
                        dotnumber = "000010000110110";
                    }
                    for(int y = 0;y<5;y++){
                        for(int x = 0;x<3;x++){
                            if(dotnumber.charAt(y*3+x) == '0'){
                                float fx = (11+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                float fy = (3+y)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                this.sub_dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                    if(this.win_count <= 999){
                        switch (this.win_count%10) {
                            case 0:
                                dotnumber = "000010010010000";
                                break;
                            case 1:
                                dotnumber = "001101101101000";
                                break;
                            case 2:
                                dotnumber = "000110101011000";
                                break;
                            case 3:
                                dotnumber = "000110000110000";
                                break;
                            case 4:
                                dotnumber = "010010000110110";
                                break;
                            case 5:
                                dotnumber = "000011000110000";
                                break;
                            case 6:
                                dotnumber = "000011000010000";
                                break;
                            case 7:
                                dotnumber = "000110101101101";
                                break;
                            case 8:
                                dotnumber = "000010000010000";
                                break;
                            case 9:
                                dotnumber = "000010000110110";
                                break;
                            default:
                                break;
                        }
                    }
                    else{
                        dotnumber = "000010000110110";
                    }
                    for(int y = 0;y<5;y++){
                        for(int x = 0;x<3;x++){
                            if(dotnumber.charAt(y*3+x) == '0'){
                                float fx = (15+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                float fy = (3+y)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                this.sub_dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                    if(this.battle_count <= 999){
                        switch ((int)(this.battle_count/100)) {
                            case 0:
                                dotnumber = "000010010010000";
                                break;
                            case 1:
                                dotnumber = "001101101101000";
                                break;
                            case 2:
                                dotnumber = "000110101011000";
                                break;
                            case 3:
                                dotnumber = "000110000110000";
                                break;
                            case 4:
                                dotnumber = "010010000110110";
                                break;
                            case 5:
                                dotnumber = "000011000110000";
                                break;
                            case 6:
                                dotnumber = "000011000010000";
                                break;
                            case 7:
                                dotnumber = "000110101101101";
                                break;
                            case 8:
                                dotnumber = "000010000010000";
                                break;
                            case 9:
                                dotnumber = "000010000110110";
                                break;
                            default:
                                break;
                        }
                    }
                    else{
                        dotnumber = "000010000110110";
                    }
                    for(int y = 0;y<5;y++){
                        for(int x = 0;x<3;x++){
                            if(dotnumber.charAt(y*3+x) == '0'){
                                float fx = (24+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                float fy = (3+y)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                this.sub_dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                    if(this.battle_count <= 999){
                        switch ((int)(this.battle_count%100)/10) {
                            case 0:
                                dotnumber = "000010010010000";
                                break;
                            case 1:
                                dotnumber = "001101101101000";
                                break;
                            case 2:
                                dotnumber = "000110101011000";
                                break;
                            case 3:
                                dotnumber = "000110000110000";
                                break;
                            case 4:
                                dotnumber = "010010000110110";
                                break;
                            case 5:
                                dotnumber = "000011000110000";
                                break;
                            case 6:
                                dotnumber = "000011000010000";
                                break;
                            case 7:
                                dotnumber = "000110101101101";
                                break;
                            case 8:
                                dotnumber = "000010000010000";
                                break;
                            case 9:
                                dotnumber = "000010000110110";
                                break;
                            default:
                                break;
                        }
                    }
                    else{
                        dotnumber = "000010000110110";
                    }
                    for(int y = 0;y<5;y++){
                        for(int x = 0;x<3;x++){
                            if(dotnumber.charAt(y*3+x) == '0'){
                                float fx = (28+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                float fy = (3+y)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                this.sub_dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                    if(this.battle_count <= 999){
                        switch ((int)(this.battle_count%10)) {
                            case 0:
                                dotnumber = "000010010010000";
                                break;
                            case 1:
                                dotnumber = "001101101101000";
                                break;
                            case 2:
                                dotnumber = "000110101011000";
                                break;
                            case 3:
                                dotnumber = "000110000110000";
                                break;
                            case 4:
                                dotnumber = "010010000110110";
                                break;
                            case 5:
                                dotnumber = "000011000110000";
                                break;
                            case 6:
                                dotnumber = "000011000010000";
                                break;
                            case 7:
                                dotnumber = "000110101101101";
                                break;
                            case 8:
                                dotnumber = "000010000010000";
                                break;
                            case 9:
                                dotnumber = "000010000110110";
                                break;
                            default:
                                break;
                        }
                    }
                    else{
                        dotnumber = "000010000110110";
                    }
                    for(int y = 0;y<5;y++){
                        for(int x = 0;x<3;x++){
                            if(dotnumber.charAt(y*3+x) == '0'){
                                float fx = (32+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                float fy = (3+y)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                this.sub_dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                    int rate = 0;
                    if(battle_count != 0){
                        rate = (100*win_count)/battle_count;
                    }
                    if(rate <= 999){
                        switch ((int)(rate/100)) {
                            case 0:
                                dotnumber = "1001011001100110011001101001";
                                break;
                            case 1:
                                dotnumber = "1001110111011101110111011101";
                                break;
                            case 2:
                                dotnumber = "1001011011101101101101110000";
                                break;
                            case 3:
                                dotnumber = "1001011011101101111001101001";
                                break;
                            case 4:
                                dotnumber = "0101010101010000110111011101";
                                break;
                            case 5:
                                dotnumber = "0000011101110001111011100001";
                                break;
                            case 6:
                                dotnumber = "1001011101110001011001101001";
                                break;
                            case 7:
                                dotnumber = "0000111011011011101110111011";
                                break;
                            case 8:
                                dotnumber = "1001011001101001011001101001";
                                break;
                            case 9:
                                dotnumber = "1001011001101000111011101001";
                                break;
                            default:
                                break;
                        }
                    }
                    else{
                        dotnumber = "1001011001101000111011101001";
                    }
                    for(int y = 0;y<7;y++){
                        for(int x = 0;x<4;x++){
                            if(dotnumber.charAt(y*4+x) == '0'){
                                float fx = (9+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                float fy = (12+y)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                this.sub_dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                    if(rate <= 999){
                        switch ((int)(rate % 100)/10) {
                            case 0:
                                dotnumber = "1001011001100110011001101001";
                                break;
                            case 1:
                                dotnumber = "1001110111011101110111011101";
                                break;
                            case 2:
                                dotnumber = "1001011011101101101101110000";
                                break;
                            case 3:
                                dotnumber = "1001011011101101111001101001";
                                break;
                            case 4:
                                dotnumber = "0101010101010000110111011101";
                                break;
                            case 5:
                                dotnumber = "0000011101110001111011100001";
                                break;
                            case 6:
                                dotnumber = "1001011101110001011001101001";
                                break;
                            case 7:
                                dotnumber = "0000111011011011101110111011";
                                break;
                            case 8:
                                dotnumber = "1001011001101001011001101001";
                                break;
                            case 9:
                                dotnumber = "1001011001101000111011101001";
                                break;
                            default:
                                break;
                        }
                    }
                    else{
                        dotnumber = "1001011001101000111011101001";
                    }
                    for(int y = 0;y<7;y++){
                        for(int x = 0;x<4;x++){
                            if(dotnumber.charAt(y*4+x) == '0'){
                                float fx = (14+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                float fy = (12+y)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                this.sub_dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                    if(rate <= 999){
                        switch ((int)(rate % 10)) {
                            case 0:
                                dotnumber = "1001011001100110011001101001";
                                break;
                            case 1:
                                dotnumber = "1001110111011101110111011101";
                                break;
                            case 2:
                                dotnumber = "1001011011101101101101110000";
                                break;
                            case 3:
                                dotnumber = "1001011011101101111001101001";
                                break;
                            case 4:
                                dotnumber = "0101010101010000110111011101";
                                break;
                            case 5:
                                dotnumber = "0000011101110001111011100001";
                                break;
                            case 6:
                                dotnumber = "1001011101110001011001101001";
                                break;
                            case 7:
                                dotnumber = "0000111011011011101110111011";
                                break;
                            case 8:
                                dotnumber = "1001011001101001011001101001";
                                break;
                            case 9:
                                dotnumber = "1001011001101000111011101001";
                                break;
                            default:
                                break;
                        }
                    }
                    else{
                        dotnumber = "1001011001101000111011101001";
                    }
                    for(int y = 0;y<7;y++){
                        for(int x = 0;x<4;x++){
                            if(dotnumber.charAt(y*4+x) == '0'){
                                float fx = (19+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                float fy = (12+y)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                this.sub_dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                }
            }
			else if(status == 10106){
                if(count == 1){
                    this.sub_dot_positions.clear();
                    String dotdata = "11111111111111111111111111111111111111111111000101010001000111111111111111111111111110110101010101111111111111111111111111111011010101010111111111111111111111111111101101010001000111111111111111111111111110111011011101111111111111111111111111111011101101110111111111111111111111111111101110110111000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100111111111111111101111111111111111111110101111111111111110111111111111111111111010111111111111111011111111111111111111100111111111111111101111111111111111111110101111111111111110111111111111111111111010111111111111101011111111111111111111100111111111111111011111111111111111111111111111111111111111111111111111111";
                    
                    for(int y = 0;y<20;y++){
                        for(int x = 0;x<40;x++){
                            if(dotdata.charAt(y*40+x) == '0'){
                            	this.sub_dot_positions.add(new PointF(x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                    if(this.type == 0 || this.type == 2){
                        dotdata = "01110011100111001110011101010111011";
                    }
                    else{
                        dotdata = "00011011010111001110011100110100011";
                    }
                    for(int y = 0;y<7;y++){
                        for(int x = 0;x<5;x++){
                            if(dotdata.charAt(y*5+x) == '0'){
                                this.sub_dot_positions.add(new PointF((25+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, (1+y)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                    if(this.type == 0 || this.type == 1){
                        dotdata = "10010101010101010010";
                    }
                    else{
                        dotdata = "01000011011101110111";
                    }
                    for(int y = 0;y<5;y++){
                        for(int x = 0;x<4;x++){
                            if(dotdata.charAt(y*4+x) == '0'){
                                this.sub_dot_positions.add(new PointF((31+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, (3+y)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                    if(this.battle_enable){
                        dotdata = "1100011101110101111100111110011111010111011100011";
                    }
                    else{
                        dotdata = "0111110101110111010111110111110101110111010111110";
                    }
                    for(int y = 0;y<7;y++){
                        for(int x = 0;x<7;x++){
                            if(dotdata.charAt(y*7+x) == '0'){
                                this.sub_dot_positions.add(new PointF((12+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, (12+y)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                    if(this.jogress_enable){
                        dotdata = "1100011101110101111100111110011111010111011100011";
                    }
                    else{
                        dotdata = "0111110101110111010111110111110101110111010111110";
                    }
                    for(int y = 0;y<7;y++){
                        for(int x = 0;x<7;x++){
                            if(dotdata.charAt(y*7+x) == '0'){
                                this.sub_dot_positions.add(new PointF((27+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, (12+y)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                }
            }
			else if(status == 10201){
				this.dot_positions.clear();
                this.sub_dot_positions.clear();
                String dotdata = "11111111111111111001111111111111111111111111111111111100010111111111111111111111111111111111101000111111111111111111111111111111111101000011111111111111111111111111111111110000001111111111111111111111111111111111010001111111111111111111111111111111111010001111111111111111111111111111111111100111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100011111111111111111111111111111111111101100111111111111111111111111111111111101000011111111111111111111111111111111101000001111111111111111111111111111111101110001111111111111111111111111111111110111101111111111111111111111111111111111011101111111111111111111111111111111111110001111111111111111111111111";
                for(int y = 0;y<20;y++){
                    for(int x = 0;x<40;x++){
                        if(dotdata.charAt(y*40+x) == '0'){
                            this.sub_dot_positions.add(new PointF(x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                        }
                    }
                }
                String arrow_dot = "1110111111001100000010000000000000111100111110111";
                for(int y = 0;y<7;y++){
                    for(int x = 0;x<7;x++){
                        if(arrow_dot.charAt(y*7+x) == '0'){
                            this.sub_dot_positions.add(new PointF((x+3)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, (y+1)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                        }
                    }
                }
			}
			else if(status == 10202){
				this.dot_positions.clear();
                this.sub_dot_positions.clear();
                String dotdata = "11111111111111111001111111111111111111111111111111111100010111111111111111111111111111111111101000111111111111111111111111111111111101000011111111111111111111111111111111110000001111111111111111111111111111111111010001111111111111111111111111111111111010001111111111111111111111111111111111100111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100011111111111111111111111111111111111101100111111111111111111111111111111111101000011111111111111111111111111111111101000001111111111111111111111111111111101110001111111111111111111111111111111110111101111111111111111111111111111111111011101111111111111111111111111111111111110001111111111111111111111111";
                for(int y = 0;y<20;y++){
                    for(int x = 0;x<40;x++){
                        if(dotdata.charAt(y*40+x) == '0'){
                            this.sub_dot_positions.add(new PointF(x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                        }
                    }
                }
                String arrow_dot = "1110111111001100000010000000000000111100111110111";
                for(int y = 0;y<7;y++){
                    for(int x = 0;x<7;x++){
                        if(arrow_dot.charAt(y*7+x) == '0'){
                            this.sub_dot_positions.add(new PointF((x+3)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, (y+12)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                        }
                    }
                }
			}
			else if(status == 10203){
				String meet_dotdata = "1111110011100010110100011010000110000011100001110100111100111111";
                if(count == 1){
                    this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    this.random_values.clear();
                    this.sub_random_values.clear();
                    for(int y = 0;y<68;y+=2){
                        for(int x = 0;x < 52;x+=2){
                            if(this.dot_pattern.get(y*52+x) == true){
                                int angle = (int) (Math.random()*720);
                                angle-=360;
                                int radius = (int) (Math.random()*200);
                                radius -= 100;
                                this.random_values.add(new PointF(radius, angle));
                                
                                float fx = (float) (51*SUB_DOT_SIDE_LENGTH_FINAL_VALUE + radius * DOT_SIDE_LENGTH_FINAL_VALUE * Math.cos(angle / 180.0 * 3.14)+x*DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) (radius * DOT_SIDE_LENGTH_FINAL_VALUE * Math.sin(angle / 180.0 * 3.14)+y*DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                    for(int y = 0;y<8;y++){
                        for(int x = 0;x<8;x++){
                            if(meet_dotdata.charAt(y*8+x) == '0'){
                                int angle = (int) (Math.random()*720);
                                angle-=360;
                                int radius = (int) (Math.random()*100);
                                radius -= 50;
                                this.sub_random_values.add(new PointF(radius, angle));
                                
                                float fx = (float) (4*SUB_DOT_SIDE_LENGTH_FINAL_VALUE + radius * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.cos(angle / 180.0f* 340.0f)+x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) (5*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+radius * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.sin(angle / 180.0f* 340.0f)+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.sub_dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                }
                else if(count <= 20){
                    this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    int index = 0;
                    for(int y = 0;y<68;y+=2){
                        for(int x =0;x<52;x+=2){
                        	//System.out.println(this.dot_pattern.size());
                            if(this.dot_pattern.get(y*52+x)){
                            	if(this.random_values.size() == index){
                            		int angle = (int) (Math.random()*720);
                                    angle-=360;
                                    int radius = (int) (Math.random()*200);
                                    radius -= 100;
                                    this.random_values.add(new PointF(radius, angle));
                            	}
                                PointF rpoint = this.random_values.get(index);
                                float fx = (float) (51*DOT_SIDE_LENGTH_FINAL_VALUE +(1.0-count/20.0)*rpoint.x * DOT_SIDE_LENGTH_FINAL_VALUE * Math.cos((1.0-count/20.0)*rpoint.y/180.0*3.14)+x*DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) ((1.0-count/20.0)*rpoint.x * DOT_SIDE_LENGTH_FINAL_VALUE * Math.sin((1.0-count/20.0)*rpoint.y/180.0*3.14)+y*DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.dot_positions.add(new PointF(fx, fy));
                                index++;
                            }
                        }
                    }
                    index = 0;
                    for(int y = 0;y<8;y++){
                        for(int x = 0;x<8;x++){
                            boolean check = (meet_dotdata.charAt(y*8+x) == '0');
                            if(check){
                            	if(this.sub_random_values.size() == index){
                            		if(meet_dotdata.charAt(y*8+x) == '0'){
                                        int angle = (int) (Math.random()*720);
                                        angle-=360;
                                        int radius = (int) (Math.random()*100);
                                        radius -= 50;
                                        this.sub_random_values.add(new PointF(radius, angle));
                                    }
                            	}
                                PointF rpoint = this.sub_random_values.get(index);
                                float fx = (float) (4*SUB_DOT_SIDE_LENGTH_FINAL_VALUE +(1.0-count/20.0)*rpoint.x * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.cos((1.0-count/20.0)*rpoint.y/180.0*3.14)+x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) (5*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+(1.0-count/20.0)*rpoint.x * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.sin((1.0-count/20.0)*rpoint.y/180.0*3.14)+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.sub_dot_positions.add(new PointF(fx, fy));
                                index++;
                            }
                        }
                    }
                }
                else if(count <= 30){
                    
                }
                else if(count <= 55){
                    this.sub_dot_positions.clear();
                    int index = 0;
                    for(int y = 0;y<8;y++){
                        for(int x = 0;x<8;x++){
                            boolean check = (meet_dotdata.charAt(y*8+x) == '0');
                            if(check){
                            	if(this.sub_random_values.size() == index){
                            		if(meet_dotdata.charAt(y*8+x) == '0'){
                                        int angle = (int) (Math.random()*720);
                                        angle-=360;
                                        int radius = (int) (Math.random()*100);
                                        radius -= 50;
                                        this.sub_random_values.add(new PointF(radius, angle));
                                    }
                            	}
                                PointF rpoint = this.sub_random_values.get(index);
                                float fx = (float) (((6*(count-30)/25.0)+4)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE +((count-30)/25.0)*rpoint.x * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.cos(((count-30)/25.0)*rpoint.y/180.0*3.14)+x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) (5*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+((count-30)/25.0)*rpoint.x * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.sin(((count-30)/25.0)*rpoint.y/180.0*3.14)+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.sub_dot_positions.add(new PointF(fx, fy));
                                index++;
                            }
                        }
                    }
                }
                else if(count < 80){
                    this.sub_dot_positions.clear();
                    int index = 0;
                    for(int y = 0;y<8;y++){
                        for(int x = 0;x<8;x++){
                            boolean check = (meet_dotdata.charAt(y*8+x) == '0');
                            if(check){
                            	if(this.sub_random_values.size() == index){
                            		if(meet_dotdata.charAt(y*8+x) == '0'){
                                        int angle = (int) (Math.random()*720);
                                        angle-=360;
                                        int radius = (int) (Math.random()*100);
                                        radius -= 50;
                                        this.sub_random_values.add(new PointF(radius, angle));
                                    }
                            	}
                                PointF rpoint = this.sub_random_values.get(index);
                                float fx = (float) (((20.0*(count-55)/25.0)+4)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE +(1-(count-55)/25.0)*rpoint.x * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.cos((1-(count-55)/25.0)*rpoint.y/180.0*3.14)+x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) (5*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+(1-(count-55)/25.0)*rpoint.x * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.sin((1-(count-55)/25.0)*rpoint.y/180.0*3.14)+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.sub_dot_positions.add(new PointF(fx, fy));
                                index++;
                            }
                        }
                    }
                }
                else if(count <90){
                    this.sub_dot_positions.clear();
                }
                else if(count <=110){
                    this.dot_positions.clear();
                    int index = 0;
                    for(int y = 0;y<68;y+=2){
                        for(int x =0;x<52;x+=2){
                            if(this.dot_pattern.get(y*52+x) == true){
                            	if(this.random_values.size() == index){
                            		int angle = (int) (Math.random()*720);
                                    angle-=360;
                                    int radius = (int) (Math.random()*200);
                                    radius -= 100;
                                    this.random_values.add(new PointF(radius, angle));
                            	}
                                PointF rpoint = this.random_values.get(index);
                                float fx = (float) (51*DOT_SIDE_LENGTH_FINAL_VALUE+((count-90)/20.0)*rpoint.x * DOT_SIDE_LENGTH_FINAL_VALUE * Math.cos((count-90)/20.0*rpoint.y/180.0*3.14)+x*DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) (((count-90)/20.0)*rpoint.x * DOT_SIDE_LENGTH_FINAL_VALUE * Math.sin((count-90)/20.0*rpoint.y/180.0*3.14)+y*DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.dot_positions.add(new PointF(fx, fy));
                                index++;
                            }
                        }
                    }
                }   
			}
			else if(status == 10204){
				String meet_dotdata = "1111000111101100110100001010000001110001011110110111011110001111";
				//System.out.println(count+"");
                if(count == 1){
                    this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    this.random_values.clear();
                    this.sub_random_values.clear();
                    for(int y = 0;y<68;y+=2){
                        for(int x = 0;x < 52;x+=2){
                            if(this.dot_pattern.get(y*52+x) == true){
                                int angle = (int) (Math.random()*720);
                                angle-=360;
                                int radius = (int) (Math.random()*200);
                                radius -= 100;
                                this.random_values.add(new PointF(radius, angle));
                                
                                float fx = (float) (51*SUB_DOT_SIDE_LENGTH_FINAL_VALUE + radius * DOT_SIDE_LENGTH_FINAL_VALUE * Math.cos(angle / 180.0 * 3.14)+x*DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) (radius * DOT_SIDE_LENGTH_FINAL_VALUE * Math.sin(angle / 180.0 * 3.14)+y*DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                    for(int y = 0;y<8;y++){
                        for(int x = 0;x<8;x++){
                            if(meet_dotdata.charAt(y*8+x) == '0'){
                                int angle = (int) (Math.random()*720);
                                angle-=360;
                                int radius = (int) (Math.random()*100);
                                radius -= 50;
                                this.sub_random_values.add(new PointF(radius, angle));
                                
                                float fx = (float) (4*SUB_DOT_SIDE_LENGTH_FINAL_VALUE + radius * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.cos(angle / 180.0f* 340.0f)+x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) (5*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+radius * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.sin(angle / 180.0f* 340.0f)+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.sub_dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                }
                else if(count <= 20){
                    this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    int index = 0;
                    for(int y = 0;y<68;y+=2){
                        for(int x =0;x<52;x+=2){
                            if(this.dot_pattern.get(y*52+x)){
                            	if(this.random_values.size() == index){
                            		int angle = (int) (Math.random()*720);
                                    angle-=360;
                                    int radius = (int) (Math.random()*200);
                                    radius -= 100;
                                    this.random_values.add(new PointF(radius, angle));
                            	}
                                PointF rpoint = this.random_values.get(index);
                                float fx = (float) (51*DOT_SIDE_LENGTH_FINAL_VALUE +(1.0-count/20.0)*rpoint.x * DOT_SIDE_LENGTH_FINAL_VALUE * Math.cos((1.0-count/20.0)*rpoint.y/180.0*3.14)+x*DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) ((1.0-count/20.0)*rpoint.x * DOT_SIDE_LENGTH_FINAL_VALUE * Math.sin((1.0-count/20.0)*rpoint.y/180.0*3.14)+y*DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.dot_positions.add(new PointF(fx, fy));
                                index++;
                            }
                        }
                    }
                    index = 0;
                    for(int y = 0;y<8;y++){
                        for(int x = 0;x<8;x++){
                            boolean check = (meet_dotdata.charAt(y*8+x) == '0');
                            if(check){
                            	if(this.sub_random_values.size() == index){
                            		if(meet_dotdata.charAt(y*8+x) == '0'){
                                        int angle = (int) (Math.random()*720);
                                        angle-=360;
                                        int radius = (int) (Math.random()*100);
                                        radius -= 50;
                                        this.sub_random_values.add(new PointF(radius, angle));
                                    }
                            	}
                                PointF rpoint = this.sub_random_values.get(index);
                                float fx = (float) (4*SUB_DOT_SIDE_LENGTH_FINAL_VALUE +(1.0-count/20.0)*rpoint.x * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.cos((1.0-count/20.0)*rpoint.y/180.0*3.14)+x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) (5*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+(1.0-count/20.0)*rpoint.x * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.sin((1.0-count/20.0)*rpoint.y/180.0*3.14)+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.sub_dot_positions.add(new PointF(fx, fy));
                                index++;
                            }
                        }
                    }
                }
                else if(count <= 30){
                    
                }
                else if(count <= 55){
                    this.sub_dot_positions.clear();
                    int index = 0;
                    for(int y = 0;y<8;y++){
                        for(int x = 0;x<8;x++){
                            boolean check = (meet_dotdata.charAt(y*8+x) == '0');
                            if(check){
                            	if(this.sub_random_values.size() == index){
                            		if(meet_dotdata.charAt(y*8+x) == '0'){
                                        int angle = (int) (Math.random()*720);
                                        angle-=360;
                                        int radius = (int) (Math.random()*100);
                                        radius -= 50;
                                        this.sub_random_values.add(new PointF(radius, angle));
                                    }
                            	}
                                PointF rpoint = this.sub_random_values.get(index);
                                float fx = (float) (((6*(count-30)/25.0)+4)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE +((count-30)/25.0)*rpoint.x * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.cos(((count-30)/25.0)*rpoint.y/180.0*3.14)+x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) (5*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+((count-30)/25.0)*rpoint.x * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.sin(((count-30)/25.0)*rpoint.y/180.0*3.14)+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.sub_dot_positions.add(new PointF(fx, fy));
                                index++;
                            }
                        }
                    }
                }
                else if(count < 80){
                    this.sub_dot_positions.clear();
                    int index = 0;
                    for(int y = 0;y<8;y++){
                        for(int x = 0;x<8;x++){
                            boolean check = (meet_dotdata.charAt(y*8+x) == '0');
                            if(check){
                            	if(this.sub_random_values.size() == index){
                            		if(meet_dotdata.charAt(y*8+x) == '0'){
                                        int angle = (int) (Math.random()*720);
                                        angle-=360;
                                        int radius = (int) (Math.random()*100);
                                        radius -= 50;
                                        this.sub_random_values.add(new PointF(radius, angle));
                                    }
                            	}
                                PointF rpoint = this.sub_random_values.get(index);
                                float fx = (float) (((20.0*(count-55)/25.0)+4)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE +(1-(count-55)/25.0)*rpoint.x * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.cos((1-(count-55)/25.0)*rpoint.y/180.0*3.14)+x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) (5*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+(1-(count-55)/25.0)*rpoint.x * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.sin((1-(count-55)/25.0)*rpoint.y/180.0*3.14)+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.sub_dot_positions.add(new PointF(fx, fy));
                                index++;
                            }
                        }
                    }
                }
                else if(count <90){
                    this.sub_dot_positions.clear();
                }
                else if(count <=110){
                    this.dot_positions.clear();
                    int index = 0;
                    for(int y = 0;y<68;y+=2){
                        for(int x =0;x<52;x+=2){
                            if(this.dot_pattern.get(y*52+x) == true){
                            	if(this.random_values.size() == index){
                            		int angle = (int) (Math.random()*720);
                                    angle-=360;
                                    int radius = (int) (Math.random()*200);
                                    radius -= 100;
                                    this.random_values.add(new PointF(radius, angle));
                            	}
                                PointF rpoint = this.random_values.get(index);
                                float fx = (float) (51*DOT_SIDE_LENGTH_FINAL_VALUE+((count-90)/20.0)*rpoint.x * DOT_SIDE_LENGTH_FINAL_VALUE * Math.cos((count-90)/20.0*rpoint.y/180.0*3.14)+x*DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) (((count-90)/20.0)*rpoint.x * DOT_SIDE_LENGTH_FINAL_VALUE * Math.sin((count-90)/20.0*rpoint.y/180.0*3.14)+y*DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.dot_positions.add(new PointF(fx, fy));
                                index++;
                            }
                        }
                    }
                }
			}
			else if(status == 10301){
                if(count == 1){
                    this.dot_positions.clear();
                    sub_dot_positions.clear();
                    String dotdata = "11111111111111111111111111111111111111111111111111110001111111111111111111111111111111111111101111111111101111101111111111111111111110110101100111100011100010001111111111111011001101011010101010101010111111111111101101110101101010101010101011111111111110110111010110101010101010001111111111111011011100101010101010101110111111111111111111111111111111111111100011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110111111111111111111111111111111111111110101100110010010111111111111111111111111010110111011101110001000111111111111111101010001000110101010101011111111111111110101101110111010101010001111111111111111010110111011101010101011111111111111111110111011101110101010100011111111111111111111111111111111111111111111";
                    for(int y = 0;y<20;y++){
                        for(int x = 0;x<40;x++){
                            if(dotdata.charAt(y*40+x)== '0'){
                                this.sub_dot_positions.add(new PointF(x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                    String arrow_dot = "1110111111001100000010000000000000111100111110111";
                    for(int y = 0;y<7;y++){
                        for(int x = 0;x<7;x++){
                            if(arrow_dot.charAt(y*7+x) == '0'){
                                this.sub_dot_positions.add(new PointF((x+3)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, (y+1)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                }
			}
			else if(status == 10302){
                if(count == 1){
                    this.dot_positions.clear();
                    sub_dot_positions.clear();
                    String dotdata = "11111111111111111111111111111111111111111111111111110001111111111111111111111111111111111111101111111111101111101111111111111111111110110101100111100011100010001111111111111011001101011010101010101010111111111111101101110101101010101010101011111111111110110111010110101010101010001111111111111011011100101010101010101110111111111111111111111111111111111111100011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110111111111111111111111111111111111111110101100110010010111111111111111111111111010110111011101110001000111111111111111101010001000110101010101011111111111111110101101110111010101010001111111111111111010110111011101010101011111111111111111110111011101110101010100011111111111111111111111111111111111111111111";
                    for(int y = 0;y<20;y++){
                        for(int x = 0;x<40;x++){
                            if(dotdata.charAt(y*40+x)== '0'){
                                this.sub_dot_positions.add(new PointF(x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                    String arrow_dot = "1110111111001100000010000000000000111100111110111";
                    for(int y = 0;y<7;y++){
                        for(int x = 0;x<7;x++){
                            if(arrow_dot.charAt(y*7+x) == '0'){
                                this.sub_dot_positions.add(new PointF((x+3)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, (y+12)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                }
			}
			else if(status == 10303){
				if(count == 1){
					this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    String dotdata = "00000000000000000000000000000000000000000000000101010101000000001010101010000000000000010101010100000000101010101000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000110000011000110000110111010111111111011101011111011101011101011101011111111101110101111101110101110101110101111111110000110000010000010111010111010111111111011101011111011101011101100011011111111101110101111101110101110111011111111111110111010000010111010000111101110111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111010101010100000000000000000000101010101001010101010000000000000000000010101010100000000000000000000000000000000000000000";
                    for(int y = 0;y<20;y++){
                        for(int x = 0;x<40;x++){
                            if(dotdata.charAt(y*40+x) == '0'){
                                this.sub_dot_positions.add(new PointF(x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                }
			}
			else if(status == 10304){
				if(count == 1){
					this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    String dotdata = "00000000000000000000000000000000000000000011100000000001110001110000000000011100000111000000001110000011100000000011100000001110000001110000000111000000011100001111111111111111111111111111111111111111111111111111111111111111111111111111111111110000011000010111010111010000010011111111011111011101011101011101110111001111111101111101110101110100110111011100111111110111110111010111010101011101110011111111011111011101011101011001110111111111111101111101110101110101110111011100111111110000010000111000110111011101110011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000111000000111000000011100000001110000000111000000001110000011100000000011100000111000000000011100011100000000000111000000000000000000000000000000000000000000";
                    for(int y = 0;y<20;y++){
                        for(int x = 0;x<40;x++){
                            if(dotdata.charAt(y*40+x) == '0'){
                                this.sub_dot_positions.add(new PointF(x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                }
			}
            else if(status == 10305){
                if(count== 1){
                    this.dot_positions.clear();
                    this.random_values.clear();
                    this.sub_dot_positions.clear();
                    this.sub_random_values.clear();
                    for(int y = 0;y<68;y+=2){
                        for(int x = 0;x < 52;x+=2){
                            if(this.dot_pattern.get(y*52+x) == true){
                                int angle = (int) (Math.random()*720);
                                angle-=360;
                                int radius = (int) (Math.random()*200);
                                radius -= 100;
                                this.random_values.add(new PointF(radius, angle));
                                
                                float fx = (float) (51*SUB_DOT_SIDE_LENGTH_FINAL_VALUE + radius * DOT_SIDE_LENGTH_FINAL_VALUE *Math.cos(angle / 180.0 * 3.14)+x*DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) (radius * DOT_SIDE_LENGTH_FINAL_VALUE *Math.sin(angle / 180.0 * 3.14)+y*DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                }
                else if(count < 20){
                    this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    int index = 0;
                    for(int y = 0;y<68;y+=2){
                        for(int x =0;x<52;x+=2){
                            if(this.dot_pattern.get(y*52+x) == true){
                            	if(this.random_values.size() == index){
                            		int angle = (int) (Math.random()*720);
                                    angle-=360;
                                    int radius = (int) (Math.random()*200);
                                    radius -= 100;
                                    this.random_values.add(new PointF(radius, angle));
                            	}
                                PointF rpoint = this.random_values.get(index);
                                float fx = (float) (51*DOT_SIDE_LENGTH_FINAL_VALUE +(1.0-count/20.0)*rpoint.x * DOT_SIDE_LENGTH_FINAL_VALUE *Math.cos((1.0-count/20.0)*rpoint.y/180.0*3.14)+x*DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) ((1.0-count/20.0)*rpoint.x * DOT_SIDE_LENGTH_FINAL_VALUE *Math.sin((1.0-count/20.0)*rpoint.y/180.0*3.14)+y*DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.dot_positions.add(new PointF(fx, fy));
                                index++;
                            }
                        }
                    }
                }
                else if(count < 245){
                    int loop = (count - 20)/45;
                    String attack_data = this.loadAttackDot();
                    if(count == 20+(loop)*45){
                        this.random_values.clear();
                        this.sub_random_values.clear();
                        this.dot_positions.clear();
                        this.sub_dot_positions.clear();
                        for(int y = 0;y<68;y+=2){
                            for(int x =0;x<52;x+=2){
                                if(this.dot_pattern.get(y*52+x)){
                                    float fx = 51f*DOT_SIDE_LENGTH_FINAL_VALUE +x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    this.dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                        for(int y = 0;y<8;y++){
                            for(int x = 0;x<8;x++){
                                if(attack_data.charAt(y*8+x) == '0'){
                                    int angle = (int) (Math.random()*720);
                                    angle-=360;
                                    int radius = (int) (Math.random()*100);
                                    radius -= 50;
                                    this.sub_random_values.add(new PointF(radius, angle));
                                    
                                    float fx = (float) (4*SUB_DOT_SIDE_LENGTH_FINAL_VALUE + radius * SUB_DOT_SIDE_LENGTH_FINAL_VALUE *Math.cos(angle / 180.0f * 340.0f)+x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                    float fy = (float) (5*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+radius * SUB_DOT_SIDE_LENGTH_FINAL_VALUE *Math.sin(angle / 180.0f * 340.0f)+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                    this.sub_dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                    }
                    if(count < 20+25+(loop)*45){
                        this.dot_positions.clear();
                        this.sub_dot_positions.clear();
                        int index = 0;
                        for(int y = 0;y<68;y+=2){
                            for(int x =0;x<52;x+=2){
                                if(this.dot_pattern.get(y*52+x) == true){
                                    float fx = 51*DOT_SIDE_LENGTH_FINAL_VALUE + x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy = 0.2f*52f*DOT_SIDE_LENGTH_FINAL_VALUE+y*DOT_SIDE_LENGTH_FINAL_VALUE*0.8f;
                                    this.dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                        for(int y = 0;y<8;y++){
                            for(int x =0;x<8;x++){
                                if(attack_data.charAt(y*8+x) == '0'){
                                	if(this.sub_random_values.size() == index){
                                		int angle = (int) (Math.random()*720);
                                        angle-=360;
                                        int radius = (int) (Math.random()*100);
                                        radius -= 50;
                                        this.sub_random_values.add(new PointF(radius, angle));
                                	}
                                    PointF randp = this.sub_random_values.get(index);
                                    float radius = randp.x;
                                    float angle = randp.y;
                                    float fx = (float) (4*SUB_DOT_SIDE_LENGTH_FINAL_VALUE + radius*(1-(count - (20+(loop)*45))/25.0) * SUB_DOT_SIDE_LENGTH_FINAL_VALUE *Math.cos(angle*(1-(count - (20+(loop)*45))/25.0) / 180.0f* 340.0f)+x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                    float fy = (float) (1*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+radius*(1-(count - (20+(loop)*45))/25.0) * SUB_DOT_SIDE_LENGTH_FINAL_VALUE *Math.sin(angle*(1-(count - (20+(loop)*45))/25.0) / 180.0f* 340.0f)+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                    this.sub_dot_positions.add(new PointF(fx, fy));
                                    index++;
                                }
                            }
                        }
                        if(this.megahits[loop] == 1){
                            index = 0;
                            for(int y = 0;y<8;y++){
                                for(int x =0;x<8;x++){
                                    if(attack_data.charAt(y*8+x) == '0'){
                                    	if(this.sub_random_values.size() == index){
                                    		int angle = (int) (Math.random()*720);
                                            angle-=360;
                                            int radius = (int) (Math.random()*100);
                                            radius -= 50;
                                            this.sub_random_values.add(new PointF(radius, angle));
                                    	}
                                        PointF randp = this.sub_random_values.get(index);
                                        float radius = randp.x;
                                        float angle = randp.y;
                                        float fx = (float) (4*SUB_DOT_SIDE_LENGTH_FINAL_VALUE + radius*(1-(count - (20+(loop)*45))/25.0) * SUB_DOT_SIDE_LENGTH_FINAL_VALUE *Math.cos(angle*(1-(count - (20+(loop)*45))/25.0) / 180.0f* 340.0f)+x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                        float fy = (float) (11*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+radius*(1-(count - (20+(loop)*45))/25.0) * SUB_DOT_SIDE_LENGTH_FINAL_VALUE *Math.sin(angle*(1-(count - (20+(loop)*45))/25.0) / 180.0f)+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                        this.sub_dot_positions.add(new PointF(fx, fy));
                                        index++;
                                    }
                                }
                            }
                        }
                    }
                    else if(count <55+(loop)*45){
                        this.dot_positions.clear();
                        this.sub_dot_positions.clear();
                        for(int y = 0;y<68;y+=2){
                            for(int x =0;x<52;x+=2){
                               if(this.dot_pattern.get(y*52+x) == true){
                                    float fx = 51f*DOT_SIDE_LENGTH_FINAL_VALUE + x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    this.dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                        for(int y = 0;y<8;y++){
                            for(int x =0;x<8;x++){
                                if(attack_data.charAt(y*8+x) == '0'){
                                    float fx = 4*SUB_DOT_SIDE_LENGTH_FINAL_VALUE-(count - (45+(loop)*45))*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+ x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy = 1*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                    if(fx >= 0){
                                        this.sub_dot_positions.add(new PointF(fx, fy));
                                    }
                                }
                            }
                        }
                        if(this.megahits[loop] == 1){
                            for(int y = 0;y<8;y++){
                                for(int x =0;x<8;x++){
                                    if(attack_data.charAt(y*8+x) == '0'){
                                        float fx = 4*SUB_DOT_SIDE_LENGTH_FINAL_VALUE-(count - (45+(loop)*45))*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+ x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                        float fy = 11*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                        if(fx >= 0){
                                        	this.sub_dot_positions.add(new PointF(fx, fy));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else if(count < 65+(loop)*45){
                        this.dot_positions.clear();
                        this.sub_dot_positions.clear();
                        for(int y = 0;y<68;y+=2){
                            for(int x =0;x<52;x+=2){
                                if(this.dot_pattern.get(y*52+x) == true){
                                    float fx = 51*DOT_SIDE_LENGTH_FINAL_VALUE + x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    this.dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                    }
                }
            }
			//reaction
            else if(status == 10306){
                if(count <= 120){
                    int loop = count / 40;
                    int ecounter = count - 40*loop;
                    if(ecounter == 1){
                        this.dot_positions.clear();
                        this.sub_dot_positions.clear();
                        for(int y = 0;y<68;y+=2){
                            for(int x =0;x<52;x+=2){
                                if(this.dot_pattern.get(y*52+x) == true){
                                    float fx = x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy;
                                    if(this.reaction == true){
                                        fy = (float) (0.2*52*DOT_SIDE_LENGTH_FINAL_VALUE+ y*DOT_SIDE_LENGTH_FINAL_VALUE*0.8);
                                    }
                                    else{
                                        fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    }
                                    this.dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                    }
                    else if(ecounter == 20){
                        this.dot_positions.clear();
                        this.sub_dot_positions.clear();
                        for(int y = 0;y<68;y+=2){
                            for(int x =0;x<52;x+=2){
                                
                                if(this.dot_pattern.get(y*52+x)){
                                    float fx = x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy;
                                    if(this.reaction == true){
                                        fy = (float) (0.2*52*DOT_SIDE_LENGTH_FINAL_VALUE+ y*DOT_SIDE_LENGTH_FINAL_VALUE*0.8);
                                    }
                                    else{
                                        fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    }
                                    this.dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                        String dotdata = null;
                        if(this.reaction == true){
                            dotdata = "1111011110111101111001110101101011011011111001111011111011101011";
                        }
                        else{
                            dotdata = "1011110110000000000000000100100001001100001000001000001110100101";
                        }
                        for(int y = 0;y<8;y++){
                            for(int x = 0;x<8;x++){
                                if(dotdata.charAt(y*8+x) == '0'){
                                    float fx1 = (4+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fx2 = (26+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy = y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                    this.sub_dot_positions.add(new PointF(fx1, fy));
                                    this.sub_dot_positions.add(new PointF(fx2, fy));
                                }
                            }
                        }
                    }
                }
                else if(count <= 150){
                    this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    for(int y = 0;y<68;y+=2){
                        for(int x =0;x<52;x+=2){
                            if(this.dot_pattern.get(y*52+x)){
                                float fx = x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                float fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                this.dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                }
            }
            else if(status == 10307){
                if(count == 1){
                    this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    for(int y = 0;y<68;y+=2){
                        for(int x = 0;x <52 ;x+=2){
                            if(this.enemy_dots.get(y*52+x)){
                                float fx = (50-x)*DOT_SIDE_LENGTH_FINAL_VALUE;
                                float fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                this.dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                    this.enemy_dots = null;
                }
            }
            else if(status == 10308){
				if(count == 1){
					this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    String dotdata = "00000000000000000000000000000000000000000000000101010101000000001010101010000000000000010101010100000000101010101000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000110000011000110000110111010111111111011101011111011101011101011101011111111101110101111101110101110101110101111111110000110000010000010111010111010111111111011101011111011101011101100011011111111101110101111101110101110111011111111111110111010000010111010000111101110111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111010101010100000000000000000000101010101001010101010000000000000000000010101010100000000000000000000000000000000000000000";
                    for(int y = 0;y<20;y++){
                        for(int x = 0;x<40;x++){
                            if(dotdata.charAt(y*40+x) == '0'){
                                this.sub_dot_positions.add(new PointF(x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                }
			}
			else if(status == 10309){
				if(count == 1){
					this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    String dotdata = "00000000000000000000000000000000000000000011100000000001110001110000000000011100000111000000001110000011100000000011100000001110000001110000000111000000011100001111111111111111111111111111111111111111111111111111111111111111111111111111111111110000011000010111010111010000010011111111011111011101011101011101110111001111111101111101110101110100110111011100111111110111110111010111010101011101110011111111011111011101011101011001110111111111111101111101110101110101110111011100111111110000010000111000110111011101110011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000111000000111000000011100000001110000000111000000001110000011100000000011100000111000000000011100011100000000000111000000000000000000000000000000000000000000";
                    for(int y = 0;y<20;y++){
                        for(int x = 0;x<40;x++){
                            if(dotdata.charAt(y*40+x) == '0'){
                                this.sub_dot_positions.add(new PointF(x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                }
			}
            else if(status == 10310){
                if(count == 1){
                    this.dot_positions.clear();
                    this.random_values.clear();
                    this.sub_dot_positions.clear();
                    this.sub_random_values.clear();
                    for(int y = 0;y<68;y+=2){
                        for(int x = 0;x < 52;x+=2){
                            if(this.dot_pattern.get(y*52+x) == true){
                                int angle = (int) (Math.random()*720);
                                angle-=360;
                                int radius = (int) (Math.random()*200);
                                radius -= 100;
                                this.random_values.add(new PointF(radius, angle));
                                
                                float fx = (float) (51*SUB_DOT_SIDE_LENGTH_FINAL_VALUE + radius * DOT_SIDE_LENGTH_FINAL_VALUE *Math.cos(angle / 180.0 * 3.14)+x*DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) (radius * DOT_SIDE_LENGTH_FINAL_VALUE *Math.sin(angle / 180.0 * 3.14)+y*DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.dot_positions.add(new PointF(fx,fy));
                            }
                        }
                    }
                }
                else if(count < 20){
                    this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    int index = 0;
                    for(int y = 0;y<68;y+=2){
                        for(int x =0;x<52;x+=2){
                            if(this.dot_pattern.get(y*52+x) == true){
                            	if(this.random_values.size() == index){
                            		int angle = (int) (Math.random()*720);
                                    angle-=360;
                                    int radius = (int) (Math.random()*200);
                                    radius -= 100;
                                    this.random_values.add(new PointF(radius, angle));
                            	}
                                PointF rpoint = this.random_values.get(index);
                                float fx = (float) (51*DOT_SIDE_LENGTH_FINAL_VALUE +(1.0-count/20.0)*rpoint.x * DOT_SIDE_LENGTH_FINAL_VALUE *Math.cos((1.0-count/20.0)*rpoint.y/180.0*3.14)+x*DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) ((1.0-count/20.0)*rpoint.x * DOT_SIDE_LENGTH_FINAL_VALUE *Math.sin((1.0-count/20.0)*rpoint.y/180.0*3.14)+y*DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.dot_positions.add(new PointF(fx, fy));
                                index++;
                            }
                        }
                    }
                }
                else if(count < 470){
                    int loop = (count - 20)/90;
                    String attack_data = this.loadAttackDot();
                    if(count == 20+loop*90){
                        this.random_values.clear();
                        this.sub_random_values.clear();
                        this.dot_positions.clear();
                        this.sub_dot_positions.clear();
                        for(int y = 0;y<68;y+=2){
                            for(int x =0;x<52;x+=2){
                                if(this.dot_pattern.get(y*52+x)){
                                    float fx = 51*DOT_SIDE_LENGTH_FINAL_VALUE +x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    this.dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                        for(int y = 0;y<8;y++){
                            for(int x = 0;x<8;x++){
                                if(attack_data.charAt(y*8+x) == '0'){
                                    int angle = (int) (Math.random()*720);
                                    angle-=360;
                                    int radius = (int) (Math.random()*100);
                                    radius -= 50;
                                    this.sub_random_values.add(new PointF(radius, angle));
                                    
                                    float fx = (float) (4*SUB_DOT_SIDE_LENGTH_FINAL_VALUE + radius * SUB_DOT_SIDE_LENGTH_FINAL_VALUE *Math.cos(angle / 180.0f * 340.0f)+x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                    float fy = (float) (5*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+radius * SUB_DOT_SIDE_LENGTH_FINAL_VALUE *Math.sin(angle / 180.0f * 340.0f)+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                    this.sub_dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                    }
                    else if(count < 45+loop*90){
                        this.dot_positions.clear();
                        this.sub_dot_positions.clear();
                        int index = 0;
                        for(int y = 0;y<68;y+=2){
                            for(int x =0;x<52;x+=2){
                                if(this.dot_pattern.get(y*52+x)){
                                    float fx = 51*DOT_SIDE_LENGTH_FINAL_VALUE + x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy = 0.2f*52f*DOT_SIDE_LENGTH_FINAL_VALUE+y*DOT_SIDE_LENGTH_FINAL_VALUE*0.8f;
                                    this.dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                        for(int y = 0;y<8;y++){
                            for(int x =0;x<8;x++){
                                if(attack_data.charAt(y*8+x) == '0'){
                                	if(this.sub_random_values.size() == index){
                                		int angle = (int) (Math.random()*720);
                                        angle-=360;
                                        int radius = (int) (Math.random()*100);
                                        radius -= 50;
                                        this.sub_random_values.add(new PointF(radius, angle));
                                	}
                                    PointF randp = this.sub_random_values.get(index);
                                    float radius = randp.x;
                                    float angle = randp.y;
                                    float fx = (float) (4*SUB_DOT_SIDE_LENGTH_FINAL_VALUE + radius*(1-(count - (20+loop*90))/25.0) * SUB_DOT_SIDE_LENGTH_FINAL_VALUE *Math.cos(angle*(1-(count - (20+loop*90))/25.0) / 180.0f * 340.0f)+x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                    float fy = (float) (1*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+radius*(1-(count - (20+loop*90))/25.0) * SUB_DOT_SIDE_LENGTH_FINAL_VALUE *Math.sin(angle*(1-(count - (20+loop*90))/25.0) / 180.0f * 340.0f)+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                    this.sub_dot_positions.add(new PointF(fx, fy));
                                    index++;
                                }
                            }
                        }
                        if(this.megahits[loop] == 1){
                            index = 0;
                            for(int y = 0;y<8;y++){
                                for(int x =0;x<8;x++){
                                    if(attack_data.charAt(y*8+x) == '0'){
                                        if(this.sub_random_values.size() == index){
                                        	int angle = (int) (Math.random()*720);
                                            angle-=360;
                                            int radius = (int) (Math.random()*100);
                                            radius -= 50;
                                            this.sub_random_values.add(new PointF(radius, angle));
                                        }
                                        PointF randp = this.sub_random_values.get(index);
                                        float radius = randp.x;
                                        float angle = randp.y;
                                        float fx = (float) (4*SUB_DOT_SIDE_LENGTH_FINAL_VALUE + radius*(1-(count - (20+loop*45))/25.0) * SUB_DOT_SIDE_LENGTH_FINAL_VALUE *Math.cos(angle*(1-(count - (20+loop*45))/25.0) / 180.0f * 340.0f)+x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                        float fy = (float) (11*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+radius*(1-(count - (20+loop*45))/25.0) * SUB_DOT_SIDE_LENGTH_FINAL_VALUE *Math.sin(angle*(1-(count - (20+loop*45))/25.0) / 180.0f * 340.0f)+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                        this.sub_dot_positions.add(new PointF(fx, fy));
                                        index++;
                                    }
                                }
                            }
                        }
                    }
                    else if(count <55+loop*90){
                        this.dot_positions.clear();
                        this.sub_dot_positions.clear();
                        for(int y = 0;y<68;y+=2){
                            for(int x =0;x<52;x+=2){
                                if(this.dot_pattern.get(y*52+x)){
                                    float fx = 51*DOT_SIDE_LENGTH_FINAL_VALUE + x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    this.dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                        for(int y = 0;y<8;y++){
                            for(int x =0;x<8;x++){
                                if(attack_data.charAt(y*8+x) == '0'){
                                    float fx = 4*SUB_DOT_SIDE_LENGTH_FINAL_VALUE-(count - (45+loop*90))*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+ x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy = 1*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                    if(fx >= 0){
                                        this.sub_dot_positions.add(new PointF(fx, fy));
                                    }
                                }
                            }
                        }
                        if(this.enemy_megahits.get(loop) == true){
                            for(int y = 0;y<8;y++){
                                for(int x =0;x<8;x++){
                                    if(attack_data.charAt(y*8+x) == '0'){
                                        float fx = 4*SUB_DOT_SIDE_LENGTH_FINAL_VALUE-(count - (45+loop*90))*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+ x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                        float fy = 11*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                        if(fx >= 0){
                                            this.sub_dot_positions.add(new PointF(fx, fy));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else if(count <75+loop*90){
                        this.dot_positions.clear();
                        this.sub_dot_positions.clear();
                        String enemy_attack = this.loadAttackDot(this.enemy_attack_type);
                        for(int y = 0;y<68;y+=2){
                            for(int x =0;x<52;x+=2){
                                if(this.dot_pattern.get(y*52+x)){
                                    float fx = 51*DOT_SIDE_LENGTH_FINAL_VALUE + x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    this.dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                        for(int y = 0;y<8;y++){
                            for(int x =0;x<8;x++){
                                if(enemy_attack.charAt(8*y+x) == '0'){
                                    float fx = (count - (55+loop*90))*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+ (8-x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy = 1*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                    if(fx >= 0){
                                        this.sub_dot_positions.add(new PointF(fx, fy));
                                    }
                                }
                            }
                        }
                        if(this.megahits[loop] == 1){
                            for(int y = 0;y<8;y++){
                                for(int x =0;x<8;x++){
                                    if(enemy_attack.charAt(y*8+x) == '0'){
                                        float fx = (count - (55+loop*90))*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+ (8-x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                        float fy = 11*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                        if(fx >= 0){
                                            this.sub_dot_positions.add(new PointF(fx, fy));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else if(count < 90+loop*90){
                        if(this.hit_pattern.get(loop) == true){
                            this.dot_positions.clear();
                            this.sub_dot_positions.clear();
                            if((count >= 78+loop*90 && count < 81+loop*90)|| (count >= 84+loop*90 && count < 87+loop*90)){
                                String dotdata="11101111111110011111011111111111001111101110011111110101111010111111110101011000111010111110110111011101100100010110011000001100000111010011111001101100111011011011111111111110111111111111111111111101110111111111111111111111111111111111101111101111111111110000000111111111111110111101111111111110000000001111111111110111101111111111111011101110111111111110111101111111111111101110111011111111111101110011111111111110000000001111111111111001110111111111111100010001111111111111111011101111111111110000000111111111111111011111011111111110101010101111111111111011111101111111111111111111111111111111011111101111111111111111111111111111111110111101111101011101111111111111111110111011101111001010101001110111010111100100110101110011111001111010100010101001111100100000111111111111110111111111011111111100";
                                for(int y = 0;y<20;y++){
                                    for(int x = 0;x<40;x++){
                                        if(dotdata.charAt(y*40+x) == '0'){
                                            this.sub_dot_positions.add(new PointF(x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                                        }
                                    }
                                }
                            }
                            else if((count >= 75+loop*90 && count < 78+loop*90) || (count >= 81+loop*90 && count < 84+loop*90) || (count >= 87+loop*90)){
                                String dotdata="11101111111110011111011111111111001111101110011111110001111000111111110100011000111000111110000111000001100100010000000000000000000000010000000000000000000000011000000000000000000000000000000000000001110000000000000000000000000000000000001111100000000000000000000000000000000000111100000000000000111111100000000000000111100000000000000100010001000000000000111100000000000000010001000100000000000001110000000000000001111111110000000000000001110000000000000011101110000000000000000011100000000000001111111000000000000000011111000000000001010101010000000000000011111100000000000000000000000000000000011111100000000000000000000000000000000000111100000000000000000000000000000000000011100000001010001000000000000000000100000100000011111001111000100010100001111100100000111111110111110111111111011111111100";
                                for(int y = 0;y<20;y++){
                                    for(int x = 0;x<40;x++){
                                        if(dotdata.charAt(y*40+x) == '0'){
                                            this.sub_dot_positions.add(new PointF(x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                                        }
                                    }
                                }
                            }
                        }
                        else{
                            this.dot_positions.clear();
                            for(int y = 0;y<68;y+=2){
                                for(int x =0;x<52;x+=2){
                                    if(this.dot_pattern.get(y*52+x)){
                                        float fx = 51*DOT_SIDE_LENGTH_FINAL_VALUE +(50-x)*DOT_SIDE_LENGTH_FINAL_VALUE;
                                        float fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                        this.dot_positions.add(new PointF(fx, fy));
                                    }
                                }
                            }
                        }
                    }
                    else if(count < 110+loop*90){
                        this.dot_positions.clear();
                        this.sub_dot_positions.clear();
                        this.dot_positions.clear();
                        for(int y = 0;y<68;y+=2){
                            for(int x =0;x<52;x+=2){
                                if(this.dot_pattern.get(y*52+x)){
                                    float fx = 51*DOT_SIDE_LENGTH_FINAL_VALUE +(x)*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    this.dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                    }
                }
            }
			//reaction
            else if(status == 10311){
                if(count <= 120){
                    int loop = count / 40;
                    int ecounter = count - 40*loop;
                    if(ecounter == 1){
                        this.dot_positions.clear();
                        this.sub_dot_positions.clear();
                        for(int y = 0;y<68;y+=2){
                            for(int x =0;x<52;x+=2){
                                if(this.dot_pattern.get(y*52+x) == true){
                                    float fx = x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy;
                                    if(this.reaction == true){
                                        fy = (float) (0.2*52*DOT_SIDE_LENGTH_FINAL_VALUE+ y*DOT_SIDE_LENGTH_FINAL_VALUE*0.8);
                                    }
                                    else{
                                        fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    }
                                    this.dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                    }
                    else if(ecounter == 20){
                        this.dot_positions.clear();
                        this.sub_dot_positions.clear();
                        for(int y = 0;y<68;y+=2){
                            for(int x =0;x<52;x+=2){
                                
                                if(this.dot_pattern.get(y*52+x)){
                                    float fx = x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy;
                                    if(this.reaction == true){
                                        fy = (float) (0.2*52*DOT_SIDE_LENGTH_FINAL_VALUE+ y*DOT_SIDE_LENGTH_FINAL_VALUE*0.8);
                                    }
                                    else{
                                        fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    }
                                    this.dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                        String dotdata = null;
                        if(this.reaction == true){
                            dotdata = "1111011110111101111001110101101011011011111001111011111011101011";
                        }
                        else{
                            dotdata = "1011110110000000000000000100100001001100001000001000001110100101";
                        }
                        for(int y = 0;y<8;y++){
                            for(int x = 0;x<8;x++){
                                if(dotdata.charAt(y*8+x) == '0'){
                                    float fx1 = (4+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fx2 = (26+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy = y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                    this.sub_dot_positions.add(new PointF(fx1, fy));
                                    this.sub_dot_positions.add(new PointF(fx2, fy));
                                }
                            }
                        }
                    }
                }
                else if(count <= 150){
                    this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    for(int y = 0;y<68;y+=2){
                        for(int x =0;x<52;x+=2){
                            if(this.dot_pattern.get(y*52+x)){
                                float fx = x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                float fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                this.dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                }
            }
            else if(status == 10401){
                if(count == 1){
                    this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    String dotdata = "11111111111111111111111111111111111111111111111111111011111111111111111111111111111111111111010111110010111111111111111111111111111101010001101110001000111111111111111111110101010110101010101011111111111111111111010101011010101010001111111111111111111101010101101010101011111111111111111111111011010110101010100011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111011111111111111111111111111111111111111101111111111111111111111111111111111111110110110001010100011011111111111111111111010101010100110101010111111111111111111101010101010111000110111111111111111111010101010001011101110101111111111111111110111011110101110001100111111111111111111111111100011111111111111111";
                    for(int y = 0;y<20;y++){
                        for(int x = 0;x<40;x++){
                            if(dotdata.charAt(y*40+x) == '0'){
                                this.sub_dot_positions.add(new PointF(x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                    String arrow_dot = "1110111111001100000010000000000000111100111110111";
                    for(int y = 0;y<7;y++){
                        for(int x = 0;x<7;x++){
                            if(arrow_dot.charAt(y*7+x) == '0'){
                                this.sub_dot_positions.add(new PointF((x+3)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, (y+1)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                }
            }
            else if(status == 10402){
                if(count == 1){
                    this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    String dotdata = "11111111111111111111111111111111111111111111111111111011111111111111111111111111111111111111010111110010111111111111111111111111111101010001101110001000111111111111111111110101010110101010101011111111111111111111010101011010101010001111111111111111111101010101101010101011111111111111111111111011010110101010100011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111011111111111111111111111111111111111111101111111111111111111111111111111111111110110110001010100011011111111111111111111010101010100110101010111111111111111111101010101010111000110111111111111111111010101010001011101110101111111111111111110111011110101110001100111111111111111111111111100011111111111111111";
                    for(int y = 0;y<20;y++){
                        for(int x = 0;x<40;x++){
                            if(dotdata.charAt(y*40+x) == '0'){
                                this.sub_dot_positions.add(new PointF(x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                    String arrow_dot = "1110111111001100000010000000000000111100111110111";
                    for(int y = 0;y<7;y++){
                        for(int x = 0;x<7;x++){
                            if(arrow_dot.charAt(y*7+x) == '0'){
                                this.sub_dot_positions.add(new PointF((x+3)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, (y+12)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                }
            }
            else if(status == 10404){
                if(count == 1){
                    this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    for(int y = 0;y<68;y+=2){
                        for(int x = 0;x <52 ;x+=2){
                            if(this.enemy_dots.get(y*52+x)){
                                float fx = (50-x)*DOT_SIDE_LENGTH_FINAL_VALUE;
                                float fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                this.dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                    this.enemy_dots = null;
                }
            }
            else if(status == 10405){
				if(count == 1){
					this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    String dotdata = "00000000000000000000000000000000000000000000000101010101000000001010101010000000000000010101010100000000101010101000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000110000011000110000110111010111111111011101011111011101011101011101011111111101110101111101110101110101110101111111110000110000010000010111010111010111111111011101011111011101011101100011011111111101110101111101110101110111011111111111110111010000010111010000111101110111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111010101010100000000000000000000101010101001010101010000000000000000000010101010100000000000000000000000000000000000000000";
                    for(int y = 0;y<20;y++){
                        for(int x = 0;x<40;x++){
                            if(dotdata.charAt(y*40+x) == '0'){
                                this.sub_dot_positions.add(new PointF(x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                }
			}
			else if(status == 10406){
				if(count == 1){
					this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    String dotdata = "00000000000000000000000000000000000000000011100000000001110001110000000000011100000111000000001110000011100000000011100000001110000001110000000111000000011100001111111111111111111111111111111111111111111111111111111111111111111111111111111111110000011000010111010111010000010011111111011111011101011101011101110111001111111101111101110101110100110111011100111111110111110111010111010101011101110011111111011111011101011101011001110111111111111101111101110101110101110111011100111111110000010000111000110111011101110011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000111000000111000000011100000001110000000111000000001110000011100000000011100000111000000000011100011100000000000111000000000000000000000000000000000000000000";
                    for(int y = 0;y<20;y++){
                        for(int x = 0;x<40;x++){
                            if(dotdata.charAt(y*40+x) == '0'){
                                this.sub_dot_positions.add(new PointF(x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                }
			}
            else if(status == 10407){
                if(count == 1){
                    this.dot_positions.clear();
                    this.random_values.clear();
                    this.sub_dot_positions.clear();
                    this.sub_random_values.clear();
                    for(int y = 0;y<68;y+=2){
                        for(int x = 0;x < 52;x+=2){
                            if(this.dot_pattern.get(y*52+x) == true){
                                int angle = (int) (Math.random()*720);
                                angle-=360;
                                int radius = (int) (Math.random()*200);
                                radius -= 100;
                                this.random_values.add(new PointF(radius, angle));
                                
                                float fx = (float) (51*SUB_DOT_SIDE_LENGTH_FINAL_VALUE + radius * DOT_SIDE_LENGTH_FINAL_VALUE *Math.cos(angle / 180.0 * 3.14)+x*DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) (radius * DOT_SIDE_LENGTH_FINAL_VALUE *Math.sin(angle / 180.0 * 3.14)+y*DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.dot_positions.add(new PointF(fx,fy));
                            }
                        }
                    }
                }
                else if(count < 20){
                    this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    int index = 0;
                    for(int y = 0;y<68;y+=2){
                        for(int x =0;x<52;x+=2){
                            if(this.dot_pattern.get(y*52+x) == true){
                            	if(this.random_values.size() == index){
                            		int angle = (int) (Math.random()*720);
                                    angle-=360;
                                    int radius = (int) (Math.random()*200);
                                    radius -= 100;
                                    this.random_values.add(new PointF(radius, angle));
                            	}
                                PointF rpoint = this.random_values.get(index);
                                float fx = (float) (51*DOT_SIDE_LENGTH_FINAL_VALUE +(1.0-count/20.0)*rpoint.x * DOT_SIDE_LENGTH_FINAL_VALUE *Math.cos((1.0-count/20.0)*rpoint.y/180.0*3.14)+x*DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) ((1.0-count/20.0)*rpoint.x * DOT_SIDE_LENGTH_FINAL_VALUE *Math.sin((1.0-count/20.0)*rpoint.y/180.0*3.14)+y*DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.dot_positions.add(new PointF(fx, fy));
                                index++;
                            }
                        }
                    }
                }
                else if(count < 470){
                    int loop = (count - 20)/90;
                    String attack_data = this.loadAttackDot();
                    if(count == 20+loop*90){
                        this.random_values.clear();
                        this.sub_random_values.clear();
                        this.dot_positions.clear();
                        this.sub_dot_positions.clear();
                        for(int y = 0;y<68;y+=2){
                            for(int x =0;x<52;x+=2){
                                if(this.dot_pattern.get(y*52+x)){
                                    float fx = 51*DOT_SIDE_LENGTH_FINAL_VALUE +x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    this.dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                        for(int y = 0;y<8;y++){
                            for(int x = 0;x<8;x++){
                                if(attack_data.charAt(y*8+x) == '0'){
                                    int angle = (int) (Math.random()*720);
                                    angle-=360;
                                    int radius = (int) (Math.random()*100);
                                    radius -= 50;
                                    this.sub_random_values.add(new PointF(radius, angle));
                                    
                                    float fx = (float) (4*SUB_DOT_SIDE_LENGTH_FINAL_VALUE + radius * SUB_DOT_SIDE_LENGTH_FINAL_VALUE *Math.cos(angle / 180.0f * 340.0f)+x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                    float fy = (float) (5*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+radius * SUB_DOT_SIDE_LENGTH_FINAL_VALUE *Math.sin(angle / 180.0f * 340.0f)+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                    this.sub_dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                    }
                    else if(count < 45+loop*90){
                        this.dot_positions.clear();
                        this.sub_dot_positions.clear();
                        int index = 0;
                        for(int y = 0;y<68;y+=2){
                            for(int x =0;x<52;x+=2){
                                if(this.dot_pattern.get(y*52+x)){
                                    float fx = 51*DOT_SIDE_LENGTH_FINAL_VALUE + x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy = 0.2f*52f*DOT_SIDE_LENGTH_FINAL_VALUE+y*DOT_SIDE_LENGTH_FINAL_VALUE*0.8f;
                                    this.dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                        for(int y = 0;y<8;y++){
                            for(int x =0;x<8;x++){
                                if(attack_data.charAt(y*8+x) == '0'){
                                	if(this.sub_random_values.size() == index){
                                		int angle = (int) (Math.random()*720);
                                        angle-=360;
                                        int radius = (int) (Math.random()*100);
                                        radius -= 50;
                                        this.sub_random_values.add(new PointF(radius, angle));
                                	}
                                    PointF randp = this.sub_random_values.get(index);
                                    float radius = randp.x;
                                    float angle = randp.y;
                                    float fx = (float) (4*SUB_DOT_SIDE_LENGTH_FINAL_VALUE + radius*(1-(count - (20+loop*90))/25.0) * SUB_DOT_SIDE_LENGTH_FINAL_VALUE *Math.cos(angle*(1-(count - (20+loop*90))/25.0) / 180.0f * 340.0f)+x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                    float fy = (float) (1*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+radius*(1-(count - (20+loop*90))/25.0) * SUB_DOT_SIDE_LENGTH_FINAL_VALUE *Math.sin(angle*(1-(count - (20+loop*90))/25.0) / 180.0f * 340.0f)+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                    this.sub_dot_positions.add(new PointF(fx, fy));
                                    index++;
                                }
                            }
                        }
                        System.out.println(megahits.length + "length"+count+"count");
                        if(this.megahits[loop] == 1){
                            index = 0;
                            for(int y = 0;y<8;y++){
                                for(int x =0;x<8;x++){
                                    if(attack_data.charAt(y*8+x) == '0'){
                                        if(this.sub_random_values.size() == index){
                                        	int angle = (int) (Math.random()*720);
                                            angle-=360;
                                            int radius = (int) (Math.random()*100);
                                            radius -= 50;
                                            this.sub_random_values.add(new PointF(radius, angle));
                                        }
                                        PointF randp = this.sub_random_values.get(index);
                                        float radius = randp.x;
                                        float angle = randp.y;
                                        float fx = (float) (4*SUB_DOT_SIDE_LENGTH_FINAL_VALUE + radius*(1-(count - (20+loop*45))/25.0) * SUB_DOT_SIDE_LENGTH_FINAL_VALUE *Math.cos(angle*(1-(count - (20+loop*45))/25.0) / 180.0f * 340.0f)+x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                        float fy = (float) (11*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+radius*(1-(count - (20+loop*45))/25.0) * SUB_DOT_SIDE_LENGTH_FINAL_VALUE *Math.sin(angle*(1-(count - (20+loop*45))/25.0) / 180.0f * 340.0f)+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                        this.sub_dot_positions.add(new PointF(fx, fy));
                                        index++;
                                    }
                                }
                            }
                        }
                    }
                    else if(count <55+loop*90){
                        this.dot_positions.clear();
                        this.sub_dot_positions.clear();
                        for(int y = 0;y<68;y+=2){
                            for(int x =0;x<52;x+=2){
                                if(this.dot_pattern.get(y*52+x)){
                                    float fx = 51*DOT_SIDE_LENGTH_FINAL_VALUE + x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    this.dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                        for(int y = 0;y<8;y++){
                            for(int x =0;x<8;x++){
                                if(attack_data.charAt(y*8+x) == '0'){
                                    float fx = 4*SUB_DOT_SIDE_LENGTH_FINAL_VALUE-(count - (45+loop*90))*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+ x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy = 1*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                    if(fx >= 0){
                                        this.sub_dot_positions.add(new PointF(fx, fy));
                                    }
                                }
                            }
                        }
                        if(this.enemy_megahits.get(loop) == true){
                            for(int y = 0;y<8;y++){
                                for(int x =0;x<8;x++){
                                    if(attack_data.charAt(y*8+x) == '0'){
                                        float fx = 4*SUB_DOT_SIDE_LENGTH_FINAL_VALUE-(count - (45+loop*90))*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+ x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                        float fy = 11*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                        if(fx >= 0){
                                            this.sub_dot_positions.add(new PointF(fx, fy));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else if(count <75+loop*90){
                        this.dot_positions.clear();
                        this.sub_dot_positions.clear();
                        String enemy_attack = this.loadAttackDot(this.enemy_attack_type);
                        for(int y = 0;y<68;y+=2){
                            for(int x =0;x<52;x+=2){
                                if(this.dot_pattern.get(y*52+x)){
                                    float fx = 51*DOT_SIDE_LENGTH_FINAL_VALUE + x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    this.dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                        for(int y = 0;y<8;y++){
                            for(int x =0;x<8;x++){
                                if(enemy_attack.charAt(8*y+x) == '0'){
                                    float fx = (count - (55+loop*90))*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+ (8-x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy = 1*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                    if(fx >= 0){
                                        this.sub_dot_positions.add(new PointF(fx, fy));
                                    }
                                }
                            }
                        }
                        if(this.megahits[loop] == 1){
                            for(int y = 0;y<8;y++){
                                for(int x =0;x<8;x++){
                                    if(enemy_attack.charAt(y*8+x) == '0'){
                                        float fx = (count - (55+loop*90))*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+ (8-x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                        float fy = 11*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                        if(fx >= 0){
                                            this.sub_dot_positions.add(new PointF(fx, fy));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else if(count < 90+loop*90){
                        if(this.hit_pattern.get(loop) == true){
                            this.dot_positions.clear();
                            this.sub_dot_positions.clear();
                            if((count >= 78+loop*90 && count < 81+loop*90)|| (count >= 84+loop*90 && count < 87+loop*90)){
                                String dotdata="11101111111110011111011111111111001111101110011111110101111010111111110101011000111010111110110111011101100100010110011000001100000111010011111001101100111011011011111111111110111111111111111111111101110111111111111111111111111111111111101111101111111111110000000111111111111110111101111111111110000000001111111111110111101111111111111011101110111111111110111101111111111111101110111011111111111101110011111111111110000000001111111111111001110111111111111100010001111111111111111011101111111111110000000111111111111111011111011111111110101010101111111111111011111101111111111111111111111111111111011111101111111111111111111111111111111110111101111101011101111111111111111110111011101111001010101001110111010111100100110101110011111001111010100010101001111100100000111111111111110111111111011111111100";
                                for(int y = 0;y<20;y++){
                                    for(int x = 0;x<40;x++){
                                        if(dotdata.charAt(y*40+x) == '0'){
                                            this.sub_dot_positions.add(new PointF(x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                                        }
                                    }
                                }
                            }
                            else if((count >= 75+loop*90 && count < 78+loop*90) || (count >= 81+loop*90 && count < 84+loop*90) || (count >= 87+loop*90)){
                                String dotdata="11101111111110011111011111111111001111101110011111110001111000111111110100011000111000111110000111000001100100010000000000000000000000010000000000000000000000011000000000000000000000000000000000000001110000000000000000000000000000000000001111100000000000000000000000000000000000111100000000000000111111100000000000000111100000000000000100010001000000000000111100000000000000010001000100000000000001110000000000000001111111110000000000000001110000000000000011101110000000000000000011100000000000001111111000000000000000011111000000000001010101010000000000000011111100000000000000000000000000000000011111100000000000000000000000000000000000111100000000000000000000000000000000000011100000001010001000000000000000000100000100000011111001111000100010100001111100100000111111110111110111111111011111111100";
                                for(int y = 0;y<20;y++){
                                    for(int x = 0;x<40;x++){
                                        if(dotdata.charAt(y*40+x) == '0'){
                                            this.sub_dot_positions.add(new PointF(x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                                        }
                                    }
                                }
                            }
                        }
                        else{
                            this.dot_positions.clear();
                            for(int y = 0;y<68;y+=2){
                                for(int x =0;x<52;x+=2){
                                    if(this.dot_pattern.get(y*52+x)){
                                        float fx = 51*DOT_SIDE_LENGTH_FINAL_VALUE +(50-x)*DOT_SIDE_LENGTH_FINAL_VALUE;
                                        float fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                        this.dot_positions.add(new PointF(fx, fy));
                                    }
                                }
                            }
                        }
                    }
                    else if(count < 110+loop*90){
                        this.dot_positions.clear();
                        this.sub_dot_positions.clear();
                        this.dot_positions.clear();
                        for(int y = 0;y<68;y+=2){
                            for(int x =0;x<52;x+=2){
                                if(this.dot_pattern.get(y*52+x)){
                                    float fx = 51*DOT_SIDE_LENGTH_FINAL_VALUE +(x)*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    this.dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                    }
                }
            }
			//reaction
            else if(status == 10311){
                if(count <= 120){
                    int loop = count / 40;
                    int ecounter = count - 40*loop;
                    if(ecounter == 1){
                        this.dot_positions.clear();
                        this.sub_dot_positions.clear();
                        for(int y = 0;y<68;y+=2){
                            for(int x =0;x<52;x+=2){
                                if(this.dot_pattern.get(y*52+x) == true){
                                    float fx = x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy;
                                    if(this.reaction == true){
                                        fy = (float) (0.2*52*DOT_SIDE_LENGTH_FINAL_VALUE+ y*DOT_SIDE_LENGTH_FINAL_VALUE*0.8);
                                    }
                                    else{
                                        fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    }
                                    this.dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                    }
                    else if(ecounter == 20){
                        this.dot_positions.clear();
                        this.sub_dot_positions.clear();
                        for(int y = 0;y<68;y+=2){
                            for(int x =0;x<52;x+=2){
                                
                                if(this.dot_pattern.get(y*52+x)){
                                    float fx = x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy;
                                    if(this.reaction == true){
                                        fy = (float) (0.2*52*DOT_SIDE_LENGTH_FINAL_VALUE+ y*DOT_SIDE_LENGTH_FINAL_VALUE*0.8);
                                    }
                                    else{
                                        fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    }
                                    this.dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                        String dotdata = null;
                        if(this.reaction == true){
                            dotdata = "1111011110111101111001110101101011011011111001111011111011101011";
                        }
                        else{
                            dotdata = "1011110110000000000000000100100001001100001000001000001110100101";
                        }
                        for(int y = 0;y<8;y++){
                            for(int x = 0;x<8;x++){
                                if(dotdata.charAt(y*8+x) == '0'){
                                    float fx1 = (4+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fx2 = (26+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy = y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                    this.sub_dot_positions.add(new PointF(fx1, fy));
                                    this.sub_dot_positions.add(new PointF(fx2, fy));
                                }
                            }
                        }
                    }
                }
                else if(count <= 150){
                    this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    for(int y = 0;y<68;y+=2){
                        for(int x =0;x<52;x+=2){
                            if(this.dot_pattern.get(y*52+x)){
                                float fx = x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                float fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                this.dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                }
            }
            else if(status == 10501){
                float wave_position = 0.5f*count;
                if(count <= 100){
                    this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    String dotdata = "11000001111111111111111111111111111111111000001111111111111111111111111111111111000001111111111111111111111111111111111110000011111111111111111111111111111111111100000111111111111111111111111111111111111000001111111111111111111111111111111111000001111111111111111111111111111111111000001111111111111111111111111111111111000001111111111111111111111111111111111110000011111111111111111111111111111111111100000111111111111111111111111111111111111000001111111111111111111111111111111111000001111111111111111111111111111111111000001111111111111111111111111111111111000001111111111111111111111111111111111110000011111111111111111111111111111111111100000111111111111111111111111111111111111000001111111111111111111111111111111111000001111111111111111111111111111111111000001111111111111111111111111111111111";
                    for(int y = 0;y<20;y++){
                        for(int x = 0;x<40;x++){
                            if(dotdata.charAt(y*40+x) == '0'){
                                float check = 40 - wave_position + x;
                                float fx = (40-wave_position+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                float fy = y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                if(check >=0 && check <= 40){
                                    this.sub_dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                    }
                    for(int i = 0;i< this.number_of_unko;i++){
                        int x0 = 0,y0 = 0;
                        if(i == 0){
                            x0 = 31;
                            y0 = 11;
                        }
                        else if(i == 1){
                            x0 = 31;
                            y0 = 1;
                        }
                        else if(i == 2){
                            x0 = 21;
                            y0 = 11;
                        }
                        else if(i == 3){
                            x0 = 21;
                            y0 = 1;
                        }
                        else if( i == 4){
                            x0 = 11;
                            y0 = 11;
                        }
                        else if(i == 5){
                            x0 = 11;
                            y0 = 1;
                        }
                        else if(i == 6){
                            x0 = 1;
                            y0 = 11;
                        }
                        else if(i == 7){
                            x0 = 1;
                            y0 = 1;
                        }
                        dotdata = "0111111110111101011101101110010111000011101000010100000000000000";
                        for(int y = 0;y<8;y++){
                            for(int x = 0;x<8;x++){
                                if(dotdata.charAt(y*8+x)=='0'){
                                    float fx = SUB_DOT_SIDE_LENGTH_FINAL_VALUE*(x + x0);
                                    float fy = SUB_DOT_SIDE_LENGTH_FINAL_VALUE*(y + y0);
                                    if(fx <= (45 - wave_position)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE){
                                        this.sub_dot_positions.add(new PointF(fx, fy));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else if(status == 10502){
                if(count <= 120){
                    int loop = count / 40;
                    int ecounter = count - 40*loop;
                    if(ecounter == 1){
                        this.dot_positions.clear();
                        this.sub_dot_positions.clear();
                        for(int y = 0;y<68;y+=2){
                            for(int x =0;x<52;x+=2){
                                if(this.dot_pattern.get(y*52+x) == true){
                                    float fx = x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy;
                                    if(this.reaction == true){
                                        fy = (float) (0.2*52*DOT_SIDE_LENGTH_FINAL_VALUE+ y*DOT_SIDE_LENGTH_FINAL_VALUE*0.8);
                                    }
                                    else{
                                        fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    }
                                    this.dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                    }
                    else if(ecounter == 20){
                        this.dot_positions.clear();
                        this.sub_dot_positions.clear();
                        for(int y = 0;y<68;y+=2){
                            for(int x =0;x<52;x+=2){
                                
                                if(this.dot_pattern.get(y*52+x)){
                                    float fx = x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy;
                                    if(this.reaction == true){
                                        fy = (float) (0.2*52*DOT_SIDE_LENGTH_FINAL_VALUE+ y*DOT_SIDE_LENGTH_FINAL_VALUE*0.8);
                                    }
                                    else{
                                        fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    }
                                    this.dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                        String dotdata = null;
                        if(this.reaction == true){
                            dotdata = "1111011110111101111001110101101011011011111001111011111011101011";
                        }
                        else{
                            dotdata = "1011110110000000000000000100100001001100001000001000001110100101";
                        }
                        for(int y = 0;y<8;y++){
                            for(int x = 0;x<8;x++){
                                if(dotdata.charAt(y*8+x) == '0'){
                                    float fx1 = (4+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fx2 = (26+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy = y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                    this.sub_dot_positions.add(new PointF(fx1, fy));
                                    this.sub_dot_positions.add(new PointF(fx2, fy));
                                }
                            }
                        }
                    }
                }
                else if(count <= 150){
                    this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    for(int y = 0;y<68;y+=2){
                        for(int x =0;x<52;x+=2){
                            if(this.dot_pattern.get(y*52+x)){
                                float fx = x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                float fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                this.dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                }
            }
            else if(status == 10601){
                if(count == 1){
                    this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    String dotdata = "11111111111111111111111111111111111111111111111111110011011011111111111111111111111111111110110101101111111111111111111111111111111011010010111111111111111111111111111111101101010011111111111111111111111111111110110101101111111111111111111111111111111011010110111111111111111111111111111111110011011011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100110000100001111111111111111111111111101101011110111111111111111111111111111110110101111011111111111111111111111111111011010001100011111111111111111111111111101101011110111111111111111111111111111110110101111011111111111111111111111111111100110111101111111111111111111111111111111111111111111111111111111111";
                    for(int y = 0;y<20;y++){
                        for(int x = 0;x<40;x++){
                            if(dotdata.charAt(y*40+x) == '0'){
                                this.sub_dot_positions.add(new PointF(x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                    String arrow_dot = "1110111111001100000010000000000000111100111110111";
                    for(int y = 0;y<7;y++){
                        for(int x = 0;x<7;x++){
                            if(arrow_dot.charAt(y*7+x) == '0'){
                                this.sub_dot_positions.add(new PointF((x+3)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, (y+1)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                }
            }
            else if(status == 10602){
                if(count == 1){
                    this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    String dotdata = "11111111111111111111111111111111111111111111111111110011011011111111111111111111111111111110110101101111111111111111111111111111111011010010111111111111111111111111111111101101010011111111111111111111111111111110110101101111111111111111111111111111111011010110111111111111111111111111111111110011011011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100110000100001111111111111111111111111101101011110111111111111111111111111111110110101111011111111111111111111111111111011010001100011111111111111111111111111101101011110111111111111111111111111111110110101111011111111111111111111111111111100110111101111111111111111111111111111111111111111111111111111111111";
                    for(int y = 0;y<20;y++){
                        for(int x = 0;x<40;x++){
                            if(dotdata.charAt(y*40+x) == '0'){
                                this.sub_dot_positions.add(new PointF(x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                    String arrow_dot = "1110111111001100000010000000000000111100111110111";
                    for(int y = 0;y<7;y++){
                        for(int x = 0;x<7;x++){
                            if(arrow_dot.charAt(y*7+x) == '0'){
                                this.sub_dot_positions.add(new PointF((x+3)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, (y+12)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                }
            }
            else if(status == 10701){
                if(count == 1){
                    this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    String dotdata = "11111111111111000001111111111111111111111111111111111011111011111111111111111111111111111111011111110111111111111111111111111111111101010101011111111111111111111111111111110111111101111111111111111111111111111111101111101111111111111111111111111111111111010001111111111111111111111111111111111100111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111101111111111111111111111111111111111111110111101111111111111111111111111111111111000000011111111111111111111111111111111000000001111111111111111111111111111111101001000111111111111111111111111111111110100110011111111111111111111111111111111001000001111111111111111111111111111111110000011111111111111111111111111111111111010010111111111111111111111";
                    for(int y = 0;y<20;y++){
                        for(int x = 0;x<40;x++){
                            if(dotdata.charAt(y*40+x) == '0'){
                                this.sub_dot_positions.add(new PointF(x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                    String arrow_dot = "1110111111001100000010000000000000111100111110111";
                    for(int y = 0;y<7;y++){
                        for(int x = 0;x<7;x++){
                            if(arrow_dot.charAt(y*7+x) == '0'){
                                this.sub_dot_positions.add(new PointF((x+3)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, (y+1)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                }
            }
            else if(status == 10702){
                if(count == 1){
                    this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    String dotdata = "11111111111111000001111111111111111111111111111111111011111011111111111111111111111111111111011111110111111111111111111111111111111101010101011111111111111111111111111111110111111101111111111111111111111111111111101111101111111111111111111111111111111111010001111111111111111111111111111111111100111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111101111111111111111111111111111111111111110111101111111111111111111111111111111111000000011111111111111111111111111111111000000001111111111111111111111111111111101001000111111111111111111111111111111110100110011111111111111111111111111111111001000001111111111111111111111111111111110000011111111111111111111111111111111111010010111111111111111111111";
                    for(int y = 0;y<20;y++){
                        for(int x = 0;x<40;x++){
                            if(dotdata.charAt(y*40+x) == '0'){
                                this.sub_dot_positions.add(new PointF(x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                    String arrow_dot = "1110111111001100000010000000000000111100111110111";
                    for(int y = 0;y<7;y++){
                        for(int x = 0;x<7;x++){
                            if(arrow_dot.charAt(y*7+x) == '0'){
                                this.sub_dot_positions.add(new PointF((x+3)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE, (y+12)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE));
                            }
                        }
                    }
                }
            }
            else if(status == 10703){
				String meet_dotdata = "1000111101100111010110110001010110111100110100101110011011110001";
				////System.out.println(count+"");
                if(count == 1){
                    this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    this.random_values.clear();
                    this.sub_random_values.clear();
                    for(int y = 0;y<68;y+=2){
                        for(int x = 0;x < 52;x+=2){
                            if(this.dot_pattern.get(y*52+x) == true){
                                int angle = (int) (Math.random()*720);
                                angle-=360;
                                int radius = (int) (Math.random()*200);
                                radius -= 100;
                                this.random_values.add(new PointF(radius, angle));
                                
                                float fx = (float) (51*SUB_DOT_SIDE_LENGTH_FINAL_VALUE + radius * DOT_SIDE_LENGTH_FINAL_VALUE * Math.cos(angle / 180.0 * 3.14)+x*DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) (radius * DOT_SIDE_LENGTH_FINAL_VALUE * Math.sin(angle / 180.0 * 3.14)+y*DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                    for(int y = 0;y<8;y++){
                        for(int x = 0;x<8;x++){
                            if(meet_dotdata.charAt(y*8+x) == '0'){
                                int angle = (int) (Math.random()*720);
                                angle-=360;
                                int radius = (int) (Math.random()*100);
                                radius -= 50;
                                this.sub_random_values.add(new PointF(radius, angle));
                                
                                float fx = (float) (4*SUB_DOT_SIDE_LENGTH_FINAL_VALUE + radius * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.cos(angle / 180.0f* 340.0f)+x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) (5*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+radius * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.sin(angle / 180.0f* 340.0f)+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.sub_dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                }
                else if(count <= 20){
                    this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    int index = 0;
                    for(int y = 0;y<68;y+=2){
                        for(int x =0;x<52;x+=2){
                            if(this.dot_pattern.get(y*52+x)){
                            	if(this.random_values.size() == index){
                            		int angle = (int) (Math.random()*720);
                                    angle-=360;
                                    int radius = (int) (Math.random()*200);
                                    radius -= 100;
                                    this.random_values.add(new PointF(radius, angle));
                            	}
                                PointF rpoint = this.random_values.get(index);
                                float fx = (float) (51*DOT_SIDE_LENGTH_FINAL_VALUE +(1.0-count/20.0)*rpoint.x * DOT_SIDE_LENGTH_FINAL_VALUE * Math.cos((1.0-count/20.0)*rpoint.y/180.0*3.14)+x*DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) ((1.0-count/20.0)*rpoint.x * DOT_SIDE_LENGTH_FINAL_VALUE * Math.sin((1.0-count/20.0)*rpoint.y/180.0*3.14)+y*DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.dot_positions.add(new PointF(fx, fy));
                                index++;
                            }
                        }
                    }
                    index = 0;
                    for(int y = 0;y<8;y++){
                        for(int x = 0;x<8;x++){
                            boolean check = (meet_dotdata.charAt(y*8+x) == '0');
                            if(check){
                            	if(this.sub_random_values.size() == index){
                            		if(meet_dotdata.charAt(y*8+x) == '0'){
                                        int angle = (int) (Math.random()*720);
                                        angle-=360;
                                        int radius = (int) (Math.random()*100);
                                        radius -= 50;
                                        this.sub_random_values.add(new PointF(radius, angle));
                                    }
                            	}
                                PointF rpoint = this.sub_random_values.get(index);
                                float fx = (float) (4*SUB_DOT_SIDE_LENGTH_FINAL_VALUE +(1.0-count/20.0)*rpoint.x * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.cos((1.0-count/20.0)*rpoint.y/180.0*3.14)+x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) (5*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+(1.0-count/20.0)*rpoint.x * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.sin((1.0-count/20.0)*rpoint.y/180.0*3.14)+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.sub_dot_positions.add(new PointF(fx, fy));
                                index++;
                            }
                        }
                    }
                }
                else if(count <= 30){
                    
                }
                else if(count <= 55){
                    this.sub_dot_positions.clear();
                    int index = 0;
                    for(int y = 0;y<8;y++){
                        for(int x = 0;x<8;x++){
                            boolean check = (meet_dotdata.charAt(y*8+x) == '0');
                            if(check){
                            	if(this.sub_random_values.size() == index){
                            		if(meet_dotdata.charAt(y*8+x) == '0'){
                                        int angle = (int) (Math.random()*720);
                                        angle-=360;
                                        int radius = (int) (Math.random()*100);
                                        radius -= 50;
                                        this.sub_random_values.add(new PointF(radius, angle));
                                    }
                            	}
                                PointF rpoint = this.sub_random_values.get(index);
                                float fx = (float) (((6*(count-30)/25.0)+4)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE +((count-30)/25.0)*rpoint.x * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.cos(((count-30)/25.0)*rpoint.y/180.0*3.14)+x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) (5*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+((count-30)/25.0)*rpoint.x * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.sin(((count-30)/25.0)*rpoint.y/180.0*3.14)+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.sub_dot_positions.add(new PointF(fx, fy));
                                index++;
                            }
                        }
                    }
                }
                else if(count < 80){
                    this.sub_dot_positions.clear();
                    int index = 0;
                    for(int y = 0;y<8;y++){
                        for(int x = 0;x<8;x++){
                            boolean check = (meet_dotdata.charAt(y*8+x) == '0');
                            if(check){
                            	if(this.sub_random_values.size() == index){
                            		if(meet_dotdata.charAt(y*8+x) == '0'){
                                        int angle = (int) (Math.random()*720);
                                        angle-=360;
                                        int radius = (int) (Math.random()*100);
                                        radius -= 50;
                                        this.sub_random_values.add(new PointF(radius, angle));
                                    }
                            	}
                                PointF rpoint = this.sub_random_values.get(index);
                                float fx = (float) (((20.0*(count-55)/25.0)+4)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE +(1-(count-55)/25.0)*rpoint.x * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.cos((1-(count-55)/25.0)*rpoint.y/180.0*3.14)+x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) (5*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+(1-(count-55)/25.0)*rpoint.x * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.sin((1-(count-55)/25.0)*rpoint.y/180.0*3.14)+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.sub_dot_positions.add(new PointF(fx, fy));
                                index++;
                            }
                        }
                    }
                }
                else if(count <90){
                    this.sub_dot_positions.clear();
                }
			}
            else if(status == 10705){
				String meet_dotdata = "1111111101111111000000010111110101111100010101010000000101111111";
				//System.out.println(count+"");
                if(count == 1){
                    this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    this.random_values.clear();
                    this.sub_random_values.clear();
                    for(int y = 0;y<68;y+=2){
                        for(int x = 0;x < 52;x+=2){
                            if(this.dot_pattern.get(y*52+x) == true){
                                int angle = (int) (Math.random()*720);
                                angle-=360;
                                int radius = (int) (Math.random()*200);
                                radius -= 100;
                                this.random_values.add(new PointF(radius, angle));
                                
                                float fx = (float) (51*SUB_DOT_SIDE_LENGTH_FINAL_VALUE + radius * DOT_SIDE_LENGTH_FINAL_VALUE * Math.cos(angle / 180.0 * 3.14)+x*DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) (radius * DOT_SIDE_LENGTH_FINAL_VALUE * Math.sin(angle / 180.0 * 3.14)+y*DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                    for(int y = 0;y<8;y++){
                        for(int x = 0;x<8;x++){
                            if(meet_dotdata.charAt(y*8+x) == '0'){
                                int angle = (int) (Math.random()*720);
                                angle-=360;
                                int radius = (int) (Math.random()*100);
                                radius -= 50;
                                this.sub_random_values.add(new PointF(radius, angle));
                                
                                float fx = (float) (4*SUB_DOT_SIDE_LENGTH_FINAL_VALUE + radius * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.cos(angle / 180.0f* 340.0f)+x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) (5*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+radius * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.sin(angle / 180.0f* 340.0f)+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.sub_dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                }
                else if(count <= 20){
                    this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    int index = 0;
                    for(int y = 0;y<68;y+=2){
                        for(int x =0;x<52;x+=2){
                            if(this.dot_pattern.get(y*52+x)){
                            	if(this.random_values.size() == index){
                            		int angle = (int) (Math.random()*720);
                                    angle-=360;
                                    int radius = (int) (Math.random()*200);
                                    radius -= 100;
                                    this.random_values.add(new PointF(radius, angle));
                            	}
                                PointF rpoint = this.random_values.get(index);
                                float fx = (float) (51*DOT_SIDE_LENGTH_FINAL_VALUE +(1.0-count/20.0)*rpoint.x * DOT_SIDE_LENGTH_FINAL_VALUE * Math.cos((1.0-count/20.0)*rpoint.y/180.0*3.14)+x*DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) ((1.0-count/20.0)*rpoint.x * DOT_SIDE_LENGTH_FINAL_VALUE * Math.sin((1.0-count/20.0)*rpoint.y/180.0*3.14)+y*DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.dot_positions.add(new PointF(fx, fy));
                                index++;
                            }
                        }
                    }
                    index = 0;
                    for(int y = 0;y<8;y++){
                        for(int x = 0;x<8;x++){
                            boolean check = (meet_dotdata.charAt(y*8+x) == '0');
                            if(check){
                            	if(this.sub_random_values.size() == index){
                            		if(meet_dotdata.charAt(y*8+x) == '0'){
                                        int angle = (int) (Math.random()*720);
                                        angle-=360;
                                        int radius = (int) (Math.random()*100);
                                        radius -= 50;
                                        this.sub_random_values.add(new PointF(radius, angle));
                                    }
                            	}
                                PointF rpoint = this.sub_random_values.get(index);
                                float fx = (float) (4*SUB_DOT_SIDE_LENGTH_FINAL_VALUE +(1.0-count/20.0)*rpoint.x * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.cos((1.0-count/20.0)*rpoint.y/180.0*3.14)+x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) (5*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+(1.0-count/20.0)*rpoint.x * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.sin((1.0-count/20.0)*rpoint.y/180.0*3.14)+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.sub_dot_positions.add(new PointF(fx, fy));
                                index++;
                            }
                        }
                    }
                }
                else if(count <= 30){
                    
                }
                else if(count <= 55){
                    this.sub_dot_positions.clear();
                    int index = 0;
                    for(int y = 0;y<8;y++){
                        for(int x = 0;x<8;x++){
                            boolean check = (meet_dotdata.charAt(y*8+x) == '0');
                            if(check){
                            	if(this.sub_random_values.size() == index){
                            		if(meet_dotdata.charAt(y*8+x) == '0'){
                                        int angle = (int) (Math.random()*720);
                                        angle-=360;
                                        int radius = (int) (Math.random()*100);
                                        radius -= 50;
                                        this.sub_random_values.add(new PointF(radius, angle));
                                    }
                            	}
                                PointF rpoint = this.sub_random_values.get(index);
                                float fx = (float) (((6*(count-30)/25.0)+4)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE +((count-30)/25.0)*rpoint.x * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.cos(((count-30)/25.0)*rpoint.y/180.0*3.14)+x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) (5*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+((count-30)/25.0)*rpoint.x * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.sin(((count-30)/25.0)*rpoint.y/180.0*3.14)+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.sub_dot_positions.add(new PointF(fx, fy));
                                index++;
                            }
                        }
                    }
                }
                else if(count < 80){
                    this.sub_dot_positions.clear();
                    int index = 0;
                    for(int y = 0;y<8;y++){
                        for(int x = 0;x<8;x++){
                            boolean check = (meet_dotdata.charAt(y*8+x) == '0');
                            if(check){
                                PointF rpoint = this.sub_random_values.get(index);
                                float fx = (float) (((20.0*(count-55)/25.0)+4)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE +(1-(count-55)/25.0)*rpoint.x * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.cos((1-(count-55)/25.0)*rpoint.y/180.0*3.14)+x*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                float fy = (float) (5*SUB_DOT_SIDE_LENGTH_FINAL_VALUE+(1-(count-55)/25.0)*rpoint.x * SUB_DOT_SIDE_LENGTH_FINAL_VALUE * Math.sin((1-(count-55)/25.0)*rpoint.y/180.0*3.14)+y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE);
                                this.sub_dot_positions.add(new PointF(fx, fy));
                                index++;
                            }
                        }
                    }
                }
                else if(count <90){
                    this.sub_dot_positions.clear();
                }
			}
            else if(status == 10408){
                if(count <= 120){
                    int loop = count / 40;
                    int ecounter = count - 40*loop;
                    if(ecounter == 1){
                        this.dot_positions.clear();
                        this.sub_dot_positions.clear();
                        for(int y = 0;y<68;y+=2){
                            for(int x =0;x<52;x+=2){
                                if(this.dot_pattern.get(y*52+x) == true){
                                    float fx = x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy;
                                    if(this.reaction == true){
                                        fy = (float) (0.2*52*DOT_SIDE_LENGTH_FINAL_VALUE+ y*DOT_SIDE_LENGTH_FINAL_VALUE*0.8);
                                    }
                                    else{
                                        fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    }
                                    this.dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                    }
                    else if(ecounter == 20){
                        this.dot_positions.clear();
                        this.sub_dot_positions.clear();
                        for(int y = 0;y<68;y+=2){
                            for(int x =0;x<52;x+=2){
                                
                                if(this.dot_pattern.get(y*52+x)){
                                    float fx = x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy;
                                    if(this.reaction == true){
                                        fy = (float) (0.2*52*DOT_SIDE_LENGTH_FINAL_VALUE+ y*DOT_SIDE_LENGTH_FINAL_VALUE*0.8);
                                    }
                                    else{
                                        fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                    }
                                    this.dot_positions.add(new PointF(fx, fy));
                                }
                            }
                        }
                        String dotdata = null;
                        if(this.reaction == true){
                            dotdata = "1111011110111101111001110101101011011011111001111011111011101011";
                        }
                        else{
                            dotdata = "1011110110000000000000000100100001001100001000001000001110100101";
                        }
                        for(int y = 0;y<8;y++){
                            for(int x = 0;x<8;x++){
                                if(dotdata.charAt(y*8+x) == '0'){
                                    float fx1 = (4+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fx2 = (26+x)*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                    float fy = y*SUB_DOT_SIDE_LENGTH_FINAL_VALUE;
                                    this.sub_dot_positions.add(new PointF(fx1, fy));
                                    this.sub_dot_positions.add(new PointF(fx2, fy));
                                }
                            }
                        }
                    }
                }
                else if(count <= 150){
                    this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    for(int y = 0;y<68;y+=2){
                        for(int x =0;x<52;x+=2){
                            if(this.dot_pattern.get(y*52+x)){
                                float fx = x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                float fy = y*DOT_SIDE_LENGTH_FINAL_VALUE;
                                this.dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                }
            }
            else if(status == 10900){
                if(count == 1 || count == 30 || count == 60){
                    this.dot_positions.clear();
                    this.sub_dot_positions.clear();
                    for(int y = 0;y<68;y+=2){
                        for(int x =0;x<52;x+=2){
                            if(this.dot_pattern.get(y*52+x) == true){
                                float fx = x*DOT_SIDE_LENGTH_FINAL_VALUE;
                                float fy = 0.2f*52*DOT_SIDE_LENGTH_FINAL_VALUE+ y*DOT_SIDE_LENGTH_FINAL_VALUE*0.8f;
                                this.dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                }
                else if(count == 15 || count == 45 || count == 75){
                    this.dot_positions.clear();
                    for(int y = 0;y<68;y+=2){
                        for(int x =0;x<52;x+=2){
                            if(this.dot_pattern.get(y*52+x) == true){
                                float fx = (52-x)*DOT_SIDE_LENGTH_FINAL_VALUE;
                                float fy = 0.2f*52*DOT_SIDE_LENGTH_FINAL_VALUE+ y*DOT_SIDE_LENGTH_FINAL_VALUE*0.8f;
                                this.dot_positions.add(new PointF(fx, fy));
                            }
                        }
                    }
                }
            }

		}
		else if(count == 0){
            this.dot_positions.clear();
            this.sub_dot_positions.clear();
		}
	}

	public String toString() {
		return super.toString() +"living??:"+this.is_living+":"+this.digimon_id;
	}

	public void writeToXml(XmlSerializer serializer) throws IllegalArgumentException, IllegalStateException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		serializer.startTag(null, "digimon");
		this.writeElementToSerializer(serializer,"isLiving",this.is_living);
		this.writeElementToSerializer(serializer, "dm", this.dm);
		this.writeElementToSerializer(serializer, "weight", this.weight);
		this.writeElementToSerializer(serializer, "hungry", this.hungry);
		this.writeElementToSerializer(serializer,"strength",this.strength);
		this.writeElementToSerializer(serializer,"number_of_unko",this.number_of_unko);
		this.writeElementToSerializer(serializer,"dp",this.dp);
		this.writeElementToSerializer(serializer,"dp_half",this.dp_half);
		this.writeElementToSerializer(serializer,"battle_count",this.battle_count);
		this.writeElementToSerializer(serializer,"win_count",this.win_count);
		this.writeElementToSerializer(serializer,"type",this.type);
		this.writeElementToSerializer(serializer,"battle_enable",this.battle_enable);
		this.writeElementToSerializer(serializer,"jogress_enable",this.jogress_enable);
		this.writeElementToSerializer(serializer,"is_sleeping",this.is_sleeping);
		this.writeElementToSerializer(serializer,"light_on",this.is_light_on);
		this.writeElementToSerializer(serializer,"is_egg",this.is_egg);
		this.writeElementToSerializer(serializer,"egg_id",this.egg_id);
		this.writeElementToSerializer(serializer,"is_sick",this.is_sick);
		this.writeElementToSerializer(serializer,"is_injured",this.is_injured);
		this.writeElementToSerializer(serializer,"attack_type",this.attack_type);
		this.writeElementToSerializer(serializer,"is_calling",this.is_calling);
		this.writeElementToSerializer(serializer,"digimon_id",this.digimon_id);
		this.writeElementToSerializer(serializer,"level",this.level);
		this.writeElementToSerializer(serializer,"protein_count",this.protein_count);
		this.writeElementToSerializer(serializer,"min_weight",this.min_weight);
		this.writeElementToSerializer(serializer,"max_eat",this.max_eat);
		this.writeElementToSerializer(serializer,"max_dp",this.max_dp);
		this.writeElementToSerializer(serializer,"potential_power",this.potential_power);
		this.writeElementToSerializer(serializer,"actual_power",this.actual_power);
		this.writeElementToSerializer(serializer,"hidden_power",this.hidden_power);
		this.writeElementToSerializer(serializer,"hidden_power_rate",this.hidden_power_rate);
		this.writeElementToSerializer(serializer,"health",this.health);
		this.writeElementToSerializer(serializer,"health_check_interval_minutes",this.health_check_interval_minutes);
		this.writeElementToSerializer(serializer,"health_check_elapsed_minutes",this.health_check_elapsed_minutes);
		this.writeElementToSerializer(serializer,"hungry_elapsed_minutes",this.hungry_elapsed_minutes);
		this.writeElementToSerializer(serializer,"hungry_interval_minutes",this.hungry_interval_minutes);
		this.writeElementToSerializer(serializer,"hungry_death_minutes",this.hungry_death_minutes);
		this.writeElementToSerializer(serializer,"strength_elapsed_minutes",this.strength_elapsed_minutes);
		this.writeElementToSerializer(serializer,"strength_interval_minutes",this.strength_interval_minutes);
		this.writeElementToSerializer(serializer,"strength_death_minutes",this.strength_death_minutes);
		this.writeElementToSerializer(serializer,"slept_time",this.slept_time);
		this.writeElementToSerializer(serializer,"wokeup_time",this.wokeup_time);
		this.writeElementToSerializer(serializer,"sleep_time",this.sleep_time);
		this.writeElementToSerializer(serializer,"wakeup_time",this.wakeup_time);
		this.writeElementToSerializer(serializer,"unko_interval_minutes",this.unko_interval_minutes);
		this.writeElementToSerializer(serializer,"unko_elapsed_minutes",this.unko_elapsed_minutes);
		this.writeElementToSerializer(serializer,"life",this.life);
		this.writeElementToSerializer(serializer,"progress_counter",this.progress_counter);
		this.writeElementToSerializer(serializer,"reaction",this.reaction);
		this.writeElementToSerializer(serializer,"lifetime",this.lifetime);
		this.writeElementToSerializer(serializer,"body_color_type",this.frame.getBody_color_type());
		this.writeElementToSerializer(serializer,"frame_color_type",this.frame.getFrame_color_type());
		this.writeElementToSerializer(serializer,"button_color_type",this.frame.getButton_color_type());
		this.writeElementToSerializer(serializer,"offline_battle_count",this.offline_battle_count);
		this.writeElementToSerializer(serializer,"pendulum_type",this.pendulum_type);
		serializer.endTag(null, "digimon");
	}
	private void writeElementToSerializer(XmlSerializer serializer,
			String tag_name, float value) throws IllegalArgumentException, IllegalStateException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		serializer.startTag(null, tag_name);
		serializer.text(value+"");
		serializer.endTag(null, tag_name);
	}

	private void writeElementToSerializer(XmlSerializer serializer,
			String tag_name, int value) throws IllegalArgumentException, IllegalStateException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		serializer.startTag(null, tag_name);
		serializer.text(value+"");
		serializer.endTag(null, tag_name);
	}

	private void writeElementToSerializer(XmlSerializer serializer,
			String tag_name, boolean value) throws IllegalArgumentException, IllegalStateException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		serializer.startTag(null, tag_name);
		serializer.text(value+"");
		serializer.endTag(null, tag_name);
	}

	public void writeElementToSerializer(){
		
	}
}
