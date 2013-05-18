package com.classica.classes.managers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.graphics.Point;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Environment;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.format.Time;
import android.util.Log;
import android.util.Xml;
import com.bump.api.IBumpAPI;
import com.bump.api.BumpAPIIntents;
import com.classica.classes.GLPanel;
import com.classica.classes.digimon.Digimon;
import com.classica.classes.events.CounterEvent;
import com.classica.classes.events.Event;
import com.classica.classes.events.ShakeEvent;
import com.classica.classes.events.TimerEvent;
import com.classica.classes.events.TouchEvent;
import com.classica.digimoid.R;

public class ProcessManager{
	public final static int BACK_COUNT = 250;
	public final static int BATTLE_ANIMATION_COUNT = 470;
	public final static int BATTLE_SELECT_JOGRESS = 10402;
	public final static int BATTLE_SELECT_ONLINE_BATTLE = 10401;
	public final static int BATTLE_ONLINE_CONNECT = 10403;
	public final static int BATTLE_ONLINE_ENCOUNT = 10404;
	public final static int BATTLE_ONLINE_READY = 10405;
	public final static int BATTLE_ONLINE_SHAKE = 10406;
	public final static int BATTLE_ONLINE_PLAY_EFFECT = 10407;
	public final static int BATTLE_ONLINE_PLAY_EMOTION = 10408;
	public final static int CARE_ANIMATION_COUNT = 90;
	public final static int CARE_INJURE = 10703;
	public final static int CARE_PLAY_EMOTION = 10705;
	public final static int CARE_SELECT_INJURE = 10701;
	public final static int CARE_SELECT_SICK = 10702;
	public final static int CARE_SICK = 10704;
	public final static int CARE_SICK_EMOTION = 10706;
	private int DECIDE_BUTTON_HEIGHT = 50;
	private int DECIDE_BUTTON_WIDTH = 420;
	private int DECIDE_BUTTON_X = 70;
	private int DECIDE_BUTTON_Y = 220;
	public final static int DENY_ANIMATION_COUNT = 100;
	private int DIGIMON_FRAME_BUTTON_RADIUS = 35;
	private int DIGIMON_FRAME_BUTTON_X_COOD = 450;
	private int DIGIMON_FRAME_FIRST_BUTTON_Y = 100;
	private int DIGIMON_FRAME_MINIBUTTON_RADIUS = 12;
	private int DIGIMON_FRAME_MINIBUTTON_X_COOD = 400;
	private int DIGIMON_FRAME_MINIBUTTON_Y_COOD = 195;
	private int DIGIMON_FRAME_SECOND_BUTTON_Y = 170;
	private int DIGIMON_FRAME_THIRD_BUTTON_Y = 240;
	public final static int EAT_ANIMATION_COUNT = 110;
	public final static int EMOTION_ANIMATION_COUNT = 150;
	public final static int ENCOUNT_ANIMATION_COUNT = 100;
	public final static int LIGHT_SELECT_OFF = 10602;
	public final static int LIGHT_SELECT_ON = 10601;
	public final static int MAINTITLE_COUNT = 100;
	public final static int MEAL_EAT_MEAT = 10203;
	public final static int MEAL_EAT_PROTEIN = 10204;
	public final static int MEAL_SELECT_MEAT = 10201;
	public final static int MEAL_SELECT_PROTEIN = 10202;
	private int NEXT_DIGIMON_CHECK_WIDTH = 70;
	public final static int NO_THANKS_COUNT = 80;
	public final static int PM_BATTLE_STATE = 10400;
	public final static int PM_CARE_STATE = 10700;
	public final static int PM_CLOCK_STATE = 10800;
	public final static int PM_DEFAULT_STATE = 10000;
	public final static int PM_DIGIMON_BLEEDING_STATE = 300;
	public final static int PM_DIGIMON_SELECTION_STATE = 200;
	public final static int PM_LIGHT_STATE = 10600;
	public final static int PM_MAINTITLE_STATE = 100;
	public final static int PM_MEAL_STATE = 10200;
	public final static int PM_NO_THANKS = 10900;
	public final static int PM_STATUS_STATE = 10100;
	public final static int PM_TRAINING_STATE = 10300;
	public final static int PM_UNKO_STATE = 10500;
	public final static int SHAKE_READY_COUNT = 50;
	public final static int SHAKE_WAIT_COUNT = 75;
	public final static int STATUS_BATTLE_POINT = 10105;
	public final static int STATUS_DIGIMON_POWER = 10104;
	public final static int STATUS_DM_AND_WEIGHT = 10101;
	public final static int STATUS_HUNGRY = 10102;
	public final static int STATUS_STRENGTH = 10103;
	public final static int STATUS_TYPE_AND_FLAG = 10106;
	public final static int TRAINIGN_OFFLINE_BATTLE_PLAY_EMOTION = 10312;
	public final static int TRAINING_ANIMATION_COUNT = 265;
	public final static int TRAINING_OFFLINE_BATTLE_ENCOUNT = 10307;
	public final static int TRAINING_OFFLINE_BATTLE_PLAY_EFFECT = 10310;
	public final static int TRAINING_OFFLINE_BATTLE_PLAY_EMOTION = 10311;
	public final static int TRAINING_OFFLINE_BATTLE_READY_COUNT = 10308;
	public final static int TRAINING_OFFLINE_BATTLE_SKAKE = 10309;
	public final static int TRAINING_SELECT_OFFLINE_BATTLE = 10302;
	public final static int TRAINING_SELECT_TRAINING = 10301;
	public final static int TRAINING_TRAINING_PLAY_EFFECT = 10305;
	public final static int TRAINING_TRAINING_PLAY_EMOTION = 10306;
	public final static int TRAINING_TRAINING_READY_COUNT = 10303;
	public final static int TRAINING_TRAINING_SHAKE = 10304;
	public final static int UNKO_CLEANING = 10501;
	public final static int UNKO_CLEANING_COUNT = 100;
	public final static int UNKO_PLAY_EMOTION = 10502;
	public final static int WALK_COUNT = 250;
	
	private int counter;
	private ArrayList<Digimon> digimon_list;
	private int digimon_selection_index;
	private boolean first_and_third_button_pressed;
	private boolean first_button_pressed;
	private Point first_release_point;
	private Point first_touch_point;
	private int icon_selection_index;
	private InputManager input_manager;
	private int internal_state;
	private int pressed_button_number;
	private boolean second_button_pressed;
	private int shake_counter;
	private int state;
	private StatusManager status_manager;
	private boolean third_button_pressed;
	private Time time;
	private int time_int;
	private int window_height;
	private int window_width;
	private int pich_id;
	private int shake_id;
	
	private SoundPool soundPool;
	
	private Context context;
	private boolean alert_ok;
	
	GLPanel parent;
	
	private IBumpAPI api;

