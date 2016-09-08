package com.example.bubble_table;

import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.entity.modifier.ScaleModifier;
import org.andengine.entity.scene.background.Background;
import org.andengine.util.color.Color;

public class GameLoopEventManager implements ITimerCallback {
	int counter = 0;
	int rndEventNumber = 1000;

	@Override
	public void onTimePassed(TimerHandler pTimerHandler) {
		// Alle 15 Sekunden mehr Zeit
		if (counter % 20 == 0) {
			GameScene.uhr.setVisible(true);
			GameScene.uhr.setX(MainActivity.getSharedInstance().rndGenerator
					.nextInt(MainActivity.CAMERA_WIDTH - 30));
			GameScene.uhr.setY(MainActivity.getSharedInstance().rndGenerator
					.nextInt(MainActivity.CAMERA_HEIGHT - 30));

		}
		// Ab Level 2 Shield
		if (counter % 25 == 0 && MainActivity.getSharedInstance().level >= 2) {
			GameScene.shieldActivator.setVisible(true);
			GameScene.shieldActivator
					.setX(MainActivity.getSharedInstance().rndGenerator
							.nextInt(MainActivity.CAMERA_WIDTH - 30));
			GameScene.shieldActivator
					.setY(MainActivity.getSharedInstance().rndGenerator
							.nextInt(MainActivity.CAMERA_HEIGHT - 30));

		}
		// Ab Level 4 Ammo
		if (counter % 20 == 0 && MainActivity.getSharedInstance().level >= 3) {
			GameScene.ammoBullet.setVisible(true);
			GameScene.ammoBullet
					.setX(MainActivity.getSharedInstance().rndGenerator
							.nextInt(MainActivity.CAMERA_WIDTH - 30));
			GameScene.ammoBullet
					.setY(MainActivity.getSharedInstance().rndGenerator
							.nextInt(MainActivity.CAMERA_HEIGHT - 30));

		}
		if (counter % 20 == 0 && counter != 0) {
			// Füge neuen Ball hinzu
			GameScene.FireBalls.add(new FireBall());
			MainActivity.getSharedInstance().mCurrentScene
					.attachChild(GameScene.FireBalls.get(GameScene.FireBalls
							.size() - 1));
			rndEventNumber = MainActivity.rndGenerator.nextInt(10) + 10;

		}
		if (counter % 30 == 0 && counter != 0) {
			// Füge neuen Ball hinzu
			GameScene.AquaBalls.add(new AquaBall());
			MainActivity.getSharedInstance().mCurrentScene
					.attachChild(GameScene.AquaBalls.get(GameScene.AquaBalls
							.size() - 1));

		}
		if (counter % 50 == 0 && counter != 0) {
			// Füge neuen Ball hinzu
			GameScene.FlashBalls.add(new FlashBall());
			MainActivity.getSharedInstance().mCurrentScene
					.attachChild(GameScene.FlashBalls.get(GameScene.FlashBalls
							.size() - 1));
			rndEventNumber = MainActivity.rndGenerator.nextInt(10) + 10;

		}
		if (counter % 70 == 0 && counter != 0) {
			// Füge neuen Ball hinzu
			GameScene.PurpleBalls.add(new PurpleBall());
			MainActivity.getSharedInstance().mCurrentScene
					.attachChild(GameScene.PurpleBalls
							.get(GameScene.PurpleBalls.size() - 1));

		}

		counter++;
		// Höheres Level
		if (counter >= 100) {
			counter = 0;
			MainActivity.getSharedInstance().level++;
		}
		// Zeitkontrolle
		MainActivity.getSharedInstance().remaining_time--;
		if (MainActivity.getSharedInstance().remaining_time < 1) {
			// VERLOREN
			MainActivity.getSharedInstance().mCurrentScene.setBackground(new Background(Color.BLACK));
			GameScene.backMusic.stop();
			GameScene.backMusic.release();
			GameScene.backMusic = null;
			MainActivity.getSharedInstance().setCurrentScene(
					new HighscoreScene());
		}
		if(MainActivity.getSharedInstance().remaining_time < 5) {
			MainActivity.getSharedInstance().mCurrentScene.setBackground(new Background(Color.RED));
		}
		else {
			MainActivity.getSharedInstance().mCurrentScene.setBackground(new Background(Color.BLACK));
		}

	}

}
