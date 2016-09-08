package com.example.bubble_table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.andengine.audio.music.Music;
import org.andengine.audio.music.MusicFactory;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.input.touch.TouchEvent;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.badlogic.gdx.math.Vector2;


public class GameScene extends Scene implements SensorEventListener {
	public static PhysicsWorld physicsWorld;

	// Sensor
	SensorManager meinSensorManager;
	Sensor meinAccelerometer;

	public static PlayerBall MyBall = null;
	public static List<FireBall> FireBalls = null;
	public static Uhr uhr = null;
	public static List<Stern> MyStars = null;
	public static List<FlashBall> FlashBalls = null;
	public static List<PurpleBall> PurpleBalls = null;
	public static List<AquaBall> AquaBalls = null;
	public static List<Bullet> Bullets = null;

	public static AmmoBullet ammoBullet = null;
	public static AnimatedSprite shieldActivator = null;
	
	public static Music backMusic = null;

	public void createPhysicsWorld() {
		physicsWorld = new PhysicsWorld(new Vector2(0f, 0f), false);
		this.registerUpdateHandler(physicsWorld);
	}

	public void createMyBall() {
		MyBall = new PlayerBall(MainActivity.getSharedInstance().rndGenerator.nextInt(MainActivity.CAMERA_WIDTH-50), MainActivity.getSharedInstance().rndGenerator.nextInt(MainActivity.CAMERA_HEIGHT-50));
		this.attachChild(MyBall.PlayerShield);
		this.attachChild(MyBall);
	}

	public static void deleteFireBalls() {
		// Feuerb‰lle s‰ubern
		FireBalls.clear();
	}

	public static void deleteFlashBalls() {
		// Feuerb‰lle s‰ubern
		FlashBalls.clear();
	}

	public static void deletePurpleBalls() {
		// Feuerb‰lle s‰ubern
		PurpleBalls.clear();
	}

	public static void deleteAquaBalls() {
		// Feuerb‰lle s‰ubern
		AquaBalls.clear();
	}

	public void createUhr() {
		uhr = new Uhr(
				MainActivity.rndGenerator
						.nextInt(MainActivity.CAMERA_WIDTH - 30),
				MainActivity.rndGenerator
						.nextInt(MainActivity.CAMERA_HEIGHT - 30));
		this.attachChild(uhr);
		uhr.setVisible(false);
	}

	public static void deleteUhr() {
		uhr.setVisible(false);
		uhr = null;

	}

	public void createAmmoBullet() {
		ammoBullet = new AmmoBullet(
				MainActivity.rndGenerator
						.nextInt(MainActivity.CAMERA_WIDTH - 30),
				MainActivity.rndGenerator
						.nextInt(MainActivity.CAMERA_HEIGHT - 30));
		this.attachChild(ammoBullet);
		ammoBullet.setVisible(false);
	}

	public static void deleteAmmoBullet() {
		ammoBullet.setVisible(false);
		ammoBullet = null;

	}

	public void createShieldActivator() {
		shieldActivator = new AnimatedSprite(
				MainActivity.rndGenerator
						.nextInt(MainActivity.CAMERA_WIDTH - 30),
				MainActivity.rndGenerator
						.nextInt(MainActivity.CAMERA_HEIGHT - 30), 30, 30,
				MainActivity.getSharedInstance().ShieldTextureRegion,
				MainActivity.getSharedInstance().getVertexBufferObjectManager());
		this.attachChild(shieldActivator);
		shieldActivator.setVisible(false);
	}

	public static void deleteShieldActivator() {
		shieldActivator.setVisible(false);
		shieldActivator = null;

	}

	public static void deleteMyStars() {
		// Sterne s‰ubern
		for (int i = 0; i < MyStars.size(); i++) {
			MyStars.get(i).setVisible(false);
			MyStars.get(i).detachSelf();
			MyStars.remove(i);
		}
	}

	public static void deleteBullets() {
		// Bullets s‰ubern
		for (int i = 0; i < Bullets.size(); i++) {
			Bullets.get(i).setVisible(false);
			Bullets.get(i).detachSelf();
			Bullets.remove(i);
		}
	}

