package com.classica.classes;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import com.classica.digimoid.R;
import com.classica.classes.digimon.Digimon;
import com.classica.classes.managers.ProcessManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;

public class GLRenderer implements Renderer {
	private FloatBuffer frame_panel_vertices;
	private FloatBuffer frame_panel_uvs;
	private FloatBuffer frame_panel_top_uvs;
	private FloatBuffer back_panel_vertices;
	private FloatBuffer back_panel_uvs;
	private FloatBuffer dot_panel_vertices;
	private FloatBuffer sub_dot_panel_vertices;
	private int texture[];

	private Bitmap maintitle_image;
	private Bitmap big_button_image;
	private Bitmap body_image;
	private Bitmap frame_image;
	private Bitmap button_image;
	private Bitmap background_image;
	private Bitmap status_icon_image;
	private Bitmap food_icon_image;
	private Bitmap training_icon_image;
	private Bitmap battle_icon_image;
	private Bitmap unko_icon_image;
	private Bitmap light_icon_image;
	private Bitmap care_icon_image;
	private Bitmap call_icon_image;

	private int application_state;
	private int bleeding_state;
	private Digimon selected_digimon;
	private int icon_selection_index;
	private int counter;
	private ProcessManager manager;

	private Context context;

	private boolean reloaded;

	private int width;
	private int sub_width;
	private int height;
	private int sub_height;

	public GLRenderer(Context context) {
		this.context = context;
		initializeResource();

		this.texture = new int[14];
	}

