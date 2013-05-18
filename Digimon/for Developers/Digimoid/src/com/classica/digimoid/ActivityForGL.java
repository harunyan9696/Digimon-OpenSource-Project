package com.classica.digimoid;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.classica.classes.Element;
import com.classica.classes.GLPanel;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.util.Log;
import android.view.Menu;

public class ActivityForGL extends Activity {
	GLPanel panel;
	ArrayList<Element> elements;
	private SensorManager sensorManager;
    private boolean isAccSensor = false;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

		panel = new GLPanel(this);
		setContentView(panel);
		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		elements = new ArrayList<Element>();
		try {
			this.generateDictionary();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			System.out.println("event thrown "+e.getClass().toString());
		}
		panel.initialize();
		panel.setDatabaseForInputManager(this.elements);
	}
	private void generateDictionary() throws Exception{
		XmlPullParserFactory factory;
		factory = XmlPullParserFactory.newInstance();
		factory.setNamespaceAware(true);
		XmlPullParser xpp = factory.newPullParser();

		InputStream inputStream = getResources().openRawResource(R.raw.androiddatabase);
		xpp.setInput(inputStream ,"UTF-8");

		int eventType = xpp.getEventType();
		Element element = new Element();
		while (eventType != XmlPullParser.END_DOCUMENT) {
			if(eventType == XmlPullParser.START_DOCUMENT) {
			} else if(eventType == XmlPullParser.START_TAG) {
				if(xpp.getName().equalsIgnoreCase("digimon")){
					element = new Element();
				}
				else if(xpp.getName().equalsIgnoreCase("id")){
					xpp.next();
					element.setId(Integer.parseInt(xpp.getText()));
				}
				else if(xpp.getName().equalsIgnoreCase("type")){
					xpp.next();
					element.setType(Integer.parseInt(xpp.getText()));
				}
				else if(xpp.getName().equalsIgnoreCase("level")){
					xpp.next();
					element.setLevel(Integer.parseInt(xpp.getText()));
				}
				else if(xpp.getName().equalsIgnoreCase("species_power")){
					xpp.next();
					element.setSpecies_power(Integer.parseInt(xpp.getText()));
				}
				else if(xpp.getName().equalsIgnoreCase("min_weight")){
					xpp.next();
					element.setMin_weight(Integer.parseInt(xpp.getText()));
				}
				else if(xpp.getName().equalsIgnoreCase("attack_type")){
					xpp.next();
					element.setAttack_type(Integer.parseInt(xpp.getText()));
				}
				else if(xpp.getName().equalsIgnoreCase("dot_pattern")){
					xpp.next();
					element.setDot_pattern(xpp.getText());
				}
				else if(xpp.getName().startsWith("id") && xpp.getName().length() != 2){
					int id = Integer.parseInt(xpp.getName().substring(2));
					element.getNext_digimons().add(id);
					xpp.next();
					element.getRequire_dps().add(Integer.parseInt(xpp.getText()));
				}
			} else if(eventType == XmlPullParser.END_TAG) {
				if(xpp.getName().equalsIgnoreCase("digimon")){
					this.elements.add(element);
				}
			}
			eventType = xpp.next();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_for_gl, menu);
		return true;
	}
	@Override
	protected void onPause() {
		// TODO 自動生成されたメソッド・スタブ
			panel.sleep();
			Log.v("RsPa","pause");
			 if (isAccSensor){
		            sensorManager.unregisterListener(this.panel);
		        }
		super.onPause();
	}
	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for (Sensor sensor : sensors) {
        	System.out.println("sensor detected");
            if( sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            	System.out.println("acc sensor detected");
                sensorManager.registerListener( this.panel, sensor, SensorManager.SENSOR_DELAY_UI);
                isAccSensor = false;
            }
        }
			Log.v("RsPa","resume");
			this.elements = null;
			panel.wakeup();
	}
}