	public void createSensor() {
		this.meinSensorManager = (SensorManager) MainActivity
				.getSharedInstance().getSystemService(Context.SENSOR_SERVICE);
		if (this.meinSensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER)
				.size() != 0) {
			this.meinAccelerometer = meinSensorManager.getSensorList(
					Sensor.TYPE_ACCELEROMETER).get(0);
			this.meinSensorManager.registerListener(this, meinAccelerometer,
					SensorManager.SENSOR_DELAY_GAME);
		}
	}

	public GameScene() {
		super();
		
		try {

			this.backMusic = MusicFactory.createMusicFromAsset(MainActivity.getSharedInstance().getMusicManager(),
					MainActivity.getSharedInstance(), "music/back1.MP3");

		} catch (IOException ex) {

		}
		backMusic.play();
		backMusic.setLooping(true);
		MainActivity.getSharedInstance().played = true;
		// Spielvariablen zur¸cksetzen
		MainActivity.getSharedInstance().punkte = 0;
		MainActivity.getSharedInstance().remaining_time = 10;
		MainActivity.getSharedInstance().level = 1;

		// PhysicWorld erstellen
		createPhysicsWorld();
		// PlayerBall erstellen
		createMyBall();
		// Erstelle Uhr f¸r nacher..
		createUhr();
		// Erstelle BulletAmmo f¸r nacher..
		createAmmoBullet();
		// Erstelle BulletAmmo f¸r nacher..
		createShieldActivator();
		MyStars = new ArrayList<Stern>();
		FireBalls = new ArrayList<FireBall>();
		FlashBalls = new ArrayList<FlashBall>();
		PurpleBalls = new ArrayList<PurpleBall>();
		AquaBalls = new ArrayList<AquaBall>();

		Bullets = new ArrayList<Bullet>();
		for (int i = 0; i < 1; i++) {
			FireBalls.add(new FireBall());
			this.attachChild(FireBalls.get(FireBalls.size() - 1));
		}

		// Updater
		this.registerUpdateHandler(new TimerHandler(0.1f, true,
				new GameLoopOutsideChecker()));
		this.registerUpdateHandler(new TimerHandler(0.03f, true,
				new GameLoopCollider()));
		this.registerUpdateHandler(new TimerHandler(1f, true,
				new GameLoopEventManager()));
		this.registerUpdateHandler(new TimerHandler(0.3f, true,
				new GameLoopOutput()));
		// Sensor erstellen
		createSensor();

		this.setTouchAreaBindingOnActionDownEnabled(true);
	}

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSensorChanged(SensorEvent arg0) {
		// TODO: Bewegung optimieren
		if (arg0.values[0] < -1) {
			MyBall.body.setLinearVelocity(MyBall.body.getLinearVelocity().x
					* 0.95f - arg0.values[0] / 10,
					MyBall.body.getLinearVelocity().y);
		} else if (arg0.values[0] > 1) {
			MyBall.body.setLinearVelocity(MyBall.body.getLinearVelocity().x
					* 0.95f - arg0.values[0] / 10,
					MyBall.body.getLinearVelocity().y);

		}
		if (arg0.values[1] < -1) { // oben
			MyBall.body.setLinearVelocity(MyBall.body.getLinearVelocity().x,
					MyBall.body.getLinearVelocity().y * 0.95f + arg0.values[1]
							/ 10);
		} else if (arg0.values[1] > 1) { // unten
			MyBall.body.setLinearVelocity(MyBall.body.getLinearVelocity().x,
					(float) MyBall.body.getLinearVelocity().y * 0.95f
							+ arg0.values[1] / 10);

		}

	}

	@Override
	public boolean onSceneTouchEvent(TouchEvent pSceneTouchEvent) {
		if (pSceneTouchEvent.isActionDown()) {
			if (MyBall.ammo > 0) {
				// Schieﬂen
				Bullets.add(new Bullet(pSceneTouchEvent.getX(),
						pSceneTouchEvent.getY()));
				GameScene.this.attachChild(Bullets.get(Bullets.size() - 1));
				MyBall.ammo--;
			}
		}
		return super.onSceneTouchEvent(pSceneTouchEvent);
	}

}
