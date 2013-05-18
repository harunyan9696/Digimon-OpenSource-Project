package com.classica.classes;

import java.util.ArrayList;

import com.classica.classes.events.ShakeEvent;
import com.classica.classes.events.TouchEvent;
import com.classica.classes.managers.InputManager;
import com.classica.classes.managers.ProcessManager;
import com.classica.classes.managers.StatusManager;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class GLPanel extends GLSurfaceView implements SensorEventListener,DialogInterface.OnClickListener{
	GLRenderer renderer;
	ProcessManager process_manager;
	InputManager input_manager;
	StatusManager status_manager;
	
	private int window_width;
	private int window_height;
	private float[] accelerometerValues;
	
	Builder myAlertView;
    Builder hostAlertView;
    EditText myTextField;
	
	private final Handler handler = new Handler();
	
	private boolean showing_alert_client;
	private boolean showing_alert_host;
	
	public GLPanel(Context context) {
		super(context);
		// TODO 自動生成されたコンストラクター・スタブ
		WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
		Display disp = wm.getDefaultDisplay();
	 	
	 	this.window_width = disp.getWidth();
	 	this.window_height = disp.getHeight();
    	myAlertView=new AlertDialog.Builder(getContext());
  		myTextField = new EditText(getContext());
  		hostAlertView=new AlertDialog.Builder(getContext());
  	    myAlertView.setTitle("Your Client Key");
  	    myAlertView.setPositiveButton("OK",this);
  	    myAlertView.setNegativeButton("Cancel",this);
  	    myAlertView.setView(myTextField);
  	    myAlertView.create();
	    hostAlertView.setTitle("Your Host Key");
	    hostAlertView.setPositiveButton("OK",this);
	    hostAlertView.setNegativeButton("Cancel", this);
	    hostAlertView.create();
	}
	public void initialize(){
		this.process_manager = new ProcessManager(this.getContext(),this);
		this.input_manager = new InputManager();
		this.status_manager = new StatusManager();
		this.status_manager.setInputManager(this.input_manager);
		
		this.process_manager.setInputManager(input_manager);
		this.process_manager.setStatusManager(status_manager);
		
		/*this.process_manager.setWindow_width(window_width);
		this.process_manager.setWindow_height(window_height);
		this.process_manager.calcurateTouchPoint();*/
		
	 	
	 	renderer = new GLRenderer(this.getContext());
		renderer.setProcessManager(this.process_manager);
		this.setRenderer(renderer);
		Log.v("glpanel","panel initialized with renderer");
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO 自動生成されたメソッド・スタブ
		int x = (int)event.getX();
		int y = (int)event.getY();
		TouchEvent touch_event = new TouchEvent();
		Point point;
		
		switch(event.getAction() & MotionEvent.ACTION_MASK) {
		case MotionEvent.ACTION_DOWN:
			touch_event.setState(TouchEvent.TOUCH_TOUCHED);
			System.out.println("touch");
			point = new Point(x, y);
			touch_event.setObject(point);
			input_manager.pushEvent(touch_event);
			break;
		case MotionEvent.ACTION_UP:
			touch_event.setState(TouchEvent.TOUCH_RELEASED);
			System.out.println("release");
			point = new Point(x, y);
			touch_event.setObject(point);
			input_manager.pushEvent(touch_event);
			break;
		case MotionEvent.ACTION_CANCEL:
			break;
		}
		return true;
	}
	public void setDatabaseForInputManager(ArrayList<Element> list){
		this.input_manager.setDatabase(list);
	}
	public void wakeup() {
		// TODO 自動生成されたメソッド・スタブ
			this.process_manager.wakeup();
			this.process_manager.startState();
	}
	public void sleep() {
		// TODO 自動生成されたメソッド・スタブ
		this.process_manager.sleep();
	}
	@Override
    public void onSensorChanged(SensorEvent event) {
		//System.out.println("changed"+event.accuracy);
        switch (event.sensor.getType()) {
            case Sensor.TYPE_ACCELEROMETER:
                accelerometerValues = event.values.clone();
                break;
        }

        if (accelerometerValues != null) {
        	//System.out.println("kasokudo");
            float targetValue =
                    Math.abs(accelerometerValues[0]) +
                            Math.abs(accelerometerValues[1]) +
                            Math.abs(accelerometerValues[2]);
            //System.out.println(targetValue);
            if(targetValue > 40.0f) {
            	System.out.println("ok");
                ShakeEvent shake = new ShakeEvent();
                this.input_manager.pushEvent(shake);
            }
        }
    }
	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	public void showAleat() {
		// TODO 自動生成されたメソッド・スタブ
		this.showing_alert_client = true;
		this.showing_alert_host = false;
		    handler.post(new Runnable() {
		      public void run() {
		    	  
		  	    myAlertView.setMessage(status_manager.getBattleString(false));
		  	    myAlertView.show();
		      }
		    });
	}

	public void showAlertForHost() {
		// TODO 自動生成されたメソッド・スタブ
		this.showing_alert_client = false;
		this.showing_alert_host = true;
		handler.post(new Runnable() {
			public void run() {
				hostAlertView.setMessage(status_manager.getBattleString(true));
				hostAlertView.show();
			}
		});
	}
	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("clicked"+which+":pointer"+dialog);
		if(which == DialogInterface.BUTTON_POSITIVE){
	        if(this.showing_alert_client == true){
	            this.process_manager.ok_button_pressed(this.myTextField.getText().toString());
	            this.myTextField.setText("");
	            this.showing_alert_client = false;
	            dialog.dismiss();
	            dialog.cancel();
	        }
	        else if(this.showing_alert_host = true){
	        	System.out.println("call");
	        	this.process_manager.hostalertClicked();
	        	this.showing_alert_host = false;
	        	dialog.dismiss();
	        	dialog.cancel();
	        }
	    }
	    else{
	        this.process_manager.cancled();
	        this.showing_alert_client = false;
	        this.showing_alert_host = false;
	        dialog.dismiss();
        	dialog.cancel();
	    }
		myAlertView=new AlertDialog.Builder(getContext());
  		myTextField = new EditText(getContext());
  		hostAlertView=new AlertDialog.Builder(getContext());
  	    myAlertView.setTitle("Your Client Key");
  	    myAlertView.setPositiveButton("OK",this);
  	    myAlertView.setNegativeButton("Cancel",this);
  	    myAlertView.setView(myTextField);
  	    myAlertView.create();
	    hostAlertView.setTitle("Your Host Key");
	    hostAlertView.setPositiveButton("OK",this);
	    hostAlertView.setNegativeButton("Cancel", this);
	    hostAlertView.create();
	}
}