	@Override
	public void onDrawFrame(GL10 gl) {
		// TODO 自動生成されたメソッド・スタブ
		// System.out.println("renderer on draw frame");
		this.updateStatus();
		this.drawStatus(gl);
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO 自動生成されたメソッド・スタブ
		this.width = width;
		this.height = height;
		this.manager.setWindow_width(width);
		this.manager.setWindow_height(height);
		this.manager.calcurateTouchPoint();
		double rate = (float) height / (float) width;
		double rate_rate = 0.7 / rate;
		if (rate_rate >= 1) {
			this.width /= rate_rate;
		} else {
			this.height *= rate_rate;
		}
		this.sub_width = (this.width - width) / 2;
		this.sub_height = (this.height - height) / 2;
		float vertices[] = { -1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f,
				-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f,
				1.0f, -1.0f };
		float as_rate = 0.7f;
		float rect_ver[] = { -1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f,
				1.0f / 3.0f, -1.0f, -1.0f, 1.0f / 3.0f, -1.0f, -1.0f, -1.0f,
				1.0f, -1.0f, 1.0f / 3.0f, 1.0f, -1.0f };
		float rect_uvs[] = { 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f,
				0.0f, 0.0f, 1.0f, 0.0f };
		float uvs[] = { 0.0f, 1.0f - as_rate, 0.0f, 1.0f, 1.0f, 1.0f - as_rate,
				1.0f, 1.0f - as_rate, 0.0f, 1.0f, 1.0f, 1.0f };
		float uvs_top[] = { 0.0f, 0.0f, 0.0f, as_rate, 1.0f, 0.0f, 1.0f, 0.0f,
				0.0f, as_rate, 1.0f, as_rate };
		float dot_ver[] = {0,0,-8,
				0,Digimon.DOT_DEFAULT_SCALE*2.0f,-8f,
				Digimon.DOT_DEFAULT_SCALE*2.0f,0.0f,-8f,
				Digimon.DOT_DEFAULT_SCALE*2.0f,0.0f,-8f,
				0,Digimon.DOT_DEFAULT_SCALE*2.0f,-8f,
				Digimon.DOT_DEFAULT_SCALE*2.0f,Digimon.DOT_DEFAULT_SCALE*2.0f,-8.0f};
		float sub_dot_ver[] = {0,0,-8,
				0,Digimon.SUB_DOT_DEFAULT_SCALE,-8,
				Digimon.SUB_DOT_DEFAULT_SCALE,0,-8,
				Digimon.SUB_DOT_DEFAULT_SCALE,0,-8,
				0,Digimon.SUB_DOT_DEFAULT_SCALE,-8,
				Digimon.SUB_DOT_DEFAULT_SCALE,Digimon.SUB_DOT_DEFAULT_SCALE,-8};
		
		ByteBuffer bb = ByteBuffer.allocateDirect(vertices.length * 4);
		bb.order(ByteOrder.nativeOrder());
		this.frame_panel_vertices = bb.asFloatBuffer();
		this.frame_panel_vertices.put(vertices);
		this.frame_panel_vertices.position(0);
		ByteBuffer bb2 = ByteBuffer.allocateDirect(uvs.length * 4);
		bb2.order(ByteOrder.nativeOrder());
		this.frame_panel_uvs = bb2.asFloatBuffer();
		this.frame_panel_uvs.put(uvs);
		this.frame_panel_uvs.position(0);
		ByteBuffer bb3 = ByteBuffer.allocateDirect(uvs_top.length * 4);
		bb3.order(ByteOrder.nativeOrder());
		this.frame_panel_top_uvs = bb3.asFloatBuffer();
		this.frame_panel_top_uvs.put(uvs_top);
		this.frame_panel_top_uvs.position(0);
		ByteBuffer bb4 = ByteBuffer.allocateDirect(rect_ver.length * 4);
		bb4.order(ByteOrder.nativeOrder());
		this.back_panel_vertices = bb4.asFloatBuffer();
		this.back_panel_vertices.put(rect_ver);
		this.back_panel_vertices.position(0);
		ByteBuffer bb5 = ByteBuffer.allocateDirect(rect_uvs.length * 4);
		bb5.order(ByteOrder.nativeOrder());
		this.back_panel_uvs = bb5.asFloatBuffer();
		this.back_panel_uvs.put(rect_uvs);
		this.back_panel_uvs.position(0);
		ByteBuffer bb6 = ByteBuffer.allocateDirect(dot_ver.length * 4);
		bb6.order(ByteOrder.nativeOrder());
		this.dot_panel_vertices = bb6.asFloatBuffer();
		this.dot_panel_vertices.put(dot_ver);
		this.dot_panel_vertices.position(0);
		ByteBuffer bb7 = ByteBuffer.allocateDirect(sub_dot_ver.length * 4);
		bb7.order(ByteOrder.nativeOrder());
		this.sub_dot_panel_vertices = bb7.asFloatBuffer();
		this.sub_dot_panel_vertices.put(sub_dot_ver);
		this.sub_dot_panel_vertices.position(0);

		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		gl.glClear(GL10.GL_DEPTH_BUFFER_BIT);
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		gl.glViewport(-width, -height, 2 * width, 2 * height);
		gl.glOrthof(-1.0f, 1.0f, -1.0f, 1.0f, 10.0f, -10.0f);
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig conf) {
		// TODO 自動生成されたメソッド・スタブ
		gl.glClearColor(0.65f, 0.65f, 0.65f, 1.0f);

		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glDepthFunc(GL10.GL_LEQUAL);
		gl.glDepthMask(true);

		gl.glAlphaFunc(GL10.GL_GEQUAL, 0.5f);
		gl.glEnable(GL10.GL_ALPHA_TEST);

		gl.glEnable(GL10.GL_TEXTURE_2D);

		gl.glGenTextures(14, texture, 0);
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[0]);
		GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, this.maintitle_image, 0);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER,
				GL10.GL_NEAREST);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER,
				GL10.GL_NEAREST);
		this.maintitle_image.recycle();
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[5]);
		GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, this.big_button_image, 0);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER,
				GL10.GL_NEAREST);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER,
				GL10.GL_NEAREST);
		this.big_button_image.recycle();
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[6]);
		GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, this.status_icon_image, 0);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER,
				GL10.GL_NEAREST);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER,
				GL10.GL_NEAREST);
		this.status_icon_image.recycle();
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[7]);
		GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, this.food_icon_image, 0);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER,
				GL10.GL_NEAREST);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER,
				GL10.GL_NEAREST);
		this.food_icon_image.recycle();
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[8]);
		GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, this.training_icon_image, 0);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER,
				GL10.GL_NEAREST);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER,
				GL10.GL_NEAREST);
		this.training_icon_image.recycle();
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[9]);
		GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, this.battle_icon_image, 0);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER,
				GL10.GL_NEAREST);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER,
				GL10.GL_NEAREST);
		this.battle_icon_image.recycle();
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[10]);
		GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, this.unko_icon_image, 0);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER,
				GL10.GL_NEAREST);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER,
				GL10.GL_NEAREST);
		this.unko_icon_image.recycle();
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[11]);
		GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, this.light_icon_image, 0);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER,
				GL10.GL_NEAREST);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER,
				GL10.GL_NEAREST);
		this.light_icon_image.recycle();
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[12]);
		GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, this.care_icon_image, 0);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER,
				GL10.GL_NEAREST);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER,
				GL10.GL_NEAREST);
		this.care_icon_image.recycle();
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[13]);
		GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, this.call_icon_image, 0);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER,
				GL10.GL_NEAREST);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER,
				GL10.GL_NEAREST);
		this.call_icon_image.recycle();
	}

	private void initializeResource() {
		// TODO 自動生成されたメソッド・スタブ
		this.maintitle_image = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.maintitielogo);
		this.big_button_image = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.button);
		this.status_icon_image = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.icon_status);
		this.food_icon_image = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.icon_food);
		this.training_icon_image = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.icon_training);
		this.battle_icon_image = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.icon_battle);
		this.unko_icon_image = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.icon_unko);
		this.light_icon_image = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.icon_light);
		this.care_icon_image = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.icon_care);
		this.call_icon_image = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.icon_call);
	}

	private void updateStatus() {
		manager.updateState();
		this.application_state = this.manager.getState();
		this.bleeding_state = this.manager.getInternalState();
		this.counter = this.manager.getCounter();
		boolean changed = false;
		if (this.selected_digimon != this.manager.getCurrentSelectedDigimon()) {
			changed = true;
		}
		if (changed == true) {
			this.selected_digimon = this.manager.getCurrentSelectedDigimon();
			//System.out.println("digimon pointer has changed"+this.selected_digimon.toString());
			this.reloadData();
		}
		this.icon_selection_index = this.manager.getIconSelectionIndex();
	}

	private void drawStatus(GL10 gl) {
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		gl.glViewport(-sub_width, -sub_height, width, height);
		gl.glOrthof(-1.0f, 1.0f, 1.0f, -1.0f, 10.0f, -10.0f);
		gl.glEnable(GL10.GL_ALPHA_TEST);
		gl.glAlphaFunc(GL10.GL_GEQUAL, 0.5f);

		if (this.reloaded == true) {
			reloadTextureOfFrame(gl);
			this.reloaded = false;
		}
		if (this.application_state == ProcessManager.PM_MAINTITLE_STATE) {
			gl.glActiveTexture(GL10.GL_TEXTURE0);
			gl.glEnable(GL10.GL_TEXTURE_2D);
			gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[0]);
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, this.frame_panel_uvs);
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// 頂点バッファの有効化
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, this.frame_panel_vertices);// 頂点バッファをOpen
																				// GLに紐付け
			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 6);
		} else if (this.application_state == ProcessManager.PM_DIGIMON_SELECTION_STATE) {
			gl.glActiveTexture(GL10.GL_TEXTURE0);
			gl.glEnable(GL10.GL_TEXTURE_2D);
			this.drawFrame(gl);
			gl.glPushMatrix();
			gl.glTranslatex(0, 0, -8);
			gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[5]);
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, this.frame_panel_top_uvs);
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// 頂点バッファの有効化
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, this.frame_panel_vertices);// 頂点バッファをOpen
																				// GLに紐付け
			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 6);
			gl.glPopMatrix();
			this.drawDot(gl);
		} else if (this.application_state == ProcessManager.PM_DIGIMON_BLEEDING_STATE) {
			this.drawFrame(gl);
			this.drawDot(gl);
		}
	}

	private void drawDot(GL10 gl) {
		// TODO 自動生成されたメソッド・スタブ
		this.selected_digimon.generateDrawPart(this.bleeding_state, this.counter);
		gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
		gl.glDisable(GL10.GL_TEXTURE_2D);
		gl.glPushMatrix();
		gl.glTranslatef(Digimon.DOT_IMAGE_DEFAULT_POSITION_X, Digimon.DOT_IMAGE_DEFAULT_POSITION_Y, -1.0f);
		gl.glColor4f(0.0f, 0.0f, 0.0f, 1.0f);
		for(int i = 0;i<selected_digimon.getDot_positions().size();i++){
			gl.glPushMatrix();
			gl.glScalef(Digimon.DOT_DEFAULT_SCALE*2.0f/3.0f, Digimon.DOT_DEFAULT_SCALE, 1.0f);
			gl.glTranslatef(selected_digimon.getDot_positions().get(i).x, selected_digimon.getDot_positions().get(i).y, 0.0f);
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, this.dot_panel_vertices);
			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 6);
			gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
			gl.glPopMatrix();
		}
		gl.glPopMatrix();
		gl.glPushMatrix();
		gl.glTranslatef(Digimon.SUB_DOT_IMAGE_DEFAULT_POSITION_X, Digimon.SUB_DOT_IMAGE_DEFAULT_POSITION_Y, -1.0f);
		for(int i = 0;i<selected_digimon.getsub_dot_positions().size();i++){
			gl.glPushMatrix();
			gl.glScalef(Digimon.SUB_DOT_DEFAULT_SCALE*2.0f/3.0f, Digimon.SUB_DOT_DEFAULT_SCALE, 1.0f);
			gl.glTranslatef(selected_digimon.getsub_dot_positions().get(i).x, selected_digimon.getsub_dot_positions().get(i).y, 0.0f);
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, this.sub_dot_panel_vertices);
			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 6);
			gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
			gl.glPopMatrix();
		}
		gl.glPopMatrix();
		gl.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		
		gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
		gl.glEnable(GL10.GL_TEXTURE_2D);
	}

	private void reloadTextureOfFrame(GL10 gl) {
		// TODO 自動生成されたメソッド・スタブ
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[1]);
		GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, this.body_image, 0);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER,
				GL10.GL_NEAREST);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER,
				GL10.GL_NEAREST);
		this.body_image.recycle();
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[2]);
		GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, this.frame_image, 0);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER,
				GL10.GL_NEAREST);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER,
				GL10.GL_NEAREST);
		this.frame_image.recycle();
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[3]);
		GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, this.button_image, 0);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER,
				GL10.GL_NEAREST);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER,
				GL10.GL_NEAREST);
		this.button_image.recycle();
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[4]);
		GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, this.background_image, 0);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER,
				GL10.GL_NEAREST);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER,
				GL10.GL_NEAREST);
		this.background_image.recycle();
	}

	public void reloadData() {
		this.reloaded = true;
		if (this.selected_digimon.getFrame().getBody_color_type() == 0) {
			this.body_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonbodyblick);
		} else if (this.selected_digimon.getFrame().getBody_color_type() == 1) {
			this.body_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonbodyblock);
		}else if (this.selected_digimon.getFrame().getBody_color_type() == 2) {
			this.body_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonbodyblue);
		}
		else if (this.selected_digimon.getFrame().getBody_color_type() == 3) {
			this.body_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonbodydarkgreen);
		}else if (this.selected_digimon.getFrame().getBody_color_type() == 4) {
			this.body_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonbodygrass);
		}else if (this.selected_digimon.getFrame().getBody_color_type() == 5) {
			this.body_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonbodygreen);
		}else if (this.selected_digimon.getFrame().getBody_color_type() == 6) {
			this.body_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonbodygreenblock);
		}else if (this.selected_digimon.getFrame().getBody_color_type() == 7) {
			this.body_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonbodyleaf);
		}else if (this.selected_digimon.getFrame().getBody_color_type() == 8) {
			this.body_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonbodymetal);
		}else if (this.selected_digimon.getFrame().getBody_color_type() == 9) {
			this.body_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonbodypink);
		}else if (this.selected_digimon.getFrame().getBody_color_type() == 10) {
			this.body_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonbodyred);
		}else if (this.selected_digimon.getFrame().getBody_color_type() == 11) {
			this.body_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonbodystone);
		}else if (this.selected_digimon.getFrame().getBody_color_type() == 12) {
			this.body_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonbodywater);
		}else if (this.selected_digimon.getFrame().getBody_color_type() == 13) {
			this.body_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonbodywine);
		}
		if (this.selected_digimon.getFrame().getFrame_color_type() == 0) {
			this.frame_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonframeaquablue);
		} else if (this.selected_digimon.getFrame().getFrame_color_type() == 1) {
			this.frame_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonframeblue);
		}else if (this.selected_digimon.getFrame().getFrame_color_type() == 2) {
			this.frame_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonframefence);
		}else if (this.selected_digimon.getFrame().getFrame_color_type() == 3) {
			this.frame_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonframegrey);
		}else if (this.selected_digimon.getFrame().getFrame_color_type() == 4) {
			this.frame_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonframelightgreen);
		}else if (this.selected_digimon.getFrame().getFrame_color_type() == 5) {
			this.frame_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonframelightpurple);
		}else if (this.selected_digimon.getFrame().getFrame_color_type() == 6) {
			this.frame_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonframelightyellow);
		}else if (this.selected_digimon.getFrame().getFrame_color_type() == 7) {
			this.frame_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonframeorange);
		}else if (this.selected_digimon.getFrame().getFrame_color_type() == 8) {
			this.frame_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonframepink);
		}else if (this.selected_digimon.getFrame().getFrame_color_type() == 9) {
			this.frame_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonframepurple);
		}else if (this.selected_digimon.getFrame().getFrame_color_type() == 10) {
			this.frame_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonframered);
		}else if (this.selected_digimon.getFrame().getFrame_color_type() == 11) {
			this.frame_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonframewhite);
		}else if (this.selected_digimon.getFrame().getFrame_color_type() == 12) {
			this.frame_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonframeyellow);
		}
		if (this.selected_digimon.getFrame().getButton_color_type() == 0) {
			this.button_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonbuttonaquablue);
		} else if (this.selected_digimon.getFrame().getBody_color_type() == 1) {
			this.button_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonbuttonaquasand);
		}else if (this.selected_digimon.getFrame().getBody_color_type() == 2) {
			this.button_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonbuttonblack);
		}else if (this.selected_digimon.getFrame().getBody_color_type() == 3) {
			this.button_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonbuttonblue);
		}else if (this.selected_digimon.getFrame().getBody_color_type() == 4) {
			this.button_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonbuttoncream);
		}else if (this.selected_digimon.getFrame().getBody_color_type() == 5) {
			this.button_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonbuttondeepgreen);
		}else if (this.selected_digimon.getFrame().getBody_color_type() == 6) {
			this.button_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonbuttondeepwhite);
		}else if (this.selected_digimon.getFrame().getBody_color_type() == 7) {
			this.button_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonbuttonlightpurple);
		}else if (this.selected_digimon.getFrame().getBody_color_type() == 8) {
			this.button_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonbuttonorange);
		}else if (this.selected_digimon.getFrame().getBody_color_type() == 9) {
			this.button_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonbuttonpink);
		}else if (this.selected_digimon.getFrame().getBody_color_type() == 10) {
			this.button_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonbuttonpurple);
		}else if (this.selected_digimon.getFrame().getBody_color_type() == 11) {
			this.button_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonbuttonred);
		}else if (this.selected_digimon.getFrame().getBody_color_type() == 12) {
			this.button_image = BitmapFactory.decodeResource(
					context.getResources(), R.drawable.digimonbuttonwood);
		}
		this.background_image = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.background);
	}

	public void setProcessManager(ProcessManager manager) {
		this.manager = manager;
	}

	public void drawFrame(GL10 gl) {
		gl.glActiveTexture(GL10.GL_TEXTURE0);
		gl.glEnable(GL10.GL_TEXTURE_2D);
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[1]);
		gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
		gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, this.frame_panel_top_uvs);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// 頂点バッファの有効化
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, this.frame_panel_vertices);// 頂点バッファをOpen
																			// GLに紐付け
		gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 6);

		gl.glPushMatrix();
		gl.glTranslatef(-0.1f, 0, -1);
		gl.glScalef(0.5f, -0.5f, 0.5f);
		gl.glEnable(GL10.GL_TEXTURE_2D);
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[4]);
		gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
		gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, this.back_panel_uvs);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// 頂点バッファの有効化
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, this.back_panel_vertices);// 頂点バッファをOpen
																			// GLに紐付け
		gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 6);
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glTranslatef(0, 0, -2);
		gl.glActiveTexture(GL10.GL_TEXTURE0);
		gl.glEnable(GL10.GL_TEXTURE_2D);
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[2]);
		gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
		gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, this.frame_panel_top_uvs);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// 頂点バッファの有効化
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, this.frame_panel_vertices);// 頂点バッファをOpen
																			// GLに紐付け
		gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 6);

		gl.glActiveTexture(GL10.GL_TEXTURE0);
		gl.glEnable(GL10.GL_TEXTURE_2D);
		gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[3]);
		gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
		gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, this.frame_panel_top_uvs);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// 頂点バッファの有効化
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, this.frame_panel_vertices);// 頂点バッファをOpen
																			// GLに紐付け
		gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 6);
		gl.glPopMatrix();
		this.drawIcons(gl);
	}

	private void drawIcons(GL10 gl) {
		// TODO 自動生成されたメソッド・スタブ
		if (this.icon_selection_index == 1) {
			gl.glPushMatrix();
			gl.glTranslatef(-0.5f, -0.35f, -5.0f);
			gl.glScalef(0.05f, -0.05f, 1);
			gl.glActiveTexture(GL10.GL_TEXTURE0);
			gl.glEnable(GL10.GL_TEXTURE_2D);
			gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[6]);
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, this.back_panel_uvs);
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// 頂点バッファの有効化
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, this.back_panel_vertices);// 頂点バッファをOpen
																				// GLに紐付け
			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 6);
			gl.glPopMatrix();
		}
		else if (this.icon_selection_index == 2) {
			gl.glPushMatrix();
			gl.glTranslatef(-0.166f*2, -0.35f, -5.0f);
			gl.glScalef(0.05f, -0.05f, 1);
			gl.glActiveTexture(GL10.GL_TEXTURE0);
			gl.glEnable(GL10.GL_TEXTURE_2D);
			gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[7]);
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, this.back_panel_uvs);
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// 頂点バッファの有効化
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, this.back_panel_vertices);// 頂点バッファをOpen
																				// GLに紐付け
			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 6);
			gl.glPopMatrix();
		}
		else if (this.icon_selection_index == 3) {
			gl.glPushMatrix();
			gl.glTranslatef(-0.166f, -0.35f, -5.0f);
			gl.glScalef(0.05f, -0.05f, 1);
			gl.glActiveTexture(GL10.GL_TEXTURE0);
			gl.glEnable(GL10.GL_TEXTURE_2D);
			gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[8]);
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, this.back_panel_uvs);
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// 頂点バッファの有効化
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, this.back_panel_vertices);// 頂点バッファをOpen
																				// GLに紐付け
			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 6);
			gl.glPopMatrix();
		}
		else if (this.icon_selection_index == 4) {
			gl.glPushMatrix();
			gl.glTranslatef(0, -0.35f, -5.0f);
			gl.glScalef(0.05f, -0.05f, 1);
			gl.glActiveTexture(GL10.GL_TEXTURE0);
			gl.glEnable(GL10.GL_TEXTURE_2D);
			gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[9]);
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, this.back_panel_uvs);
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// 頂点バッファの有効化
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, this.back_panel_vertices);// 頂点バッファをOpen
																				// GLに紐付け
			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 6);
			gl.glPopMatrix();
		}
		else if (this.icon_selection_index == 5) {
			gl.glPushMatrix();
			gl.glTranslatef(-0.5f, 0.35f, -5.0f);
			gl.glScalef(0.05f, -0.05f, 1);
			gl.glActiveTexture(GL10.GL_TEXTURE0);
			gl.glEnable(GL10.GL_TEXTURE_2D);
			gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[10]);
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, this.back_panel_uvs);
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// 頂点バッファの有効化
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, this.back_panel_vertices);// 頂点バッファをOpen
																				// GLに紐付け
			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 6);
			gl.glPopMatrix();
		}
		else if (this.icon_selection_index == 6) {
			gl.glPushMatrix();
			gl.glTranslatef(-0.166f*2, 0.35f, -5.0f);
			gl.glScalef(0.05f, -0.05f, 1);
			gl.glActiveTexture(GL10.GL_TEXTURE0);
			gl.glEnable(GL10.GL_TEXTURE_2D);
			gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[11]);
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, this.back_panel_uvs);
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// 頂点バッファの有効化
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, this.back_panel_vertices);// 頂点バッファをOpen
																				// GLに紐付け
			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 6);
			gl.glPopMatrix();
		}
		else if (this.icon_selection_index == 7) {
			gl.glPushMatrix();
			gl.glTranslatef(-0.166f, 0.35f, -5.0f);
			gl.glScalef(0.05f, -0.05f, 1);
			gl.glActiveTexture(GL10.GL_TEXTURE0);
			gl.glEnable(GL10.GL_TEXTURE_2D);
			gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[12]);
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, this.back_panel_uvs);
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// 頂点バッファの有効化
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, this.back_panel_vertices);// 頂点バッファをOpen
																				// GLに紐付け
			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 6);
			gl.glPopMatrix();
		}
		if (selected_digimon.isIs_calling() == true) {
			gl.glPushMatrix();
			gl.glTranslatef(0, 0.35f, -5.0f);
			gl.glScalef(0.05f, -0.05f, 1);
			gl.glActiveTexture(GL10.GL_TEXTURE0);
			gl.glEnable(GL10.GL_TEXTURE_2D);
			gl.glBindTexture(GL10.GL_TEXTURE_2D, texture[13]);
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, this.back_panel_uvs);
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);// 頂点バッファの有効化
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, this.back_panel_vertices);// 頂点バッファをOpen
																				// GLに紐付け
			gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 6);
			gl.glPopMatrix();
		}
	}
}
