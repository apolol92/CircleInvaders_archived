package com.example.bubble_table;

import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.entity.text.Text;

public class GameLoopOutput implements ITimerCallback {
	boolean start = true;
	public static Text ScoreText;
	public static Text TimeText;
	public static Text AmmoText;
	boolean gettedAmmo = false;

	public boolean directionPlayerBall = true; // true größer false kleiner

	@Override
	public void onTimePassed(TimerHandler pTimerHandler) {
		if (start) {
			ScoreText = new Text(0, 0, MainActivity.getSharedInstance().mFont, "Your Score: 000",
					MainActivity.getSharedInstance()
							.getVertexBufferObjectManager());
			MainActivity.getSharedInstance().mCurrentScene
					.attachChild(ScoreText);
			TimeText = new Text(MainActivity.CAMERA_WIDTH - 200, 0,
					MainActivity.getSharedInstance().mFont, "Remaining: 030", MainActivity
							.getSharedInstance().getVertexBufferObjectManager());
			MainActivity.getSharedInstance().mCurrentScene
					.attachChild(TimeText);
			AmmoText = new Text(0, MainActivity.CAMERA_HEIGHT - 32,
					MainActivity.getSharedInstance().mFont, "Ammo: 000",
					MainActivity.getSharedInstance()
							.getVertexBufferObjectManager());
			MainActivity.getSharedInstance().mCurrentScene
					.attachChild(AmmoText);
			AmmoText.setVisible(false);
			start = false;
		} else {
			ScoreText.setVisible(false);
			ScoreText.setText("Your Score: "
					+ MainActivity.getSharedInstance().punkte);
			ScoreText.setVisible(true);
			TimeText.setVisible(false);
			TimeText.setText("Remaining: "
					+ MainActivity.getSharedInstance().remaining_time);
			TimeText.setVisible(true);
		}
		
		
		if (GameScene.MyBall.ammo >= 0) {
			AmmoText.setVisible(false);
			AmmoText.setText("Ammo: " + GameScene.MyBall.ammo);
			AmmoText.setVisible(true);
		}

	}

}