    private final ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className, IBinder binder) {
            Log.i("BumpTest", "onServiceConnected");
            api = IBumpAPI.Stub.asInterface(binder);
            try {
                api.configure("your_api_key_here",
                              "Bump User");
            } catch (RemoteException e) {
                Log.w("BumpTest", e);
            }
            Log.d("Bump Test", "Service connected");
        }

        @Override
        public void onServiceDisconnected(ComponentName className) {
            Log.d("Bump Test", "Service disconnected");
        }
    };

    private final BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();
            try {
                if (action.equals(BumpAPIIntents.DATA_RECEIVED)) {
                    Log.i("Bump Test", "Received data from: " + api.userIDForChannelID(intent.getLongExtra("channelID", 0))); 
                    Log.i("Bump Test", "Data: " + new String(intent.getByteArrayExtra("data")));
                } else if (action.equals(BumpAPIIntents.MATCHED)) {
                    long channelID = intent.getLongExtra("proposedChannelID", 0); 
                    Log.i("Bump Test", "Matched with: " + api.userIDForChannelID(channelID));
                    api.confirm(channelID, true);
                    Log.i("Bump Test", "Confirm sent");
                } else if (action.equals(BumpAPIIntents.CHANNEL_CONFIRMED)) {
                    long channelID = intent.getLongExtra("channelID", 0);
                    Log.i("Bump Test", "Channel confirmed with " + api.userIDForChannelID(channelID));
                    api.send(channelID, "Hello, world!".getBytes());
                } else if (action.equals(BumpAPIIntents.NOT_MATCHED)) {
                    Log.i("Bump Test", "Not matched.");
                } else if (action.equals(BumpAPIIntents.CONNECTED)) {
                    Log.i("Bump Test", "Connected to Bump...");
                    api.enableBumping();
                }
            } catch (RemoteException e) {}
        } 
    };
	
	public ProcessManager(Context context,GLPanel panel) {
		this.parent = panel;
		
		this.digimon_list = new ArrayList<Digimon>();

		this.state = PM_MAINTITLE_STATE;
		this.internal_state = PM_DEFAULT_STATE;
		this.icon_selection_index = 0;

		this.pressed_button_number = 0;
		this.first_button_pressed = false;
		this.second_button_pressed = false;
		this.third_button_pressed = false;
		this.first_and_third_button_pressed = false;

		Digimon for_error_avoid = new Digimon();
		digimon_list.add(for_error_avoid);

		this.first_touch_point = new Point(0, 0);
		new Point(0, 0);
		this.first_release_point = new Point(0, 0);
		new Point(0, 0);
		
		this.time = new Time();
		time.setToNow();
		
		soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);  
		this.pich_id = soundPool.load(context, R.raw.pich, 1);
		this.shake_id = soundPool.load(context, R.raw.shake,2);
		
		this.context = context;
	}

	private void buttonPressedInBattleState(int button) {
		// TODO 自動生成されたメソッド・スタブ
		soundPool.play(pich_id, 1.0F, 1.0F, 1, 0, 1.0F);
		if (button == 1) {
			if (this.internal_state == BATTLE_SELECT_ONLINE_BATTLE) {
				this.internal_state++;
				this.input_manager.destoryCount();
				this.input_manager.requestCount(BACK_COUNT);
			} else if (this.internal_state == BATTLE_SELECT_JOGRESS) {
				this.internal_state--;
				this.input_manager.destoryCount();
				this.input_manager.requestCount(BACK_COUNT);
			}
		} else if (button == 2) {
			if (this.internal_state == BATTLE_SELECT_ONLINE_BATTLE) {
				if (this.status_manager.canDoOnlineBattle() == true) {
					this.internal_state = BATTLE_ONLINE_READY;
					this.input_manager.destoryCount();
					this.input_manager.requestCount(SHAKE_READY_COUNT);
				} else {
					this.internal_state = PM_NO_THANKS;
					this.input_manager.destoryCount();
					this.input_manager.requestCount(DENY_ANIMATION_COUNT);
				}
			}
			if (this.internal_state == BATTLE_SELECT_JOGRESS) {
				if (this.status_manager.canDoJogress() == true) {
					this.internal_state = BATTLE_SELECT_JOGRESS;
					this.input_manager.destoryCount();
					this.input_manager.requestCount(ENCOUNT_ANIMATION_COUNT);
					this.status_manager.doJogress();
				} else {
					this.internal_state = PM_NO_THANKS;
					this.input_manager.destoryCount();
					this.input_manager.requestCount(DENY_ANIMATION_COUNT);
				}
			}
		} else if (button == 3) {
			if (this.internal_state == BATTLE_SELECT_ONLINE_BATTLE
					|| this.internal_state == BATTLE_SELECT_JOGRESS) {
				this.input_manager.destoryCount();
			}
		}
	}

	private void buttonPressedInCareState(int button) {
		// TODO 自動生成されたメソッド・スタブ
		soundPool.play(pich_id, 1.0F, 1.0F, 1, 0, 1.0F);
		if (button == 1) {
			if (this.internal_state == CARE_SELECT_INJURE) {
				this.internal_state++;
				this.input_manager.destoryCount();
				this.input_manager.requestCount(BACK_COUNT);
			} else if (this.internal_state == CARE_SELECT_SICK) {
				this.internal_state--;
				this.input_manager.destoryCount();
				this.input_manager.requestCount(BACK_COUNT);
			}
		} else if (button == 2) {
			if (this.internal_state == CARE_SELECT_INJURE) {
				if (this.status_manager.canCareInjure() == true) {
					this.internal_state = CARE_INJURE;
					this.input_manager.destoryCount();
					this.input_manager.requestCount(CARE_ANIMATION_COUNT);
					this.status_manager.careInjure();
				} else {
					this.internal_state = PM_NO_THANKS;
					this.input_manager.destoryCount();
					this.input_manager.requestCount(DENY_ANIMATION_COUNT);
				}
			}
			if (this.internal_state == CARE_SELECT_SICK) {
				if (this.status_manager.canCareSick() == true) {
					this.internal_state = CARE_SICK;
					this.input_manager.destoryCount();
					this.input_manager.requestCount(CARE_ANIMATION_COUNT);
					this.status_manager.careSick();
				} else {
					this.internal_state = PM_NO_THANKS;
					this.input_manager.destoryCount();
					this.input_manager.requestCount(DENY_ANIMATION_COUNT);
				}
			}
		} else if (button == 3) {
			if (internal_state == CARE_INJURE || internal_state == CARE_SICK) {
				this.input_manager.destoryCount();
			}
		}
	}

	private void buttonPressedInLightState(int button) {
		soundPool.play(pich_id, 1.0F, 1.0F, 1, 0, 1.0F);
		// TODO 自動生成されたメソッド・スタブ
		if (button == 1) {
			if (this.internal_state == LIGHT_SELECT_ON) {
				this.internal_state++;
				this.input_manager.destoryCount();
				this.input_manager.requestCount(BACK_COUNT);
			} else if (this.internal_state == LIGHT_SELECT_OFF) {
				this.internal_state--;
				this.input_manager.destoryCount();
				this.input_manager.requestCount(BACK_COUNT);
			}
		} else if (button == 2) {
			if (this.internal_state == LIGHT_SELECT_ON) {
				this.internal_state = PM_DEFAULT_STATE;
				this.status_manager.turnLight(true);
				this.input_manager.destoryCount();
				this.input_manager.requestCount(WALK_COUNT);
			} else if (this.internal_state == LIGHT_SELECT_OFF) {
				this.internal_state = PM_DEFAULT_STATE;
				this.status_manager.turnLight(false);
				this.input_manager.destoryCount();
				this.input_manager.requestCount(WALK_COUNT);
			}
		}
	}

	private void buttonPressedInMealState(int button) {
		// TODO 自動生成されたメソッド・スタブ
		soundPool.play(pich_id, 1.0F, 1.0F, 1, 0, 1.0F);
		if (button == 1) {
			if (this.internal_state == MEAL_SELECT_MEAT) {
				this.internal_state++;
				this.input_manager.destoryCount();
				this.input_manager.requestCount(BACK_COUNT);
			} else if (this.internal_state == MEAL_SELECT_PROTEIN) {
				this.internal_state--;
				this.input_manager.destoryCount();
				this.input_manager.requestCount(BACK_COUNT);
			}
		} else if (button == 2) {
			if (this.internal_state == MEAL_SELECT_MEAT) {
				if (this.status_manager.canEatMeat() == true) {
					this.internal_state = MEAL_EAT_MEAT;
					this.input_manager.destoryCount();
					this.input_manager.requestCount(EAT_ANIMATION_COUNT);
					this.status_manager.eatMeat();
				} else {
					this.internal_state = PM_NO_THANKS;
					this.input_manager.destoryCount();
					this.input_manager.requestCount(DENY_ANIMATION_COUNT);
				}
			}
			if (this.internal_state == MEAL_SELECT_PROTEIN) {
				if (this.status_manager.canEatProtein() == true) {
					this.internal_state = MEAL_EAT_PROTEIN;
					this.input_manager.destoryCount();
					this.input_manager.requestCount(EAT_ANIMATION_COUNT);
					this.status_manager.eatProtein();
				} else {
					this.internal_state = PM_NO_THANKS;
					this.input_manager.destoryCount();
					this.input_manager.requestCount(DENY_ANIMATION_COUNT);
				}
			}
		} else if (button == 3) {
			if (this.internal_state == MEAL_EAT_MEAT
					|| this.internal_state == MEAL_EAT_PROTEIN) {
				this.input_manager.destoryCount();
			}
		}
	}

	private void buttonPressedInStatusState(int button) {
		// TODO 自動生成されたメソッド・スタブ
		soundPool.play(pich_id, 1.0F, 1.0F, 1, 0, 1.0F);
		if (button == 1) {
			if (this.internal_state != STATUS_TYPE_AND_FLAG) {
				this.internal_state++;
				this.input_manager.destoryCount();
				this.input_manager.requestCount(BACK_COUNT);
			} else {
				this.internal_state = STATUS_DM_AND_WEIGHT;
				this.input_manager.destoryCount();
				this.input_manager.requestCount(BACK_COUNT);
			}
		}
	}

	private void buttonPressedInTrainingState(int button) {
		// TODO 自動生成されたメソッド・スタブ
		soundPool.play(pich_id, 1.0F, 1.0F, 1, 0, 1.0F);
		if (button == 1) {
			if (this.internal_state == TRAINING_SELECT_TRAINING) {
				this.internal_state++;
				this.input_manager.destoryCount();
				this.input_manager.requestCount(BACK_COUNT);
			} else if (this.internal_state == TRAINING_SELECT_OFFLINE_BATTLE) {
				this.internal_state--;
				this.input_manager.destoryCount();
				this.input_manager.requestCount(BACK_COUNT);
			}
		} else if (button == 2) {
			if (this.internal_state == TRAINING_SELECT_TRAINING) {
				if (this.status_manager.canDoTraining() == true) {
					this.internal_state = TRAINING_TRAINING_READY_COUNT;
					this.input_manager.destoryCount();
					this.input_manager.requestCount(SHAKE_READY_COUNT);
				} else {
					this.internal_state = PM_NO_THANKS;
					this.input_manager.destoryCount();
					this.input_manager.requestCount(DENY_ANIMATION_COUNT);
				}
			}
			if (this.internal_state == TRAINING_SELECT_OFFLINE_BATTLE) {
				if (this.status_manager.canDoOfflineBattle() == true) {
					this.internal_state = TRAINING_OFFLINE_BATTLE_ENCOUNT;
					this.input_manager.destoryCount();
					this.input_manager.requestCount(ENCOUNT_ANIMATION_COUNT);
					this.status_manager.decideEnemy();
				} else {
					this.internal_state = PM_NO_THANKS;
					this.input_manager.destoryCount();
					this.input_manager.requestCount(DENY_ANIMATION_COUNT);
				}
			}
		} else if (button == 3) {
			if (this.internal_state != TRAINING_SELECT_TRAINING
					&& this.internal_state != TRAINING_SELECT_OFFLINE_BATTLE) {
				this.input_manager.destoryCount();
			}
		}
	}

	private void buttonPressedInUnkoState(int button) {
		// TODO 自動生成されたメソッド・スタブ
		soundPool.play(pich_id, 1.0F, 1.0F, 1, 0, 1.0F);
		if (button == 3) {
			this.status_manager.washUnko();
		}
	}

	private void catchEventInBleedingState(Event pop) {
		// TODO 自動生成されたメソッド・スタブ
		if (pop.getEventType() == TouchEvent.EVENT_TOUCH) {
			TouchEvent touch = (TouchEvent) pop;
			int state = touch.getState();
			Point touched_point = touch.getObject();
			int x = touched_point.x;
			int y = touched_point.y;
			System.out.println("x"+x+",y"+y);
			if (state == TouchEvent.TOUCH_TOUCHED) {
				this.pressed_button_number++;
				if (Math.pow(x - DIGIMON_FRAME_BUTTON_X_COOD, 2.0)
						+ Math.pow(y - DIGIMON_FRAME_FIRST_BUTTON_Y, 2.0) <= Math
							.pow(DIGIMON_FRAME_BUTTON_RADIUS, 2.0)) {
					if (this.second_button_pressed == false) {
						this.first_button_pressed = true;
						if (this.third_button_pressed == true) {
							this.first_button_pressed = false;
							this.third_button_pressed = false;
							this.first_and_third_button_pressed = true;
						}
					}
				} else if (Math.pow(x - DIGIMON_FRAME_BUTTON_X_COOD, 2.0)
						+ Math.pow(y - DIGIMON_FRAME_SECOND_BUTTON_Y, 2.0) <= Math
							.pow(DIGIMON_FRAME_BUTTON_RADIUS, 2.0)) {
					if (this.first_button_pressed == false
							&& this.third_button_pressed == false
							&& this.first_and_third_button_pressed == false) {
						this.second_button_pressed = true;
					}
				} else if (Math.pow(x - DIGIMON_FRAME_BUTTON_X_COOD, 2.0)
						+ Math.pow(y - DIGIMON_FRAME_THIRD_BUTTON_Y, 2.0) <= Math
							.pow(DIGIMON_FRAME_BUTTON_RADIUS, 2.0)) {
					if (this.second_button_pressed == false) {
						this.third_button_pressed = true;
						if (this.first_button_pressed == true) {
							this.first_button_pressed = false;
							this.third_button_pressed = false;
							this.first_and_third_button_pressed = true;
						}
					}
				} else if (Math.pow(x - DIGIMON_FRAME_MINIBUTTON_X_COOD, 2.0)
						+ Math.pow(y - DIGIMON_FRAME_MINIBUTTON_Y_COOD, 2.0) <= Math
							.pow(DIGIMON_FRAME_MINIBUTTON_RADIUS, 2.0)) {
					this.goSelectonState();
				}
				if (this.pressed_button_number == 0) {
					if (this.first_button_pressed == true
							&& this.second_button_pressed == false
							&& this.third_button_pressed == false
							&& this.first_and_third_button_pressed == false) {
						this.firstButtonPressed();
					} else if (this.first_button_pressed == false
							&& this.second_button_pressed == true
							&& this.third_button_pressed == false
							&& this.first_and_third_button_pressed == false) {
						this.secondButtonPressed();
					} else if (this.first_button_pressed == false
							&& this.second_button_pressed == false
							&& this.third_button_pressed == true
							&& this.first_and_third_button_pressed == false) {
						this.thirdButtonPressed();
					} else if (this.first_button_pressed == false
							&& this.second_button_pressed == false
							&& this.third_button_pressed == false
							&& this.first_and_third_button_pressed == true) {
						this.firstAndThirdButtonPressed();
					}
					this.first_button_pressed = false;
					this.second_button_pressed = false;
					this.third_button_pressed = false;
					this.first_and_third_button_pressed = false;
				}
			}
			if (state == TouchEvent.TOUCH_RELEASED) {
				this.pressed_button_number--;
				if (Math.pow(x - DIGIMON_FRAME_BUTTON_X_COOD, 2.0)
						+ Math.pow(y - DIGIMON_FRAME_FIRST_BUTTON_Y, 2.0) <= Math
							.pow(DIGIMON_FRAME_BUTTON_RADIUS, 2.0)) {
					if (this.second_button_pressed == false) {
						this.first_button_pressed = true;
						if (this.third_button_pressed == true) {
							this.first_button_pressed = false;
							this.third_button_pressed = false;
							this.first_and_third_button_pressed = true;
						}
					}
				} else if (Math.pow(x - DIGIMON_FRAME_BUTTON_X_COOD, 2.0)
						+ Math.pow(y - DIGIMON_FRAME_SECOND_BUTTON_Y, 2.0) <= Math
							.pow(DIGIMON_FRAME_BUTTON_RADIUS, 2.0)) {
					if (this.first_button_pressed == false
							&& this.third_button_pressed == false
							&& this.first_and_third_button_pressed == false) {
						this.second_button_pressed = true;
					}
				} else if (Math.pow(x - DIGIMON_FRAME_BUTTON_X_COOD, 2.0)
						+ Math.pow(y - DIGIMON_FRAME_THIRD_BUTTON_Y, 2.0) <= Math
							.pow(DIGIMON_FRAME_BUTTON_RADIUS, 2.0)) {
					if (this.second_button_pressed == false) {
						this.third_button_pressed = true;
						if (this.first_button_pressed == true) {
							this.first_button_pressed = false;
							this.third_button_pressed = false;
							this.first_and_third_button_pressed = true;
						}
					}
				} else if (Math.pow(x - DIGIMON_FRAME_MINIBUTTON_X_COOD, 2.0)
						+ Math.pow(y - DIGIMON_FRAME_MINIBUTTON_Y_COOD, 2.0) <= Math
							.pow(DIGIMON_FRAME_MINIBUTTON_RADIUS, 2.0)) {
					this.goSelectonState();
				}
				if (this.pressed_button_number == 0) {
					if (this.first_button_pressed == true
							&& this.second_button_pressed == false
							&& this.third_button_pressed == false
							&& this.first_and_third_button_pressed == false) {
						this.firstButtonPressed();
					} else if (this.first_button_pressed == false
							&& this.second_button_pressed == true
							&& this.third_button_pressed == false
							&& this.first_and_third_button_pressed == false) {
						this.secondButtonPressed();
					} else if (this.first_button_pressed == false
							&& this.second_button_pressed == false
							&& this.third_button_pressed == true
							&& this.first_and_third_button_pressed == false) {
						this.thirdButtonPressed();
					} else if (this.first_button_pressed == false
							&& this.second_button_pressed == false
							&& this.third_button_pressed == false
							&& this.first_and_third_button_pressed == true) {
						this.firstAndThirdButtonPressed();
					}
					this.first_button_pressed = false;
					this.second_button_pressed = false;
					this.third_button_pressed = false;
					this.first_and_third_button_pressed = false;
				}
			}
		} else if (pop.getEventType() == ShakeEvent.EVENT_SHAKE) {
			soundPool.play(shake_id, 1.0F, 1.0F, 1, 0, 1.0F);
			this.shake_counter++;
		} else if (pop.getEventType() == CounterEvent.EVENT_COUNTER) {
			CounterEvent counter = (CounterEvent) pop;
			this.counter = counter.getObject().get(0);
			if (this.internal_state == PM_DEFAULT_STATE) {
				if (counter.isFinished() == true) {
					this.input_manager.requestCount(WALK_COUNT);
				}
			} else if (this.internal_state == PM_NO_THANKS) {
				if (counter.isFinished() == true) {
					this.internal_state = PM_DEFAULT_STATE;
					this.input_manager.requestCount(WALK_COUNT);
				}
			} else if (this.internal_state == STATUS_DM_AND_WEIGHT) {
				if (counter.isFinished() == true) {
					this.internal_state = PM_DEFAULT_STATE;
					this.input_manager.requestCount(WALK_COUNT);
				}
			} else if (this.internal_state == STATUS_HUNGRY) {
				if (counter.isFinished() == true) {
					this.internal_state = PM_DEFAULT_STATE;
					this.input_manager.requestCount(WALK_COUNT);
				}
			} else if (this.internal_state == STATUS_STRENGTH) {
				if (counter.isFinished() == true) {
					this.internal_state = PM_DEFAULT_STATE;
					this.input_manager.requestCount(WALK_COUNT);
				}
			} else if (this.internal_state == STATUS_BATTLE_POINT) {
				if (counter.isFinished() == true) {
					this.internal_state = PM_DEFAULT_STATE;
					this.input_manager.requestCount(WALK_COUNT);
				}
			} else if (this.internal_state == STATUS_TYPE_AND_FLAG) {
				if (counter.isFinished() == true) {
					this.internal_state = PM_DEFAULT_STATE;
					this.input_manager.requestCount(WALK_COUNT);
				}
			} else if (this.internal_state == MEAL_SELECT_MEAT) {
				if (counter.isFinished() == true) {
					this.internal_state = PM_DEFAULT_STATE;
					this.input_manager.requestCount(WALK_COUNT);
				}
			} else if (this.internal_state == MEAL_SELECT_PROTEIN) {
				if (counter.isFinished() == true) {
					this.internal_state = PM_DEFAULT_STATE;
					this.input_manager.requestCount(WALK_COUNT);
				}
			} else if (this.internal_state == MEAL_EAT_MEAT) {
				if (counter.isFinished() == true) {
					this.internal_state = PM_DEFAULT_STATE;
					this.input_manager.requestCount(WALK_COUNT);
				}
			} else if (this.internal_state == MEAL_EAT_PROTEIN) {
				if (counter.isFinished() == true) {
					this.internal_state = PM_DEFAULT_STATE;
					this.input_manager.requestCount(WALK_COUNT);
				}
			} else if (this.internal_state == TRAINING_SELECT_TRAINING) {
				if (counter.isFinished() == true) {
					this.internal_state = PM_DEFAULT_STATE;
					this.input_manager.requestCount(WALK_COUNT);
				}
			} else if (this.internal_state == TRAINING_SELECT_OFFLINE_BATTLE) {
				if (counter.isFinished() == true) {
					this.internal_state = PM_DEFAULT_STATE;
					this.input_manager.requestCount(SHAKE_WAIT_COUNT);
				}
			} else if (this.internal_state == TRAINING_TRAINING_READY_COUNT) {
				if (counter.isFinished() == true) {
					this.internal_state = TRAINING_TRAINING_SHAKE;
					this.input_manager.requestCount(SHAKE_WAIT_COUNT);
				}
			} else if (this.internal_state == TRAINING_TRAINING_SHAKE) {
				if (counter.isFinished() == true) {
					this.status_manager
							.calcurateAttackPatternForTrainingWithShakeCount(this.shake_counter);
					this.status_manager.doTraining();
					this.internal_state = TRAINING_TRAINING_PLAY_EFFECT;
					this.input_manager.requestCount(TRAINING_ANIMATION_COUNT);
				}
			} else if (this.internal_state == TRAINING_TRAINING_PLAY_EFFECT) {
				if (counter.isFinished() == true) {
					this.internal_state = TRAINING_TRAINING_PLAY_EMOTION;
					this.input_manager.requestCount(EMOTION_ANIMATION_COUNT);
				}
			} else if (this.internal_state == TRAINING_OFFLINE_BATTLE_ENCOUNT) {
				if (counter.isFinished() == true) {
					this.internal_state = TRAINING_OFFLINE_BATTLE_READY_COUNT;
					this.input_manager.requestCount(SHAKE_READY_COUNT);
				}
			} else if (this.internal_state == TRAINING_OFFLINE_BATTLE_READY_COUNT) {
				if (counter.isFinished() == true) {
					this.internal_state = TRAINING_OFFLINE_BATTLE_SKAKE;
					this.input_manager.requestCount(SHAKE_WAIT_COUNT);
				}
			} else if (this.internal_state == TRAINING_OFFLINE_BATTLE_SKAKE) {
				if (counter.isFinished() == true) {
					this.status_manager
							.calcurateAttackPatternForOfflineBattleWithShakeCount(this.shake_counter);
					this.status_manager.doOfflineBattle();
					this.internal_state = TRAINING_OFFLINE_BATTLE_PLAY_EFFECT;
					this.input_manager.requestCount(BATTLE_ANIMATION_COUNT);
				}
			} else if (this.internal_state == TRAINING_OFFLINE_BATTLE_PLAY_EFFECT) {
				if (counter.isFinished() == true) {
					this.internal_state = TRAINING_OFFLINE_BATTLE_PLAY_EMOTION;
					this.input_manager.requestCount(EMOTION_ANIMATION_COUNT);
				}
			} else if (this.internal_state == TRAINING_OFFLINE_BATTLE_PLAY_EMOTION) {
				if (counter.isFinished() == true) {
					this.internal_state = PM_DEFAULT_STATE;
					this.input_manager.requestCount(WALK_COUNT);
				}
			} 
			else if(this.internal_state == BATTLE_ONLINE_ENCOUNT){
				if(counter.isFinished() == true){
					this.internal_state = BATTLE_ONLINE_PLAY_EFFECT;
					this.input_manager.requestCount(BATTLE_ANIMATION_COUNT);
				}
			}
			else if(this.internal_state == BATTLE_ONLINE_READY){
	            if(counter.isFinished() == true){
	                this.internal_state = BATTLE_ONLINE_SHAKE;
	                this.input_manager.requestCount(SHAKE_WAIT_COUNT);
	            }
	        }
			else if(this.internal_state == BATTLE_ONLINE_SHAKE){
	            if(counter.isFinished() == true){
	                this.status_manager.calcurateAttackPatternForOnlineBattleWithShakeCount(shake_counter);//[self->status_manager calcurateAttackPatternForOnlineBattleWithShakeCount:shaked_count];
	                this.internal_state = BATTLE_ONLINE_CONNECT;
	                this.input_manager.destoryCount();//[self->input_manager destroy_Count];
	                this.showAleat();
	            }
	        }
	        else if(this.internal_state == BATTLE_ONLINE_PLAY_EFFECT){
	            if(counter.isFinished() == true){
	                this.internal_state = BATTLE_ONLINE_PLAY_EMOTION;
	                this.input_manager.requestCount(EMOTION_ANIMATION_COUNT);
	            }
	        }
	        else if(this.internal_state == BATTLE_ONLINE_PLAY_EMOTION){
	            if(counter.isFinished() == true){
	                this.internal_state = PM_DEFAULT_STATE;
	                this.input_manager.requestCount(WALK_COUNT);
	            }
	        }else if (this.internal_state == UNKO_CLEANING) {
				if (counter.isFinished() == true) {
					this.internal_state = UNKO_PLAY_EMOTION;
					this.input_manager.requestCount(EMOTION_ANIMATION_COUNT);
					this.status_manager.washUnko();
				}
			} else if (this.internal_state == UNKO_PLAY_EMOTION) {
				if (counter.isFinished() == true) {
					this.internal_state = PM_DEFAULT_STATE;
					this.input_manager.requestCount(WALK_COUNT);
				}
			} else if (this.internal_state == CARE_INJURE) {
				if (counter.isFinished() == true) {
					this.internal_state = CARE_PLAY_EMOTION;
					this.input_manager.requestCount(EMOTION_ANIMATION_COUNT);
				}
			} else if (this.internal_state == CARE_SICK) {
				if (counter.isFinished() == true) {
					this.internal_state = CARE_PLAY_EMOTION;
					this.input_manager.requestCount(EMOTION_ANIMATION_COUNT);
				}
			} else if (this.internal_state == CARE_PLAY_EMOTION) {
				if (counter.isFinished() == true) {
					this.internal_state = PM_DEFAULT_STATE;
					this.input_manager.requestCount(WALK_COUNT);
				}
			}
		}
	}

	private void showAleat() {
		// TODO 自動生成されたメソッド・スタブ
		parent.showAleat();
	}

	private void catchEventInMaintitleState(Event pop) {
		// TODO 自動生成されたメソッド・スタブ
		if (pop.getEventType() == TouchEvent.EVENT_TOUCH) {
			TouchEvent touch = (TouchEvent) pop;
			if (touch.getState() == TouchEvent.TOUCH_RELEASED) {
				this.state = PM_DIGIMON_SELECTION_STATE;
				this.input_manager.destoryCount();
				this.input_manager.requestCount(WALK_COUNT);
			}
		} else if (pop.getEventType() == CounterEvent.EVENT_COUNTER) {
			CounterEvent counter = (CounterEvent) pop;
			if (counter.isFinished() == true) {
				this.state = PM_DIGIMON_SELECTION_STATE;
				this.input_manager.requestCount(WALK_COUNT);
			}
		}
	}

	private void catchEventInSelectionState(Event pop) {
		// TODO 自動生成されたメソッド・スタブ
		if (pop.getEventType() == TouchEvent.EVENT_TOUCH) {
			TouchEvent touch = (TouchEvent) pop;
			int x = touch.getObject().x;
			int y = touch.getObject().y;
			int state = touch.getState();
			if (state == TouchEvent.TOUCH_TOUCHED) {
				this.first_touch_point = new Point(x, y);
			} else if (state == TouchEvent.TOUCH_RELEASED) {
				this.first_release_point = new Point(x, y);
				if (first_release_point.x - first_touch_point.x > this.NEXT_DIGIMON_CHECK_WIDTH) {
					if (this.digimon_list.size() > digimon_selection_index + 1) {
						this.digimon_selection_index++;
						this.status_manager
								.changeSelected(digimon_selection_index);
						System.out.println("next");
					}
				} else if (first_release_point.x - first_touch_point.x < -this.NEXT_DIGIMON_CHECK_WIDTH) {
					if (0 <= digimon_selection_index - 1) {
						this.digimon_selection_index--;
						this.status_manager
								.changeSelected(digimon_selection_index);
						System.out.println("prev");
					}
				} else if (first_touch_point.x > DECIDE_BUTTON_X
						&& first_touch_point.x < DECIDE_BUTTON_X
								+ DECIDE_BUTTON_WIDTH
						&& first_touch_point.y > DECIDE_BUTTON_Y
						&& first_touch_point.y < DECIDE_BUTTON_Y
								+ DECIDE_BUTTON_HEIGHT
						&& first_release_point.x > DECIDE_BUTTON_X
						&& first_release_point.x < DECIDE_BUTTON_X
								+ DECIDE_BUTTON_WIDTH
						&& first_release_point.y > DECIDE_BUTTON_Y
						&& first_release_point.y < DECIDE_BUTTON_Y
								+ DECIDE_BUTTON_HEIGHT) {
					System.out.println("ok");
					this.first_touch_point = new Point(0, 0);
					new Point(0, 0);
					this.first_release_point = new Point(0, 0);
					new Point(0, 0);
					this.pressed_button_number = 0;
					this.state = PM_DIGIMON_BLEEDING_STATE;
					this.input_manager.requestCount(WALK_COUNT);
				}
				System.out.println("end");
				this.first_touch_point = new Point(0, 0);
				new Point(0, 0);
				this.first_release_point = new Point(0, 0);
				new Point(0, 0);
			}
		} else if (pop.getEventType() == CounterEvent.EVENT_COUNTER) {
			CounterEvent counter = (CounterEvent) pop;
			this.counter = counter.getObject().get(0);
			if (this.internal_state == PM_DEFAULT_STATE) {
				if (counter.isFinished() == true) {
					this.input_manager.requestCount(WALK_COUNT);
				}
			}
		}
	}

	private void firstAndThirdButtonPressed() {
		// TODO 自動生成されたメソッド・スタブ
		if (this.status_manager.isDieing() == true) {
			soundPool.play(pich_id, 1.0F, 1.0F, 1, 0, 1.0F);
			this.status_manager.recovery();
		} else {
			if (this.internal_state == PM_CLOCK_STATE) {
				this.internal_state = PM_DEFAULT_STATE;
				soundPool.play(pich_id, 1.0F, 1.0F, 1, 0, 1.0F);
				this.input_manager.requestCount(WALK_COUNT);
			} else {
				soundPool.play(pich_id, 1.0F, 1.0F, 1, 0, 1.0F);
				this.internal_state = PM_CLOCK_STATE;
				this.input_manager.destoryCount();
				this.icon_selection_index = 0;
			}
		}
	}

	private void firstButtonPressed() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("first button pressed");
		if (this.status_manager.canOperate() == true) {
			if (this.internal_state == PM_DEFAULT_STATE) {
				soundPool.play(pich_id, 1.0F, 1.0F, 1, 0, 1.0F);
				this.icon_selection_index++;
				if (this.icon_selection_index > 7) {
					soundPool.play(pich_id, 1.0F, 1.0F, 1, 0, 1.0F);
					this.icon_selection_index = 0;
				}
			} else if (this.internal_state / 100 * 100 == PM_STATUS_STATE) {
				this.buttonPressedInStatusState(1);
			} else if (this.internal_state / 100 * 100 == PM_MEAL_STATE) {
				this.buttonPressedInMealState(1);
			} else if (this.internal_state / 100 * 100 == PM_TRAINING_STATE) {
				this.buttonPressedInTrainingState(1);
			} else if (this.internal_state / 100 * 100 == PM_BATTLE_STATE) {
				this.buttonPressedInBattleState(1);
			} else if (this.internal_state / 100 * 100 == PM_LIGHT_STATE) {
				this.buttonPressedInLightState(1);
			} else if (this.internal_state / 100 * 100 == PM_CARE_STATE) {
				this.buttonPressedInCareState(1);
			}
		}
	}

	public int getWindow_height() {
		return window_height;
	}

	public int getWindow_width() {
		return window_width;
	}

	private void goSelectonState() {
		// TODO 自動生成されたメソッド・スタブ
		this.state = PM_DIGIMON_SELECTION_STATE;
		this.input_manager.requestCount(WALK_COUNT);
		this.icon_selection_index = 0;
		this.internal_state = PM_DEFAULT_STATE;
	}

	private void secondButtonPressed() {
		// TODO 自動生成されたメソッド・スタブ
		if (this.status_manager.canOperate() == true) {
			if (this.internal_state == PM_DEFAULT_STATE) {
				soundPool.play(pich_id, 1.0F, 1.0F, 1, 0, 1.0F);
				if(icon_selection_index != 0){
				this.input_manager.destoryCount();
				this.internal_state = PM_DEFAULT_STATE
						+ this.icon_selection_index * 100;
				}
				else if(icon_selection_index == 0){
					this.firstAndThirdButtonPressed();
				}
			} else if (this.internal_state / 100 * 100 == PM_STATUS_STATE) {
				this.buttonPressedInStatusState(2);
			} else if (this.internal_state / 100 * 100 == PM_MEAL_STATE) {
				this.buttonPressedInMealState(2);
			} else if (this.internal_state / 100 * 100 == PM_TRAINING_STATE) {
				this.buttonPressedInTrainingState(2);
			} else if (this.internal_state / 100 * 100 == PM_BATTLE_STATE) {
				this.buttonPressedInBattleState(2);
			} else if (this.internal_state / 100 * 100 == PM_LIGHT_STATE) {
				this.buttonPressedInLightState(2);
			} else if (this.internal_state / 100 * 100 == PM_CARE_STATE) {
				this.buttonPressedInCareState(2);
			}
		}
		else if(this.status_manager.isDieing() == true){
			this.firstAndThirdButtonPressed();
		}
	}

	public boolean setInputManager(InputManager in_manager) {
		if (in_manager != null) {
			this.input_manager = in_manager;
			return true;
		} else {
			return false;
		}
	}

	public boolean setStatusManager(StatusManager st_manager) {
		if (st_manager != null) {
			this.status_manager = st_manager;
			return true;
		} else {
			return false;
		}
	}

	public void setWindow_height(int window_height) {
		this.window_height = window_height;
	}

	public void setWindow_width(int window_width) {
		this.window_width = window_width;
	}

	public void startState() {
		this.input_manager.requestCount(MAINTITLE_COUNT);
	}

	private void thirdButtonPressed() {
		// TODO 自動生成されたメソッド・スタブ
		if (this.status_manager.canOperate() == true) {
			if (this.internal_state == PM_DEFAULT_STATE) {
				soundPool.play(pich_id, 1.0F, 1.0F, 1, 0, 1.0F);
				this.icon_selection_index--;
				if (this.icon_selection_index < 0) {
					this.icon_selection_index = 7;
				}
			} else if (this.internal_state / 100 * 100 == PM_STATUS_STATE) {
				this.buttonPressedInStatusState(3);
				this.input_manager.destoryCount();
				this.internal_state = PM_DEFAULT_STATE;
				this.input_manager.requestCount(WALK_COUNT);
			} else if (this.internal_state / 100 * 100 == PM_MEAL_STATE) {
				this.buttonPressedInMealState(3);
				this.input_manager.destoryCount();
				this.internal_state = PM_DEFAULT_STATE;
				this.input_manager.requestCount(WALK_COUNT);
			} else if (this.internal_state / 100 * 100 == PM_TRAINING_STATE) {
				this.buttonPressedInTrainingState(3);
				this.input_manager.destoryCount();
				this.internal_state = PM_DEFAULT_STATE;
				this.input_manager.requestCount(WALK_COUNT);
			} else if (this.internal_state / 100 * 100 == PM_BATTLE_STATE) {
				this.buttonPressedInBattleState(3);
				this.input_manager.destoryCount();
				this.internal_state = PM_DEFAULT_STATE;
				this.input_manager.requestCount(WALK_COUNT);
			} else if (this.internal_state / 100 * 100 == PM_UNKO_STATE) {
				this.buttonPressedInUnkoState(3);
				this.input_manager.destoryCount();
				this.internal_state = PM_DEFAULT_STATE;
				this.input_manager.requestCount(WALK_COUNT);
			} else if (this.internal_state / 100 * 100 == PM_LIGHT_STATE) {
				this.buttonPressedInLightState(3);
				this.input_manager.destoryCount();
				this.internal_state = PM_DEFAULT_STATE;
				this.input_manager.requestCount(WALK_COUNT);
			} else if (this.internal_state / 100 * 100 == PM_CARE_STATE) {
				this.buttonPressedInCareState(3);
				this.input_manager.destoryCount();
				this.internal_state = PM_DEFAULT_STATE;
				this.input_manager.requestCount(WALK_COUNT);
			} else {
				this.internal_state = PM_DEFAULT_STATE;
				this.input_manager.requestCount(WALK_COUNT);
			}
		}
	}

	public void updateState() {
		// Log.v("CurrentState", ""+this.state);
		// Log.v("CurrentInternalState", ""+this.internal_state);
		if (this.state == ProcessManager.PM_MAINTITLE_STATE) {
			Event pop = this.input_manager.popEvent();
			while (pop != null) {
				if (pop.getEventType() != TimerEvent.EVENT_TIMER) {
					this.catchEventInMaintitleState(pop);
				} else {
					TimerEvent tevent = (TimerEvent) pop;
					this.time = tevent.getObject();
					this.updateTime();
				}
				pop = this.input_manager.popEvent();
			}
		} else if (this.state == ProcessManager.PM_DIGIMON_SELECTION_STATE) {
			Event pop = this.input_manager.popEvent();
			while (pop != null) {
				if (pop.getEventType() != TimerEvent.EVENT_TIMER) {
					this.catchEventInSelectionState(pop);
				} else {
					TimerEvent tevent = (TimerEvent) pop;
					this.time = tevent.getObject();
					this.updateTime();
				}
				pop = this.input_manager.popEvent();
			}
		} else if (this.state == ProcessManager.PM_DIGIMON_BLEEDING_STATE) {
			Event pop = this.input_manager.popEvent();
			while (pop != null) {
				if (pop.getEventType() != TimerEvent.EVENT_TIMER) {
					this.catchEventInBleedingState(pop);
				} else {
					TimerEvent tevent = (TimerEvent) pop;
					this.time = tevent.getObject();
					this.updateTime();
				}
				pop = this.input_manager.popEvent();
			}
			if (this.internal_state == PM_STATUS_STATE) {
				this.internal_state++;
				this.input_manager.requestCount(BACK_COUNT);
			} else if (this.internal_state == PM_MEAL_STATE) {
				this.internal_state++;
				this.input_manager.requestCount(BACK_COUNT);
			} else if (this.internal_state == PM_TRAINING_STATE) {
				this.internal_state++;
				this.input_manager.requestCount(BACK_COUNT);
			} else if (this.internal_state == PM_BATTLE_STATE) {
				this.internal_state++;
				this.input_manager.requestCount(BACK_COUNT);
			} else if (this.internal_state == PM_UNKO_STATE) {
				this.internal_state++;
				this.input_manager.requestCount(UNKO_CLEANING_COUNT);
			} else if (this.internal_state == PM_LIGHT_STATE) {
				this.internal_state++;
				this.input_manager.requestCount(BACK_COUNT);
			} else if (this.internal_state == PM_CARE_STATE) {
				this.internal_state++;
				this.input_manager.requestCount(BACK_COUNT);
			}
		}
		this.input_manager.updateFrame();
	}

	private void updateTime() {
		// TODO 自動生成されたメソッド・スタブ
		// String current_time =
		// time.year+"/"+time.month+"/"+time.monthDay+"/"+time.hour+"/"+time.minute+"/"+time.second;
		int h = this.time.hour;
		int m = this.time.minute;
		int current_time = h*100+m;
		if(current_time != time_int){
			this.time_int = current_time;
			this.status_manager.updateStatusByMinutes(current_time);
		}
	}

	public int getState() {
		return this.state;
	}

	public int getInternalState() {
		return this.internal_state;
	}

	public int getCounter() {
		return this.counter;
	}

	public int getIconSelectionIndex() {
		return this.icon_selection_index;
	}

	public Digimon getCurrentSelectedDigimon() {
		//System.out.println(digimon_list.get(digimon_selection_index).());
		return this.digimon_list.get(digimon_selection_index);
	}

	public void calcurateTouchPoint() {
		float height = this.window_height;
		float width = this.window_width;
		double rate = (float) height / (float) width;
		double rate_rate = 0.7 / rate;
		if (rate_rate >= 1) {
			width /= rate_rate;
		} else {
			height *= rate_rate;
		}
		int sub_width =  (int)(0* (this.window_width - width) / 2);
		int sub_height = (int)( 0*(this.window_height - height) / 2);
		float width_rate = width / 460.0f;
		float height_rate = height / 320;
		this.DECIDE_BUTTON_X *= width_rate;
		this.DECIDE_BUTTON_X += sub_width;
		this.DECIDE_BUTTON_Y *= height_rate;
		this.DECIDE_BUTTON_Y += sub_height;
		this.DECIDE_BUTTON_WIDTH *= width_rate;
		this.DECIDE_BUTTON_HEIGHT *= height_rate;
		this.NEXT_DIGIMON_CHECK_WIDTH *= width_rate;
		this.DIGIMON_FRAME_BUTTON_X_COOD *= width_rate;
		this.DIGIMON_FRAME_BUTTON_X_COOD += sub_width;
		this.DIGIMON_FRAME_FIRST_BUTTON_Y *= height_rate;
		this.DIGIMON_FRAME_FIRST_BUTTON_Y += sub_height;
		this.DIGIMON_FRAME_SECOND_BUTTON_Y *= height_rate;
		this.DIGIMON_FRAME_SECOND_BUTTON_Y += sub_height;
		this.DIGIMON_FRAME_THIRD_BUTTON_Y *= height_rate;
		this.DIGIMON_FRAME_THIRD_BUTTON_Y += sub_height;
		this.DIGIMON_FRAME_BUTTON_RADIUS *= Math.min(width_rate, height_rate);
		this.DIGIMON_FRAME_MINIBUTTON_X_COOD *= width_rate;
		this.DIGIMON_FRAME_MINIBUTTON_X_COOD += sub_width;
		this.DIGIMON_FRAME_MINIBUTTON_Y_COOD *= height_rate;
		this.DIGIMON_FRAME_MINIBUTTON_Y_COOD += sub_height;
		this.DIGIMON_FRAME_MINIBUTTON_RADIUS *= Math.min(width_rate,
				height_rate);

		System.out.println("x:" + this.DECIDE_BUTTON_X + "width:"
				+ this.DECIDE_BUTTON_WIDTH + "y:" + this.DECIDE_BUTTON_Y
				+ "height:" + this.DECIDE_BUTTON_HEIGHT+"checkwidth:"+this.NEXT_DIGIMON_CHECK_WIDTH);
		System.out.println("x"+this.DIGIMON_FRAME_BUTTON_X_COOD+"y:"+this.DIGIMON_FRAME_FIRST_BUTTON_Y+":rad"+this.DIGIMON_FRAME_BUTTON_RADIUS);
	}

	public void wakeup() {
		// TODO 自動生成されたメソッド・スタブ
		File xmlfile = new File(Environment.getExternalStorageDirectory() + File.separator +"digimon"+File.separator+"savedata.xml");
		FileInputStream fileis;
		this.digimon_list = new ArrayList<Digimon>();
		this.status_manager.setDigimonList(this.digimon_list);
		try {
			fileis = new FileInputStream(xmlfile);
			XmlPullParserFactory factory;
			factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);
			XmlPullParser xpp = factory.newPullParser();
			xpp.setInput(fileis ,"UTF-8");

			int eventType = xpp.getEventType();
			Digimon digimon = null;
			int year=0,month=0,day=0,hour=0,minute = 0;
			while (eventType != XmlPullParser.END_DOCUMENT) {
				if(eventType == XmlPullParser.START_DOCUMENT) {
				} 
				else if(eventType == XmlPullParser.START_TAG) {
					System.out.println(xpp.getName());
					if(xpp.getName().equalsIgnoreCase("digimon")){
						digimon = new Digimon();
						System.out.println("create instance of digimon");
					}
					else if(xpp.getName().equalsIgnoreCase("isLiving")){
						xpp.next();String value = xpp.getText();
						digimon.setIs_living(Boolean.parseBoolean(value));
					}
					else if(xpp.getName().equalsIgnoreCase("dm")){
						xpp.next();String value = xpp.getText();
						digimon.setDm(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("weight")){
						xpp.next();String value = xpp.getText();
						digimon.setWeight(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("hungry")){
						xpp.next();String value = xpp.getText();
						digimon.setHungry(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("strength")){
						xpp.next();String value = xpp.getText();
						digimon.setStrength(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("number_of_unko")){
						xpp.next();String value = xpp.getText();
						digimon.setNumber_of_unko(Integer.parseInt(value),-100);
					}
					else if(xpp.getName().equalsIgnoreCase("dp")){
						xpp.next();String value = xpp.getText();
						digimon.setDp(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("dp_half")){
						xpp.next();String value = xpp.getText();
						digimon.setDp_half(Boolean.parseBoolean(value));
					}
					else if(xpp.getName().equalsIgnoreCase("battle_count")){
						xpp.next();String value = xpp.getText();
						digimon.setBattle_count(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("win_count")){
						xpp.next();String value = xpp.getText();
						digimon.setWin_count(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("type")){
						xpp.next();String value = xpp.getText();
						digimon.setType(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("battle_enable")){
						xpp.next();String value = xpp.getText();
						digimon.setBattle_enable(Boolean.parseBoolean(value));
					}
					else if(xpp.getName().equalsIgnoreCase("jogress_enable")){
						xpp.next();String value = xpp.getText();
						digimon.setJogress_enable(Boolean.parseBoolean(value));
					}
					else if(xpp.getName().equalsIgnoreCase("is_sleeping")){
						xpp.next();String value = xpp.getText();
						digimon.setIs_sleeping(Boolean.parseBoolean(value));
					}
					else if(xpp.getName().equalsIgnoreCase("light_on")){
						xpp.next();String value = xpp.getText();
						digimon.setIs_light_on(Boolean.parseBoolean(value));
					}
					else if(xpp.getName().equalsIgnoreCase("is_egg")){
						xpp.next();String value = xpp.getText();
						digimon.setIs_egg(Boolean.parseBoolean(value));
					}
					else if(xpp.getName().equalsIgnoreCase("egg_id")){
						xpp.next();String value = xpp.getText();
						digimon.setEgg_id(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("is_sick")){
						xpp.next();String value = xpp.getText();
						digimon.setIs_sick(Boolean.parseBoolean(value));
					}
					else if(xpp.getName().equalsIgnoreCase("is_injured")){
						xpp.next();String value = xpp.getText();
						digimon.setIs_injured(Boolean.parseBoolean(value));
					}
					else if(xpp.getName().equalsIgnoreCase("attack_type")){
						xpp.next();String value = xpp.getText();
						digimon.setAttack_type(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("is_calling")){
						xpp.next();String value = xpp.getText();
						digimon.setIs_calling(Boolean.parseBoolean(value));
					}
					else if(xpp.getName().equalsIgnoreCase("digimon_id")){
						xpp.next();String value = xpp.getText();
						digimon.setDigimon_id(Integer.parseInt(value));
						System.out.println("set digimon_id:"+digimon.getDigimon_id());
					}
					else if(xpp.getName().equalsIgnoreCase("level")){
						xpp.next();String value = xpp.getText();
						digimon.setLevel(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("protein_count")){
						xpp.next();String value = xpp.getText();
						digimon.setProtein_count(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("min_weight")){
						xpp.next();String value = xpp.getText();
						digimon.setMin_weight(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("max_eat")){
						xpp.next();String value = xpp.getText();
						digimon.setMax_eat(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("max_dp")){
						xpp.next();String value = xpp.getText();
						digimon.setMax_dp(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("potential_power")){
						xpp.next();String value = xpp.getText();
						digimon.setPotential_power(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("actual_power")){
						xpp.next();String value = xpp.getText();
						digimon.setActual_power(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("hidden_power")){
						xpp.next();String value = xpp.getText();
						digimon.setHidden_power(Float.parseFloat(value));
					}
					else if(xpp.getName().equalsIgnoreCase("hidden_power_rate")){
						xpp.next();String value = xpp.getText();
						digimon.setHidden_power_rate(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("health")){
						xpp.next();String value = xpp.getText();
						digimon.setHealth(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("health_check_interval_minutes")){
						xpp.next();String value = xpp.getText();
						digimon.setHealth_check_interval_minutes(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("health_check_elapsed_minutes")){
						xpp.next();String value = xpp.getText();
						digimon.setHealth_check_elapsed_minutes(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("hungry_interval_minutes")){
						xpp.next();String value = xpp.getText();
						digimon.setHungry_interval_minutes(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("strength_interval_minutes")){
						xpp.next();String value = xpp.getText();
						digimon.setStrength_interval_minutes(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("hungry_elapsed_minutes")){
						xpp.next();String value = xpp.getText();
						digimon.setHungry_elapsed_minutes(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("strength_elapsed_minutes")){
						xpp.next();String value = xpp.getText();
						digimon.setStrength_elapsed_minutes(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("hungry_death_minutes")){
						xpp.next();String value = xpp.getText();
						digimon.setHungry_death_minutes(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("strength_death_minutes")){
						xpp.next();String value = xpp.getText();
						digimon.setStrength_death_minutes(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("unko_interval_minutes")){
						xpp.next();String value = xpp.getText();
						digimon.setUnko_interval_minutes(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("unko_elapsed_minutes")){
						xpp.next();String value = xpp.getText();
						digimon.setUnko_elapsed_minutes(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("sleep_time")){
						xpp.next();String value = xpp.getText();
						digimon.setSleep_time(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("slept_time")){
						xpp.next();String value = xpp.getText();
						digimon.setSlept_time(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("wakeup_time")){
						xpp.next();String value = xpp.getText();
						digimon.setWakeup_time(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("wokeup_time")){
						xpp.next();String value = xpp.getText();
						digimon.setWokeup_time(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("life")){
						xpp.next();String value = xpp.getText();
						digimon.setLife(Integer.parseInt(value),"wakeup");
					}
					else if(xpp.getName().equalsIgnoreCase("progress_counter")){
						xpp.next();String value = xpp.getText();
						digimon.setProgress_counter(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("reaction")){
						xpp.next();String value = xpp.getText();
						digimon.setReaction(Boolean.parseBoolean(value));
					}
					else if(xpp.getName().equalsIgnoreCase("lifetime")){
						xpp.next();String value = xpp.getText();
						digimon.setLifetime(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("body_color_type")){
						xpp.next();String value = xpp.getText();
						digimon.getFrame().setBody_color_type(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("frame_color_type")){
						xpp.next();String value = xpp.getText();
						digimon.getFrame().setFrame_color_type(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("button_color_type")){
						xpp.next();String value = xpp.getText();
						digimon.getFrame().setButton_color_type(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("strength_interval_minuts")){
						xpp.next();String value = xpp.getText();
						digimon.setStrength_interval_minutes(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("offline_battle_count")){
						xpp.next();String value = xpp.getText();
						digimon.setOffline_battle_count(Integer.parseInt(value));
					}
					else if(xpp.getName().equalsIgnoreCase("year")){
						xpp.next();String value = xpp.getText();
						year = Integer.parseInt(value);
					}
					else if(xpp.getName().equalsIgnoreCase("month")){
						xpp.next();String value = xpp.getText();
						month = Integer.parseInt(value);
					}
					else if(xpp.getName().equalsIgnoreCase("day")){
						xpp.next();String value = xpp.getText();
						day = Integer.parseInt(value);
					}
					else if(xpp.getName().equalsIgnoreCase("hour")){
						xpp.next();String value = xpp.getText();
						hour = Integer.parseInt(value);
					}
					else if(xpp.getName().equalsIgnoreCase("minute")){
						xpp.next();String value = xpp.getText();
						minute = Integer.parseInt(value);
					}
					else if(xpp.getName().equalsIgnoreCase("pendulum_type")){
						xpp.next();String value = xpp.getText();
						digimon.setPendulum_type(Integer.parseInt(value));
					}
				}
				else if(eventType == XmlPullParser.END_TAG){
					if(xpp.getName().equalsIgnoreCase("digimon")){
						digimon.setDotPattern(this.input_manager.referDatabaseFromId(digimon.getDigimon_id()).getDot_pattern());
						System.out.println("add digimon"+digimon.toString());
						this.digimon_list.add(digimon);
						System.out.println(this.digimon_list.size());
					}
				}
				eventType = xpp.next();
			}
			int nyear = this.time.year;
			int nmonth = this.time.month;
			int nday = this.time.monthDay;
			int nhour = this.time.hour;
			int nminute = this.time.minute;
			int ctime = hour*60+minute;
			int ctime2 = nhour*60+nminute;
			System.out.println(nhour+":"+(hour*100+minute)+":"+(nhour*100+nminute)+"ctime:"+ctime+"ctime2:"+ctime2+"sub:"+(ctime2-ctime));
			if(nyear-year >0 || nmonth-month > 0){
				for(int i = 0;i<digimon_list.size();i++){
					digimon_list.get(i).setIs_living(false);
				}
			}
			else{
				int day_sub = nday - day;
				System.out.println("day:"+day_sub);
				int sub_time = ctime2-ctime;
				this.status_manager.doReloadProcessingWithElapsedMinutesAndLastTime(sub_time+day_sub*(24*60),hour*100+minute);
			}
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		System.out.println(this.digimon_list.size());
		if(this.digimon_list.size() <= 0){
			this.digimon_list.add(new Digimon());
			this.status_manager.recovery();
		}
	}

	public void sleep() {
		System.out.println("sleep");
		// TODO 自動生成されたメソッド・スタブ
		XmlSerializer serializer = Xml.newSerializer();
		System.out.println(Environment.getDataDirectory().getPath()+"/savedata.xml");
		File xmlfile = new File(Environment.getExternalStorageDirectory() + File.separator +"digimon"+File.separator+"savedata.xml");
		try{
			xmlfile.createNewFile();
		}catch(IOException e){
			Log.e("IOEXCEPTION",e.toString());
			File dir = new File(Environment.getExternalStorageDirectory()+File.separator+"digimon/");
			dir.mkdir();
			try {
				xmlfile.createNewFile();
			} catch (IOException e2) {
				// TODO 自動生成された catch ブロック
				e2.printStackTrace();
			}
		}
		FileOutputStream fileos = null;
		try {
			fileos = new FileOutputStream(xmlfile);
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		try {
			serializer.setOutput(fileos,"UTF-8");
			serializer.startDocument(null, Boolean.valueOf(true));
			serializer.startTag(null, "root");
			for(int i = 0;i<this.digimon_list.size();i++){
				digimon_list.get(i).writeToXml(serializer);
			}
			serializer.startTag(null, "time");
			serializer.startTag(null, "year");
			serializer.text(this.time.year+"");
			serializer.endTag(null, "year");
			serializer.startTag(null, "month");
			serializer.text(this.time.month+"");
			serializer.endTag(null, "month");
			serializer.startTag(null, "day");
			serializer.text(this.time.monthDay+"");
			serializer.endTag(null, "day");
			serializer.startTag(null, "hour");
			serializer.text(this.time.hour+"");
			serializer.endTag(null, "hour");
			serializer.startTag(null, "minute");
			serializer.text(this.time.minute+"");
			serializer.endTag(null, "minute");
			serializer.endTag(null, "time");
			serializer.endTag(null, "root");
			serializer.endDocument();
			serializer.flush();
			fileos.close();
		} catch (IllegalArgumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	public void ok_button_pressed(String text) {
		// TODO 自動生成されたメソッド・スタブ
		this.alert_ok = true;
	    String arg = text;
	    if(arg.length() > 0){
	        System.out.println(arg);
	        boolean success =  this.status_manager.setPromptArg(arg);
	        if(success == true){
	            if(this.status_manager.ishost() == false){
	            	this.status_manager.doOnlineBattle();
	                this.internal_state = BATTLE_ONLINE_ENCOUNT;
	                this.input_manager.destoryCount();//[self->input_manager destroy_Count];
	                this.input_manager.requestCount(ENCOUNT_ANIMATION_COUNT);//[self->input_manager request_Count:ENCOUNT_ANIMATION_COUNT];
	                System.out.println("data_send");
	            }
	            else if(this.status_manager.ishost() == true){
	                this.status_manager.doOnlineBattle();
	                this.showAlertForHost();
	                System.out.println("hosting");
	            }
	        }
	        else{
	            this.internal_state = PM_NO_THANKS;
	            this.input_manager.destoryCount();///[self->input_manager destroy_Count];
		        this.input_manager.requestCount(NO_THANKS_COUNT);
	        }
	    }
	}

	private void showAlertForHost() {
		// TODO 自動生成されたメソッド・スタブ
		parent.showAlertForHost();
	}

	public void hostalertClicked() {
		// TODO 自動生成されたメソッド・スタブ
		this.internal_state = BATTLE_ONLINE_ENCOUNT;
        this.input_manager.destoryCount();
        this.input_manager.requestCount(ENCOUNT_ANIMATION_COUNT);
	}

	public void cancled() {
		// TODO 自動生成されたメソッド・スタブ
		this.internal_state =PM_NO_THANKS;//self->internal_state = PM_NO_THANKS;
        this.input_manager.destoryCount();///[self->input_manager destroy_Count];
        this.input_manager.requestCount(NO_THANKS_COUNT);//[self->input_manager request_Count:NO_THANKS_COUNT];
	}

}
